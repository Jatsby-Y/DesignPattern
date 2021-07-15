package strategy.demo;

public class SteamedFishStrategy implements FishCookingStrategy {
    @Override
    public void cooking() {
        System.out.println("steamed fish");
    }
}
