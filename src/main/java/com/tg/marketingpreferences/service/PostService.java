package com.tg.marketingpreferences.service;

import com.tg.marketingpreferences.dto.PostDto;
import com.tg.marketingpreferences.entity.Post;
import com.tg.marketingpreferences.exception.ResourceNotFoundException;

public interface PostService {

    PostDto createPost(Long userId, PostDto postDto) throws ResourceNotFoundException;

    PostDto updatePost(Long userId,Long postId, PostDto postDto) throws ResourceNotFoundException;
}
