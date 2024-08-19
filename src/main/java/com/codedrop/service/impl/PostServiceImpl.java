package com.codedrop.service.impl;

import com.codedrop.model.Post;
import com.codedrop.repository.PostRepository;
import com.codedrop.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(Integer id) {
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found with id " + id));
    }

    @Override
    public Post create(Post orderDetail) {
        return postRepository.save(orderDetail);
    }

    @Override
    public Post update(Post orderDetail) {
        return postRepository.save(orderDetail);
    }

    @Override
    public void delete(Integer id) {
        postRepository.deleteById(id);
    }
}
