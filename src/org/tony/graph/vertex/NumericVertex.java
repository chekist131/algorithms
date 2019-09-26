package org.tony.graph.vertex;

public class NumericVertex implements Comparable<NumericVertex> {
    protected final int number;

    public NumericVertex(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(NumericVertex numericVertex) {
        return this.number - numericVertex.number;
    }

    @Override
    public String toString() {
        return "NumericVertex{" +
                "number=" + number +
                '}';
    }

}
