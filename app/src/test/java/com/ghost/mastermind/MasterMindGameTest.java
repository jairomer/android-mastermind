package com.ghost.mastermind;

import org.junit.Test;
import static org.junit.Assert.*;

public class MasterMindGameTest {
    @Test
    public void Game_canBeStarted() {
        MasterMindGame mmg = null;
        try {
            mmg = new MasterMindGame(3, 3, 3, false);
            assertEquals(mmg.getRemainingSlots(), 3);
            assertEquals(mmg.checkCurrentSlot(), MasterMindGame.NEXT_TURN);
            assertEquals(mmg.getRemainingSlots(), 2);
            assertEquals(mmg.checkCurrentSlot(), MasterMindGame.NEXT_TURN);
            assertEquals(mmg.getRemainingSlots(), 1);
            assertEquals(mmg.checkCurrentSlot(), MasterMindGame.DEFEAT);
        } catch (MasterMindGame.GameException e) {
            e.printStackTrace();
            assertFalse(true);
        }
    }

    @Test
    public void Game_colorsCanBeSet() {
        MasterMindGame mmg = null;
        try {
            mmg = new MasterMindGame(3, 3, 3, false);
        } catch (MasterMindGame.GameException e) {
            e.printStackTrace();
        }

        try {
            mmg.setColorOnCurrentSlot(2, 1);
        } catch (MasterMindGame.GameException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        Slot cs = mmg.getCurrentSlot();
        assertEquals(2, cs.getSlotCode().getBalls().get(1).getColor());
    }

    @Test
    public void Game_bruteForceVictory() {
     /* TODO */
    }

}
