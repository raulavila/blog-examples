package com.raulavila.multithreading.blockingqueue;

import com.raulavila.multithreading.Buffer;

import java.util.concurrent.BlockingQueue;

public class BlockingQueueBuffer<E> implements Buffer<E> {

    private final BlockingQueue<E> queue;

    public BlockingQueueBuffer(BlockingQueue<E> queue) {
        this.queue = queue;
    }

    @Override
    public void put(E element) {
        try {
            queue.put(element);
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
