import java.util.Scanner;

public class ConnectFour
{
    // array of Players
    private Player[] players;

    // Board object used in the game
    private Board board;
    
    public ConnectFour()
    {
        run();
    }

    public void run()
    {
        System.out.println("--------------------------------------------------------");
        System.out.println("This game requires exactly two people to play.");
        System.out.println("So if there are more of than two people or only one...");
        System.out.println("Sorry, kid.");
        System.out.println("--------------------------------------------------------");
        System.out.println("Welcome to Connect Four!");
        System.out.println("Player one will be " + Player.RED + "0" + Player.RESET_COLOR + " and Player two will be " + Player.YELLOW + "0");
        Scanner scan = new Scanner(System.in);

        Player player1 = new Player(Player.RED + "0");
        Player player2 = new Player(Player.YELLOW + "0");

        System.out.print(Player.RESET_COLOR + "What size board? (6, 7, 8, 9): ");
        int boardSize = scan.nextInt();

        board = new Board(boardSize);

        // draws the board as part of setup
        board.drawBoard();

        boolean keepGoing = false;
        boolean keepGoing2 = false;

        while(!keepGoing)
        {
            System.out.println("Player 1! " + Player.RED + ("0") + Player.RESET_COLOR + " Your turn: ");
            int chosenSpace = scan.nextInt();
            keepGoing = board.recordMove(chosenSpace, player1);
        }

        board.drawBoard();

        while(!keepGoing2)
        {
            System.out.println("Player 2! " + Player.YELLOW + ("0") + Player.RESET_COLOR + " Your turn: ");
            int chosenSpace = scan.nextInt();
            keepGoing2 = board.recordMove(chosenSpace, player1);
        }

        board.drawBoard();
    }
}
