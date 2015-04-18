package com.raulavila.multithreading.blockingqueue;

import com.raulavila.multithreading.Creator;
import com.raulavila.multithreading.Dryer;
import com.raulavila.multithreading.Buffer;
import com.raulavila.multithreading.Washer;
import com.raulavila.multithreading.model.Dish;
import com.raulavila.multithreading.model.UnitOfWork;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueBufferExample {

    public static void main(String[] args) {
        Buffer<UnitOfWork<Dish>> createdDishesQueue =
                new BlockingQueueBuffer<>(
                        new ArrayBlockingQueue<UnitOfWork<Dish>>(2));

        Buffer<UnitOfWork<Dish>> washedDishesQueue =
                new BlockingQueueBuffer<>(
                        new ArrayBlockingQueue<UnitOfWork<Dish>>(2));

        Creator creator = new Creator(createdDishesQueue);
        Washer washer1 = new Washer(createdDishesQueue, washedDishesQueue);
        Washer washer2 = new Washer(createdDishesQueue, washedDishesQueue);
        Dryer dryer = new Dryer(washedDishesQueue);

        new Thread(creator).start();
        new Thread(washer1).start();
        new Thread(washer2).start();
        new Thread(dryer).start();
    }
}
