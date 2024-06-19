package com.shuyixiao.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shuyixiao.dto.Article;
import com.shuyixiao.dto.ResponseResult;

import java.util.List;

/**
 * ClassName ArticleService.java
 * author 舒一笑
 * version 1.0.0
 * Description 文章数据存储
 * createTime 2024年06月14日 11:34:00
 */
public interface ArticleService extends IService<Article> {

    List<Article> findAll();

    ResponseResult<Article> findById(Long id);

    boolean save(Article article);

    boolean deleteById(Long id);
}
