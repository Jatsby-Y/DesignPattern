# 策略模式
## 目的
策略模式主要定义了一系列算法，并对它们进行封装，使算法可以互换。 
在多种算法相似的情况下，使用策略模式可以避免多重if...else所带来
的低可读性和低扩展性。
## 优缺点
**优点：** 
1. 对开闭原则完美支持，扩展性较高。
2. 可避免多重判断，提高可读性。

**缺点：** 
1. 会造成较多的策略类，维护难度增加。
2. 所有策略必须对调用者暴露，即调用者需要理解所有策略以便适时选择。
## 模式结构
策略模式主要有三个角色：
1. 抽象策略（Strategy）类：一个公共接口，各种不同的策略算法将以不同的
方式实现这个接口，环境角色使用这个接口调用不同的算法，一般使用接口或抽象类实现。
2. 具体策略（Concrete Strategy）类：实现了抽象策略定义的接口，
提供具体的算法实现。
3. 环境（Context）类：持有一个策略类的引用，最终给客户端调用。
## 实现方式
【例】以鱼的烹饪为例：主要可分为清蒸和红烧两种方式（策略）。
**实现步骤：**  
1 定义对鱼进行烹饪的抽象策略类（FishCookingStrategy），
类中包含对象的行为``cooking()``。
```java
public interface FishCookingStrategy {
    public void cooking();
}
```
2 定义具体策略，清蒸鱼（SteamedFishStrategy）和红烧鱼（BraisedFishStrategy），
实现抽象策略类。
```java
public class SteamedFishStrategy implements FishCookingStrategy {
    @Override
    public void cooking() {
        System.out.println("steamed fish");
    }
}
```
```java
public class BraisedFishStrategy implements FishCookingStrategy {
    @Override
    public void cooking() {
        System.out.println("braised fish");
    }
}
```
3 构建环境（Kitchen）,它具有设置策略、获取当前策略、使用当前策略的方法。
```java
public class Kitchen {
    private FishCookingStrategy fishCookingStrategy;

    public FishCookingStrategy getFishCookingStrategy() {
        return fishCookingStrategy;
    }

    public void setFishCookingStrategy(FishCookingStrategy fishCookingStrategy) {
        this.fishCookingStrategy = fishCookingStrategy;
    }

    public void cooking() {
        if (fishCookingStrategy != null) {
            fishCookingStrategy.cooking();
        }
    }
}
```
4 编写Demo,创建环境对象，设置并调用不同策略。
```java
public class strategyPatternDemo {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();
        kitchen.setFishCookingStrategy(new SteamedFishStrategy());
        kitchen.cooking();
        kitchen.setFishCookingStrategy(new BraisedFishStrategy());
        kitchen.cooking();
    }
}
```