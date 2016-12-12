package com.constitution;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by MATQ on 2016-12-11.
 */

public class InputParser {

    public static Const Parser(String FilePath ){

        Const constitution = new Const();

        String Line, Line2, Titleofchapter; int article = 1, chapter = 1;
        String TMP[] = null;


   FileReader fr = null;
   String linia = "";

   // OTWIERANIE PLIKU:
   try {
     fr = new FileReader(FilePath);
   } catch (FileNotFoundException e) {
       System.out.println("Error during oppening file!");
       System.exit(1);
   }


    BufferedReader bfr = new BufferedReader(fr);
    // ODCZYT KOLEJNYCH LINII Z PLIKU:
   try {
       Chapter ChapterObject = new Chapter(0,0,0, "Guard");
       Article ArticleObject = new Article(0, "Guard");

        while((Line = bfr.readLine()) != null){
            if (Line.startsWith("Rozdział")){
                if (article != 1) ChapterObject.SetLastArticle(article-1);
                constitution.ListOfAllChapters.add(ChapterObject);
                ChapterObject = new Chapter();  //utworz nastepny
                ChapterObject.SetFirstArticle(article);
                ChapterObject.SetNumChapter(chapter); chapter++;
                Titleofchapter = Line + "\n";
                Line = bfr.readLine();
                if (Line == null || Line.length()<2) continue;
                Titleofchapter += Line;
                ChapterObject.SetTitle(Titleofchapter);
                continue;
            }

            while (Line != null && !Line.startsWith("Rozdział")){
                //wczytuje artykuły

                if (Line.startsWith("Art. ")){
                    constitution.ListOfAllArticles.add(ArticleObject);
                    ArticleObject = new Article(article, Line);
                    ArticleObject.ChangeTextArticle(Line);
                    ArticleObject.ChangeTextArticle("\n");
                    ArticleObject.SetTitle(Line);
                    ++article;
                    Line = bfr.readLine();
                }

                while (Line!= null && !Line.startsWith("Art. ") && !Line.startsWith("Rozdział")){
                    //edycja linii

                    if (Line.startsWith("©Kancelaria Sejmu") || Line.startsWith("2009-11-16"))
                    {Line = bfr.readLine(); continue;}

                    if (Line.endsWith("-") && (Line2 = bfr.readLine()) != null){
                        Line = Line.substring(0, Line.length()-1); // string bez -
                        TMP = Line2.split(" ", 1);   //string pierwszy wyraz od tab TMP
                        Line = Line.concat(TMP[0]);
                        ArticleObject.ChangeTextArticle(Line);
                        ArticleObject.ChangeTextArticle("\n");
                        Line = Line2.substring(TMP[0].length(), Line2.length());
                        continue;
                    }
                    if (Line == null || Line.length()<2) {Line = bfr.readLine(); continue;}
                    ArticleObject.ChangeTextArticle(Line);
                    ArticleObject.ChangeTextArticle("\n");
                    Line = bfr.readLine();
                }
            }
        }
       --article; --chapter;
       ChapterObject.SetLastArticle(article);

    } catch (IOException e) {
        System.out.println("Error reading file!");
        System.exit(2);
    }


/*
        try (Scanner scanner = new Scanner(new File(FilePath))) {

            Chapter ChapterObject = new Chapter(0,0,0, "Guard");
            Article ArticleObject = new Article(0, "Guard");

            while (scanner.hasNext()){
                //System.out.println(scanner.nextLine());
                Line = scanner.nextLine();
                //System.out.println(Line);

                //wczytuje kolejny rozdzial
                if (Line.startsWith("Rozdział")){
                    if (article != 1) ChapterObject.SetLastArticle(article-1);
                    constitution.ListOfAllChapters.add(ChapterObject);
                    ChapterObject = new Chapter();  //utworz nastepny
                    ChapterObject.SetFirstArticle(article);
                    ChapterObject.SetNumChapter(chapter); chapter++;
                    Titleofchapter = Line + "\n";
                    if (scanner.hasNext()) Line = scanner.nextLine();
                    Titleofchapter += Line;
                    ChapterObject.SetTitle(Titleofchapter);
                    continue;
                }

                while (scanner.hasNext() && !Line.startsWith("Rozdział")){
                    //wczytuje artykuły

                    if (Line.startsWith("Art. ")){
                        constitution.ListOfAllArticles.add(ArticleObject);
                        ArticleObject = new Article(article, Line);
                        ArticleObject.ChangeTextArticle(Line);
                        ArticleObject.SetTitle(Line);
                        ++article;
                        Line = scanner.nextLine();
                    }

                    while (scanner.hasNext() && !Line.startsWith("Art. ") && !Line.startsWith("Rozdział")){
                        //edycja linii

                        if (Line.startsWith("©Kancelaria Sejmu") || Line.startsWith("2009-11-16"))
                        {Line = scanner.nextLine(); continue;}

                        if (Line.endsWith("-") && scanner.hasNext()){
                            Line2 = scanner.nextLine();
                            Line = Line.substring(0, Line.length()-1); // string bez -
                            TMP = Line2.split(" ", 1);   //string pierwszy wyraz od tab TMP
                            Line = Line.concat(TMP[0]);
                            ArticleObject.ChangeTextArticle(Line);
                            ArticleObject.ChangeTextArticle("\n");
                            Line = Line2.substring(TMP[0].length(), Line2.length());
                            continue;
                        }

                        ArticleObject.ChangeTextArticle(Line);
                        Line = scanner.nextLine();
                    }
                }
            }

            --article; --chapter;
            ChapterObject.SetLastArticle(article);


        } catch (IOException e) {
            e.printStackTrace();
        }
*/

        // ZAMYKANIE PLIKU
        try {
            fr.close();
        } catch (IOException e) {
            System.out.println("Error during closing file!");
            System.exit(3);
        }

        return constitution;
    }

}


