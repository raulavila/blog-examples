package com.raulavila.multithreading.blockingqueue;

import com.raulavila.multithreading.Creator;
import com.raulavila.multithreading.Dryer;
import com.raulavila.multithreading.Buffer;
import com.raulavila.multithreading.Washer;
import com.raulavila.multithreading.model.Dish;
import com.raulavila.multithreading.model.UnitOfWork;

import java.util.concurrent.LinkedBlockingQueue;

public class UnboundedBlockingQueueBufferExample {

    public static void main(String[] args) {
        Buffer<UnitOfWork<Dish>> createdDishesQueue =
                new BlockingQueueBuffer<>(
                        new LinkedBlockingQueue<UnitOfWork<Dish>>());

        Buffer<UnitOfWork<Dish>> washedDishesQueue =
                new BlockingQueueBuffer<>(
                        new LinkedBlockingQueue<UnitOfWork<Dish>>());

        Creator creator = new Creator(createdDishesQueue);
        Washer washer = new Washer(createdDishesQueue, washedDishesQueue);
        Dryer dryer = new Dryer(washedDishesQueue);

        new Thread(creator).start();
        new Thread(washer).start();
        new Thread(dryer).start();
    }

}
