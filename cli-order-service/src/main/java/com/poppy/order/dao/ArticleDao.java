package com.poppy.order.dao;

import com.poppy.order.domain.Article;

import java.util.List;

/**
 * @Description:
 * @Author DENGHUANQING1
 * @Date 2018/12/9 17:05
 */

public interface ArticleDao {
    void add(Article article);

    void batchAdd(List<Article> articleList);
}
