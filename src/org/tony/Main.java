package org.tony;

import org.tony.collection.list.*;
import org.tony.collection.set.MyHashSet;
import org.tony.collection.set.MySet;
import org.tony.collection.set.MyTreeSet;
import org.tony.graph.Graph;
import org.tony.graph.WeightedGraph;
import org.tony.sorting.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        weightedGraph();
    }

    static void weightedGraph(){
        WeightedGraph weightedGraph = new WeightedGraph();
        final List<WeightedGraph.NumericVertex> verts = new ArrayList<>(6);
        for (int i = 0; i < 6; i++)
            verts.add(i, weightedGraph.new NumericVertex(i));
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
        System.out.println(verts.get(0));
        System.out.println(verts.get(0).getWeight(verts.get(1)));
        System.out.println(verts.get(0).getNextVertexesWithWeights());
    }

    static void depthFirstSearch() {
        Graph graph = new Graph();
        graph.initSample();
        Graph.DepthFirstSearch depthFirstSearch = graph.new DepthFirstSearch();
        for (Map.Entry<Graph.NumericVertex, Graph.NumericVertex> x :
                depthFirstSearch.getPreviousVertexes().getAll())
            System.out.println(x + " ");
        System.out.println();
    }

    static void breadthFirstSearch() {
        Graph graph = new Graph();
        graph.initSample();
        Graph.NumericVertex startNode = graph.getAllNodes().iterator().next();
        Graph.BreadthFirstSearch breadthFirstSearch = graph.new BreadthFirstSearch(startNode);
        System.out.println("Staring node: " + breadthFirstSearch.getStartNode());
        System.out.println();
        for (Map.Entry<Graph.NumericVertex, Integer> x :
                breadthFirstSearch.getPathLengthToVertexes().getAll())
            System.out.println(x + " ");
        System.out.println();
        for (Map.Entry<Graph.NumericVertex, Graph.NumericVertex> x :
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
