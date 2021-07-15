# 建造者模式
## 目的
将一个复杂对象的**构建**与**表示**分离，使得同样的构建过程可以创建
不同的表示。其主要作用是可以让调用者在不知道对象内部复杂构建过程和
细节的情况下直接创建对象。
## 优缺点
**优点：** 
1. 对象构建与表示分离，实现了解耦，便于控制细节风险。
2. 建造者独立，便于扩展。

**缺点：** 
1. 对象必须有共同点，在范围上有一定限制。
2. 若内部变化复杂，会有很多建造者类，难以维护。
## 实现方式
实现步骤：  
1 定义需要构建的产品类。
```java
public class Computer {
    private String cpu;
    private String memory;
    private String disk;
    // 以下省略属性的getter和setter方法
}
```
2 定义抽象接口，以描述产品的内部构建过程，包括装配细节和最终构建方法。
```java
public interface ComputerBuilder {
    public ComputerBuilder installCpu(String cpu);
    public ComputerBuilder installMemory(String memory);
    public ComputerBuilder installDisk(String disk);
    public Computer build(); // 最终构建方法
}
```
3 定义抽象接口的具体实现类，以实现产品中各个组件的装配及最终产品的构建。
```java
public class ComputerConcreteBuilder implements ComputerBuilder {
    private Computer computer;

    public ComputerConcreteBuilder() {
        computer = new Computer();
    }

    @Override
    public ComputerBuilder installCpu(String cpu) {
        computer.setCpu(cpu);
        System.out.println("install cpu");
        return this;
    }

    @Override
    public ComputerBuilder installMemory(String memory) {
        computer.setMemory(memory);
        System.out.println("install memory");
        return this;
    }

    @Override
    public ComputerBuilder installDisk(String disk) {
        computer.setDisk(disk);
        System.out.println("install disk");
        return this;
    }

    @Override
    public Computer build() {
        return computer;
    }
}
```
4 编写Demo,构建具体产品。
```java
public class BuilderPatternDemo {
    public static void main(String[] args) {
        ComputerBuilder computerBuilder = new ComputerConcreteBuilder();
        Computer computer = computerBuilder.installCpu("8core").installMemory("16G")
                .installDisk("1TB").build();
        System.out.println(String.format("电脑的CPU为：%s", computer.getCpu()));
        System.out.println(String.format("电脑的Memory为：%s", computer.getMemory()));
        System.out.println(String.format("电脑的Disk为：%s", computer.getDisk()));
    }
}
```