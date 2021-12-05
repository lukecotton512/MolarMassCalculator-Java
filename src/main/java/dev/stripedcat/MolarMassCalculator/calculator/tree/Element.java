package dev.stripedcat.MolarMassCalculator.calculator.tree;

public class Element implements FormulaItem {
    private String name;
    private int multiplier;

    public Element(String name) {
        this(name, 1);
    }

    public Element(String name, int multiplier) {
        this.name = name;
        this.multiplier = multiplier;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMultiplier() {
        return this.multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    public double getWeight() {
        // TODO: Add ability to query database for weight of element.
        return 0.0;
    }
}
