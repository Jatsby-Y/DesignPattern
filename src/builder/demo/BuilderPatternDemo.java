package builder.demo;

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
