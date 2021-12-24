package dev.stripedcat.MolarMassCalculator.calculator.tree;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

public class Formula implements FormulaItem, Collection<FormulaItem> {
    private List<FormulaItem> components;
    private int multiplier;

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

    public FormulaItem getComponent(int index) {
        return this.components.get(index);
    }

    @Override
    public boolean add(FormulaItem component) {
        return this.components.add(component);
    }

    // Return number of items in the underlying array.
    @Override
    public int size() {
        return this.components.size();
    }

    // See if the formula is empty.
    @Override
    public boolean isEmpty() {
        return this.components.isEmpty();
    }

    // See if the formula contains an item.
    @Override
    public boolean contains(Object o) {
        return this.components.contains(o);
    }

    // Return an iterator to iterate over the formula.
    @Override
    public Iterator<FormulaItem> iterator() {
        return this.components.iterator();
    }

    // Return an array of Objects.
    @Override
    public Object[] toArray() {
        return this.components.toArray();
    }

    // Return an array of generic items.
    @Override
    public <T> T[] toArray(T[] a) {
        if (!(a instanceof FormulaItem[])) {
            throw new ArrayStoreException();
        }
        return this.components.toArray(a);
    }

    @Override
    public boolean remove(Object o) {
        return this.components.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.components.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends FormulaItem> c) {
        return this.components.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.components.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.components.retainAll(c);
    }

    @Override
    public void clear() {
        this.components.clear();
    }

    @Override
    public Spliterator<FormulaItem> spliterator() {
        return this.components.spliterator();
    }

    @Override
    public Stream<FormulaItem> stream() {
        return this.components.stream();
    }
}
