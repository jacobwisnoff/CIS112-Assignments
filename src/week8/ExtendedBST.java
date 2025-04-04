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

        QueueInterface<BSTNode> queue = new LinkedQueue<>();
        queue.enqueue(root);
        int height = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            height++;

            while (size > 0) {
                BSTNode node = queue.dequeue();

                if (node.getLeft() != null)
                    queue.enqueue(node.getLeft());

                if (node.getRight() != null)
                    queue.enqueue(node.getRight());

                size--;
            }
        }
        return height;
    }

}
