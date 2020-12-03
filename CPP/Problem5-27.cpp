//  Adhit Siripurapu
//  11/4/20
//  Lab 5
//  P5.27: Uses recursion to return the reversed version of a string

#include <iostream>
#include <string>
using namespace std;

string reverse(string str)
{
    if (str.length() == 0)
    {
        return str;
    }
    return reverse(str.substr(1)) + str[0];
}

int main()
{
    string original = "abcdefgh";
    cout << "Original: " << original << endl;
    cout << "Reversed: " << reverse(original) << endl;
}