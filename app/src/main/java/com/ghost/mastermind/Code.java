package com.ghost.mastermind;


import java.util.ArrayList;

class Code {

    protected int length;
    protected boolean allowDuplicates;
    protected ArrayList<Ball> balls;

    boolean containsColor(int color) {
        for (Ball b : balls) {
            if (b.getColor() == color)
                return true;
        }
        return false;
    }

    Code(int length, boolean allowduplicates) {
        this.length = length;
        this.allowDuplicates = allowduplicates;
        balls = new ArrayList<>();
        for (int i=0; i<length; ++i)
            balls.add(new Ball(0));
    }

    Code(int length, boolean allowduplicates, ArrayList<Ball> newBalls) {
        this.length = length;
        this.allowDuplicates = allowduplicates;
        this.balls = new ArrayList<>();
        for (int i=0; i<length; ++i)
            this.balls.add(newBalls.get(i));
    }

    int getLength() {
        return length;
    }

    boolean isAllowingDuplicates() {
        return allowDuplicates;
    }

    ArrayList<Ball> getBalls() {
        return balls;
    }

    boolean equals(Code other) {
        if (length != other.getLength() || allowDuplicates != other.isAllowingDuplicates())
            return false;

        ArrayList<Ball> otherBalls = other.getBalls();
        for (int i=0; i < balls.size(); ++i) {
            if (!balls.get(i).equals(other.getBalls().get(i)))
                return false;
        }
        return true;
    }

    Code setBallToColor(int ballLocation, int color) {
        if (ballLocation < 0 || color < 0 || ballLocation > length)
            return null;
        if (!allowDuplicates && containsColor(color))
            return null;

        ArrayList<Ball> newBalls = getBalls();
        newBalls.set(ballLocation, balls.get(ballLocation).setValue(color));
        return new Code(this.getLength(), this.isAllowingDuplicates(), newBalls);
    }
}
