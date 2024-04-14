package com.FinalSprint.Trees.Controller;

import com.FinalSprint.Trees.Entity.BinaryTree;
import com.FinalSprint.Trees.Service.BinaryTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BinaryTreeController {

    @Autowired
    private BinaryTreeService binaryTreeService;

    @PostMapping("/process-numbers")
    public BinaryTree processNumbers(@RequestBody int[] numbers) {
        return binaryTreeService.processNumbers(numbers);
    }

    @GetMapping("/previous-trees")
    public List<BinaryTree> getPreviousTrees() {
        return binaryTreeService.getPreviousTrees();
    }
}
