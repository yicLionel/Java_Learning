package Runnable_Safe;


/**
 * 使用同步方法解决实现Runnable接口的线程安全问题
 */


public class WindowTest1 {
    public static void main(String[] args) {

        SaleTicket1 s = new SaleTicket1();

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

class SaleTicket1 implements Runnable {
    int ticket = 100;
    boolean isFlag = true;
    @Override
    public void run() {
        while(isFlag) {

            show();

        }
    }

    public synchronized void show(){ //此时的同步监视器是：this。是唯一的

        if(ticket > 0){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "售票： 票号为" + ticket);
            ticket--;
        } else {
            isFlag = false;
        }
    }
}