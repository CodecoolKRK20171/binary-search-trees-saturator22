package com.codecool.javabst;

public class TreeNode {

    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    public void removeChild(int value ,TreeNode parent) {
        if (value < this.value) {
            if (left != null) {
                left.removeChild(value, this);
            } else {
                throw new IllegalArgumentException("Tried to remove non existing child");
            }
        } else if (value > this.value) {
            if (right != null) {
                right.removeChild(value, this);
            } else {
                throw new IllegalArgumentException("Tried to remove non existing child");
            }
        } else {
            if (right != null && left != null) {
                this.value = right.getLowest();
                right.removeChild(this.value, this);
            } else if (parent.left == this) {
                parent.left = (left != null) ? left : right;
            } else if (parent.right == this) {
                parent.right = (left != null) ? left : right;
            }
            return;
        }
    }



    private int getLowest() {
        if(left == null) {
            return this.value;
        }

        return left.getLowest();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
