package com.csy.basic.java.relative.thread.create;

/**
 * 创建线程的四种方式
 * 1. 继承Thread类创建线程类，直接调用线程类的run()方法
 * @author chensy
 * @date 2019-05-18 00:00
 */
public class FirstThreadTest extends Thread {
    int i = 0;
    //重写run方法，把执行的内容放入run方法中
    public void run() { //执行体
        for (; i < 100; i++) {
            if (i == 50) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(getName() + "  " + i);
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "  : " + i);
            if(i == 20) {
                //TODO 此处两个线程设置了优先级，但是遍历10000，还是先遍历完第一个，再遍历第二个，优先级并没有起作用，数据太小？
                FirstThreadTest threadTest1 =  new FirstThreadTest();
                threadTest1.setPriority(Thread.MIN_PRIORITY);
                FirstThreadTest threadTest2 =  new FirstThreadTest();
                threadTest2.setName("max-test");
                threadTest2.setPriority(Thread.MAX_PRIORITY);

                threadTest1.run();
                threadTest2.run();
            }
        }
    }

    /**
     * Java多线程的上下文切换
     * https://blog.csdn.net/fuyuwei2015/article/details/71860349
     *
     * 当CPU从执行一个线程切换到执行另外一个线程的时候，它需要先存储当前线程的本地的数据，程序指针等，然后载入另一个线程的本地数据，
     * 程序指针等，最后才开始执行。这种切换称为“上下文切换”(“context switch”)
     * 上下文切换并不廉价,是比较耗时的
     */

    /**
     * 并发编程的目的是为了让程序运行得更快，但是并不是启动更多的线程就能让程序最大限度地并发执行。在进行并发编程时，如果希望通过多线程执行任务让程序运行得更快，
     * 会面临非常多的挑战，比如上下文切换的问题、死锁的问题，以及受限于硬件和软件的资源限制问题，本文要研究的是上下文切换的问题。
     */

    /**
     * 既然上下文切换会导致额外的开销，因此减少上下文切换次数便可以提高多线程程序的运行效率。减少上下文切换的方法有无锁并发编程、CAS算法、使用最少线程和使用协程。
     *
     * 无锁并发编程。多线程竞争时，会引起上下文切换，所以多线程处理数据时，可以用一些办法来避免使用锁，如将数据的ID按照Hash取模分段，不同的线程处理不同段的数据
     * CAS算法。Java的Atomic包使用CAS算法来更新数据，而不需要加锁
     * 使用最少线程。避免创建不需要的线程，比如任务很少，但是创建了很多线程来处理，这样会造成大量线程都处于等待状态
     * 协程。在单线程里实现多任务的调度，并在单线程里维持多个任务间的切换
     */


}
