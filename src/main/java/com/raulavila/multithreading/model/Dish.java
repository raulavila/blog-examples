package com.raulavila.multithreading.model;

public class Dish {
    public enum State {CREATED, WET, DRY; }

    private final int id;
    private State state;

    public Dish(int id) {
        this.id = id;
        state = State.CREATED;
    }

    public int getId() {
        return id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
