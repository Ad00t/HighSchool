//  Adhit Siripurapu
//  9/10/20
//  Lab 2
//  R2.17: Prints a user-provided number between 1,000 and 999,999 with a comma separating the thousands

#include <iostream>
#include <string>
using namespace std;

int main()
{
    cout << "Please enter an integer between 1,000 and 999,999: ";
    string i;
    cin >> i;

    int comma_index = i.length() - 3;
    cout << i.substr(0, comma_index) + "," + i.substr(comma_index);

    return 0;
}