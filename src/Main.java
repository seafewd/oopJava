public class Main {

    public static void main(String[] args) {
        Car volvo = new Volvo240();
        volvo.nrDoors = 4;

        System.out.println(volvo.getNrDoors());
    }
}
