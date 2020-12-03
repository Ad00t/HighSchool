==============================     PART 1     ==============================
   string str, str1, str2;

   cout << "Please type a string: ";
   //  Lines that read in a string were deleted
   //  Those lines are able to read in any string, even one containing spaces


//  Loop 1:  What is printed?
   for (int i=str.length()-1;  i>=0;  i--)
   {
      cout << str [i];
   }
   cout << endl;


//  Loop 2:  What is printed?
   for (int i=str.length()-1;  i>=0;  i--)
   {
      cout << str [i] << str [i];
   }
   cout << endl;


//  Loop 3:  What is printed?
   for (int i=0;  i<str.length();  i++)
   {
      cout << " " << str [i];
   }
   cout << endl;


//  Loop 4:  What is printed?
   for (int i=0;  i<str.length();  i++)
   {
      cout << str [i] << " ";
   }
   cout << endl;


//  Loop 5:  What is printed?
   for (int i=0;  i<str.length();  i+=2)
   {
      cout << str [i] << " ";
   }
   cout << endl;






//  Loop 6:  What does the variable "count" contain after the loop?
   int count = 0;
   for (int i=0;  i<str.length();  i++)
   {
      if (str [i] > 'A'  &&  str [i] < 'Z')
          count++;
   }


//  Loop 7:  What makes the variable "found" true?
   bool found = false;
   str2 = "hello";
   int i=0;
   while (!found  &&  i <= str.length()-str2.length())
   {
      if (str.substr(i, str2.length()) == str2)
      {
         found = true;
      }
      else
      {
         i++;
      }
   }

   // When str2 is found inside of str (searching by starting at i=0 in str then incrementing until it's found)


//  Loop 8:  What is printed?
   cout << "Please type your name (first and last, separated by a space): ";
   //  Lines to read in the name  (These lines are omitted.)
   //  Lines to validate format of name (These lines are also omitted.)
   found = false;
   i=0;
   while (!found  &&  i < str.length())
   {
      if (str [i] == ' ')
      {
         found = true;
      }
      else
      {
         i++;
      }
   }
   str1 = str.substr(i, str.length ()-i);
   str2 = str.substr(0, i);
   cout << str1 << ", " << str2 << endl;






==============================     PART 2     ==============================

Exercise 1.  Write a loop to read numbers.  Each number should be a
positive integer.  Print each number as it is read.  Exit the loop
when the user types an invalid value.

Exercise 2.  Write a loop to read in an (integer) part number.  Print
out “Order 50 parts.  Part number is _____”  Put the number you
read in the blank.  Exit the loop when the user types an invalid
value, which is a number smaller than 1000 or greater than 9999. 
(Each part number is a 4-digit value.)

Exercise 3.  The user will type in the name of a song, one letter per
line.
	a.)  Tell how many words are in the name of the song.  Hint:  The
number of words is the same as one more than the number of spaces in
the song name.

	b.)  The user will type in the name of a song, one letter per line. 
Tell if the name of the song contains the letter v.

Exercise 4.  The user can type a code to insert, modify, or delete a
record in our corporate database.  The codes are
	1–Insert
	2–Modify
	3–Delete
	4–Exit
Read the code.  Then, if the code is not 4, ask for an integer record
number and call the correct method.  If the code is 4, exit the
program. Methods are insertRecord (recordNumber), modifyRecord
(recordNumber), and deletetRecord (recordNumber).  The record number
is an argument (and the only argument) for each method.  Code a loop
to read and process choices until the user enters 4 (which exits the
program.)

Exercise 5.  You are writing a program to simulate a mouse running
through a maze.  The mouse makes several steps.  (This is in a loop.)
There are three Boolean variables, wallOnLeft, wallOnRight,
wallAhead.  For each loop iteration, check the variables.  If
wallOnLeft is false, call the method moveLeft.  Otherwise, if
wallAhead is false, call moveAhead.  Otherwise, if wallOnRight is
false, call moveRight.  Otherwise, call the method moveBack and then
call then method turnRight.  After making a move, check if the
boolean variable cheeseFound is true.  If so, exit the loop.  You can
assume that, at the start of the loop, somehow the mouse makes a move
and the boolean variables get set correctly.  You can put a comment
at the start of the loop saying that.
