// public class Kangaroo implements Transporter<Wallaby>
public interface Transporter<T extends Transportable> {

    boolean load(Transportable t);

    Transportable unload(int vehiclesToUnload);
}
