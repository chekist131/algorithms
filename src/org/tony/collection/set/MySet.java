package org.tony.collection.set;

import org.tony.collection.MyCollection;

import java.util.List;

public interface MySet extends MyCollection {
    boolean find(int x);
    List<Integer> getAll();
}
