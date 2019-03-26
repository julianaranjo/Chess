package Source;

/**********************************************************************
 * An abstract class which gives the individual piece classes some
 * of their methods
 *
 * @author Tyler Dys, Matt Jones, Julia Naranjo
 * @version 3/25/2019
 *********************************************************************/
public abstract class ChessPiece implements IChessPiece {


	private Player owner;

    /******************************************************************
     * Constructor for the ChessPiece class that sets the Players color
     *
     * @param player
     *****************************************************************/
	protected ChessPiece(Player player) {
		this.owner = player;
	}

    /******************************************************************
     * Abstract type method for storing the player's piece type
     * (pawn, knight, etc.)
     *****************************************************************/
	public abstract String type();

    /******************************************************************
     * Returns the owner of the piece
     *****************************************************************/
	public Player player() {
		return owner;
	}

    /******************************************************************
     * Determines the general rules for validating a move

     * @param move the players move
	 * @param board the chess board array
     *****************************************************************/
	public boolean isValidMove(Move move, IChessPiece[][] board) {
		boolean valid = true;

		if ((move.fromRow == move.toRow) && (move.fromColumn == move.toColumn))
			valid = false;

		if (board[move.toRow][move.toColumn].player().equals(player()))
			valid = false;

		return valid;
	}
}
