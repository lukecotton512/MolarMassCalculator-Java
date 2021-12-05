package dev.stripedcat.MolarMassCalculator.calculator.tree;

import java.util.List;

public class Formula implements FormulaItem {
    private List<FormulaItem> components;
    private int multiplier;

    public void addComponent(FormulaItem component) {
        this.components.add(component);
    }

    public double getWeight() {
        double weight = 0.0;
        for (FormulaItem component: components) {
            weight += component.getWeight();
        }
        return weight;
    }

    public int getMultiplier() {
        return this.multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }
}
