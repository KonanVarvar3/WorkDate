package com.homework.task1.ball;

import com.homework.task1.ball.Ball;

public class Container {

    private int x1;
    private int x2;
    private int y1;
    private int y2;

    private int width;
    private int height;

    public Container(int x, int y, int width, int height) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x + width;
        this.y2 = y + height;
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    //the abscissa and ordinate axes are divided into four parts counterclock-wise from the top right part
    //the number after the X is the part
    //X to the right is positive, and Y down is positive
    public boolean collides(Ball ball) {
        // 1 and 4 part of coordinat for X
        // and 4 and 3 part of coordinat for Y
        float coordLeftX4 = ball.getX() - ball.getRadius();// = coordLeftX1
        float coordRightX4 = ball.getX() + ball.getRadius();// = coordRightX1
        float coordLessY4 = ball.getY() - ball.getRadius();// = coordLessY3
        float coordMoreY4 = ball.getY() + ball.getRadius();// = coordMoreY3

        // 2 and 3 part of coordinat for X
        // and 1 and 2 part of coordinat for Y
        float coordRightX3 = ball.getX() + ball.getRadius();// = coordRightX2
        float coordLeftX3 = ball.getX() - ball.getRadius();// = coordLeftX2
        float coord1LessY2 = ball.getY() + ball.getRadius();// = coordLessY1
        float coordMoreY2 = ball.getY() - ball.getRadius();// = coordMoreY1

        return (coordLeftX4 >= x1 && coordRightX4 <= x2 && coordLessY4 >= y1 && coordMoreY4 <= y2)//4 part
                || (coordLeftX4 >= x1 && coordRightX4 <= x2 && coordMoreY2 >= y1 && coord1LessY2 <= y2)//1 part
                || (coordRightX3 <= x1 && coordLeftX3 >= x2 && coordMoreY2 <= y1 && coord1LessY2 >= y2)//2 part
                || (coordRightX3 <= x1 && coordLeftX3 >= x2 && coordLessY4 >= y1 && coordMoreY4 <= y2);//3 part
    }

    @Override
    public String toString() {
        return "\"Container[(" + x1 + "," + y1
                + "),(" + x2 + "," + y2 + ")]\"";
    }
}
