package com.poppy.order.dao.impl;

import com.poppy.order.dao.ArticleDao;
import com.poppy.order.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Author DENGHUANQING1
 * @Date 2018/12/9 17:06
 */
@Repository
public class ArticleDaoMongoImpl implements ArticleDao {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void add(Article article) {
        mongoTemplate.save(article);
    }

    @Override
    public void batchAdd(List<Article> articleList) {
        Query query = Query.query(Criteria.where("author").is("yinjihuan"));
        mongoTemplate.remove(query, Article.class);
        mongoTemplate.insert(articleList, Article.class);
    }
}
