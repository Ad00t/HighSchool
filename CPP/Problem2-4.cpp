//  Adhit Siripurapu
//  9/10/20
//  Lab 2
//  R2.4: Prints the sum, difference, product, and average of two user-provided integers

#include <iostream>
using namespace std;

int main()
{
    int i1, i2;
    cout << "Integer #1: ";
    cin >> i1;
    cout << "Integer #2: ";
    cin >> i2;

    cout << "Sum: " << i1 + i2 << endl;
    cout << "Difference: " << i1 - i2 << endl;
    cout << "Product: " << i1 * i2 << endl;
    cout << "Average: " << (i1 + i2) / 2.0 << endl;

    return 0;
}