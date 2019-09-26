package org.tony.graph.algorithm;

import org.tony.graph.vertex.NumericVertex;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PreviousVertexes<VertexT extends NumericVertex> {
    private final Map<VertexT, VertexT> data = new TreeMap<>();

    public void put(VertexT current, VertexT previous) {
        data.put(current, previous);
    }

    public Set<Map.Entry<VertexT, VertexT>> getAll() {
        return data.entrySet();
    }
}
