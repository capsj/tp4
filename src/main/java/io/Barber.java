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
            try{
                System.out.println("Waiting client");
                checkClients();
                Thread.sleep(4000);
                toSleep();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void cutHair(int clientId) throws InterruptedException {
        occupied = true;
        System.out.println("Cutting hair of client " + clientId);
        long timer = (long) (Math.random()*5000);
        Thread.sleep(timer);
        occupied = false;
        System.out.println("DONE CLIENT " + clientId);
    }

    private synchronized void checkClients() {
        notifyAll();
    }

    private synchronized void toSleep() throws InterruptedException {
        asleep = true;
        System.out.println("Barber is SLEEPING");
        wait();
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
