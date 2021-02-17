package Test;

public class Kangaroo implements Transporter<Kangaroo>, Transportable {

    private DefaultTransporter<Kangaroo> dt;

    public Kangaroo() {
        dt = new DefaultTransporter<>();
    }

    @Override
    public void load(Kangaroo kangaroo) {
            dt.load(kangaroo);
    }

    @Override
    public Kangaroo unload() {
        return dt.unload();
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getWeight() {
        return 0;
    }
}
