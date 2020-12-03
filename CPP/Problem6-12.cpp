//  Adhit Siripurapu
//  12/2/20
//  Lab 6
//  P6.12: Removes duplicates from a given array

#include <iostream>
using namespace std;

void remove_index(int arr[], int index, int& size)
{
    for (int i = index + 1; i < size; i++)
    {
        arr[i - 1] = arr[i];
    }
    size--;
}

void remove_duplicates(int arr[], int& size)
{
    for (int i = 0; i < size; i++)
    {
        for (int j = i + 1; j < size; j++)
        {
            if (arr[i] == arr[j])
            {
                remove_index(arr, j, size);
                j--;
            }
        }
    }
}

int main()
{
    int size = 9;
    int arr[] = { 1, 4, 9, 16, 9, 7, 4, 9, 11 };

    for (int i = 0; i < size; i++)
    {
        cout << arr[i] << " ";
    }
    cout << endl;

    remove_duplicates(arr, size);

    for (int i = 0; i < size; i++)
    {
        cout << arr[i] << " ";
    }
    
    return 0;
}