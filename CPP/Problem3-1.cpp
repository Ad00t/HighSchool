//  Adhit Siripurapu
//  9/22/20
//  Lab 3
//  P3.1: Prints if water is solid, liquid, or gas at the given temperature + unit

#include <iostream>
using namespace std;

int main()
{
    double temp; 
    cout << "Enter temperature: "; cin >> temp;
    char unit; 
    cout << "Enter temperature measurement unit: "; cin >> unit;

    if ((temp <= 0 && unit == 'C') || (temp <= 32 && unit == 'F'))
        cout << "Solid";
    else if ((temp <= 100 && unit == 'C') || (temp <= 212 && unit == 'F'))
        cout << "Liquid";
    else
        cout << "Gas";  
}