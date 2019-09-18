package org.tony.graph.algorithm;

import org.tony.graph.Graph;
import org.tony.graph.vertex.NumericVertex;

import java.util.TreeMap;

/**
 * Алгоритм поиска в глубину на графе
 */
public class DepthFirstSearch {

    private Graph<NumericVertex> graph;
    private final PreviousVertexes previousVertexes;

    public DepthFirstSearch(Graph<NumericVertex> graph) {
        this.graph = graph;
        previousVertexes = new PreviousVertexes();
        init();
    }

    private void init() {
        final TreeMap<NumericVertex, VertexColor> statusC = new TreeMap<>();
        for (NumericVertex node : graph.getAllNodes()) {
            statusC.put(node, VertexColor.White);
        }
        for (NumericVertex node : graph.getAllNodes()) {
            if (statusC.get(node) == VertexColor.White) {
                initRecur(node, statusC);
            }
        }
    }

    private void initRecur(NumericVertex node, TreeMap<NumericVertex, VertexColor> statusC) {
        statusC.put(node, VertexColor.Grey);
        for (NumericVertex next : graph.getLinks(node)) {
            if (statusC.get(next) == VertexColor.White){
                previousVertexes.put(next, node);
                initRecur(next, statusC);
            }
        }
        statusC.put(node, VertexColor.Black);
    }

    public PreviousVertexes getPreviousVertexes() {
        return previousVertexes;
    }
}
