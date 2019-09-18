package org.tony.graph.algorithm;

import org.tony.graph.Graph;
import org.tony.graph.vertex.NumericVertex;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Алогоритм поиска в ширину на графе (Breadth First Search)
 */
public class BreadthFirstSearch<VertexT extends NumericVertex> {

    private Graph<VertexT> graph;
    private final VertexT startNode;

    private final PreviousVertexes previousVertexes;
    private final PathLengthToVertexes pathLengthToVertexes;

    public BreadthFirstSearch(Graph<VertexT> graph, VertexT startNode) {
        this.graph = graph;
        this.startNode = startNode;
        previousVertexes = new PreviousVertexes();
        pathLengthToVertexes = new PathLengthToVertexes();
        init();
    }

    private void init() {
        final TreeMap<VertexT, VertexColor> statusC = new TreeMap<>();
        for (VertexT node : graph.getAllNodes()) {
            if (node != startNode) {
                pathLengthToVertexes.put(node, Integer.MAX_VALUE);
                statusC.put(node, VertexColor.White);
            }
        }
        pathLengthToVertexes.put(startNode, 0);
        statusC.put(startNode, VertexColor.Grey);
        final Queue<VertexT> queue = new LinkedList<>();
        queue.add(startNode);
        while (!queue.isEmpty()) {
            final VertexT node = queue.poll();
            for (VertexT next : graph.getLinks(node)) {
                if (statusC.get(next) == VertexColor.White) {
                    pathLengthToVertexes.put(next, pathLengthToVertexes.get(node) + 1);
                    previousVertexes.put(next, node);
                    queue.add(next);
                    statusC.put(next, VertexColor.Grey);
                }
            }
            statusC.put(node, VertexColor.Black);
        }
    }

    public VertexT getStartNode() {
        return startNode;
    }

    /**
     * @return путь от начальной вершины до каждой
     * (соответствие вершин своим предшественникам)
     * (при наличии нескольких путей могут отличатся)
     */
    public PreviousVertexes getPreviousVertexes() {
        return previousVertexes;
    }

    /**
     * @return количестов переходов от начальной вершины то других
     */
    public PathLengthToVertexes getPathLengthToVertexes() {
        return pathLengthToVertexes;
    }

}
