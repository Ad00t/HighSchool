// Adhit Siripurapu
// 9/4/20
// Lab 1, P1.6
/* Takes in an account balance and prints it out after each of three years
   after applying annual compound interest of 5% 
*/

#include <iostream>
using namespace std;

int main()
{
    cout << "Account Balance: ";
    double account_balance;
    cin >> account_balance;

    cout.precision(2);
    account_balance *= 1.05;
    cout << fixed << "Year 1: " << account_balance << endl;
    account_balance *= 1.05;
    cout << fixed << "Year 2: " << account_balance << endl;
    account_balance *= 1.05;
    cout << fixed << "Year 3: " << account_balance << endl;
    return 0;
}