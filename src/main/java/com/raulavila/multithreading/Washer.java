package com.raulavila.multithreading;

import com.raulavila.multithreading.model.Dish;
import com.raulavila.multithreading.model.UnitOfWork;

public class Washer implements Runnable {

    private Buffer<UnitOfWork<Dish>> createdDishesBuffer;
    private Buffer<UnitOfWork<Dish>> washedDishesBuffer;

    public Washer(Buffer<UnitOfWork<Dish>> createdDishesBuffer,
                  Buffer<UnitOfWork<Dish>> washedDishesBuffer) {
        this.createdDishesBuffer = createdDishesBuffer;
        this.washedDishesBuffer = washedDishesBuffer;
    }

    @Override
    public void run() {
        try {
            while(true) {
                System.out.println("Washer: waiting to take dish");

                UnitOfWork<Dish> unitOfWork = createdDishesBuffer.take();

                Dish dish = unitOfWork.getItem();

                System.out.println("Washer: took dish " + dish.getId() + " - washing...");

                Thread.sleep(5000);
                dish.setState(Dish.State.WET);

                System.out.println("Washer: putting washed dish " + dish.getId() + " into buffer");

                unitOfWork.setThreadId(Thread.currentThread().getId());
                washedDishesBuffer.put(unitOfWork);

                System.out.println("Washer: dish " + dish.getId() + " put into buffer");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
