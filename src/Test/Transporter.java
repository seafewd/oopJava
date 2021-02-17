package Test;

// public class Kangaroo implements Transporter<Wallaby>
public interface Transporter<T extends Transportable> {

    void load(T t);
    T unload();
}
