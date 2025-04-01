package week8;

import ch07.trees.BinarySearchTree;

public class Week8Driver {

    public static void main(String[] args){
        ExtendedBST<Integer> tree = new ExtendedBST<>();

        // 29: min2()

        // Empty tree - Expected: null
        System.out.println(tree.min2());

        // One element tree - Expected: 10
        tree.add(10);
        System.out.println(tree.min2());

        //Multi-element tree - Expected: -5
        tree.add(0);
        tree.add(15);
        tree.add(-5);
        tree.add(5);
        System.out.println(tree.min2());

        // 32: height()

        //RECURSIVE HEIGHT METHOD

        // Multi-element tree - Expected: 2
        System.out.println("Height of current tree: " + tree.height());

        // Empty tree - Expected: -1
        tree = new ExtendedBST<>();
        System.out.println("Height of current tree: " + tree.height());

        // One element tree - Expected: 0
        tree.add(10);
        System.out.println("Height of current tree: " + tree.height());

        //ITERATIVE HEIGHT METHOD

    }

}
