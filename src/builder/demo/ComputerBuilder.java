package builder.demo;

public interface ComputerBuilder {
    public ComputerBuilder installCpu(String cpu);
    public ComputerBuilder installMemory(String memory);
    public ComputerBuilder installDisk(String disk);
    public Computer build();
}
