package com.raulavila.multithreading.model;

public class UnitOfWork<T> {
    private T item;
    
    private long threadId;

    public UnitOfWork(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public long getThreadId() {
        return threadId;
    }

    public void setThreadId(long threadId) {
        this.threadId = threadId;
    }
}

