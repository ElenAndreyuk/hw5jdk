package ru.gb.philosophers;

public class Philosopher extends Thread {
    private String name;
    private int counter;
    private DinnerTable dinnerTable;

    public Philosopher(String name, DinnerTable dinnerTable) {
        this.name = name;
        counter++;
        this.dinnerTable = dinnerTable;
    }

    @Override
    public void run() {
        while (counter< 3)
        try{
            if (dinnerTable.isFork()){
                dinner();
            }
            reflect();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void dinner() throws InterruptedException{
        dinnerTable.setFork(false);
        System.out.println(name + " обедает");
        counter++;
        sleep(500);
        System.out.println(name + " отобедал");
        dinnerTable.setFork(true);
        sleep(100);
    }


    public void reflect() throws InterruptedException{
        System.out.println(name + " размышляет");
        sleep(1000);
    }


}
