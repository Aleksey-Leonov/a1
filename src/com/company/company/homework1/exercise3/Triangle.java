package com.company.company.homework1.exercise3;

    public class Triangle implements GettingS {
    private double a;
    private double h;

        public Triangle(double a, double h) {
            this.a = a;
            this.h = h;
        }

        @Override
    public double GettingS() {
        return 1/2*(a*h);
    }
}
