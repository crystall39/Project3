// Created by Crystal Ling

import java.util.Scanner;

public class ConnectFour
{
    private Player[] players;

    private Board board;

    boolean keepGoing = true;

    /**
     * Introduces players into the Connect Four game
     * Initializes players[] with the length of 2 for two players
     * Creates two player objects and places them inside players[]
     * Asks user for the board size, which must be 4 or more to be functional
     * Creates and draws a new board based on the inputted board size
     */
    public ConnectFour()
    {
        setUp();
    }

    public void setUp()
    {
        System.out.println("--------------------------------------------------------");
        System.out.println("This game requires exactly two people to play.");
        System.out.println("So if there are more of than two people or only one...");
        System.out.println("Sorry, kid.");
        System.out.println("--------------------------------------------------------");
        System.out.println("Welcome to Connect Four!");
        System.out.println("Player one will be " + Player.RED + "0" + Player.RESET_COLOR + " and Player two will be " + Player.YELLOW + "0");
        Scanner scan = new Scanner(System.in);

        players = new Player[2];
        Player player1 = new Player(Player.RED + "0");
        Player player2 = new Player(Player.YELLOW + "0");
        players[0] = player1;
        players[1] = player2;

        int boardSize = 0;
        while (boardSize < 4)
        {
            System.out.print(Player.RESET_COLOR + "What size board? (must be 4 or more): ");
            boardSize = scan.nextInt();
        }
        board = new Board(boardSize);

        board.drawBoard();
    }

    /**
     * A while loop that will end if the board is full or if a player wins
     * The enhanced for loop will iterate between player 1 and player 2 in players[]
     * When a player makes a move, and it is a winning move, turn(player) will be set to true
     * That will cause the if statement to be true, which will make keepGoing false and break
     */
    public void playGame()
    {
        while (keepGoing && !board.isFull())
        {
            for (Player player : players)
            {
                if (turn(player))
                {
                    keepGoing = false;
                    break;
                }
            }
        }
    }

    /**
     * This method is run when a player takes a turn
     * Will, first, ask the player to pick a column for their move
     * If that column is full, the player must pick another one
     * If the column is not full, that player's colored piece would be placed and the board is drawn with their piece in the right place
     * If the player made a winning move, a message will be printed and would return true
     * If the board is full, a message will be printed and would return true
     * Will return false otherwise
     *
     * @param player either player 1 or player 2
     * @return true if the board is full or if a player makes a winning move, false if the player makes a normal move
     */
    public boolean turn(Player player)
    {
        Scanner scan = new Scanner(System.in);

        boolean playerGo = false;

        while(!playerGo)
        {
            System.out.print("Player " + player.getSymbol() + Player.RESET_COLOR + "! Your turn: ");
            int chosenSpace = scan.nextInt();
            playerGo = board.recordMove(chosenSpace, player);
        }
        board.drawBoard();

        if (board.checkWinner())
        {
            System.out.println("Looks like we have a winner! And it's " + player.getSymbol() + Player.RESET_COLOR + "!");
            return true;
        }
        if (board.isFull())
        {
            System.out.println("Looks like no one won this time! Try again!");
            return true;
        }
        return false;
    }
}