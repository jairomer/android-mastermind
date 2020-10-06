package com.ghost.mastermind;

class Slot {
    private Code feedback;
    private Code slotCode;

    Slot(int length, boolean allowRepeated) {
        this.feedback = new FeedbackCode(length, false);
        this.slotCode = new SlotCode(length, allowRepeated);
    }

    Code getFeedbackCode() { return feedback; }

    Code getSlotCode() { return slotCode; }

    boolean checkSlot(MasterCode mastercode) {
        return slotCode.equals(mastercode);
    }

    Slot setSlotBallToColor(int ballLocation, int color) {
        Code newCode = slotCode.setBallToColor(ballLocation, color);
        if (newCode != null) {
            slotCode = newCode;
            return this;
        }
        return null;
    }

    Slot setFeedbackBallToColor(int ballLocation, int color) {
        Code newCode = feedback.setBallToColor(ballLocation, color);
        if (newCode != null) {
            feedback = newCode;
            return this;
        }
        return null;
    }
}
