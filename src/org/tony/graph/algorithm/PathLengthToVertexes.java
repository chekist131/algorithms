package org.tony.graph.algorithm;

import org.tony.graph.vertex.NumericVertex;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PathLengthToVertexes {
    private final Map<NumericVertex, Integer> data = new TreeMap<>();

    public void put(NumericVertex numericVertex, int length) {
        data.put(numericVertex, length);
    }

    public int get(NumericVertex node) {
        return data.get(node);
    }

    public Set<Map.Entry<NumericVertex, Integer>> getAll() {
        return data.entrySet();
    }
}
