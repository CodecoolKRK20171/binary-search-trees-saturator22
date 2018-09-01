package com.codecool;

import com.codecool.javabst.BinarySearchTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTests {

    BinarySearchTree binarySearchTree;

    @BeforeEach
    void setup() {
        List<Integer> intArrayList = new ArrayList<>();
        intArrayList.add(1);
        intArrayList.add(3);
        intArrayList.add(15);
        intArrayList.add(400);

        binarySearchTree = BinarySearchTree.build(intArrayList);
    }

    @Test
    void testSearch() {
        assertAll(
                () -> assertEquals(15, binarySearchTree.search(15).getValue()),
                () -> assertEquals(null, binarySearchTree.search(-1))
        );
    }

    @Test
    void testAdd() {

        binarySearchTree.add(2);
        binarySearchTree.add(13);

        assertAll(
                () -> assertEquals(2, binarySearchTree.search(1).getRight().getValue()),
                () -> assertEquals(13, binarySearchTree.search(3).getRight().getValue())
        );
    }

    @Test
    void testRemoveChild() {
        binarySearchTree.add(2);
        binarySearchTree.add(13);

        binarySearchTree.remove(3);
        binarySearchTree.remove(1);

        assertAll(
                () -> assertEquals(13, binarySearchTree.getRoot().getLeft().getValue()),
                () -> assertEquals(2, binarySearchTree.search(13).getLeft().getValue())
        );
    }

    @Test
    void testRemoveRoot() {
        binarySearchTree.remove(15);

        assertEquals(400, binarySearchTree.getRoot().getValue());
    }

    @Test
    void testRemoveNonExisting() {
        binarySearchTree.remove(-2);

        assertThrows(IllegalArgumentException.class, () -> binarySearchTree.remove(-2));
    }

}
