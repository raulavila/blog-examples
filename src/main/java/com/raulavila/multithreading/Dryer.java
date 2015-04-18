package com.raulavila.multithreading;

import com.raulavila.multithreading.model.Dish;
import com.raulavila.multithreading.model.UnitOfWork;

public class Dryer implements Runnable {

    private Buffer<UnitOfWork<Dish>> washedDishesBuffer;

    public Dryer(Buffer<UnitOfWork<Dish>> washedDishesBuffer) {
        this.washedDishesBuffer = washedDishesBuffer;
    }

    @Override
    public void run() {
        try {
            while(true) {
                System.out.println("Dryer: waiting to take dish");

                UnitOfWork<Dish> unitOfWork = washedDishesBuffer.take();

                Dish dish = unitOfWork.getItem();
                System.out.println("Dryer: took dish " + dish.getId() + " - drying...");

                Thread.sleep(2000);
                dish.setState(Dish.State.DRY);

                unitOfWork.setThreadId(Thread.currentThread().getId());
                System.out.println("Dryer: dish " + dish.getId() + " is dry (done)");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
