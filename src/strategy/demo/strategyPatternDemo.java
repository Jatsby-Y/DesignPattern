package strategy.demo;

public class strategyPatternDemo {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();
        kitchen.setFishCookingStrategy(new SteamedFishStrategy());
        kitchen.cooking();
        kitchen.setFishCookingStrategy(new BraisedFishStrategy());
        kitchen.cooking();
    }
}
