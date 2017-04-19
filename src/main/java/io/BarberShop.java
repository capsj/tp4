package main.java.io;

/**
 * tp4
 * Created by jeronimocarlos on 4/17/17.
 */
public class BarberShop {
    private int chairs;
    private int occupiedChairs;
//    private boolean barberChair;
    private Barber barber;

    public BarberShop(int chairs, Barber barber){
        this.chairs = chairs;
//        barberChair = true;
        occupiedChairs = 0;
        this.barber = barber;
    }

    public void getHaircut(Client client) throws InterruptedException {
        if (occupiedChairs == chairs) {
            System.out.println("All chairs occupied, client leaves");
        } else {
            if (barber.isOccupied()) {
                occupiedChairs++;
                Thread.currentThread().wait();
                System.out.println("Client " + client.id + " is waiting");
            } else if (barber.isAsleep()) {
                barber.wakeUp();
                barber.cutHair(client);
            } else {
                barber.cutHair(client);
            }
        }
    }


    public boolean isEmpty(){
        return occupiedChairs == 0;
    }
}
