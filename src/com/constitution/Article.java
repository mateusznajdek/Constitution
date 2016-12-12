package com.constitution;

/**
 * Created by MATQ on 2016-12-05.
 */

public class Article {
    private int NumArticle;
    private String TextArticle = "";
    private String Title = "";

    public Article(int NumArticle, String Title) {
        this.NumArticle = NumArticle;
        this.Title = Title;
    }


    public void SetTitle(String Title) {
        this.Title = Title;
    }

    public String ReturnTitle() {
        return Title;
    }

    public void SetNumArticle(int NumArticle) {
        this.NumArticle = NumArticle;
    }

    public int ReturnNumArticle() {
        return NumArticle;
    }

    public void ChangeTextArticle(String DiffrentTextArticle) {
        this.TextArticle += DiffrentTextArticle;
    }

    public String ReturnTextArticle() {
        return TextArticle;
    }
}