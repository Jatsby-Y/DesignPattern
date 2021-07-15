package strategy.demo;

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
