package com.ghost.mastermind;

class Ball {

    private int value;

     Ball(int value) { this.value = value; }

     int getColor() {
        return value;
    }

     Ball setValue(int value) {
        return new Ball(value);
    }

     boolean equals(Ball other) {
        return value == other.getColor();
    }
}
