import java.util.Scanner;

public class ConnectFour
{
    private Player[] players;

    private Board board;
    
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

    public void playGame()
    {
        Scanner scan = new Scanner(System.in);
        boolean player1Go = false;
        boolean player2Go = false;
        boolean keepGoing = true;
        boolean checkWinner = false;

        while (keepGoing)
        {
            while(!player1Go)
            {
                System.out.print("Player " + players[0].getSymbol() + Player.RESET_COLOR + "! Your turn: ");
                int chosenSpace = scan.nextInt();
                player1Go = board.recordMove(chosenSpace, players[0]);
            }
            player1Go = false;

            board.drawBoard();

            if (board.checkWinner())
            {
                System.out.println("Looks like we have a winner! And it's " + players[0].getSymbol() + Player.RESET_COLOR + "!");
                keepGoing = false;
                checkWinner = true;
            }
            else if (board.isFull())
            {
                keepGoing = false;
                System.out.println("Looks like no one won this time! Try again!");
            }

            if (checkWinner == false)
            {
                while(!player2Go)
                {
                    System.out.print("Player " + players[1].getSymbol() + Player.RESET_COLOR + "! Your turn: ");
                    int chosenSpace = scan.nextInt();
                    player2Go = board.recordMove(chosenSpace, players[1]);
                }
                player2Go = false;

                board.drawBoard();

                if (board.checkWinner())
                {
                    System.out.println("Looks like we have a winner! And it's " + players[1].getSymbol() + Player.RESET_COLOR + "!");
                    keepGoing = false;
                    checkWinner = true;
                }
                if (board.isFull() && checkWinner == false)
                {
                    keepGoing = false;
                    System.out.println("Looks like no one won this time! Try again!");
                }
            }
        }
    }
}
