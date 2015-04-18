package com.raulavila.multithreading.transferqueue;

import com.raulavila.multithreading.Creator;
import com.raulavila.multithreading.Dryer;
import com.raulavila.multithreading.Buffer;
import com.raulavila.multithreading.Washer;
import com.raulavila.multithreading.model.Dish;
import com.raulavila.multithreading.model.UnitOfWork;

import java.util.concurrent.LinkedTransferQueue;

public class TransferQueueBufferExample {

    public static void main(String[] args) {
        Buffer<UnitOfWork<Dish>> createdDishesQueue =
                new TransferQueueBuffer<>(
                        new LinkedTransferQueue<UnitOfWork<Dish>>());

        Buffer<UnitOfWork<Dish>> washedDishesQueue =
                new TransferQueueBuffer<>(
                        new LinkedTransferQueue<UnitOfWork<Dish>>());

        Creator creator = new Creator(createdDishesQueue);
        Washer washer1 = new Washer(createdDishesQueue, washedDishesQueue);
        Washer washer2 = new Washer(createdDishesQueue, washedDishesQueue);
        Washer washer3 = new Washer(createdDishesQueue, washedDishesQueue);
        Washer washer4 = new Washer(createdDishesQueue, washedDishesQueue);
        Dryer dryer = new Dryer(washedDishesQueue);

        new Thread(creator).start();
        new Thread(washer1).start();
        new Thread(washer2).start();
        new Thread(washer3).start();
        new Thread(washer4).start();
        new Thread(dryer).start();
    }
}
