class PrintNum extends Thread{

    public PrintNum() {

    }

    public PrintNum(String name) {
        super(name);
    }


    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            if(i%2==0) {
                System.out.println(Thread.currentThread().getName() + ": "
                + Thread.currentThread().getPriority() + ": " + i);
            }
        }
    }
}



public class PrintNumTest {
    public static void main(String[] args) {
        PrintNum p1 = new PrintNum("线程1");
        p1.setName("子线程1");
        p1.setPriority(Thread.MIN_PRIORITY);

        p1.start();

        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        for (int i = 0; i < 100; i++) {
            if(i%2==0) {
                System.out.println(Thread.currentThread().getName() + "----> " +
                        Thread.currentThread().getPriority() + ": " + i);
                ;
            }

            /*if(i%20==0) {
                Thread.yield();
            }*/

            /*if(i==20) {
                try {
                    p1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/
        }

    }
}