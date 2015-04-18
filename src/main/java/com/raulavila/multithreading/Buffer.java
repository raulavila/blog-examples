package com.raulavila.multithreading;

public interface Buffer<E> {
    void put(E element);
    E take();
}
