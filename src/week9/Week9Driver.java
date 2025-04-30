package week9;

import ch08.maps.HMap;
import ch08.maps.MapEntry;

public class Week9Driver {

    public static void main(String[] args){

        // #10: BST Map implementation
        System.out.println("Problem #10: BSTMap Implementation");
        System.out.println("------------------");
        BSTMap<Integer,String> map = new BSTMap<>();
        map.put(1, "Bat");
        map.put(2, "Rat");
        map.put(3, "Dog");

        /* Testing for-each loop
        for(MapEntry<Integer,String> value : map){
            System.out.println(value.getValue());
        }
            */

        System.out.println("Element 1: " + map.get(1)
                            + "\nElement 2: " + map.get(2)
                            + "\nElement 3: " + map.get(3));
        System.out.println("Num Elements in Map: " + map.size());
        System.out.println();

        // #28: HMap
        System.out.println("Problem #28: HMap");
        System.out.println("------------------");

        HMap<Integer,String> hmap = new HMap<>();
        hmap.put(1, "Apple");
        hmap.put(2, "Banana");
        hmap.put(3, "Carrot");
        System.out.println(hmap);
    }
}
