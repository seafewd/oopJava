import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;

class CarTest {
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
        Assertions.assertEquals("Current position: (4, 6)", saab.getPosition(saab));
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
        Assertions.assertEquals(-1, saab.xPos);
    }

    /**
     * Test method turnRight
     */
    @Test
    public void testTurnRight() {
        saab.xPos = 0;
        saab.gas(0.3);
        Assertions.assertEquals(1, saab.xPos);
    }

    /**
     * Test method isInLimit
     */
    @Test
    public void testIsInLimit() {
        Assertions.assertFalse(saab.isInLimit(.5, 1.5, 2.0));
        Assertions.assertTrue(saab.isInLimit(.3, .9, .6));
    }

}