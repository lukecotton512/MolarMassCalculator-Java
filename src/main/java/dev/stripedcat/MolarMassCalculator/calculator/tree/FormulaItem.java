package dev.stripedcat.MolarMassCalculator.calculator.tree;

public interface FormulaItem {
    public double getWeight();

    public int getMultiplier();
    public void setMultiplier(int multiplier);
}
