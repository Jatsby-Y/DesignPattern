package factory.demo;

public class FruitFactory {

    // 使用工厂方法获取具体对象
    public Fruit getFruit(String fruitName) {
        if (fruitName == null) {
            return null;
        }
        if (fruitName.equalsIgnoreCase("APPLE")) {
            return new Apple();
        } else if (fruitName.equalsIgnoreCase("BANANA")) {
            return new Banana();
        } else if (fruitName.equalsIgnoreCase("PEACH")) {
            return new Peach();
        } else {
            return null;
        }
    }
}
