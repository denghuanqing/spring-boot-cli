package com.poppy.order.controller;

import com.poppy.order.domain.Article;
import com.poppy.order.domain.Component;
import com.poppy.order.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author DENGHUANQING1
 * @Date 2018/12/9 17:36
 */
@RestController
public class AtricleController {
    @Autowired
    ArticleService articleService;

    @RequestMapping("/article")
    public void get() {
        final Article article = new Article();
        article.setTitle("MongoTemplate的基本使用");
        article.setAuthor("yinjihuan");
        article.setUrl("http://cxytiandi.com/blog/detail/");

        final Component component = new Component();
        component.setAuthor("dhq");
        component.setContent("文章写的不错哦");
        final ArrayList<Component> list = new ArrayList<>();
        list.add(component);
        article.setComponentList(list);

        article.setVisitCount(0L);
        article.setAddTime(new Date());

        articleService.add(article);
    }

    @RequestMapping("/article/batchAdd")
    public void batchAdd() {

        List<Article> articles = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            Article article = new Article();
            article.setTitle("MongoTemplate的基本使用");
            article.setAuthor("yinjihuan");
            article.setUrl("http://cxytiandi.com/blog/detail/" + i);

            Component component = new Component();
            component.setAuthor("dhq");
            component.setContent("文章写的不错哦");
            final ArrayList<Component> list = new ArrayList<>();
            list.add(component);
            article.setComponentList(list);

            article.setVisitCount(0L);
            article.setAddTime(new Date());
            articles.add(article);
        }

        articleService.batchAdd(articles);
    }


}
