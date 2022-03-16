// class for the tic tac toe board (grid); the methods in this class
// draw the grid, updates it with eeach move, and check for a winner
public class Board
{
    // spaces on the Board (2D array of Space objects)
    private Space[][] spaces;

    private int boardSize;

    /**
     * Constructs Space objects and adds them to the spaces array.
     * Also sets up the winning conditions for tic-tac-toe.
     */
      public Board(int size)
      {
          boardSize = size;

          // initialize the spaces 2D array
          spaces = new Space[size][size];

          // set each space in the spaces 2d array to a new Space object
          // which has a "blank" as the default symbol
          for (int row = 0; row < spaces.length; row++)
          {
              for (int col = 0; col < spaces[0].length; col++)
              {
                  spaces[row][col] = new Space();
              }
          }
      }

      // getter method which allows the client to specify
      // which specific Space to return
      public Space getSpace(int row, int col)
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
                System.out.print("  " + number);
                number++;
                if (i == spaces[0].length - 1)
                {
                    System.out.println();
                }
            }

            for (int i = 0; i < spaces.length; i++) // rows
            {
                for (int j = 0; j < spaces[0].length; j++) // columns
                {
                    if (j == 0)
                    {
                        System.out.print("|  |");
                    }
                    else
                    {
                        System.out.print("  |");
                    }
                    if (j == spaces[0].length - 1)
                    {
                        System.out.println();

                        for (int k = 0; k < spaces[0].length; k++)
                        {
                            System.out.print("---");
                        }
                        System.out.println("-");
                    }
                }

            }
        }

    /**
     * Updates a space based on a player's move by changing it from a blank space to either
     * a an X or O (whichever symbol is associated with player)
     * The method uses an integer (spaceIdx) to determine which space is going to be updated.
     * Method returns TRUE if the space was successfully "occupied", which occurs via the occupySpace
     * method on the space object; if the space was NOT successfully occupied (either because the selected
     * space was outside therange, OR the space was ALREADY occupied by the opposite player), then
     * return false to indicate the space was NOT occupied.
     *
     * @param spaceNum  the selected space of the space to be occupied by player.
     * @param player  the Player taking the turn and attempting to "occupy" the space.
     * @return  true if the move was successful and the space occupied; return false otherwise.
     */
      public boolean recordMove(int columnNum, Player player)
      {
          if (columnNum < 1 || columnNum > spaces[0].length)
          {
              return false;
          }

          for (int i = spaces.length - 1; i > -1; i--) // rows
          {
              if (Space.BLANK != spaces[i][columnNum].getSymbol())
              {
                  spaces[i][columnNum].occupySpace(player.getSymbol());
                  return true;
              }
          }
          return false;
      }

    /**
     *Determines whether or not the board is full (has no BLANK spaces).
     *
     *@return True if there are no BLANKs in any spaces.
     */
      public boolean isFull()
      {
          for (Space[] row : spaces)
          {
              for (Space space : row)
              {
                  if (space.getSymbol() == Space.BLANK)
                  {
                      return false;
                  }
              }
          }
          return true;
      }

    /**
     * Determine whether or not there is a winner and if so, which symbol won;
     * this method returns the symbol of the winning Player OR returns BLANK if no winner
     *
     * @return  if there IS a winning condition on the board, appropriately returns
                the winning Player's symbol; if there is NO winning condition and no
                current winner, this method returns BLANK
     */
      public String checkWinner()
      {
          // check for a winner by iterating through the 2D array and checking if all
          // symbols in a particular row,  column, or diagonal are the same

          // CHECK ROWS FIRST:
          String rowWinner = checkRows();

          if (!rowWinner.equals(Space.BLANK))
          {
              return rowWinner;
          }

          // THEN LET'S CHECK COLUMNS:
          String colWinner = checkColumns();

          if (!colWinner.equals(Space.BLANK))
          {
              return colWinner;
          }

          // FINALLY LET'S CHECK DIAGONALS:
          String diagWinner = checkDiagonals();

          if (!diagWinner.equals(Space.BLANK))
          {
              return diagWinner;
          }

          // no winner so far
          return Space.BLANK;
      }

    /**
     * Determines whether or not any ROW in the grid has all matching symbols
     *
     * @return  if there IS a winning condition in any of the ROWS, appropriately returns
                the winning Player's symbol; if no rows have all the same symbol (i.e. no
                winner across the rows), return a BLANK
     */
      private String checkRows()
      {

      }

    /**
     * Determines whether or not any COLUMN in the grid has all matching symbols
     *
     * @return  if there IS a winning condition in any of the COLUMNS, appropriately returns
                the winning Player's symbol; if no columns have all the same symbol (i.e. no
                winner across the columns), return a BLANK
     */
      private String checkColumns()
      {

      }

    /**
     * Determines whether or not either DIAGONAL in the grid has all matching symbols
     *
     * @return  if there IS a winning condition in either of the diagonals, appropriately returns
                the winning Player's symbol; if neither diagonol has all the same symbol (i.e. no
                winner across the diagonals), return a BLANK
     */
      private String checkDiagonals()
      {

      }
}