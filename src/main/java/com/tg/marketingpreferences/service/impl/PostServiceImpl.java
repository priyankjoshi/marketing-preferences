package com.tg.marketingpreferences.service.impl;

import com.tg.marketingpreferences.dto.PostDto;
import com.tg.marketingpreferences.entity.Post;
import com.tg.marketingpreferences.exception.ResourceNotFoundException;
import com.tg.marketingpreferences.repository.PostRepository;
import com.tg.marketingpreferences.repository.UserRepository;
import com.tg.marketingpreferences.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PostServiceImpl implements PostService {


    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public PostDto createPost(Long userId, PostDto postDto) throws ResourceNotFoundException {

        Post  post = mapToEntity(postDto);
        Post response = userRepository.findById(userId).map(user ->{
            post.setUser(user);
            return postRepository.save(post);
        }).orElseThrow(()->new ResourceNotFoundException("user with Id -"+userId+" not found"));
        return mapToDto(response);
    }

    @Override
    public PostDto updatePost(Long userId, Long postId, PostDto postDto) throws ResourceNotFoundException {
        if(!userRepository.existsById(userId))
            throw new ResourceNotFoundException("User with ID "+userId+" not found");
       Post updatedPost =postRepository.findById(postId).map(post -> {
           post.setDescription(postDto.getDescription());
           post.setUpdatedAt(new Date());
           return postRepository.save(post);
        }).orElseThrow(()->new ResourceNotFoundException(" Post with ID "+postId+" not found"));
       return mapToDto(updatedPost);

    }

    private Post mapToEntity(PostDto postDto) {
        Post post = mapper.map(postDto,Post.class);
        post.setCreatedAt(new Date());
        return post;
    }

    private PostDto mapToDto(Post post){
        PostDto postDto = mapper.map(post,PostDto.class);
        return postDto;
    }

}
