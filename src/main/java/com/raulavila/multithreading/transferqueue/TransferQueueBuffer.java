package com.raulavila.multithreading.transferqueue;

import com.raulavila.multithreading.Buffer;

import java.util.concurrent.TransferQueue;

public class TransferQueueBuffer<E> implements Buffer<E> {
    private final TransferQueue<E> queue;

    public TransferQueueBuffer(TransferQueue<E> queue) {
        this.queue = queue;
    }

    @Override
    public void put(E element) {
        try {
            queue.transfer(element);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public E take() {
        try {
            E element = queue.take();
            return element;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
