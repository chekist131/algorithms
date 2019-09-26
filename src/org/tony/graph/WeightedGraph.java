package org.tony.graph;

import org.tony.graph.vertex.NumericVertex;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WeightedGraph<VertexT extends NumericVertex> extends Graph<VertexT> {

    private final Map<VertexT, Map<VertexT, Integer>> weights = new TreeMap<>();

    public void setLink(VertexT from, VertexT to, int weight) {
        if (weights.get(from) == null) {
            Map<VertexT, Integer> e = new TreeMap<>();
            e.put(to, weight);
            weights.put(from, e);
        } else {
            weights.get(from).put(to, weight);
        }
    }

    @Override
    public void setLink(VertexT from, VertexT to) {
        this.setLink(from, to, 1);
    }

    @Override
    public Set<VertexT> getLinks(VertexT numericVertex) {
        return weights.get(numericVertex).keySet();
    }

    @Override
    public Set<VertexT> getAllNodes() {
        return weights.keySet();
    }

    @Override
    public int getLength(VertexT from, VertexT to) {
        return weights.get(from).get(to);
    }
}
