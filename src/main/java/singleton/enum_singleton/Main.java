package singleton.enum_singleton;

public class Main {
    public static void main(String[] args) {
        Abc obj1 = Abc.INSTANCE;
        obj1.setI(5);
        obj1.show();

        Abc obj2 = Abc.INSTANCE;
        obj2.setI(10);

        obj1.show();
    }
}
