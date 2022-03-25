// class representing a Player;
// each player has a unique symbol
public class Player
{
	public static final String YELLOW = "\033[0;33m";
	public static final String RED = "\u001B[31m";
	public static final String RESET_COLOR = "\033[0m";
	public static final String[] playerSymbols = {RED + "0", YELLOW + "0"};

	private final String symbol;

	public Player (String symbol)
	{
		this.symbol = symbol;
	}

	public String getSymbol()
	{
		return symbol;
	}
}