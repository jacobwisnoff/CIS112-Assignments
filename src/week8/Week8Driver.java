package week8;

import java.util.Random;

public class Week8Driver {

    public static void main(String[] args){
        ExtendedBST<Integer> tree = new ExtendedBST<>();
        Random rand = new Random();

        // Variables used in fRatio method
        final int NUM_TREES = 10;
        final int NUM_NODES = 1000;
        final int MAX_VALUE = 3000;

        // 29: min2()

        // Empty tree - Expected: null
        System.out.println("Min value of empty tree: " + tree.min2());

        // One-element tree - Expected: 10
        tree.add(10);
        System.out.println("Min value of one-element tree: " + tree.min2());

        //Multi-element tree - Expected: -5
        tree.add(0);
        tree.add(15);
        tree.add(-5);
        tree.add(5);
        tree.add(6);
        System.out.println("Min value of multi-element tree: " + tree.min2());
        System.out.println();

        // 32: height()

        //RECURSIVE AND ITERATIVE HEIGHT METHODS

        // Multi-element tree - Expected: 3
        System.out.println("RECURSIVE - Height of current tree: " + tree.height());
        System.out.println("ITERATIVE - Height of current tree : " + tree.height2());
        System.out.println();

        // Empty tree - Expected: -1
        tree = new ExtendedBST<>();
        System.out.println("RECURSIVE - Height of current tree: " + tree.height());
        System.out.println("ITERATIVE - Height of current tree : " + tree.height2());
        System.out.println();

        // One element tree - Expected: 0
        tree.add(10);
        System.out.println("RECURSIVE - Height of current tree: " + tree.height());
        System.out.println("ITERATIVE - Height of current tree : " + tree.height2());
        System.out.println();

        // 48: fRatio()
        for (int i = 1; i <= NUM_TREES; i++) {
            tree = new ExtendedBST<>();

            // Insert 1000 random integers between 1 and 3000
            for (int j = 0; j < NUM_NODES; j++) {
                int value = rand.nextInt(MAX_VALUE) + 1;
                tree.add(value);
            }

            int height = tree.height();
            double optimalHeight = Math.log(NUM_NODES) / Math.log(2);  // log base 2
            double fullnessRatio = tree.fRatio();

            System.out.printf("Tree %d:\n", i);
            System.out.printf("  Height: %d\n", height);
            System.out.printf("  Optimal Height (log₂n): %.2f\n", optimalHeight);
            System.out.printf("  Fullness Ratio: %.2f\n\n", fullnessRatio);
        }
    }

}


