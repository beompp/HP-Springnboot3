package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
<<<<<<< HEAD

public class ArticleForm {

=======
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private Long id;
>>>>>>> home
    private String title;
    private String content;

    public Article toEntity() {
        return new Article(id, title, content);
    }

    public Article toEntity() {
        return new Article(null, title, content);
    }
}
