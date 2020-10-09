package com.ghost.mastermind;

import org.junit.Test;
import static org.junit.Assert.*;

public class CodeUnitTest {

    @Test
    public void Code_canBeCreated() {
        Code newCode = new Code(4, true);

        assertEquals(newCode.getLength(), 4);
        assertTrue(newCode.isAllowingDuplicates());
    }

    @Test
    public void Code_canBeModifiedAsExpected() {
        Code code = new Code(4, true);
        Code newCode = code.setBallToColor(2, 5);

        assertEquals(newCode.getLength(), code.getLength());
        assertEquals(newCode.isAllowingDuplicates(), code.isAllowingDuplicates());
        assertEquals(newCode.getBalls().get(2).getColor(), 5);
    }


    @Test
    public void Code_canBeCompared() {
        Code c1 = new Code (4, false);
        Code c2 = new Code (4, true);
        Code c3 = new Code (3, false);
        Code c4 = new Code (3, true);

        assertFalse(c1.equals(c2));
        assertFalse(c1.equals(c3));
        assertFalse(c1.equals(c4));

        Code c5 = new Code (4, false);
        assertTrue(c1.equals(c5));
    }

    @Test
    public void Code_ballCanBeSet() {
        Code c1 = new Code(4, true);
        Code c2 = new Code(4, false);

        Code newC1 = c1.setBallToColor(3, 2);
        assertNotNull(newC1);
        assertEquals(newC1.getBalls().get(3).getColor(), 2);

        Code newC2 = c2.setBallToColor(3, 0);
        assertNull(newC2);
    }

    @Test
    public void MasterCode_generatesNonduplicatedRandomBalls() {
        MasterCode mc = new MasterCode(4, false, 6);
        assertFalse(mc.hasDuplicates());
    }

}
