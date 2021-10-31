package com.example.service;

import com.example.entity.author.Author;
import com.example.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> gatAllAuthors() {
        return authorRepository.findAll();
    }

    public Map<String, List<Author>> getAuthorsMap() {
        return authorRepository.findAll().stream()
                .collect(Collectors.groupingBy(author -> author.getName().substring(0,1)));
    }
}
