package orange.business.jhub.util;

public class FruitDuplicateException extends RuntimeException{

    public FruitDuplicateException(String name) {
        super("Fruit '" + name + "' already exists.");
    }
}
