import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CarrierTest {

    Car saab = new Saab95();
    Car volvo = new Volvo240();
    Car volvo2 = new Volvo240();
    Car volvo3 = new Volvo240();
    Car volvo4 = new Volvo240();
    Car volvo5 = new Volvo240();
    Scania scania = new Scania();
    Carrier ferry = new BoatyMcBoatFace();

    /**
     * Reset vehicle positions & clear cargo
     */
    @Before
    public void resetPositionsAndClearCargo() {
        scania.load.clear();

        volvo.setXPos(0);
        volvo.setYPos(0);
        volvo2.setXPos(0);
        volvo2.setYPos(0);
        volvo3.setXPos(0);
        volvo3.setYPos(0);
        volvo4.setXPos(0);
        volvo4.setYPos(0);
        volvo5.setXPos(0);
        volvo5.setYPos(0);
        saab.setXPos(0);
        saab.setYPos(0);
        scania.setXPos(0);
        scania.setYPos(0);
    }

    /**
     * Test isCloseEnoughToLoad
     * Assert true because x-and y-positions are within boundaries
     */
    @Test
    public void testIsCloseEnoughToLoad() {
        saab.setXPos(5);
        saab.setYPos(4);
        scania.setXPos(2);
        scania.setYPos(2);
        Assertions.assertTrue(scania.isCloseEnoughToLoad(saab));
    }

    /**
     * Test isCloseEnoughToLoad
     * Assert false because x-and y-positions are outside boundaries
     */
    @Test
    public void testIsCloseEnoughToLoadWhenFarAway() {
        saab.setXPos(25);
        saab.setYPos(-18);
        scania.setXPos(2);
        scania.setYPos(2);
        Assertions.assertFalse(scania.isCloseEnoughToLoad(saab));
    }

    /**
     * Test load car
     */
    @Test
    public void testLoadCar() {
        scania.loadCar(saab);
        scania.loadCar(volvo);
        Assertions.assertEquals(2, scania.getLoad().size());
    }

    /**
     * Test transportNotFull
     */
    @Test
    public void testTransportNotFull() {
        scania.loadCar(saab);
        scania.loadCar(volvo);
        scania.loadCar(volvo2);
        scania.loadCar(volvo3);
        scania.loadCar(volvo4);
        System.out.println("cars: " + scania.getLoad().size());
        System.out.println(scania.modelName);
        // should fail here because Scania only takes 5 cars
        Assertions.assertFalse(scania.transportNotFull());
    }

    /**
     * Test moveLoad (x-pos)
     */
    @Test
    public void testMoveLoad() {
        scania.load.clear();
        scania.loadCar(saab);
        scania.move();
        scania.move();
        scania.turnLeft();
        scania.turnLeft();
        scania.move();
        Assertions.assertEquals(scania.getXPos(), saab.getXPos());
    }

    /**
     * Test moveLoad (y-pos)
     */
    @Test
    public void testMoveLoadYPos() {
        scania.load.clear();
        scania.loadCar(saab);
        scania.gas(.7);
        scania.move();
        scania.turnLeft();
        scania.turnLeft();
        scania.move();
        Assertions.assertEquals(scania.getYPos(), saab.getYPos());
    }

    /**
     * Test unloadVehicles (y-pos)
     */
    @Test
    public void testUnloadVehicles() {
        scania.load.clear();
        scania.loadCar(saab);
        scania.loadCar(volvo);
        scania.loadCar(volvo2);
        scania.unloadVehicles(3);
        Assertions.assertEquals(-4, volvo2.getXPos());
    }
}
