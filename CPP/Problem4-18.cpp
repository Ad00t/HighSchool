//  Adhit Siripurapu
//  10/7/20
//  Lab 4
//  P4.18: Computes Fibonacci sequence up to a specified number of iterations

#include <iostream>
#include <cmath>
using namespace std;

int main()
{
    cout << "n: "; int n; cin >> n;

    int fold1 = 1;
    int fold2 = 1;
    int fnew = fold1 + fold2;
    cout << fold1 << endl << fold2 << endl;

    for (int i = 0; i < n - 2; i++)
    {
        cout << fnew << endl;
        fold2 = fold1;
        fold1 = fnew;
        fnew = fold1 + fold2;
    }
}