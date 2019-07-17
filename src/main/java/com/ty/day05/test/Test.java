package com.ty.day05.test;

public class Test {

    int i;
    Point p;

    @Override
    public String toString() {
        return "Test{" +
                "i=" + i +
                ", p=" + p +
                '}';
    }

    public Test(int i, Point p) {
        this.i = i;
        this.p = p;
    }
}
