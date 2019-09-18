package org.tony.graph;

import org.tony.graph.vertex.NumericVertex;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WeightedGraph extends Graph<NumericVertex> {

    private final Map<NumericVertex, Map<NumericVertex, Integer>> weights = new TreeMap<>();

    public void setLink(NumericVertex from, NumericVertex to, int weight) {
        if (weights.get(from) == null) {
            Map<NumericVertex, Integer> e = new TreeMap<>();
            e.put(to, weight);
            weights.put(from, e);
        } else {
            weights.get(from).put(to, weight);
        }
    }

    @Override
    public void setLink(NumericVertex from, NumericVertex to) {
        this.setLink(from, to, 1);
    }

    @Override
    public Set<NumericVertex> getLinks(NumericVertex numericVertex) {
        return weights.get(numericVertex).keySet();
    }

    @Override
    public Set<NumericVertex> getAllNodes() {
        return weights.keySet();
    }
}
