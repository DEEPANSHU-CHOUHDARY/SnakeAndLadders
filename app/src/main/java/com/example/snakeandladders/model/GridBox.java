package com.example.snakeandladders.model;

public class GridBox {
    private boolean red;
    private boolean green;
    private boolean white;
    private boolean currentPosition;

    public GridBox(boolean red, boolean green, boolean white, boolean currentPosition) {
        this.red = red;
        this.green = green;
        this.white = white;
        this.currentPosition = currentPosition;
    }

    public boolean isRed() {
        return red;
    }

    public void setRed(boolean red) {
        this.red = red;
    }

    public boolean isGreen() {
        return green;
    }

    public void setGreen(boolean green) {
        this.green = green;
    }

    public boolean isWhite() {
        return white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public boolean isCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(boolean currentPosition) {
        this.currentPosition = currentPosition;
    }
}
