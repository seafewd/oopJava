import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.awt.*;

/**
 * CarTest test class
 */
public class CarTest {

    /**
     * Set up test car
     */
    private final Saab95 saab = new Saab95();

    /**
     * Test method getNrDoors
     */
    @Test
    public void testGetNrDoors(){
        Assertions.assertEquals(2, saab.getNrDoors());
    }

    /**
     * Test method getEnginePower
     */
    @Test
    public void testGetEnginePower(){
        Assertions.assertEquals(125, saab.getEnginePower());
    }

    /**
     * Test method getCurrentSpeed
     */
    @Test
    public void testGetCurrentSpeed() {
        Assertions.assertEquals(0, saab.getCurrentSpeed());
    }

    /**
     * Test method getColor
     */
    @Test
    public void testGetColor() {
        Assertions.assertEquals(Color.red, saab.getColor());
    }

    /**
     * Test method setColor
     */
    @Test
    public void testSetColor() {
        saab.setColor(Color.blue);
        Assertions.assertSame(saab.getColor(), Color.blue);
    }

    /**
     * Test method startEngine
     */
    @Test
    public void testStartEngine() {
        saab.startEngine();
        Assertions.assertEquals(0.1, saab.getCurrentSpeed());
    }

    /**
     * Test method stopEngine
     */
    @Test
    public void testStopEngine() {
        saab.stopEngine();
        Assertions.assertEquals(0, saab.getCurrentSpeed());
    }

    /**
     * Test method getPosition
     */
    @Test
    public void testGetPosition() {
        saab.xPos = 6;
        saab.yPos = 4;
        Assertions.assertEquals("Current position: (6, 4).", saab.getPosition(saab));
    }

    /**
     * Test method move
     */
    @Test
    public void testMove() {
        saab.yPos = 0;
        saab.move();
        Assertions.assertEquals(1, saab.yPos);
    }

    /**
     * Test method turnLeft
     */
    @Test
    public void testTurnLeft() {
        saab.xPos = 0;
        saab.gas(0.3);
        saab.turnLeft();
        Assertions.assertEquals(-1, saab.xPos);
    }

    /**
     * Test method turnRight
     */
    @Test
    public void testTurnRight() {
        saab.xPos = 0;
        saab.gas(0.3);
        saab.turnRight();
        Assertions.assertEquals(1, saab.xPos);
    }

    /**
     * Test method isInLimit (exceeding upper bound)
     */
    @Test
    public void testIsInLimitUpper() {
        Assertions.assertFalse(saab.isInLimit(.5, 1.5, 2.0));
    }

    /**
     * Test method isInLimit (not exceeding bounds)
     */
    @Test
    public void testIsInLimitLower() {
        Assertions.assertTrue(saab.isInLimit(.3, .9, .6));
    }


    /**
     * Test method gas
     */
    @Test
    public void testGas() {
        saab.currentSpeed = .1;
        saab.gas(.5);
        Assertions.assertTrue(saab.getCurrentSpeed() >= 0.6);
    }

    /**
     * Test method brake
     */
    @Test
    public void testBrake() {
        saab.currentSpeed = .6;
        saab.brake(.4);
        Assertions.assertTrue(saab.getCurrentSpeed() <= .2);
    }

    /**
     * Test method incrementSpeed
     */
    @Test
    public void testIncrementSpeed() {
        saab.currentSpeed = 0;
        saab.incrementSpeed(.7);
        Assertions.assertTrue(saab.getCurrentSpeed() >= .7);
    }

    /**
     * Test method decrementSpeed (normal with fixed values, not exceeding
     * lower bound value
     */
    @Test
    public void testDecrementSpeed() {
        saab.currentSpeed = .5;
        saab.decrementSpeed(.3);
        Assertions.assertTrue(saab.getCurrentSpeed() <= .2);
    }

    /**
     * Test method decrementSpeed (exceeding lower bound value)
     */
    @Test
    public void testDecrementSpeedExceedingBounds() {
        saab.currentSpeed = 0;
        saab.decrementSpeed(5);
        Assertions.assertEquals(0, saab.getCurrentSpeed());
    }

}