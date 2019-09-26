package org.tony;

import org.tony.collection.list.*;
import org.tony.collection.set.MyHashSet;
import org.tony.collection.set.MySet;
import org.tony.collection.set.MyTreeSet;
import org.tony.graph.*;
import org.tony.graph.algorithm.BreadthFirstSearch;
import org.tony.graph.algorithm.DepthFirstSearch;
import org.tony.graph.vertex.NumericVertex;
import org.tony.sorting.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        {
            System.out.println();
            System.out.println("Usual graph");
            Graph<NumericVertex> graph = new Graph<>();
            initGraphWithNumericVertexes(graph);
            breadthFirstSearch(graph);
            depthFirstSearch(graph);
        }
        {
            System.out.println();
            System.out.println("Usual graph");
            Graph<NumericVertex> graph = new WeightedGraph<>();
            initGraphWithNumericVertexes(graph);
            breadthFirstSearch(graph);
            depthFirstSearch(graph);
        }
        {
            System.out.println();
            System.out.println("Weighted graph");
            WeightedGraph<NumericVertex> graph = new WeightedGraph<>();
            initGraphWithWeightedNumericVertexes(graph);
            breadthFirstSearch(graph);
            depthFirstSearch(graph);
        }
    }

    private static void initGraphWithWeightedNumericVertexes(WeightedGraph<NumericVertex> graph){
        final List<NumericVertex> verts = new ArrayList<>(6);
        for (int i = 0; i < 6; i++)
            verts.add(i, new NumericVertex(i));
        graph.setLink(verts.get(0), verts.get(1), 4);
        graph.setLink(verts.get(0), verts.get(3), 2);
        graph.setLink(verts.get(1), verts.get(5), 1);
        graph.setLink(verts.get(2), verts.get(5), 7);
        graph.setLink(verts.get(3), verts.get(1), 5);
        graph.setLink(verts.get(3), verts.get(2), 3);
        graph.setLink(verts.get(4), verts.get(3), 2);
        graph.setLink(verts.get(4), verts.get(5), 5);
        graph.setLink(verts.get(5), verts.get(3), 4);
        graph.setLink(verts.get(5), verts.get(4), 1);
    }

    static void depthFirstSearch(Graph<NumericVertex> graph) {
        DepthFirstSearch<NumericVertex> depthFirstSearch = new DepthFirstSearch<>(graph);
        for (Map.Entry<NumericVertex, NumericVertex> x :
                depthFirstSearch.getPreviousVertexes().getAll())
            System.out.println(x + " ");
        System.out.println();
    }

    /**
     * Пример графа из видео
     * https://www.youtube.com/watch?v=I8VEJVlB8mw
     */
    private static void initGraphWithNumericVertexes(Graph<NumericVertex> g){
        final List<NumericVertex> verts = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            verts.add(i, new NumericVertex(i + 1));
        }
        g.setLink(verts.get(0), verts.get(1));
        g.setLink(verts.get(0), verts.get(3));
        g.setLink(verts.get(1), verts.get(5));
        g.setLink(verts.get(2), verts.get(5));
        g.setLink(verts.get(3), verts.get(1));
        g.setLink(verts.get(3), verts.get(2));
        g.setLink(verts.get(4), verts.get(3));
        g.setLink(verts.get(4), verts.get(5));
        g.setLink(verts.get(5), verts.get(3));
        g.setLink(verts.get(5), verts.get(4));
    }

    static void breadthFirstSearch(Graph<NumericVertex> graph) {
        NumericVertex startNode = graph.getAllNodes().iterator().next();
        BreadthFirstSearch<NumericVertex> breadthFirstSearch = new BreadthFirstSearch<>(graph, startNode);
        System.out.println("Staring node: " + breadthFirstSearch.getStartNode());
        System.out.println();
        for (Map.Entry<NumericVertex, Integer> x :
                breadthFirstSearch.getPathLengthToVertexes().getAll())
            System.out.println(x + " ");
        System.out.println();
        for (Map.Entry<NumericVertex, NumericVertex> x :
                breadthFirstSearch.getPreviousVertexes().getAll())
            System.out.println(x + " ");
        System.out.println();
    }

    static void myList() {
        MyArrayList myArrayList = new MyArrayList();
        {
            System.out.println("ArrayListStack");
            MyStack myStack = myArrayList;
            myStack.add(3);
            myStack.add(1);
            myStack.add(2);
            for (int x : myStack) {
                System.out.print(x + " ");
            }
            System.out.println();
            System.out.println(myStack.pop());
            System.out.println(myStack.pop());
            myStack.add(4);
            System.out.println(myStack.pop());
        }
        {
            System.out.println("ArrayListIndex");
            MyIndexedList myList = myArrayList;
            for (int x : myList) {
                System.out.print(x + " ");
            }
            System.out.println();
            System.out.println(myList.get(0));
        }
        {
            System.out.println("LinkedListStack");
            MyStack myStack = new MyLList();
            myStack.add(3);
            myStack.add(1);
            myStack.add(2);
            for (int x : myStack) {
                System.out.print(x + " ");
            }
            System.out.println();
            System.out.println(myStack.pop());
            System.out.println(myStack.pop());
            myStack.add(4);
            System.out.println(myStack.pop());
        }
        {
            System.out.println("DoubleLinkedListDequeue");
            MyDLList myDLList = new MyDLList();
            MyDequeue myDequeue = myDLList;
            myDequeue.pushLeft(3);
            myDequeue.pushRight(555);
            myDequeue.pushLeft(2);
            myDequeue.pushLeft(1);
            for (Integer x : myDequeue) {
                System.out.print(x + " ");
            }
            System.out.println();
            System.out.println(myDequeue.popRight());
            System.out.println(myDequeue.popRight());
            myDequeue.pushRight(444);
            System.out.println(myDequeue.popLeft());
            System.out.println(myDequeue.popLeft());
            System.out.println(myDequeue.popLeft());
        }
    }

    static void myHashSet() {
        MySet mySet = new MyHashSet();
        mySet.add(1);
        mySet.add(4);
        mySet.add(2);
        mySet.add(2);
        for (int x : mySet)
            System.out.print(x + " ");
        System.out.println();
        System.out.println(mySet.find(1));
        System.out.println(mySet.find(2));
        System.out.println(mySet.find(3));
        System.out.println(mySet.find(4));
        System.out.println(Arrays.toString(mySet.getAll().toArray()));
    }

    static void myTreeSet() {
        MySet mySet = new MyTreeSet();
        mySet.add(1);
        mySet.add(4);
        mySet.add(2);
        mySet.add(2);
        for (int x : mySet)
            System.out.print(x + " ");
        System.out.println();
        System.out.println(mySet.find(1));
        System.out.println(mySet.find(2));
        System.out.println(mySet.find(3));
        System.out.println(mySet.find(4));
        System.out.println(Arrays.toString(mySet.getAll().toArray()));
    }

    static void sortings() {
        Integer[] array = {10, 2, 10, 3, 1, 2, 5};
        List<Sorting> sortingCollection = new LinkedList<>();
        sortingCollection.add(new NoneSorting());
        sortingCollection.add(new BubbleSorting());
        sortingCollection.add(new SelectionSorting());
        sortingCollection.add(new InsertionSorting());
        sortingCollection.add(new ShuttleSorting());
        sortingCollection.add(new ShellSorting());
        sortingCollection.add(new MergeSorting());
        sortingCollection.add(new QuickSorting());
        for (Sorting sorting : sortingCollection) {
            System.out.println(String.format("%s %s",
                    Arrays.toString(sorting.getSortedArray(array)),
                    sorting.getClass().getSimpleName()));
        }
    }
}
