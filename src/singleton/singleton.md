# 单例模式
## 目的
确保一个类在同一时刻只有一个实例，并提供这个实例的全局访问
## 特点
* 静态成员变量私有化，提供全局类名访问
* 构造函数私有化，确保不能通过构造函数创建对象实例，只能通过静态函数返回私有变量实例
## 实现方式
####I 懒汉式
优点：变量实例被延迟话，若没有用到该类，就不会实例化，节约资源。
缺点：线程不安全，若多个线程同时进入``if (instance == null)``,且判断instance不为null，则会有多个线程同时参与实例化，导致实例化多次
```java
public class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton() {

    }
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
```