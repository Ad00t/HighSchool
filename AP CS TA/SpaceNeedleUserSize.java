/*
Write a program to print a figure that looks like the Seattle Space
Needle. Use a class constant for SIZE, loops for patterns,
and static methods for structure/redundancy. Take user input for
the actual value of SIZE.

Please use these lines of code to start your program:

import java.util.Scanner;           // needed for Scanner class
public class SpaceNeedleUserSize {
    public static int SIZE;         // class constant for SpaceNeedle SIZE    
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("enter SIZE: ");
        SIZE = console.nextInt();   // get SIZE from user
        System.out.println();       // for HG output
        .
        .
        .

Note:
UNDEFINED FOR ODD SIZES (width of stem could be rounded up or down).
YOUR CODE WILL BE TESTED FOR EVEN SIZES ONLY.

input/output examples (the leading blank line will not appear in HG):

Charles-Brucker-MacBook-Pro-3:SpaceNeedle cfbrucker$ java SpaceNeedleUserSize
enter SIZE: 2

      ||
      ||
   __/||\__
__/:::||:::\__
|""""""""""""|
\_/\/\/\/\/\_/
  \_/\/\/\_/
      ||
      ||
     ||||
     ||||
     ||||
     ||||
   __/||\__
__/:::||:::\__
|""""""""""""|
Charles-Brucker-MacBook-Pro-3:SpaceNeedle cfbrucker$ 

Charles-Brucker-MacBook-Pro-3:SpaceNeedle cfbrucker$ java SpaceNeedleUserSize
enter SIZE: 4

            ||
            ||
            ||
            ||
         __/||\__
      __/:::||:::\__
   __/::::::||::::::\__
__/:::::::::||:::::::::\__
|""""""""""""""""""""""""|
\_/\/\/\/\/\/\/\/\/\/\/\_/
  \_/\/\/\/\/\/\/\/\/\_/
    \_/\/\/\/\/\/\/\_/
      \_/\/\/\/\/\_/
            ||
            ||
            ||
            ||
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         __/||\__
      __/:::||:::\__
   __/::::::||::::::\__
__/:::::::::||:::::::::\__
|""""""""""""""""""""""""|
Charles-Brucker-MacBook-Pro-3:SpaceNeedle cfbrucker$ 
*/

import java.util.Scanner;           // needed for Scanner class
public class SpaceNeedleUserSize {
    public static int SIZE;         // class constant for SpaceNeedle SIZE    
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("enter SIZE: ");
        SIZE = console.nextInt();   // get SIZE from user
        System.out.println();       // for HG output
        console.close();

        stick();
        cone();

        for(int i = 0; i<SIZE; i++) {
        	for(int j = 0; j<SIZE*3+1 - i; j++) {
        		if(j<i) {
        			System.out.print("  ");
        		} else if(j==i) {
        			System.out.print("\\_");
        		} else if(j == SIZE*3 - i) {
        			System.out.print("_/");
        		} else {
        			System.out.print("/\\");
        		}
        	}
        	System.out.print("\n");
        }

        stick();

        for(int i = 0; i< SIZE*6-8; i++) {
        	thickStick();
        }

        cone();
    }
    static void stick() {
    	for(int i = 0; i<SIZE; i++) {
    		for(int j = 0; j<SIZE; j++) {
    			System.out.print("   ");
    		}
    		System.out.print("||\n");
    	}
    }

    static void cone() {
    	for(int i = 0; i<SIZE; i++) {
    		for(int j = SIZE-1; j>=0; j--) {
    			if(j == i) {
    				System.out.print("__/");
    			} else if(j < i) {
    				System.out.print(":::");
    			} else {
	    			System.out.print("   ");
	    		}
    		}

    		System.out.print("||");

    		for(int j = 0; j<=i; j++) {
    			if(j == i) {
    				System.out.print("\\__");
    			} else if(j < i) {
    				System.out.print(":::");
    			} else {
	    			System.out.print("   ");
	    		}
    		}

    		System.out.print("\n");
    	}
    	System.out.print("|");
    	for(int i = 0; i<SIZE; i++) {
    		System.out.print("\"\"\"\"\"\"");
    	}
    	System.out.print("|\n");
    }

    static void thickStick() {
    	for(int i = 0; i< SIZE*2+1; i++) {
    		System.out.print(" ");
    	}
    	for(int i = 0; i<2; i++) {
	    	System.out.print("|");
	    	for(int j = 0; j<SIZE-2; j++) {
	    		System.out.print("%");
	    	}
	    	System.out.print("|");
	    }
	    System.out.print("\n");
    }
}