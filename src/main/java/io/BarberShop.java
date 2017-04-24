package main.java.io;

/**
 * tp4
 * Created by jeronimocarlos on 4/17/17.
 */
public class BarberShop {
    private int chairs;
    private int occupiedChairs;
    private Barber barber;

    public BarberShop(int chairs, Barber barber){
        this.chairs = chairs;
        occupiedChairs = 0;
        this.barber = barber;
    }

    public synchronized boolean getHaircut(int clientId) throws InterruptedException {
        if (occupiedChairs == chairs) {
            System.out.println("All chairs occupied, client leaves");
            return false;
        } else {
            if (barber.isOccupied()) {
                occupiedChairs++;
                while (barber.isOccupied()) {
                    System.out.println("Client " + clientId + " is waiting");
                    wait();
                }
                occupiedChairs--;
                barber.cutHair(clientId);

            } else if (barber.isAsleep()) {
                System.out.println("Client " + clientId + " woke the barber up");
                barber.wakeUp();
                barber.cutHair(clientId);
            } else {
                barber.cutHair(clientId);
            }
            return true;
        }
    }
}
