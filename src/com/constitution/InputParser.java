package com.constitution;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by MATQ on 2016-12-11.
 */

public class InputParser {

    public static Const Parser(String FilePath ){

        Const constitution = new Const();

        String Line, Line2, Titleofchapter; int article = 1, chapter = 1;
        String TMP[] = null;
    /*

   FileReader fr = null;
   String linia = "";

   // OTWIERANIE PLIKU:
   try {
     fr = new FileReader("plik.txt");
   } catch (FileNotFoundException e) {
       System.out.println("BŁĄD PRZY OTWIERANIU PLIKU!");
       System.exit(1);
   }

   BufferedReader bfr = new BufferedReader(fr);
   // ODCZYT KOLEJNYCH LINII Z PLIKU:
   try {
     while((linia = bfr.readLine()) != null){
        System.out.println(linia);
     }
    } catch (IOException e) {
        System.out.println("BŁĄD ODCZYTU Z PLIKU!");
        System.exit(2);
   }

   // ZAMYKANIE PLIKU
   try {
     fr.close();
    } catch (IOException e) {
         System.out.println("BŁĄD PRZY ZAMYKANIU PLIKU!");
         System.exit(3);
        }
    }
     */

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
        return constitution;
    }

}
