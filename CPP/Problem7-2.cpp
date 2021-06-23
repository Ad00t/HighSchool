//  Adhit Siripurapu
//  1/13/21
//  Lab 7
//  P7.2: Replaces the value of p with x if x is greater and returns the old value of p

#include <iostream>
using namespace std;

double replace_if_greater(double* p, double x)
{
    double old = *p;
    if (x > *p)
    {
        *p = x;
    }
    return old;
}

int main()
{
    double a = 3.0;
    double b = 10.0;
    cout << "a: " << a << " b: " << b << endl;
    cout << "x > p: " << replace_if_greater(&a, b) << endl;
    cout << "a: " << a << " b: " << b << endl;
    return 0;
}