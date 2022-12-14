package patern.producerconsumer;


import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerTest1 {
    private static BlockingQueue queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello, JAVA !!!");
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    private static void producer() throws InterruptedException {
        Random random = new Random();

        while (true) {
            queue.put(random.nextInt(100));
        }

    }

    private static void consumer() throws InterruptedException {
        while (true) {
            Thread.sleep(100);
            System.out.println(queue.take());
            System.out.println("Queue size " + queue.size());
        }

    }
}
