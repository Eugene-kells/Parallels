package task_1;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

class Bank {
    public static final int NTEST = 10000;
    private final int[] accounts;
    private long ntransacts = 0;
    private Semaphore semaphore;

    public Bank(int n, int initialBalance, Semaphore semaphore) {
        accounts = new int[n];
        Arrays.fill(accounts, initialBalance);
        this.semaphore = semaphore;
    }

    public void transfer(int from, int to, int amount) throws InterruptedException {
        semaphore.acquire();
        accounts[from] -= amount;
        accounts[to] += amount;
        ntransacts++;
        if (ntransacts % NTEST == 0)
            test();
        semaphore.release();
    }

    public void test() {
        int sum = 0;
        for (int account : accounts) sum += account;
        System.out.println("Transactions:" + ntransacts + " Sum: " + sum);
    }

    public int size() {
        return accounts.length;
    }
}
