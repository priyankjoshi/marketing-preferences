package com.tg.marketingpreferences.resource;

import com.tg.marketingpreferences.dto.PostDto;
import com.tg.marketingpreferences.exception.ResourceNotFoundException;
import com.tg.marketingpreferences.service.PostService;
import jdk.internal.loader.Resource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class PostControllerTest {

    @InjectMocks
    private PostController postController;

    @Mock
    private PostService postService;

    @Test
    public void createPost() throws ResourceNotFoundException {
        //Prepare request
        Long userId = 1L;
        PostDto postDto = new PostDto();
        postDto.setTitle("First Post");
        postDto.setDescription("First Description");

        //mock
        Mockito.when(postService.createPost(userId, postDto)).thenReturn(postDto);

        //Actual Call
        ResponseEntity<PostDto> responseEntity = postController.createPost(userId, postDto);

        //Assertion
        Assert.assertNotNull(responseEntity);
        Assert.assertEquals(responseEntity.getBody().getTitle(), "First Post");
    }

    @Test(expected = ResourceNotFoundException.class)
    public void createPostThrowsResourceNotFoundException() throws ResourceNotFoundException {
        //Prepare request
        Long userId = 1L;
        PostDto postDto = new PostDto();
        postDto.setTitle("First Post");
        postDto.setDescription("First Description");

        //mock
        Mockito.when(postService.createPost(userId, postDto)).thenThrow(new ResourceNotFoundException("User Not Found"));

        //Actual Call
        postController.createPost(userId, postDto);

    }

    @Test
    public void updatePost() throws ResourceNotFoundException {

        //Prepare request
        Long userId = 1L;
        Long postId = 1L;
        PostDto postDto = new PostDto();

        postDto.setDescription("First Description Updated");

        //mock
        Mockito.when(postService.updatePost(userId, postId, postDto)).thenReturn(postDto);


        //Actual Call
        ResponseEntity<PostDto> postUpdated = postController.updatePost(userId, postId, postDto);

        //Assertion
        Assert.assertNotNull(postUpdated);
        Assert.assertEquals(postUpdated.getBody().getDescription(), "First Description Updated");
    }

    @Test(expected = ResourceNotFoundException.class)
    public void updatePostThrowsResourceNotFoundException() throws ResourceNotFoundException {

        //Prepare request
        Long userId = 1L;
        Long postId = 1L;
        PostDto postDto = new PostDto();

        postDto.setDescription("First Description Updated");

        //mock
        Mockito.when(postService.updatePost(userId, postId, postDto)).thenThrow(new ResourceNotFoundException("User Not Present"));


        //Actual Call
        postController.updatePost(userId, postId, postDto);

    }
}
