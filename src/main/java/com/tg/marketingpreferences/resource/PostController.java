package com.tg.marketingpreferences.resource;

import com.tg.marketingpreferences.dto.PostDto;
import com.tg.marketingpreferences.exception.ResourceNotFoundException;
import com.tg.marketingpreferences.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class PostController {

    @Autowired
    private PostService postService;



    @PostMapping("/user/{userId}/post")
    public ResponseEntity<PostDto> createPost(@PathVariable(value = "userId") Long userId, @Valid @RequestBody PostDto postDto)
            throws ResourceNotFoundException {
        PostDto postResponse = postService.createPost(userId, postDto);
        return ResponseEntity.ok(postResponse);

    }


    @PutMapping("/user/{userId}/post/{postId}")
    public ResponseEntity<PostDto> updatePost(@PathVariable(value = "userId") Long userId,
                               @PathVariable(value = "postId") Long postId, @Valid @RequestBody PostDto postDto)
            throws ResourceNotFoundException {
        PostDto updatedPost = postService.updatePost(userId,postId,postDto);
        return ResponseEntity.ok(updatedPost);
    }

}
