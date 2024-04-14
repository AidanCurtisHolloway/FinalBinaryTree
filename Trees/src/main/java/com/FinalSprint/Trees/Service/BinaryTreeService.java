package com.FinalSprint.Trees.Service;

import com.FinalSprint.Trees.Entity.BinaryTree;
import com.FinalSprint.Trees.Entity.Node;
import com.FinalSprint.Trees.Repository.BinaryTreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BinaryTreeService {

    @Autowired
    private BinaryTreeRepository binaryTreeRepository;

    // Method to process numbers, construct binary tree, and save to database
    public BinaryTree processNumbers(int[] numbers) {
        BinaryTree binaryTree = new BinaryTree();
        if (numbers != null && numbers.length > 0) {
            for (int num : numbers) {
                binaryTree.insert(num);
            }
            binaryTreeRepository.save(binaryTree);
        }
        return binaryTree;
    }

    // Method to retrieve and return previous trees from the database
    public List<BinaryTree> getPreviousTrees() {
        return binaryTreeRepository.findAll();
    }
}
