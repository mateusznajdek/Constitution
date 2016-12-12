package com.constitution;

/**
 * Created by MATQ on 2016-12-05.
 */

public class Main {

    public static void main(String[] args) {

	    Const ConstitutionObject = InputParser.Parser(args[0]);

		Arguments.OneArgument AorBorCAndNumberOrNumbers = Arguments.Arguments(args);
		Chapter tmp; int first = 0, last = 0;

		switch (AorBorCAndNumberOrNumbers.ReturnAorBorC()){
			case 'a' : System.out.print(ConstitutionObject.TextArticle(AorBorCAndNumberOrNumbers.ReturnFirstNumber())); break;
			case 'A' : System.out.print(ConstitutionObject.TextArticle(AorBorCAndNumberOrNumbers.ReturnFirstNumber())); break;

			case 'c' : tmp = ConstitutionObject.ReturnChapter(AorBorCAndNumberOrNumbers.ReturnFirstNumber());
				first = tmp.ReturnNumFirstArticle(); last = tmp.ReturnNumLastArticle(); break;
			case 'C' : tmp = ConstitutionObject.ReturnChapter(AorBorCAndNumberOrNumbers.ReturnFirstNumber());
				first = tmp.ReturnNumFirstArticle(); last = tmp.ReturnNumLastArticle(); break;

			case 'b' : first = AorBorCAndNumberOrNumbers.ReturnFirstNumber(); last = AorBorCAndNumberOrNumbers.ReturnSecondNumber(); break;
			case 'B' : first = AorBorCAndNumberOrNumbers.ReturnFirstNumber(); last = AorBorCAndNumberOrNumbers.ReturnSecondNumber(); break;

			default: throw new IllegalArgumentException("Incorrect second argument of chose.");
		}

		if (AorBorCAndNumberOrNumbers.ReturnAorBorC() != 'a' && AorBorCAndNumberOrNumbers.ReturnAorBorC() != 'A')
			for (int i=first; i<=last; ++i)
				System.out.print(ConstitutionObject.TextArticle(i));


    }
}
