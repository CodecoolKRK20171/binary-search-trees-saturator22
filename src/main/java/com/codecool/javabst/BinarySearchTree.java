package com.codecool.javabst;

import java.util.List;

/*
Given an array sorted in increasing order with unique integer elements write an algorithm to create a binary search tree
with minimal height. Hint: The middle element of the array should be the root.
*/
public class BinarySearchTree {

    private TreeNode root;

    public static BinarySearchTree build(List<Integer> elements) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = tree.buildTree(elements);
        return tree;
    }

    private TreeNode buildTree(List<Integer> elems) {
        if (elems.size() > 0) {
            int middle = (int) Math.floor(elems.size() / 2);
            TreeNode newNode = new TreeNode(elems.get(middle));
            newNode.left = buildTree(elems.subList(0, middle));
            if (elems.size() > 2) {
                newNode.right = buildTree(elems.subList(middle + 1, elems.size()));
            }
            return newNode;
        }
        return null;
    }

    public TreeNode search(Integer toFind) {
        TreeNode current = root;
        while (current != null) {
            if (toFind == current.value) {
                return current;
            }
            else if (toFind < current.value) {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }
        return null;
    }

    public void add(Integer toAdd) {
        TreeNode current = root;
        while (true) {
            if (toAdd == current.value) {
                throw new IllegalArgumentException("Element already in the tree");
            }
            else if (toAdd < current.value) {
                if (current.left != null) {
                    current = current.left;
                }
                else {
                    current.left = new TreeNode(toAdd);
                    return;
                }
            }
            else {
                if (current.right != null) {
                    current = current.right;
                }
                else {
                    current.right = new TreeNode(toAdd);
                    return;
                }
            }
        }
    }

    public void remove(Integer toRemove) {
        if (root.value == toRemove) {
            TreeNode dummyNode = new TreeNode(0);
            dummyNode.setLeft(root);
            root.removeChild(toRemove, dummyNode);
            root = dummyNode.getLeft();
            return;
        } else {
            root.removeChild(toRemove, null);
        }
    }

    public TreeNode getRoot() {
        return root;
    }
}
