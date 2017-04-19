package main.java.io;

/**
 * tp4
 * Created by jeronimocarlos on 4/17/17.
 */
public class Client extends Thread{
    int id;
    private BarberShop shop;

    public Client(int id, BarberShop shop){
        this.id = id;
        this.shop = shop;
    }

    public void run(){
        while(true){
            try {
                System.out.println("Client " + id + " entered");
                shop.getHaircut(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
