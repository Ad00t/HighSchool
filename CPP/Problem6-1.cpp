//  Adhit Siripurapu
//  12/2/20
//  Lab 6
//  P6.1: Prints every element of an even index, every even element, all elements in reverse,
//  and the first & last elements of an array with 10 random integers

#include <iostream>
#include <ctime>
#include <stdlib.h>
using namespace std;

void print_even_indices(int arr[])
{
    for (int i = 0; i < 10; i += 2)
    {
        if (i != 0)
        {
            cout << " ";
        }
        cout << arr[i];
    }
    cout << endl;
}

void print_even_elements(int arr[])
{
    for (int i = 0; i < 10; i++)
    {
        if (arr[i] % 2 == 0) 
        {
            cout << arr[i] << " ";
        }
    }
    cout << endl;
}

void print_reverse(int arr[])
{
    for (int i = 9; i >= 0; i--)
    {
        if (i != 9)
        {
            cout << " ";
        }
        cout << arr[i]; 
    }
    cout << endl;
}

void print_first_last(int arr[])
{
    cout << arr[0] << " " << arr[9] << endl;
}

int main()
{
    srand(time(0));
    int arr[10];
    for (int i = 0; i < 10; i++)
    {
        arr[i] = rand() % 10 + 1;
        if (i != 0)
        {
            cout << " ";
        }
        cout << arr[i];
    }
    cout << endl;

    print_even_indices(arr);
    print_even_elements(arr);
    print_reverse(arr);
    print_first_last(arr);

    return 0;
}