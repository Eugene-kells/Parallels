package task_2;

import java.util.Random;

public class Producer implements Runnable {
    private Drop drop;
    private int SIZE = 100;

    public Producer(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        int importantInfo[] = new int[SIZE];
        for (int i = 0; i < SIZE; i++)
            importantInfo[i] = i;
        Random random = new Random();

        for (int i = 0; i < importantInfo.length; i++) {
            drop.put(importantInfo[i]);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
            }
        }
        drop.put(-1);
    }
}
