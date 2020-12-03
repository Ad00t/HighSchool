//  Adhit Siripurapu
//  11/4/20
//  Lab 5
//  P5.3: Computes and tests the smallest and average of 3 doubles

#include <iostream>
#include <iomanip>
using namespace std;

double smallest(double x, double y, double z)
{
    double smallest = x;
    if (y < smallest)
    {
        smallest = y;
    }
    if (z < smallest)
    {
        smallest = z;
    }
    
    return smallest;
}

double average(double x, double y, double z)
{
    return (x + y + z) / 3;
}

int main()
{
    double x = 5;
    double y = 6;
    double z = 7;

    cout << "Smallest: " << smallest(x, y, z) << endl;
    cout << fixed << setprecision(3) << "Average: " << average(x, y, z) << endl;
}