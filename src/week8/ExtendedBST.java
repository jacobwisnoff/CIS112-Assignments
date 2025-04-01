package week8;

import ch07.trees.*;
import support.BSTNode;

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
        int leftHeight = 0;
        int rightHeight = 0;

        if (root == null){
            return -1;
        }
        else if (root.getInfo() != null && root.getLeft() == null && root.getRight() == null){
            return 0;
        }
        else{
            while (root.getLeft() != null){
                root = root.getLeft();
                leftHeight++;
            }
            while (root.getRight() != null){
                root = root.getRight();
                rightHeight++;
            }

            if (leftHeight > rightHeight){
                return leftHeight;
            }
            else{
                return rightHeight;
            }
        }
    }

}
