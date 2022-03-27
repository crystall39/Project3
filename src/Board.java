// Created by Crystal Ling

import java.util.Arrays;

public class Board
{
    private String[][] spaces;

    private int boardSize;

    /**
     * Sets boardSize private instance variable to the parameter
     * Creates a 2D array based on the size given
     * Replaces every space in the 2D array with "  "
     *
     * @param size length or width of the board
     */
    public Board(int size)
    {
          boardSize = size;

          spaces = new String[size][size];

          for (int row = 0; row < boardSize; row++)
          {
              for (int col = 0; col < boardSize; col++)
              {
                  spaces[row][col] = "  ";
              }
          }
    }

    /**
     * Numbers the columns on top of the 2D array by using a for loop and a local variable
     * Correctly formats the numbers so that they align with the column
     * Draws the board by printing the 2D array
     */
    public void drawBoard()
    {
        int number = 1;
        for (int i = 0; i < boardSize; i++) // numbers top columns
        {
            if (number == 1)
            {
                System.out.print("  " + number);
            }
            else if (number < 10)
            {
                System.out.print("   " + number);
            }
            else
            {
                System.out.print("  " + number);
            }
            number++;
            if (i == boardSize - 1)
            {
                System.out.println();
            }
        }

        for (int i = 0; i < boardSize; i++)
        {
            System.out.print(Arrays.toString(spaces[i]));
            System.out.println();
        }
    }

    /**
     * Records the move of the player in the column they choose
     * Checks to see the column they place their piece in is a valid column
     * This is to make sure there are no out-of-bounds error if they place it in a place the 2D array does not allow
     * Finds the lowest row and checks to see if it is empty
     * If so, the piece is placed there and return true
     * Otherwise, the row is increased by one until the program can find an empty space
     * Then it would return true
     * If there are no empty spaces in the chosen column, it would ultimately return false
     *
     * @param columnNum the column number the player wants to place their piece in
     * @param player either player 1 or player 2
     * @return true if the column the player places their piece in is valid, false if otherwise
     */
    public boolean recordMove(int columnNum, Player player)
    {
        if (columnNum < 1 || columnNum > boardSize)
        {
          return false;
        }

        for (int i = boardSize - 1; i > - 1; i--) // rows
        {
            if (spaces[i][columnNum - 1].equals("  ")) // empty
            {
                spaces[i][columnNum - 1] = (" " + player.getSymbol() + Player.RESET_COLOR);
                return true;
            }
        }
        return false;
    }

    /**
     * Checks to see if the board is full
     * Iterates through the top row of the board and sees if the spaces are blank
     * If a single space in the top row is blank, it will return false
     * Otherwise, it would return true
     *
     * @return true if the board is full, false if not
     */
    public boolean isFull()
    {
        for (int i = 0; i < boardSize; i++)
        {
            if (spaces[0][i].equals("  "))
            {
              return false;
            }
        }
        return true;
    }

    /**
     * Checks to see if there is a winner in each move
     *
     * @return true if there is a winner, false if there is not
     */
    public boolean checkWinner()
    {
        if (checkRows())
        {
            return true;
        }

        if (checkColumns())
        {
            return true;
        }

        if (checkDiagonals())
        {
            return true;
        }
        return false;
    }

    /**
     * Checks the rows (left to right) if there are 4 of the same pieces in a row
     * i represents the rows, which can be any
     * j represents the column, which have to be three less from the right side, or else there would be an out-of-bounds error
     * Checks to see if one item and the three items to its right are the same
     * Returns true if it is
     * Otherwise, it iterates through all rows and any available columns for four matching pieces
     * If none are found, return false
     *
     * @return true if there is a winner, false if there is not
     */
    private boolean checkRows()
    {
        for (int i = 0; i < boardSize; i++)
        {
            for (int j = 0; j < boardSize - 3; j++)
            {
                if (!spaces[i][j].equals("  ") &&
                   spaces[i][j].equals(spaces[i][j + 1]) &&
                   spaces[i][j + 1].equals(spaces[i][j + 2]) &&
                   spaces[i][j + 2].equals(spaces[i][j + 3]))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks the columns (up to down) if there are 4 of the same pieces in a row
     * i represents the rows, which have to be three less from the bottom, or else there would be an out-of-bounds error
     * j represents the column, which can be any
     * Checks to see if one item and the three items under it are the same
     * Returns true if it is
     * Otherwise, it iterates through any available rows and all columns for four matching pieces
     * If none are found, return false
     *
     * @return true if there is a winner, false if there is not
     */
    private boolean checkColumns()
    {
        for (int i = 0; i < boardSize - 3; i++)
        {
            for (int j = 0; j < boardSize; j++)
            {
                if (!spaces[i][j].equals("  ") &&
                     spaces[i][j].equals(spaces[i + 1][j]) &&
                     spaces[i + 1][j].equals(spaces[i + 2][j]) &&
                     spaces[i + 2][j].equals(spaces[i + 3][j]))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks the diagonals (top left to bottom right and bottom left to top left) if there are 4 of the same pieces in a row
     *
     * For top left to bottom right diagonals, rows and columns are the same number ([0][0], [1][1], [2][2], etc.)
     * i represents the rows, which have to be three less from the bottom, or else there would be an out-of-bounds error
     * j represents the column, which have to be three less from the right, or else there would be an out-of-bounds error
     * Checks to see if one item and the three items under and to the right of it are the same
     * Returns true if it is
     * Otherwise, it iterates through any available rows and all columns for four matching pieces
     * If none are found, return false
     *
     * For bottom left to top right diagonals, rows start at the board size and go down and columns start at 0 and go up([0][5], [1][4], [2][3], [3][2], etc.)
     * i represents the rows, which starts at the board size and sve to stop at the 3rd row, or else there would be an out-of-bounds error
     * j represents the column, which starts at 0 and has to be three less from the right side, or else there would be an out-of-bounds error
     * Checks to see if one item and the three items above and to the right of it are the same
     * Returns true if it is
     * Otherwise, it iterates through any available rows and all columns for four matching pieces
     * If none are found, return false
     * @return true if there is a winner, false if there is not
     */
    private boolean checkDiagonals()
    {
        for (int i = 0; i < boardSize - 3; i++)
        {
            for (int j = 0; j < boardSize - 3; j++)
            {
                if (!spaces[i][j].equals("  ") &&
                     spaces[i][j].equals(spaces[i + 1][j + 1]) &&
                     spaces[i + 1][j + 1].equals(spaces[i + 2][j + 2]) &&
                     spaces[i + 2][j + 2].equals(spaces[i + 3][j + 3]))
                {
                    return true;
                }
            }
        }

        for (int i = boardSize - 1; i >= 3; i--)
        {
            for (int j = 0; j < boardSize - 3; j++)
            {
                if (!spaces[i][j].equals("  ") &&
                     spaces[i][j].equals(spaces[i - 1][j + 1]) &&
                     spaces[i - 1][j + 1].equals(spaces[i - 2][j + 2]) &&
                     spaces[i - 2][j + 2].equals(spaces[i - 3][j + 3]))
                {
                    return true;
                }
            }
        }
        return false;
    }
}