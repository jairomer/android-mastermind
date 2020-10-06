package com.ghost.mastermind;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MasterMindGame {
    private MasterCode masterCode;
    private ArrayList<Slot> slots;
    private int currentSlot;
    private int availableColors;

    final public static int VICTORY   = 0;
    final public static int DEFEAT    = 1;
    final public static int NEXT_TURN = 2;
    final public static int CORRECT_COLOR_CORRECT_POS      = 0;
    final public static int CORRECT_COLOR_INCORRECT_POS    = 1;
    final public static int INCORRECT_COLOR                = 2;

    private void setFeedbackCode() {
        int correctColorCorrectPosition     = 0;
        int correctColorIncorrectPosition   = 0;
        int incorrectColor                  = 0;

        for (int position=0; position<masterCode.getLength(); ++position) {
            if (masterCode.getBalls().get(position).equals(slots.get(currentSlot).getSlotCode().getBalls().get(position)))
                correctColorCorrectPosition++;
            else if (slots.get(currentSlot).getSlotCode().containsColor(masterCode.getBalls().get(position).getColor()))
                correctColorIncorrectPosition++;
            else
                incorrectColor++;
        }
        assert(correctColorCorrectPosition+correctColorIncorrectPosition+incorrectColor == masterCode.getLength());
        Slot curr = slots.get(currentSlot);
        int i=0;
        while(i<correctColorCorrectPosition) {
            curr.setFeedbackBallToColor(i, CORRECT_COLOR_CORRECT_POS);
            ++i;
        }
        while(i<correctColorCorrectPosition+correctColorIncorrectPosition) {
            curr.setFeedbackBallToColor(i, CORRECT_COLOR_INCORRECT_POS);
            ++i;
        }
        while(i<correctColorCorrectPosition+correctColorIncorrectPosition+incorrectColor) {
            curr.setFeedbackBallToColor(i, INCORRECT_COLOR);
            ++i;
        }

        slots.set(currentSlot, curr);
    }

    public MasterMindGame(int numberOfSlots, int numberOfColors, int codeLength, boolean duplicateAllowed) throws GameException {
        slots = new ArrayList<>();
        currentSlot = 0;
        availableColors = numberOfColors;

        if(codeLength > availableColors && !duplicateAllowed)
            throw new GameException("Too few colors");

        for (int i=0; i<numberOfSlots; ++i)
            slots.add(new Slot(codeLength, duplicateAllowed));

        masterCode = new MasterCode(codeLength, duplicateAllowed, numberOfColors);
    }

    public int getRemainingSlots() {
        return slots.size() - currentSlot;
    }

    public int checkCurrentSlot() {
        if (slots.get(currentSlot).checkSlot(masterCode))
            return VICTORY;
        else if (currentSlot == slots.size()-1)
            return DEFEAT;

        setFeedbackCode();
        currentSlot++;
        return NEXT_TURN;
    }

    public void setColorOnCurrentSlot(int color, int index) throws GameException {
        if (color < 0 || color > availableColors)
            throw new GameException("Color out of bounds.");
        if (index < 0 || index > slots.get(currentSlot).getSlotCode().getLength())
            throw new GameException("Index out of bounds");
        slots.set(currentSlot, slots.get(index).setSlotBallToColor(index, color));
    }

    public MasterCode getMastermind() {
        return masterCode;
    }

    public Slot getCurrentSlot() {
        return slots.get(currentSlot);
    }

    static class GameException extends Exception {
        @Nullable

        private String message;
        public GameException(String message) {
            this.message = message;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }
}
