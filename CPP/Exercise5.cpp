#include<iostream>
using namespace std;

void moveLeft() { cout << "left" << endl; }
void moveRight() { cout << "right" << endl; }
void moveAhead() { cout << "ahead" << endl; }
void moveBack() { cout << "back" << endl; }
void turnRight() { cout << "turn right" << endl; }

int main()
{
    bool wallOnLeft, wallOnRight, wallAhead, cheeseFound;
    // Mouse has made a move and all booleans reflect that
    while (true)
    {
        if (!wallOnLeft)
            moveLeft();
        else if (!wallAhead)
            moveAhead();
        else if (!wallOnRight)
            moveRight();
        else
        {
            moveBack();
            turnRight();
        }

        if (cheeseFound)
            break;        
    }
}