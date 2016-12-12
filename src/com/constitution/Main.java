package com.constitution;

/**
 * Created by MATQ on 2016-12-05.
 */

public class Main {

    public static void main(String[] args) {
        if (args.length==0) {
            System.err.print("Didn't specifited arguments");
            System.exit(11);
        }

	    Const ConstitutionObject = InputParser.Parser(args[0]);

		Arguments.OneArgument AorBorCAndNumberOrNumbers = Arguments.Arguments(args);
		Chapter tmp; int first = 0, last = 0;

        System.out.println("Syntax program:\n Prog chould be called with parametrs:" +
                "  name_of_file.txt  what_do_to  num_1  (num_2 optional)\n " +
                "what_to_do:   a-print article   b-print interval  c-print chapter\n");

        //System.out.println(AorBorCAndNumberOrNumbers.ReturnAorBorC());
		//System.out.println(ConstitutionObject.TextArticle(7));
        //System.out.println(ConstitutionObject.ListOfAllChapters.isEmpty());

		switch (AorBorCAndNumberOrNumbers.ReturnAorBorC()){
			case 'a' : System.out.print(ConstitutionObject.TextArticle(AorBorCAndNumberOrNumbers.ReturnFirstNumber())); break;
			case 'A' : System.out.print(ConstitutionObject.TextArticle(AorBorCAndNumberOrNumbers.ReturnFirstNumber())); break;

			case 'c' : tmp = ConstitutionObject.ReturnChapter(AorBorCAndNumberOrNumbers.ReturnFirstNumber());
				first = tmp.ReturnNumFirstArticle(); last = tmp.ReturnNumLastArticle();
				System.out.print(first); System.out.print(last); break;
			case 'C' : tmp = ConstitutionObject.ReturnChapter(AorBorCAndNumberOrNumbers.ReturnFirstNumber());
				first = tmp.ReturnNumFirstArticle(); last = tmp.ReturnNumLastArticle(); break;

			case 'b' : first = AorBorCAndNumberOrNumbers.ReturnFirstNumber(); last = AorBorCAndNumberOrNumbers.ReturnSecondNumber(); break;
			case 'B' : first = AorBorCAndNumberOrNumbers.ReturnFirstNumber(); last = AorBorCAndNumberOrNumbers.ReturnSecondNumber(); break;

			default:
                System.err.print("Incorrect AorBorC, not equal a or b or c.");
                System.exit(10);
		}

		if (AorBorCAndNumberOrNumbers.ReturnAorBorC() != 'a' && AorBorCAndNumberOrNumbers.ReturnAorBorC() != 'A')
			for (int i=first; i<=last; ++i)
				System.out.print(ConstitutionObject.TextArticle(i));


    }
}
