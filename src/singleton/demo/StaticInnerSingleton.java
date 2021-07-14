package singleton.demo;

public class StaticInnerSingleton {
    private StaticInnerSingleton() {

    }

    private static class SingletonHolder {
        private static final StaticInnerSingleton INSTANCE = new StaticInnerSingleton();
    }

    public static StaticInnerSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
