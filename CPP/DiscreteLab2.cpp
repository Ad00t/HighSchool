//  Adhit Siripurapu
//  2/19/21
//  Lab 2
//  Defines and tests 3 functions:
//    (1) Calculates the union of two sets
//    (2) Calculates the intersection of two sets
//    (3) Tells if the first set is a subset of the second or not

#include <iostream>
#include <iterator>
#include <set>
#include <string>
using namespace std;

typedef set<int> int_set;

int_set set_union(int_set A, int_set B)
{
    int_set result;
    for (int n : A)
        result.insert(n);
    for (int n : B)
        result.insert(n);
    return result;
}

int_set set_intersection(int_set A, int_set B)
{
    int_set result;
    for (int n : A)
    {
        if (B.find(n) != B.end())
            result.insert(n);
    }
    return result;
}

bool is_subset(int_set A, int_set B)
{
    for (int n : A)
    {
        if (B.find(n) == B.end())
            return false;
    }
    return true;
}

void list_elements(string label, int_set set)
{
    cout << label << ": ";
    for (int n : set)
        cout << n << " ";
    cout << endl;
}

int main() {
    int_set A;
    for (int n : { -1, 1, 4, 2, 5, 7 })
        A.insert(n);
    list_elements("A", A);

    int_set B;
    for (int n : { 3, 9, 1, 6, 7, -1 })
        B.insert(n);
    list_elements("B", B);

    list_elements("Union", set_union(A, B));
    list_elements("Intersection", set_intersection(A, B));
    cout << "A is a subset of B? " << is_subset(A, B) << endl;

    return 0;
}