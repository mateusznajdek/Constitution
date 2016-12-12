package com.constitution;

/**
 * Created by MATQ on 2016-12-12.
 */
public class Arguments {
    protected static class OneArgument {
        protected char AorBorC;
        protected int FirstNumber;
        protected int SecondNumber;


        public OneArgument(char AorBorCint, int FirstNumber) {
            this.FirstNumber = FirstNumber;
            this.AorBorC = AorBorC;
        }

        public OneArgument(char AorBorC, int FirstNumber, int SecondNumber) {
            this.FirstNumber = FirstNumber;
            this.SecondNumber = SecondNumber;
            this.AorBorC = AorBorC;
        }

        public char ReturnAorBorC() {
            return AorBorC;
        }

        public int ReturnFirstNumber() {
            return FirstNumber;
        }

        public int ReturnSecondNumber() {
            return SecondNumber;
        }

    }

    public static OneArgument Arguments(String[] args){
        if (args.length < 3) throw new IllegalArgumentException("The amount of argumnets is too low!");


        if (!args[1].equals("a") && !args[1].equals("b") && !args[1].equals("c") && !args[1].equals("A") && !args[1].equals("B") && !args[1].equals("C"))
            throw new IllegalArgumentException("Second argument is incorret! (diffrent than a or b or c)");

        if  (!Character.isDigit(args[2].charAt(0)))
            throw new IllegalArgumentException("Third argument is incorret! (Must be a number equal or less than 243)");

        if (!args[1].equals("b") && !args[1].equals("B")) return new OneArgument(args[1].charAt(0), Integer.parseInt(args[2]));

        return new OneArgument(args[1].charAt(0), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
    }





}
