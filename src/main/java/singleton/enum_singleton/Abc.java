package singleton.enum_singleton;

public enum Abc {
    INSTANCE; // implicitly create a private constructor
    private int i;

    public void show() {
        System.out.println(i);
    }

    public void setI(int i) {
        this.i = i;
    }
}
