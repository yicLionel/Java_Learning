package Runnable_Safe;

/**
 * 使用实现Runnable接口的方式，实现卖票----->存在线程安全问题
 * 使用同步代码块解决卖票中的线程安全问题
 */

public class WindowTest {
    public static void main(String[] args) {

        SaleTicket s = new SaleTicket();

        Thread t1 = new Thread(s);
        Thread t2 = new Thread(s);
        Thread t3 = new Thread(s);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}

class Dog{

}

class SaleTicket implements Runnable {
    int ticket = 100;
    Object obj = new Object();
    Dog dog = new Dog();
    @Override
    public void run() {

        while(true) {

            //    synchronized (obj){ //obj必须是唯一的
            //    synchronized (dog) { //dog也是唯一的
            synchronized (this){ //this也是唯一的
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "售票： 票号为" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }


        }
    }
}

