import java.util.ArrayList;

public class Deposito<T> {
    private ArrayList<T> x;

    public Deposito() {
        x = new ArrayList<T>();
    }

    public void add(T y) {
        x.add(y);
    }

    public T get() {
        if (x.size() == 0) {
            return null;
        } else {
            return x.remove(0);
        }
    }
}