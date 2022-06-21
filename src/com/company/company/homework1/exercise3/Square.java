package com.company.company.homework1.exercise3;

public class Square implements GettingS{
    private double a;
    private double b;

    public Square(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double GettingS() {
        return a*b;
    }
}
