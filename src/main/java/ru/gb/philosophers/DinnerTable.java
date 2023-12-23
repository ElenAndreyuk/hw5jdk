package ru.gb.philosophers;

import java.util.ArrayList;
import java.util.List;

public class DinnerTable extends Thread {
    private volatile boolean fork;
    private List<Philosopher> philosophers;


    public DinnerTable() {
        this.fork = true;
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


    public void setFork(boolean fork) {
        this.fork = fork;
    }

    public boolean isFork() {
        return fork;
    }
}
