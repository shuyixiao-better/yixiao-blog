package com.shuyixiao.system.controller;

import com.shuyixiao.dto.Article;
import com.shuyixiao.dto.ResponseResult;
import com.shuyixiao.system.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName ArticleController.java
 * author 舒一笑
 * version 1.0.0
 * Description 文章数据存储
 * createTime 2024年06月14日 11:33:00
 */
@RestController
@RequestMapping("/shuyixiao/v1")
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @GetMapping("/getAllArticles")
    public ResponseResult<List<Article>> getAllArticles() {
        return ResponseResult.success(articleService.findAll());
    }

    @GetMapping("/getArticleById")
    public ResponseResult<Article> getArticleById(Long id) {
        return articleService.findById(id);
    }

    @PostMapping
    public boolean createArticle(@RequestBody Article article) {
        return articleService.save(article);
    }

    @PutMapping("/{id}")
    public boolean updateArticle(@PathVariable Long id, @RequestBody Article article) {
        article.setId(id);
        return articleService.save(article);
    }

    @DeleteMapping("/{id}")
    public boolean deleteArticle(@PathVariable Long id) {
        return articleService.deleteById(id);
    }

}
