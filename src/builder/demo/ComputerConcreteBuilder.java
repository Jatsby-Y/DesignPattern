package builder.demo;

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
