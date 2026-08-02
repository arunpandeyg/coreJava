package com.blog.app.controller;

import com.blog.app.dto.CommentDto;
import com.blog.app.paloads.ApiResponse;
import com.blog.app.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;
    //create comments
    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment, @PathVariable Integer postId){
         CommentDto createdComment = this.commentService.createComment(comment,  postId);
         return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }
    //delete comments
    @DeleteMapping("/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
         this.commentService.deleteComment(commentId);
         return new ResponseEntity<>(new ApiResponse("Comment deleted successfully !!", true), HttpStatus.OK);
    }
}
