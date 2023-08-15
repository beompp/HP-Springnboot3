package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

<<<<<<< HEAD
public interface ArticleRepository extends CrudRepository<Article, Long> {
=======
import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    @Override
    ArrayList<Article> findAll();
>>>>>>> home
}
