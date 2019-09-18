package org.tony.graph.algorithm;

import org.tony.graph.vertex.NumericVertex;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PreviousVertexes {
    private final Map<NumericVertex, NumericVertex> data = new TreeMap<>();

    public void put(NumericVertex current, NumericVertex previous) {
        data.put(current, previous);
    }

    public Set<Map.Entry<NumericVertex, NumericVertex>> getAll() {
        return data.entrySet();
    }
}
