#include <iostream>
#include <string>
#include <opencv2/opencv.hpp>

using namespace cv;
using namespace std;

//////////////// CONSTANTS ////////////////

string file_name = "maze.png";
string dir = "C:\\Users\\ramesh\\Programming\\School\\CPP\\project\\";
Size window_size = Size(550, 550);
bool print_arr = false;

//////////////// 2D ARRAYS ////////////////

int maze[10000][10000];
int rows, cols;
int start_r, start_c;
int end_r, end_c;
int solution[10000][10000];

//////////////// 2D ARRAY FLAGS ////////////////

// Universal
int OPEN = 0; 

// Maze array
int WALL = 1;
int START = 2;
int END = 3;

// Solution array
int PATH = 4;
int TRAVELED = 5;

//////////////// RGB STRUCTURE ////////////////

struct RGB 
{

    public:
        uchar red; 
        uchar green; 
        uchar blue;

        RGB(uchar red, uchar green, uchar blue)
        {
            this->red = blue;
            this->green = green;
            this->blue = red;
        }

        bool equals(RGB o)
        {
            return (blue == o.blue && green == o.green && red == o.red);
        }

};

//////////////// CONVENIENT RGB COLORS ////////////////

RGB* black = new RGB(0, 0, 0);
RGB* white = new RGB(255, 255, 255);
RGB* green = new RGB(0, 255, 0);
RGB* yellow = new RGB(255, 255, 0);

//////////////// FUNCTIONS ////////////////

// Sets the global rows and cols variables to the dimensions of the image
void set_rows_cols(Mat maze_img)
{
    rows = maze_img.rows;
    cols = maze_img.cols;
    cout << "Rows & cols set" << endl;
}

// Read each pixel of the original maze image and convert to an int in the maze 2d array
// 0 = open (white), 1 = wall (black), 2 = start, 3 = end 
void fill_maze_arr(Mat maze_img)
{
    for (int r = 0; r < rows; r++)
    {
        for (int c = 0; c < cols; c++)
        {
            solution[r][c] = OPEN;
            if (maze_img.ptr<RGB>(r, c)->equals(*black))
            {
                maze[r][c] = WALL;
            }  
            else
            {
                if (c == 0)
                {
                    maze[r][c] = START;
                    start_r = r;
                    start_c = c;
                }
                else if (c == cols - 1)
                {
                    maze[r][c] = END;
                    end_r = r;
                    end_c = c;
                }
            }
            if (print_arr) cout << maze[r][c] << " ";                      
        }
        if (print_arr) cout << endl;
    }
    cout << "Maze 2D array filled" << endl;
}

// Convenience method to check if the solving algorithm is allowed to enter a given space
bool is_free(int r1, int c1)
{
    return (maze[r1][c1] == OPEN || maze[r1][c1] == END) && solution[r1][c1] == OPEN;
}

// Uses recursive backtracking to incrementally search for a path to the end
bool find_solution(Mat &maze_img, int r, int c)
{
    solution[r][c] = PATH;
    
    if (r == end_r && c == end_c)
        return true;

    if (r < rows - 1 && is_free(r + 1, c) && find_solution(maze_img, r + 1, c))
        return true;
    if (r > 0 && is_free(r - 1, c) && find_solution(maze_img, r - 1, c))
        return true;
    if (c < cols - 1 && is_free(r, c + 1) && find_solution(maze_img, r, c + 1))
        return true;
    if (c > 0 && is_free(r, c - 1) && find_solution(maze_img, r, c - 1))
        return true;
   
    solution[r][c] = TRAVELED;
    return false; 
}

// Colors the solution green and other explored spaces yellow
void color_in_solution(Mat &maze_img)
{
    for (int r = 0; r < rows; r++)
    {
        for (int c = 0; c < cols; c++)
        {
            if (solution[r][c] == PATH)
            {
                maze_img.at<RGB>(r, c) = *green;
            }
            else if (solution[r][c] == TRAVELED)
            {
                maze_img.at<RGB>(r, c) = *yellow;
            }
        }
    }
    cout << "Solution colored in" << endl;
}

// Scales up and displays a Mat (maze image) in a named window
void display_mat(Mat maze_img, string name)
{
    Mat scaled_up;
    resize(maze_img, scaled_up, window_size);
    namedWindow(name, WINDOW_AUTOSIZE);
    imshow(name, scaled_up);
    cout << name << " displayed" << endl;
    waitKey(0);
}

int main()
{
    Mat logo_img = imread(dir + "logo.png");
    display_mat(logo_img, "The Amazing Mazer");
    Mat maze_img = imread(dir + file_name);

    set_rows_cols(maze_img);
    fill_maze_arr(maze_img);

    bool isSolved = find_solution(maze_img, start_r, start_c);
    color_in_solution(maze_img);

    if (isSolved)
    {
        cout << "Solution found!" << endl;
        display_mat(maze_img, "Solved Maze");
        imwrite(dir + "solved_" + file_name, maze_img);
    }
    else
    {
        cout << "No solution found!" << endl;
        display_mat(maze_img, "Unsolved Maze");
        imwrite(dir + "unsolved_" + file_name, maze_img);
    }

    return 0;
}
