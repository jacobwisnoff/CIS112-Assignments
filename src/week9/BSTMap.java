package week9;

import ch07.trees.*;
import ch08.maps.*;
import java.util.Iterator;

public class BSTMap<K,V> implements MapInterface<K,V> {

    private BinarySearchTree<MapEntry<K,V>> map;

    public BSTMap(){
        map = new BinarySearchTree<>();
    }

    @Override
    public V put(K k, V v) {
        return null;
    }

    @Override
    public V get(K k) {
        return null;
    }

    @Override
    public V remove(K k) {
        return null;
    }

    @Override
    public boolean contains(K k) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<MapEntry<K, V>> iterator() {
        return map.iterator();
    }
}
