import java.util.Arrays;

// class for the tic tac toe board (grid); the methods in this class
// draw the grid, updates it with eeach move, and check for a winner
public class Board
{
    // spaces on the Board (2D array of Space objects)
    private String[][] spaces;

    private int boardSize;

    /**
     * Constructs Space objects and adds them to the spaces array.
     * Also sets up the winning conditions for tic-tac-toe.
     */
      public Board(int size)
      {
          boardSize = size;

          // initialize the spaces 2D array
          spaces = new String[size][size];

          // set each space in the spaces 2d array to a new Space object
          // which has a "blank" as the default symbol
          for (int row = 0; row < spaces.length; row++)
          {
              for (int col = 0; col < spaces[0].length; col++)
              {
                  spaces[row][col] = "  ";
              }
          }
      }

      // getter method which allows the client to specify
      // which specific Space to return
      public String getSpace(int row, int col)
      {
          // check to make sure the requested Space is in bounds!
          if (row >= 0 && row < spaces.length && col >= 0 && col < spaces[0].length)
          {
              return spaces[row][col];
          }
          return null;
      }

      /**
       * Draws the tic-tac-toe board so that the user can see what is happening.
       * The empty board should look like this:
       *
       *   1|2|3
       *   -----
       *   4|5|6
       *   -----
       *   7|8|9
       *
       * As the players choose space numbers, those spaces will be filled in with Xs and Os.
       *
       *   O|2|3
       *   -----
       *   4|X|6
       *   -----
       *   7|8|9
       *
       * This method goes through each space on the board and checks for BLANKS.
       * If the space is BLANK, it prints the appropriate number.
       * Otherwise, it prints the appropriate symbol.
       */
        public void drawBoard()
        {
            int number = 1;
            for (int i = 0; i < spaces[0].length; i++) // numbers top columns
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
                if (i == spaces[0].length - 1)
                {
                    System.out.println();
                }
            }
//
//            for (int i = 0; i < spaces.length; i++) // rows
//            {
//                for (int j = 0; j < spaces[0].length; j++) // columns
//                {
//                    if (j == 0)
//                    {
//                        System.out.print("|  |");
//                    }
//                    else
//                    {
//                        System.out.print("  |");
//                    }
//                    if (j == spaces[0].length - 1)
//                    {
//                        System.out.println();
//
//                        for (int k = 0; k < spaces[0].length; k++)
//                        {
//                            System.out.print("---");
//                        }
//                        System.out.println("-");
//                    }
//                }
//
//            }
            for (int i = 0; i < spaces.length; i++)
            {
                System.out.print(Arrays.toString(spaces[i]));
                System.out.println();
            }
        }

      public boolean recordMove(int columnNum, Player player)
      {
          if (columnNum < 1 || columnNum > spaces[0].length)
          {
              return false;
          }

          for (int i = spaces.length - 1; i > -1; i--) // rows
          {
              if (spaces[i][columnNum - 1].equals("  ")) //empty
              {
                  spaces[i][columnNum - 1] = (" " + player.getSymbol() + Player.RESET_COLOR);
                  return true;
              }
          }
          return false;
      }

      public boolean isFull()
      {
          for (String[] row : spaces)
          {
              for (String item : row)
              {
                  if (item.equals("  "))
                  {
                      return false;
                  }
              }
          }
          return true;
      }

      public boolean checkWinner()
      {
          // check for a winner by iterating through the 2D array and checking if all
          // symbols in a particular row,  column, or diagonal are the same

          // CHECK ROWS FIRST:

          if (checkRows() == true)
          {
              return true;
          }

          if (checkColumns() == true)
          {
              return true;
          }

          // FINALLY LET'S CHECK DIAGONALS:
          boolean diagWinner = checkDiagonals();

          if (checkDiagonals() == true)
          {
              return true;
          }

          // no winner so far
          return false;
      }

      private boolean checkRows() // true if there is
      {
          return true;
      }

      private boolean checkColumns() // true if there is
      {
          return true;
      }

      private boolean checkDiagonals() // true if there is
      {
          return true;
      }
}