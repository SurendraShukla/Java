package me.surendra.thread;

import java.util.ArrayList;
import java.util.List;


class Service implements Runnable {
    static ExternalService externalService = new ExternalService();

    String name;

    public Service(final String name) {
        this.name = name;
    }

    @Override
    public void run() {
        // Limit this api for only 6 parallel calls
        externalService.serviceCall(name);
    }
}


public class ExternalService {

    public void serviceCall(String s) {
        System.out.println("Hello " + s);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello " + s);
    }

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(new Service("Thread_" + i)));
        }

        for (Thread t : threads) {
            t.start();
        }

    }

}
