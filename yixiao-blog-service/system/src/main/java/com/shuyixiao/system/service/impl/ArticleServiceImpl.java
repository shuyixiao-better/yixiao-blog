package com.shuyixiao.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shuyixiao.dto.Article;
import com.shuyixiao.dto.ResponseResult;
import com.shuyixiao.system.mapper.ArticleMapper;
import com.shuyixiao.system.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName ArticleServiceImpl.java
 * author 舒一笑
 * version 1.0.0
 * Description TODO
 * createTime 2024年06月14日 11:35:00
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService  {

    @Autowired
    private ArticleMapper articleMapper;



    @Override
    public List<Article> findAll() {
        List<Article> articleList = this.list();
        return articleList;
    }

    @Override
    public ResponseResult<Article> findById(Long id) {
        Article article = articleMapper.selectById(id);
        return ResponseResult.success(article);
    }

    @Override
    public boolean save(Article article) {
        return this.save(article);
    }

    @Override
    public boolean deleteById(Long id) {
        return this.deleteById(id);
    }
}
