package ru.gb.philosophers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class DinnerTable extends Thread {
    private AtomicBoolean fork;
    private List<Philosopher> philosophers;


    public DinnerTable() {
        this.fork = new AtomicBoolean(true);
        this.philosophers = new ArrayList<>();
        philosophers.add(new Philosopher("Кант", this));
        philosophers.add(new Philosopher("Ницше", this));
        philosophers.add(new Philosopher("Платон", this));
        philosophers.add(new Philosopher("Юм", this));
        philosophers.add(new Philosopher("Декарт", this));

    }

    @Override
    public void run() {
        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }
    }


    public synchronized void setFork(boolean fork) {
        this.fork.set(fork);
    }

    public synchronized boolean isFork() {
        return fork.get();
    }
}
