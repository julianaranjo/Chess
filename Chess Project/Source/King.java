package Source;

/**********************************************************************
 * Class for the King piece. Determines valid moves and
 * identifiers.
 *
 * @author Tyler Dys, Matt Jones, Julia Naranjo
 * @version 3/25/2019
 *********************************************************************/
public class King extends ChessPiece {

	/******************************************************************
	 * Constructor for the King class. Creates a new white or black
	 * King piece.
	 *
	 * @param player Either black or white, determines piece color
	 *****************************************************************/
	public King(Player player) {
		super(player);
	}

	/******************************************************************
	 * Sets the type / name of the King object "King"
	 *
	 * @return "King"
	 *****************************************************************/
	public String type() {
		return "King";
	}

	/******************************************************************
	 * Method for determining if the player's move choice is valid.
	 *
	 * @param move the player's move
	 * @param board the game board array
	 * @return true or false depending on validity of move
	 *****************************************************************/
	public boolean isValidMove(Move move, IChessPiece[][] board) {
		boolean valid = true;

		if ((move.fromRow == move.toRow) && (move.fromColumn == move.toColumn))
			return false;

		if (board[move.toRow][move.toColumn] != null)
			if (board[move.toRow][move.toColumn].player().equals(player()))
				return false;

        if (move.fromColumn - move.toColumn > 1 || move.fromColumn - move.toColumn < -1)
		{
			valid = false;
		}
		if (move.fromRow - move.toRow > 1 || move.fromRow - move.toRow < -1)
		{
			valid = false;
		}
		return valid;
	}
}