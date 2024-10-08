package com.mx.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.model.Article;

 
public interface ArticleRepository extends JpaRepository<Article, String> {
}