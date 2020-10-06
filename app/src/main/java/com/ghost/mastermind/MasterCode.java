package com.ghost.mastermind;

import java.util.ArrayList;
import java.util.Random;

class MasterCode extends Code {
    private int getRandomColor(int numberOfColors) {
        Random r = new Random();
        int color = r.nextInt(numberOfColors);
        while(!this.isAllowingDuplicates() && this.containsColor(color))
            color = getRandomColor(numberOfColors);

        if (color < 0)
            color = -1*color;
        return color;
    }

    boolean hasDuplicates() {
        for (int i=0; i<balls.size(); ++i) {
            for (int j=i+1; j<balls.size(); ++j) {
                if (balls.get(i).equals(balls.get(j)))
                    return true;
            }
        }
        return false;
    }

    MasterCode(int length, boolean allowduplicates, int numberOfColors) {
        super(length, allowduplicates);
        this.balls = new ArrayList<>();
        for (int i=0; i<length; ++i)
            this.balls.add(new Ball(getRandomColor(numberOfColors)));
    }
}
