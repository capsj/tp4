package io.philosophersProblem;

/**
 * Created by Mati on 4/3/2017.
 */
public class Philosopher extends Thread{

    private long id;
    private Fork right;
    private Fork left;

    public Philosopher(long id, Fork right, Fork left) {
        this.id = id;
        this.right = right;
        this.left = left;
    }

    @Override
    public void run() {
        while(true) {
            try {
                System.out.println("Filosofo " + id + " esta pensando");
                sleep(2000);
                System.out.println("Filosofo " + id + " va a comer");
                if (right.getId() < left.getId()) {
                    right.pickUp();
                    left.pickUp();
                    finishEating();
                }
                else{
                    left.pickUp();
                    right.pickUp();
                    finishEating();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void finishEating() {
        System.out.println("Filosofo " + id + " termino de comer");
        right.putDown();
        left.putDown();
    }
}
