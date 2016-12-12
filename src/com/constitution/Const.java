package com.constitution;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by MATQ on 2016-12-05.
 */

public class Const {
    public List<Chapter> ListOfAllChapters = new LinkedList<>();
    public List<Article> ListOfAllArticles = new LinkedList<>();

    public Chapter ReturnChapter(int ChapterNum){
        return ListOfAllChapters.get(ChapterNum);
    }

    public String TextArticle(int ArticleNum){
        return ListOfAllArticles.get(ArticleNum).ReturnTextArticle();
    }

}
