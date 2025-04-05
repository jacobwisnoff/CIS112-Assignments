package week8;

import ch07.trees.*;
import support.BSTNode;
import ch04.queues.*;

public class ExtendedBST<T> extends BinarySearchTree<T> {

    // min2() method
    public T min2(){
        return recMin(root);
    }

    // Helper recMin() method
    private T recMin(BSTNode<T> root) {
        if (isEmpty()){
            return null;
        }
        else if (root.getLeft() == null){
            return root.getInfo();
        }
        else{
            return recMin(root.getLeft());
        }
    }

    // Recursive Height Method
    public int height(){
        return recHeight(root);
    }

    // Helper Method for Recursive Height
    private int recHeight(BSTNode<T> root) {
        if (root == null){
            return -1;
        }

        int leftHeight = recHeight(root.getLeft());
        int rightHeight = recHeight(root.getRight());

        if (leftHeight > rightHeight){
            return leftHeight + 1;
        }
        else{
            return rightHeight + 1;
        }
    }

    //Iterative Height Method
    public int height2(){
        if (root == null)
            return -1;

        QueueInterface<BSTNode<T>> queue = new LinkedQueue<>();
        queue.enqueue(root);
        int height = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            height++;

            while (size > 0) {
                BSTNode<T> node = queue.dequeue();

                if (node.getLeft() != null)
                    queue.enqueue(node.getLeft());

                if (node.getRight() != null)
                    queue.enqueue(node.getRight());

                size--;
            }
        }
        return height;
    }

    // Fullness Ratio method
    public double fRatio(){
        int height = recHeight(root);        // Maximum height
        int minHeight = recMinHeight(root);  // Minimum height

        if (height == 0)
            return 1.0;         // Single node tree
        else if (height == -1)
            return 0.0;         // Empty tree

        return (double) minHeight / height;
    }

    // Helper method to compute minimum height
    private int recMinHeight(BSTNode<T> root) {
        if (root == null) {
            return -1;
        }

        // If it's a leaf node
        if (root.getLeft() == null && root.getRight() == null) {
            return 0;
        }

        // If one of the children is null, recurse only on the non-null child
        if (root.getLeft() == null) {
            return recMinHeight(root.getRight()) + 1;
        } else if (root.getRight() == null) {
            return recMinHeight(root.getLeft()) + 1;
        }

        // Both children exist, take the min of the two
        return Math.min(recMinHeight(root.getLeft()), recMinHeight(root.getRight())) + 1;
    }


}
