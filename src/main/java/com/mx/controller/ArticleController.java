package com.mx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mx.model.Article;
import com.mx.service.ArticleService;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    // Create
    @PostMapping
    public Article createProduct(@RequestBody Article article) {
        return articleService.saveArticle(article);
    }

    // Read (All)
    @GetMapping
    public List<Article> getAllProducts() {
        return articleService.getAllArticles();
    }

    // Read (One)
    @GetMapping("/{id}")
    public ResponseEntity<Article> getProductById(@PathVariable String id) {
        return articleService.getArticleById(id)  
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Article> updateProduct(@PathVariable String id, @RequestBody Article updatedArticle) {
        return articleService.getArticleById(id)
                .map(article -> {
                	article.setDescription(updatedArticle.getDescription());
                	article.setModel(updatedArticle.getModel());
                	Article saveArticle = articleService.saveArticle(article);
                    return ResponseEntity.ok(saveArticle);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        if (articleService.getArticleById(id).isPresent()) {
        	articleService.deleteArticle(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}