/*
线程的创建方法二：
1. 创建一个实现Runnable接口的类
2. 实现接口中的run( ) --> 将此线程要执行的操作，声明在此方法体中
3. 创建当前实现类的对象
4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的实例
5. Thread类的实例调用start( );
*/


// 创建一个实现Runnable接口的类
public class Thread2 {
    public static void main(String[] args) {
        EvenNumPrint1 p1 = new EvenNumPrint1();
        Thread t1 = new Thread(p1);
        t1.start();

        // 主线程执行的操作，用于对比
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
class EvenNumPrint1 implements Runnable {
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
