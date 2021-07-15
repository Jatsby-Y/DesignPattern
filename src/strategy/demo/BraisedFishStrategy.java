package strategy.demo;

public class BraisedFishStrategy implements FishCookingStrategy {
    @Override
    public void cooking() {
        System.out.println("braised fish");
    }
}
