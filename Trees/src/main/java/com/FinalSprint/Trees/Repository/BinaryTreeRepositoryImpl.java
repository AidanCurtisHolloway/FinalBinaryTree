package com.FinalSprint.Trees.Repository;

import com.FinalSprint.Trees.Entity.BinaryTree;
import com.FinalSprint.Trees.Service.BinaryTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BinaryTreeRepositoryImpl {

    @Autowired
    private BinaryTreeService binaryTreeService;

    // Method implementation to save a binary tree constructed from numbers
    public BinaryTree saveBinaryTree(int[] numbers) {
        return binaryTreeService.processNumbers(numbers);
    }
}
