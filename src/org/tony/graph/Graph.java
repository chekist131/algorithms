package org.tony.graph;

import java.util.*;

public class Graph {

    /**
     * Пример графа из видео
     * https://www.youtube.com/watch?v=I8VEJVlB8mw
     */
    public void initSample() {
        final List<NumericVertex> verts = new ArrayList<>();
        for (int i = 0; i < 6; i++)
            verts.add(i, new NumericVertex(i + 1));
        verts.get(0).addLink(verts.get(1));
        verts.get(0).addLink(verts.get(3));
        verts.get(1).addLink(verts.get(5));
        verts.get(2).addLink(verts.get(5));
        verts.get(3).addLink(verts.get(1));
        verts.get(3).addLink(verts.get(2));
        verts.get(4).addLink(verts.get(3));
        verts.get(4).addLink(verts.get(5));
        verts.get(5).addLink(verts.get(3));
        verts.get(5).addLink(verts.get(4));
    }

    protected final Map<NumericVertex, Set<NumericVertex>> data = new TreeMap<>();

    public Set<NumericVertex> getAllNodes() {
        return data.keySet();
    }

    public class NumericVertex implements Comparable<NumericVertex> {
        protected final int number;

        public NumericVertex(int number) {
            this.number = number;
        }

        public Set<NumericVertex> getNextVertexes() {
            return Graph.this.data.get(this);
        }

        public void addLink(NumericVertex toNode) {
            data.computeIfAbsent(this, vertexT -> new TreeSet<>());
            data.get(this).add(toNode);
        }

        @Override
        public int compareTo(NumericVertex numericVertex) {
            return this.number - numericVertex.number;
        }

        @Override
        public String toString() {
            return "NumericVertex{" +
                    "number=" + number +
                    '}';
        }

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
    }

    public class PreviousVertexes {
        private final Map<NumericVertex, NumericVertex> data = new TreeMap<>();

        public void put(NumericVertex current, NumericVertex previous) {
            data.put(current, previous);
        }

        public Set<Map.Entry<NumericVertex, NumericVertex>> getAll() {
            return data.entrySet();
        }
    }

    /**
     * Алогоритм поиска в ширину на графе (Breadth First Search)
     */
    public class BreadthFirstSearch {

        private final NumericVertex startNode;

        private final Graph.PreviousVertexes previousVertexes;
        private final NumericVertex.PathLengthToVertexes pathLengthToVertexes;

        public BreadthFirstSearch(NumericVertex startNode) {
            this.startNode = startNode;
            previousVertexes = new PreviousVertexes();
            pathLengthToVertexes = startNode.new PathLengthToVertexes();
            init();
        }

        private void init() {
            final TreeMap<NumericVertex, VertexColor> statusC = new TreeMap<>();
            for (NumericVertex node : getAllNodes()) {
                if (node != startNode) {
                    pathLengthToVertexes.put(node, Integer.MAX_VALUE);
                    statusC.put(node, VertexColor.White);
                }
            }
            pathLengthToVertexes.put(startNode, 0);
            statusC.put(startNode, VertexColor.Grey);
            final Queue<NumericVertex> queue = new LinkedList<>();
            queue.add(startNode);
            while (!queue.isEmpty()) {
                final NumericVertex node = queue.poll();
                for (NumericVertex next : node.getNextVertexes()) {
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

        public NumericVertex getStartNode() {
            return startNode;
        }

        /**
         * @return путь от начальной вершины до каждой
         * (соответствие вершин своим предшественникам)
         * (при наличии нескольких путей могут отличатся)
         */
        public Graph.PreviousVertexes getPreviousVertexes() {
            return previousVertexes;
        }

        /**
         * @return количестов переходов от начальной вершины то других
         */
        public NumericVertex.PathLengthToVertexes getPathLengthToVertexes() {
            return pathLengthToVertexes;
        }

    }

    protected enum VertexColor {White, Grey, Black}

    /**
     * Алгоритм поиска в глубину на графе
     */
    public class DepthFirstSearch {

        private final Graph.PreviousVertexes previousVertexes;

        public DepthFirstSearch() {
            previousVertexes = new PreviousVertexes();
            init();
        }

        private void init() {
            final TreeMap<NumericVertex, VertexColor> statusC = new TreeMap<>();
            for (NumericVertex node : getAllNodes()) {
                statusC.put(node, VertexColor.White);
            }
            for (NumericVertex node : getAllNodes()) {
                if (statusC.get(node) == VertexColor.White) {
                    initRecur(node, statusC);
                }
            }
        }

        private void initRecur(NumericVertex node, TreeMap<NumericVertex, VertexColor> statusC) {
            statusC.put(node, VertexColor.Grey);
            for (NumericVertex next : node.getNextVertexes()) {
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

}
