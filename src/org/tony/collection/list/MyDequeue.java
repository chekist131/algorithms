package org.tony.collection.list;

import org.tony.collection.MyCollection;

public interface MyDequeue extends MyCollection {
    void pushRight(int x);
    int popLeft();
    void pushLeft(int x);
    int popRight();
}
