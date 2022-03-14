// class representing a Player;
// each player has a unique symbol
public class Player
{
	public static final String YELLOW = "\033[0;33m";
	public static final String RED = "\u001B[31m";
	public static final String RESET_COLOR = "\033[0m";
	public static final String[] playerSymbols = {RED + "O", YELLOW + "O"};

	// instance variable marked as FINAL
	// once it's set in the constructor, it stays!
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