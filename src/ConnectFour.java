import java.util.Scanner;

public class ConnectFour
{
    // array of Players
    private Player[] players;

    // Board object used in the game
    private Board board;
    
    public ConnectFour()
    {
        setup();
    }

    public void setup()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("What size board? (6, 7, 8, 9): ");
        int boardSize = scan.nextInt();

        board = new Board(boardSize);

        // draws the board as part of setup
        board.drawBoard();
    }

    public void runGame()
    {
        System.out.println("--------------------------------------------------------");
        System.out.println("This game requires exactly two people to play.");
        System.out.println("So if there are more of than two people or only one...");
        System.out.println("Sorry, kid.");
        System.out.println("--------------------------------------------------------");
        System.out.println("Welcome to Connect Four!");
        System.out.println("Player one will be " + Player.RED + "0" + Player.RESET_COLOR + " and Player two will be " + Player.YELLOW + "0");
    }

}
