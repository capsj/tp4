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
                Thread.sleep(1000);
                System.out.println("Client " + id + " entered");
                if(shop.getHaircut(id)){
                    Thread.sleep(25000);
                } else{
                    Thread.sleep(4000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
