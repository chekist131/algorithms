package org.tony.graph;

import org.tony.graph.vertex.NumericVertex;

import java.util.*;

public class Graph<VertexT extends NumericVertex> {

    private final Map<VertexT, Set<VertexT>> data = new TreeMap<>();

    public Set<VertexT> getAllNodes() {
        return data.keySet();
    }

    public Set<VertexT> getLinks(VertexT vertexT){
        data.computeIfAbsent(vertexT, k -> new TreeSet<>());
        return data.get(vertexT);
    }

    public void setLink(VertexT from, VertexT to){
        data.computeIfAbsent(from, k -> new TreeSet<>());
        data.get(from).add(to);
    }
}
