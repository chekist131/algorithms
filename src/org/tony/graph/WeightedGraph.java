package org.tony.graph;

import java.util.*;

public class WeightedGraph extends Graph {

    @Override
    public void initSample() {
        final List<NumericVertex> verts = new ArrayList<>(6);
        for (int i = 0; i < 6; i++)
            verts.add(i, new NumericVertex(i + 1));
        verts.get(0).addLink(verts.get(1), 5);
        verts.get(0).addLink(verts.get(3), 3);
        verts.get(1).addLink(verts.get(5), 1);
        verts.get(2).addLink(verts.get(5), 4);
        verts.get(3).addLink(verts.get(1), 4);
        verts.get(3).addLink(verts.get(2), 22);
        verts.get(4).addLink(verts.get(3), 2);
        verts.get(4).addLink(verts.get(5), 6);
        verts.get(5).addLink(verts.get(3), 3);
        verts.get(5).addLink(verts.get(4), 9);
    }

    public class NumericVertex extends Graph.NumericVertex {

        private final Map<NumericVertex, Integer> weights = new TreeMap<>();

        public NumericVertex(int number) {
            super(number);
        }

        public void addLink(NumericVertex node, int weight) {
            weights.put(node, weight);
        }

        public int getWeight(NumericVertex node) {
            return weights.get(node);
        }

        public Map<NumericVertex, Integer> getNextVertexesWithWeights(){
            return weights;
        }
    }
}
