package com.FinalSprint.Trees.Repository;

import com.FinalSprint.Trees.Entity.BinaryTree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinaryTreeRepository extends JpaRepository<BinaryTree, Long> {
    // You can define custom query methods here if needed

    // Method to save a binary tree constructed from numbers
    BinaryTree saveBinaryTree(int[] numbers);
}
