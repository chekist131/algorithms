package org.tony.graph.algorithm;

import org.tony.graph.vertex.NumericVertex;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PathLengthToVertexes<VertexT extends NumericVertex> {
    private final Map<VertexT, Integer> data = new TreeMap<>();

    public void put(VertexT numericVertex, int length) {
        data.put(numericVertex, length);
    }

    public int get(VertexT node) {
        return data.get(node);
    }

    public Set<Map.Entry<VertexT, Integer>> getAll() {
        return data.entrySet();
    }
}
