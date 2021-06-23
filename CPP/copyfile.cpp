//  Adhit Siripurapu
//  1/20/21
//  Lab 8
//  P8.14: Copies the contents of one file to another, specified by command arguments

#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main(int argc, char* argv[])
{
    string from = argv[1];
    string to = argv[2];

    ifstream in_strm;
    in_strm.open(from.c_str());

    ofstream out_strm;
    out_strm.open(to.c_str());

    char c;
    while (in_strm.get(c))
    {
        out_strm << c;
    }

    in_strm.close();
    out_strm.close();

    return 0;
}