package com.tg.marketingpreferences.service;

import com.tg.marketingpreferences.dto.PostDto;
import com.tg.marketingpreferences.entity.Post;
import com.tg.marketingpreferences.entity.User;
import com.tg.marketingpreferences.exception.ResourceNotFoundException;
import com.tg.marketingpreferences.repository.PostRepository;
import com.tg.marketingpreferences.repository.UserRepository;
import com.tg.marketingpreferences.service.impl.PostServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
public class PostServiceImplTest {

    @InjectMocks
    private PostServiceImpl postServiceImpl;

    @Mock
    private PostRepository postRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ModelMapper mapper;

    @Test
    public void createPostSuccessful() throws ResourceNotFoundException {

        //Prepare request
        Long userId = 1L;
        PostDto postDto = getPostDto();
        User user = getUser(userId);
        Date date = new Date();
        Post post = getPost(postDto, user, date);

        //mock
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        Mockito.when(postRepository.save(Mockito.any(Post.class))).thenReturn(post);
        Mockito.when(mapper.map(postDto,Post.class)).thenReturn(post);
        Mockito.when(mapper.map(post,PostDto.class)).thenReturn(createPostDtoResponse());
        PostDto postDtoResponse = postServiceImpl.createPost(userId,postDto);

        //Assert

        Assert.assertNotNull(postDtoResponse);
        Assert.assertEquals(postDtoResponse.getId().longValue(),1L);
    }

    @Test
    public void updatePostSuccessful() throws ResourceNotFoundException {

        //Prepare request
        Long userId = 1L;
        Long postId = 1L;
        PostDto postDto = getPostDto();
        User user = getUser(userId);
        Date date = new Date();
        Post post = getPost(postDto, user, date);

        //mock
        Mockito.when(userRepository.existsById((userId))).thenReturn(true);
        Mockito.when(postRepository.findById(postId)).thenReturn(Optional.of(post));
        Mockito.when(postRepository.save(Mockito.any(Post.class))).thenReturn(post);
        Mockito.when(mapper.map(post,PostDto.class)).thenReturn(createPostDtoResponse());
        PostDto postDtoResponse = postServiceImpl.updatePost(userId,postId,postDto);

        //Assert

        Assert.assertNotNull(postDtoResponse);
        Assert.assertEquals(postDtoResponse.getId().longValue(),1L);
    }

    private PostDto createPostDtoResponse() {
        PostDto postDto = getPostDto();
        postDto.setId(1L);
        return postDto;
    }

    private PostDto getPostDto() {
        PostDto postDto = new PostDto();
        postDto.setTitle("First Post");
        postDto.setDescription("First Description");
        return postDto;
    }

    private User getUser(Long userId) {
        User user = new User();
        user.setId(userId);
        user.setUserName("Priyank Joshi");
        return user;
    }

    private Post getPost(PostDto postDto, User user, Date date) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setCreatedAt(date);
        post.setUser(user);
        post.setId(1L);
        return post;
    }



}
