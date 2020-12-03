//  Adhit Siripurapu
//  10/7/20
//  Lab 4
//  P4.1: Prints (a) sum of all even numbers on [2, 100] (b) sum of all squares
//        on [1, 100] (c) all powers of 2 from 2^0 up to 2^20 (d) sum of all odd 
//        numbers on inputs [a, b] and (e) sum of all odd digits of an input

#include <iostream>
#include <cmath>
using namespace std;

int main()
{
    int a_sum = 0;
    for (int n = 2; n <= 100; n += 2)
    {
        a_sum += n;
    }  
    cout << "a) " << a_sum << endl;

    int b_sum = 0;
    for (int n = 1; n <= 10; n++)
    {
        b_sum += pow(n, 2);
    }  
    cout << "b) " << b_sum << endl;

    cout << "c)" << endl;
    for (int i = 0; i <= 20; i++)
    {
        cout << pow(2, i) << endl;
    }

    cout << "d)" << endl;
    cout << "a: "; int a; cin >> a;
    cout << "b: "; int b; cin >> b;
    int d_sum = 0;
    for (int i = a; i <= b; i++)
    {
        if (i % 2 == 1)
            d_sum += i;
    }
    cout << d_sum << endl;

    cout << "e)" << endl;
    cout << "number: "; string n; cin >> n;
    int sum = 0;
    for (int i = 0; i < n.length(); i++) {
        int n_i = n[i] - '0';
        if (n_i % 2 == 1)
            sum += n_i;
    }
    cout << sum << endl;
}