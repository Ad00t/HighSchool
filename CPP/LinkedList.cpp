//  Adhit Siripurapu
//  12/17/20
//  Linked List
//  Defines, creates, and tests a linked list manipulation implementation

#include <iostream>
#include <string>
using namespace std;

struct Node
{
    string name;
    Node* next;
};

Node* linked_list = NULL;

void insert_data(string name)
{
    Node* first = new Node;
    first->name = name;
    first->next = linked_list;
    linked_list = first;
}

string delete_node()
{
    if (linked_list != NULL)
    {
        Node* save_ptr = linked_list;
        linked_list = linked_list->next;
        string name = save_ptr->name;
        delete save_ptr;
        return name;
    }
}

void print_linked_list()
{
    Node* reader = linked_list; 
    while (reader != NULL)
    {
        cout << reader->name << " ";
        reader = reader->next;
    }
    delete reader;
    cout << endl;
}

int main()
{    
    insert_data("Charlie");
    print_linked_list();

    insert_data("Beth");
    print_linked_list();

    insert_data("Alex");
    print_linked_list();

    string deleted = delete_node();
    cout << "Deleted " << deleted << endl;
    print_linked_list();

    return 0;
}


