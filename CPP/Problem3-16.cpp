//  Adhit Siripurapu
//  9/22/20
//  Lab 3
//  P3.16: Prints an employee's paycheck given their name, salary, and hours 

#include <iostream>
#include <string>
#include <iomanip>
using namespace std;

int main()
{
    string name;
    cout << "Enter name: "; cin >> name;
    double salary;
    cout << "Enter salary: "; cin >> salary;
    double hours;
    cout << "Enter work hours: "; cin >> hours;

    if (hours > 40)
        cout << name << "'s Paycheck: " << fixed << setprecision(2) << "$" << ((40 * salary) + (1.5 * salary * (hours - 40)));
    else
        cout << name << "'s Paycheck: " << fixed << setprecision(2) << "$" << (salary * hours);
}