#include<iostream>
using namespace std;

void insertRecord(int recordNumber) { cout << "insert" << endl; }
void modifyRecord(int recordNumber) { cout << "modify" << endl; }
void deleteRecord(int recordNumber) { cout << "delete" << endl; }

int main()
{
    while (true)
    {
        cout << "Enter an integer code (1 through 4): ";
        int code; cin >> code;
        if (code == 4) return 0;

        cout << "Enter an integer record number: ";
        int recordNumber; cin >> recordNumber;
        
        if (code == 1)
            insertRecord(recordNumber);
        if (code == 2)
            modifyRecord(recordNumber);
        if (code == 3)
            deleteRecord(recordNumber);
    }
}