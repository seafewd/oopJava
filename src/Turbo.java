public class Turbo {

    private boolean turboOn;

    public Turbo() {
        turboOn = false;
    }

    public boolean isTurboOn() {
        return turboOn;
    }

    public void toggleTurboOn() {
        turboOn = !turboOn;
    }
}
