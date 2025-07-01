/*
线程的创建方法一：
1. 创建一个继承于Thread类的子类
2. 重写Thread类的run( ) ---> 将此线程要执行的操作，声明在此方法体中
3. 创建当前Thread的子类的对象
4. 通过对象调用start( ): 1.启动线程 2.调用当前线程的run( )

 */
// 写法1
class OddNumPrint extends Thread{
    public void run(){
        for (int i = 0; i < 100; i++) {
            if(i%2==0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
class EvenNumPrint extends Thread{
    public void run(){
        for (int i = 0; i < 100; i++) {
            if(i%2==1) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

public class Thread1 {
    public static void main(String[] args) {
        OddNumPrint o1 = new OddNumPrint();
        EvenNumPrint e1 = new EvenNumPrint();

        o1.start();
        e1.start();

        // 写法2
        // 创建Thread类的匿名对象的匿名写法
        new Thread(){
            public void run(){
                for (int i = 0; i < 100; i++) {
                    if(i%2==1) {
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                    }
                }
            };
        }.start();
    }
}
