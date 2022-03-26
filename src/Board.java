import java.util.Arrays;

public class Board
{
    private String[][] spaces;

    private int boardSize;

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

    private boolean checkRows() // true if there is, left to right
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

    private boolean checkColumns() // true if there is, bottom to top
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

    private boolean checkDiagonals() // true if there is
    {
        for (int i = 0; i < boardSize - 3; i++) // top left to bottom right
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

        for (int i = boardSize - 1; i > 2; i--) // bottom left to top right
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