package week9;

import ch07.trees.*;
import ch08.maps.*;
import java.util.Iterator;

// *NOTE* The access modifier for the MapEntry() constructor of
// the MapEntry class must be changed to public *NOTE*

public class BSTMap<K,V> implements MapInterface<K,V> {

    private BinarySearchTree<MapEntry<K,V>> map;

    public BSTMap(){
        map = new BinarySearchTree<>();
    }

    @Override
    public V put(K k, V v) {
        if (k == null){
            throw new IllegalArgumentException("Maps do not allow null keys.");
        }

        MapEntry<K, V> entry = new MapEntry<K, V>(k, v);

        MapEntry<K, V> temp;
        Iterator<MapEntry<K, V>> search = map.iterator();
        while (search.hasNext()){

            temp = search.next();
            if (temp.getKey().equals(k)){

                search.remove();
                map.add(entry);
                return temp.getValue();
            }
        }

        map.add(entry);
        return null;

    }

    @Override
    public V get(K k) {
        if (k == null)
            throw new IllegalArgumentException("Maps do not allow null keys.");

        for (MapEntry<K, V> temp : map){
            if (temp.getKey().equals(k)){
                return temp.getValue();
            }

        }
        return null;
    }

    @Override
    public V remove(K k) {
        if (k == null){
            throw new UnsupportedOperationException("Maps do not allow null keys.");
        }

        MapEntry<K, V> temp;

        Iterator<MapEntry<K, V>> search = map.iterator();
        while (search.hasNext()){
            temp = search.next();

            if (temp.getKey().equals(k)){
                search.remove();
                return temp.getValue();

            }
        }
        return null;
    }

    @Override
    public boolean contains(K k) {
        if (k == null){
            throw new UnsupportedOperationException("Maps do not support null keys.");
        }

        for (MapEntry<K, V> temp : map){
            if (temp.getKey().equals(k)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();   // returns BST isEmpty method
    }

    @Override
    public boolean isFull() {
        return false;           // link-based BST are never full
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
