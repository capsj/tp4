package io;

import io.philosophersProblem.Fork;
import io.philosophersProblem.Philosopher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Mati on 4/3/2017.
 */
public class PhilosophersTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert number of philosophers");
        int philosophers = scanner.nextInt();


        List<Fork> forks = new ArrayList<Fork>();

        for (int i = 0; i < philosophers; i++) {
            forks.add(new Fork(i));
        }

        for (int i = 0; i < philosophers; i++) {
            if(i == 0) new Philosopher(i, forks.get(philosophers-i-1), forks.get(i)).start();
            else new Philosopher(i, forks.get(i-1), forks.get(i)).start();
        }
    }
}
