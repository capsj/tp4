package main.java.io;

/**
 * tp4
 * Created by jeronimocarlos on 4/17/17.
 */
public class Barber extends Thread{
    private boolean occupied;
    private boolean asleep;

    public Barber(){
        occupied = false;
        asleep = false;
    }

    public void run(){
        while (true){

        }
    }
    public void cutHair(Client client) throws InterruptedException {
        occupied = true;
        System.out.println("Cutting hair of client " + client.id);
        long timer = (long) (Math.random()*100);
        Thread.sleep(timer);
        sleep(timer);
        checkClients();
    }

    private void checkClients() {
        notifyAll();
    }

    private void toSleep(){
        asleep = true;
        System.out.println("Barber is sleeping");
    }

    public void wakeUp() {
        asleep = false;
        System.out.println("Barber woke up");
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isAsleep() {
        return asleep;
    }
}
