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
        MapEntry<K, V> dummyEntry = new MapEntry<>(k, null);
        MapEntry<K, V> foundEntry = map.get(dummyEntry);
        return (foundEntry != null) ? foundEntry.getValue() : null;
    }

    @Override
    public V remove(K k) {
        return null;
    }

    @Override
    public boolean contains(K k) {
        return map.contains((MapEntry<K, V>) k);
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();   // returns BST isEmpty method
    }

    @Override
    public boolean isFull() {
        return map.isFull();  // returns BST isFull method
    }

    @Override
    public int size() {
        return map.size();  // returns BST size method
    }

    @Override
    public Iterator<MapEntry<K, V>> iterator() {
        return map.iterator();
    }
}
