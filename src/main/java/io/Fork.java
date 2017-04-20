package io.philosophersProblem;

import java.util.concurrent.Semaphore;

/**
 * Created by Mati on 4/3/2017.
 */
public class Fork {

    private long id;
    private Semaphore semaphore;

    public Fork(long id) {
        this.id = id;
        this.semaphore = new Semaphore(1);
    }

    void pickUp() throws InterruptedException {
        semaphore.acquire();
    }

    public void putDown() {
        semaphore.release();
    }


    long getId() {
        return id;
    }
}
