#include <iostream>
#include <string>
#include <list>
using namespace std;

int maze[100000000][100000000];
int width, height;
int start_r, start_c;
int end_r, end_c;
int solution[100000000][100000000];

int FREE = 0; 

int WALL = 1;
int START = 2;
int END = 3;

int PATH = 1;
int TRAVELED = 2;

void /* change to img return type */ load_img(string filepath)
{

}

void set_width_height(/* img-type maze_img */)
{
    width = 100; /* change to maze_img width */
    height = 100; /* change to maze_img height */
}

void fill_maze_arr(/* img-type maze_img */)
{
    for (int r = 0; r < height; r++)
    {
        for (int c = 0; c < width; c++)
        {
            solution[r][c] = FREE;
            if (true /* pixel color is black (wall) */)
            {
                maze[r][c] = WALL;
            }  
            else
            {
                if (c == 0)
                {
                    maze[r][c] = START;
                }
                else if (c == width - 1)
                {
                    maze[r][c] = END;
                }
                else
                {
                    maze[r][c] = FREE;
                }
            }                      
        }
    }
}

bool is_free(int r1, int c1)
{
    return maze[r1][c1] == FREE && solution[r1][c1] == FREE;
}

bool find_solution(int r, int c)
{
    solution[r][c] = PATH;
    
    if (r == end_r && c == end_c)
        return true;

    if (r < height - 1 && is_free(r + 1, c) && find_solution(r + 1, c))
        return true;
    if (r > 0 && is_free(r - 1, c) && find_solution(r - 1, c))
        return true;
    if (c < width - 1 && is_free(r, c + 1) && find_solution(r, c + 1))
        return true;
    if (c > 0 && is_free(r, c - 1) && find_solution(r, c - 1))
        return true;
   
    solution[r][c] = TRAVELED;
    return false; 
}

int main()
{
    /* img-type maze_img = */ load_img("maze.png");
    set_width_height(/* maze_img */);
    fill_maze_arr(/* maze_img */);

    if (find_solution(start_r, start_c))
    {
        /* edit image and color solution yellow */
    }
    else
    {
        /* output no solution found */
    }
    
    return 0;
}