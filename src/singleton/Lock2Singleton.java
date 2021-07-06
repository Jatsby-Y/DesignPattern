package singleton;

public class Lock2Singleton {
    private static volatile Lock2Singleton instance;

    private Lock2Singleton() {

    }

    public static Lock2Singleton getInstance() {
        if (instance == null) {
            synchronized (Lock2Singleton.class) {
                if (instance == null) {
                    instance = new Lock2Singleton();
                }
            }
        }
        return instance;
    }
}
