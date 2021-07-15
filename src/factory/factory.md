# 工厂模式
## 目的
定义创建对象的接口，其具体实现由其子类决定，从而使对象的创建过程延迟到子类进行，
解决了接口的选择问题。
## 优缺点
**优点：** 
1. 便捷。创建对象时，只需传入对象类型或名称即可。
2. 扩展性高。若要增加产品，只需添加一个工厂类即可。
3. 安全性好。屏蔽了具体实现，只将接口暴露给调用者。

**缺点：** 
1. 每次增加产品都需要增加具体实现类以构建工厂，复杂度较高，所以工厂模式
一般用于构建复杂对象。
## 实现方式
实现步骤：  
1 定义创建对象的接口。
```java
public interface Fruit {
    public void buy();
}
```
2 构建具体实现类。
```java
public class Apple implements Fruit {
    @Override
    public void buy() {
        System.out.println("Buy Apples");
    }
}
```
```java
public class Banana implements Fruit {
    @Override
    public void buy() {
        System.out.println("Buy bananas");
    }
}
```
```java
public class Peach implements Fruit {
    @Override
    public void buy() {
        System.out.println("Buy peaches");
    }
}
```
3 定义工厂类。
```java
public class FruitFactory {

    // 使用工厂方法获取具体对象
    public Fruit getFruit(String fruitName) {
        if (fruitName == null) {
            return null;
        }
        if (fruitName.equalsIgnoreCase("APPLE")) {
            return new Apple();
        } else if (fruitName.equalsIgnoreCase("BANANA")) {
            return new Banana();
        } else if (fruitName.equalsIgnoreCase("PEACH")) {
            return new Peach();
        } else {
            return null;
        }
    }
}
```
4 编写Demo
```java
public class FactoryPatternDemo {
    public static void main(String[] args) {
        FruitFactory fruitFactory = new FruitFactory();

        Fruit fruit1 = fruitFactory.getFruit("APPLE");
        fruit1.buy();

        Fruit fruit2 = fruitFactory.getFruit("BANANA");
        fruit2.buy();

        Fruit fruit3 = fruitFactory.getFruit("PEACH");
        fruit3.buy();
    }
}
```

