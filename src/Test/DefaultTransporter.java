package Test;

import java.util.Collection;

public class DefaultTransporter<T extends Transportable> implements Transporter<T> {
    Collection<T> goods;

    @Override
    public void load(T t) {

    }

    @Override
    public T unload() {
        return null;
    }
}
