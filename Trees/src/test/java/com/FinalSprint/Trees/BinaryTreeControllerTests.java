package com.FinalSprint.Trees;

import com.FinalSprint.Trees.Controller.BinaryTreeController;
import com.FinalSprint.Trees.Entity.BinaryTree;
import com.FinalSprint.Trees.Service.BinaryTreeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(BinaryTreeController.class)
public class BinaryTreeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BinaryTreeService binaryTreeService;

    @Test
    public void testProcessNumbers() throws Exception {
        int[] numbers = {1, 2, 3};
        BinaryTree binaryTree = new BinaryTree(); // Create a dummy binary tree for testing
        when(binaryTreeService.processNumbers(numbers)).thenReturn(binaryTree);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/process-numbers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("[1, 2, 3]"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetPreviousTrees() throws Exception {
        BinaryTree binaryTree = new BinaryTree(); // Create a dummy binary tree for testing
        List<BinaryTree> binaryTreeList = Collections.singletonList(binaryTree);
        when(binaryTreeService.getPreviousTrees()).thenReturn(binaryTreeList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/previous-trees"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
