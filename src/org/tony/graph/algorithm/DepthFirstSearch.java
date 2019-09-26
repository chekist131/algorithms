package org.tony.graph.algorithm;

import org.tony.graph.Graph;
import org.tony.graph.vertex.NumericVertex;

import java.util.TreeMap;

/**
 * Алгоритм поиска в глубину на графе
 */
public class DepthFirstSearch<VertexT extends NumericVertex> {

    private final Graph<VertexT> graph;
    private final PreviousVertexes<VertexT> previousVertexes;

    public DepthFirstSearch(Graph<VertexT> graph) {
        this.graph = graph;
        previousVertexes = new PreviousVertexes<>();
        init();
    }

    private void init() {
        final TreeMap<VertexT, VertexColor> statusC = new TreeMap<>();
        for (VertexT node : graph.getAllNodes()) {
            statusC.put(node, VertexColor.White);
        }
        for (VertexT node : graph.getAllNodes()) {
            if (statusC.get(node) == VertexColor.White) {
                initRecur(node, statusC);
            }
        }
    }

    private void initRecur(VertexT node, TreeMap<VertexT, VertexColor> statusC) {
        statusC.put(node, VertexColor.Grey);
        for (VertexT next : graph.getLinks(node)) {
            if (statusC.get(next) == VertexColor.White){
                previousVertexes.put(next, node);
                initRecur(next, statusC);
            }
        }
        statusC.put(node, VertexColor.Black);
    }

    public PreviousVertexes<VertexT> getPreviousVertexes() {
        return previousVertexes;
    }
}
