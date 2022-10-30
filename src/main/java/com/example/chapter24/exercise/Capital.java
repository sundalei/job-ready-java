package com.example.chapter24.exercise;

public class Capital {

    private String name;
    private double population;
    private double squareMileage;

    public Capital() {
    }

    public Capital(String name, double population, double squareMileage) {
        this.name = name;
        this.population = population;
        this.squareMileage = squareMileage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public double getSquareMileage() {
        return squareMileage;
    }

    public void setSquareMileage(double squareMileage) {
        this.squareMileage = squareMileage;
    }

    @Override
    public String toString() {
        return "Capital [name=" + name + ", population=" + population + ", squareMileage=" + squareMileage + "]";
    }
}
