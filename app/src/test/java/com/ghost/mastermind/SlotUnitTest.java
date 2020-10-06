package com.ghost.mastermind;

import org.junit.Test;
import static org.junit.Assert.*;

public class SlotUnitTest {
    @Test
    public void Slot_slotBallCanBeSet() {
        Slot slot = new Slot(4, false);

        Slot mod_slot = slot.setSlotBallToColor(3, 34);
        Code mod_slotcode = mod_slot.getSlotCode();
        assertEquals(mod_slotcode.getBalls().get(3).getColor(), 34);
    }

    @Test
    public void Slot_slotFeedbackCanBeSet() {
        Slot slot = new Slot(4, false);

        Slot mod_slot = slot.setFeedbackBallToColor(3, 34);
        assertNotNull(mod_slot);

        Code mod_feedback = mod_slot.getFeedbackCode();
        assertEquals(mod_feedback.getBalls().get(3).getColor(), 34);
    }

    @Test
    public void Slot_slotCanBeChecked() {
        Slot slot = new Slot(100, true);
        MasterCode mc = new MasterCode(100, true, 5);
        assertFalse(slot.checkSlot(mc));

        int i = 0;
        for (Ball b : mc.getBalls()) {
            slot = slot.setSlotBallToColor(i, b.getColor());
            i++;
        }

        assertTrue(slot.checkSlot(mc));
    }

}
