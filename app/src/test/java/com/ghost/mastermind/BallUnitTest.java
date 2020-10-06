package com.ghost.mastermind;


import org.junit.Test;
import static org.junit.Assert.*;

public class BallUnitTest {

    @Test
    public void ball_canBeCreated() {
        Ball b = new Ball(2);
        assertEquals(b.getColor() , 2);
    }

    @Test
    public void ball_canBeModifiedAsExpected() {
        Ball b = new Ball(0);
        Ball b_mod = b.setValue(3);
        assertEquals(b_mod.getColor(), 3);
    }

    @Test
    public void ball_canBeCompared() {
        Ball b1 = new Ball(0);
        Ball b2 = new Ball(1);
        Ball b3 = new Ball(0);

        assertTrue(b1.equals(b3));
        assertFalse(b1.equals(b2));
    }
}
