import java.util.Scanner;

public class ConnectFour
{
    private Player[] players;

    private Board board;
    
    public ConnectFour()
    {
        setUp();
    }

    boolean keepGoing = true;

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

    public void playGame()
    {
        while (keepGoing && !board.isFull())
        {
            for (Player player : players)
            {
                if (turn(player)) {
                    keepGoing = false;
                    break;
                }
            }
        }

    }

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