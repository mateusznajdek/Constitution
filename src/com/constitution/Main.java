package com.constitution;

/**
 * Created by MATQ on 2016-12-05.
 */

public class Main {

    public static void main(String[] args) {
	    Const ConstitutionObject = new Const();

	    Const test = InputParser.Parser(args[0]);

	    System.out.print(test.ListOfAllArticles.get(1).ReturnTextArticle());

    }
}
