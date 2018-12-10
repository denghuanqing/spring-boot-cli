package com.poppy.order.domain;

/**
 * @Description: 文章评论
 * @Author DENGHUANQING1
 * @Date 2018/12/9 17:01
 */
public class Component {
    private int id;
    //    @Field("author")
    private String author;
    //    @Field("content")
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
