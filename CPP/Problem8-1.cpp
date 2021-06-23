//  Adhit Siripurapu
//  1/20/21
//  Lab 8
//  P8.1: Carries out the following tasks:
/* Open a file with the name hello.txt
 * Store the message "Hello, World!" in the file.
 * Close the file.
 * Open the same file again.
 * Read the message into a string variable and print it.
 */


#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main()
{
    ofstream out_strm;
    out_strm.open("hello.txt");
    out_strm << "Hello, World!";
    out_strm.close();

    ifstream in_strm;
    in_strm.open("hello.txt");
    string hello_world;
    if (getline(in_strm, hello_world))
    {
        cout << hello_world << endl;
    }

    return 0;
}