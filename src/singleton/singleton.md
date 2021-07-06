# 单例模式
## 目的
确保一个类在同一时刻只有一个实例，并提供这个实例的全局访问
## 特点
* 静态成员变量私有化，提供全局类名访问
* 构造函数私有化，确保不能通过构造函数创建对象实例，只能通过静态函数返回私有变量实例
## 实现方式
#### I 懒汉式-线程不安全
优点：变量实例被延迟话，若没有用到该类，就不会实例化，节约资源。
缺点：线程不安全，若多个线程同时进入``if (instance == null)``,且判断instance不为null，则会有多个线程同时参与实例化，导致实例化多次
```java
public class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton() {

    }
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
```
#### II 懒汉式-线程安全
将获取实例的方法用synchronized关键字修饰即可
```java
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
```
缺点：由于使用synchronized修饰方法，同一时刻只能有一个线程进入方法，
若该线程长时间不是放锁资源，其余线程都处于阻塞状态，可能会造成性能问题
#### III 饿汉式
优点：懒汉式的线程不安全问题主要是由于对象被实例化多次，若在定义变量时直接实例化即可避免这种现象  
缺点：丢失了延迟实例化所带来的节约资源的优势
```java
private static HungrySingleton instance = new HungrySingleton();
```
#### IV 双重锁校验式-线程安全
只对实例化的部分代码进行枷锁，避免多线程阻塞
```java
public class Lock2Singleton {
    private static volatile Lock2Singleton instance;

    private Lock2Singleton() {

    }

    public static Lock2Singleton getInstance() {
        if (instance == null) {
            synchronized (Lock2Singleton.class) {
                if (instance == null) {
                    instance = new Lock2Singleton();
                }
            }
        }
        return instance;
    }
}
```
**为什么对用volatile关键字修饰instance变量？**  
答：变量在实例化时，需要三个步骤：
1. 为instance分配内存空间
2. 初始化instance对象(调用构造函数)
3. 将instance指向分配的内存地址   

而在实际运行中，为了充分利用CPU，JVM可能会进行指令重排，执行顺序可能变成1->3->2，
则此时可能会出现有线程判断地址不为null，返回instance实例的情况，但该对象并没有完成初始化  
  
使用多volatile关键字，可以防止JVM指令重排，保证线程安全
#### V 静态内部类式
当StaticInnerSingleton类被加载时，静态内部类SingletonHolder并没有加载到内存中。
只有当``getInstance()``方法被调用时，采用加载SingletonHolder类，从而初始化
INSTANCE实例，且JVM能保证INSTANCE只被实例化一次
```java
public class StaticInnerSingleton {
    private StaticInnerSingleton() {

    }

    private static class SingletonHolder {
        private static final StaticInnerSingleton INSTANCE = new StaticInnerSingleton();
    }

    public static StaticInnerSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
```
优点：既可以延迟初始化，节约资源，也保证了线程安全


