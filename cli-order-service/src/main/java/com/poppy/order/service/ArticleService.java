package com.poppy.order.service;

import com.poppy.order.dao.ArticleDao;
import com.poppy.order.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author DENGHUANQING1
 * @Date 2018/12/9 17:04
 */
@Service
public class ArticleService {
    @Autowired
    ArticleDao articleDao;

    public void add(Article article) {
        articleDao.add(article);
    }

    public void batchAdd(List<Article> articles) {
        articleDao.batchAdd(articles);
    }
}
