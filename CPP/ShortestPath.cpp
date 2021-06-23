//  Adhit Siripurapu
//  5/19/21
//  Shortest Path
//  Finds the shortest path between two nodes in a graph

#include <iostream>
#include <vector>
using namespace std;

void print_matx(int matx[100][100], int r, int c)
{
    for (int row = 0; row < r; row++)
    {
        for (int col = 0; col < c; col++)
            cout << matx[row][col] << " ";
        cout << endl;
    }
}

struct Graph
{

    int num_verts, edges;
    int adj_matx[100][100];
    int inc_matx[100][100];

    void init(int nv)
    {
        num_verts = nv;
        for (int row = 0; row < num_verts; row++)
            for (int col = 0; col < num_verts; col++)
                adj_matx[row][col] = 0;
    }

    void add_uni_edge(int v1, int v2)
    {
        adj_matx[v1][v2] = 1;
    }

    void add_bi_edge(int v1, int v2)
    {
        add_uni_edge(v1, v2);
        add_uni_edge(v2, v1);
    }

    void print_adj_matrix()
    {
        cout << "Adjacency Matrix" << endl;
        print_matx(adj_matx, num_verts, num_verts);
    }

    void calculate_and_print_incidence_matrix()
    {
        int edge = 0;
        for (int row = 0; row < num_verts; row++)
        {
            for (int col = 0; col <= row; col++)
            {
                if (adj_matx[row][col] == 1)
                {
                    inc_matx[row][edge] = 1;
                    inc_matx[col][edge] = -1;
                    if (adj_matx[col][row] == 1)
                        inc_matx[col][edge] = 1;
                    edge++;
                }
            }
        }
        edges = edge + 1;
        cout << "Incidence Matrix" << endl;
        print_matx(inc_matx, num_verts, num_verts);
    }

    void print_edge_list()
    {
        cout << "Edge List" << endl;
        for (int row = 0; row < num_verts; row++)
            for (int col = 0; col < num_verts; col++)
                if (adj_matx[row][col] == 1)
                    cout << row << " -> " << col << endl;
    }

    void print()
    {
        print_adj_matrix();
        print_edge_list();
    }

    struct Node
    {
        int sp_length;
        int sp_predecessor;
        bool visited;
    };

    int find_next_neighbor(int vert, std::vector<int> &searched_neighbors)
    {
        for (int i = 0; i < num_verts; i++)
        {
            if (adj_matx[vert][i] == 1)
            {
                bool unsearched = true;
                for (int j = 0; j < searched_neighbors.size(); j++)
                {
                   if (i == searched_neighbors.at(j))
                   {
                       unsearched = false;
                       break;
                   } 
                }
                if (unsearched)
                {
                    searched_neighbors.push_back(i);
                    return i;
                }
            }
        }
        return -1;
    }

    void find_shortest_path(int start_vert, int end_vert)
    {
        // Initialization
        Node nodes[100];
        std::vector<int> unvisited;
        int iFront = 0, iBack = 1;
        bool done = false;
        for (Node n : nodes)
            n.visited = false;
        nodes[start_vert].visited = true;
        nodes[start_vert].sp_predecessor = -1;
        nodes[start_vert].sp_length = 0;

        // Algorithm
        unvisited.push_back(start_vert);
        while (!done && unvisited.size() != 0) 
        {
            int front_vert = unvisited.front();
            int next_neighbor = front_vert;
            std::vector<int> searched_neighbors;
            while (!done && (next_neighbor = find_next_neighbor(front_vert, searched_neighbors)) != -1)
            {
                if (!nodes[next_neighbor].visited)
                {
                    nodes[next_neighbor].visited = true;
                    nodes[next_neighbor].sp_length = nodes[front_vert].sp_length + 1;
                    nodes[next_neighbor].sp_predecessor = front_vert;
                    unvisited.insert(unvisited.begin(), next_neighbor);
                }
                done = (next_neighbor == end_vert);
            } 
        }

        // Traversal is complete; add vertices to shortest path array
        int shortest_path[100];
        shortest_path[0] = end_vert;
        int posn = 0, vert = end_vert;
        while (nodes[vert].sp_predecessor != -1)
        {
            vert = nodes[vert].sp_predecessor;
            shortest_path[++posn] = vert;
        }

        // Print shortest path
        cout << "Shortest path from " << start_vert << " to " << end_vert << endl;
        for (int i = posn; i >= 0; i--)
            cout << shortest_path[i] << " ";
        cout << endl;
    }

};

Graph create_graph_Fig6_p136()
{
    Graph gr;
    gr.init(10);
    gr.add_bi_edge(0, 2);
    gr.add_bi_edge(1, 7);
    gr.print();
    gr.calculate_and_print_incidence_matrix();
    return gr;
}

int main()
{
    Graph fig6_p136 = create_graph_Fig6_p136();
    fig6_p136.find_shortest_path(2, 0);
    return 0;
}
