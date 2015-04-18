package com.raulavila.multithreading;

import com.raulavila.multithreading.model.Dish;
import com.raulavila.multithreading.model.UnitOfWork;

import java.util.concurrent.atomic.AtomicInteger;

public class Creator implements Runnable {

    public static final AtomicInteger sequence = new AtomicInteger(1);

    private Buffer<UnitOfWork<Dish>> createdDishesBuffer;

    public Creator(Buffer<UnitOfWork<Dish>> createdDishesBuffer) {
        this.createdDishesBuffer = createdDishesBuffer;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println("Creator: creating dish...");

            Dish dish = new Dish(sequence.getAndIncrement());

            System.out.println("Creator: dish " + dish.getId() + " - putting into buffer...");

            UnitOfWork<Dish> unitOfWork = new UnitOfWork<Dish>(dish);
            unitOfWork.setThreadId(Thread.currentThread().getId());

            createdDishesBuffer.put(unitOfWork);

            System.out.println("Creator: Dish " + dish.getId() + " put into buffer");
        }
    }
}
