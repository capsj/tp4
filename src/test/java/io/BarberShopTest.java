package test.java.io;

import main.java.io.Barber;
import main.java.io.BarberShop;
import main.java.io.Client;

/**
 * tp4
 * Created by jeronimocarlos on 4/17/17.
 */
public class BarberShopTest {

    public static void main(String[] args) throws InterruptedException {
        int clients = 10;
        int chairs = 4;
        Barber barber = new Barber();
        BarberShop barberShop = new BarberShop(chairs, barber);
        barber.start();
        for (int i = 0; i < clients; i++) {
            new Client(i, barberShop).start();
            Thread.sleep(1000);
        }
    }
}
