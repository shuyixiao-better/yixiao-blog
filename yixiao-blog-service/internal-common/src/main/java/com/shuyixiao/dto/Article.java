package com.shuyixiao.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ClassName Article.java
 * author 舒一笑
 * version 1.0.0
 * Description TODO
 * createTime 2024年06月14日 11:31:00
 */
@Data
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String title;

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
