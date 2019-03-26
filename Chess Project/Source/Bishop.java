package Source;

/**********************************************************************
 * Class for the bishop piece. Determines valid moves and
 * identifiers.
 *
 * @author Tyler Dys, Matt Jones, Julia Naranjo
 * @version 3/25/2019
 *********************************************************************/
public class Bishop extends ChessPiece {

    /******************************************************************
     * Constructor for the Bishop class. Creates a new white or black
     * bishop piece.
     *
     * @param player Either black or white, determines piece color
     *****************************************************************/
    public Bishop(Player player) {
        super(player);
    }

    /******************************************************************
     * Sets the type / name of the bishop object "Bishop"
     *
     * @return "Bishop"
     *****************************************************************/
    public String type() {
        return "Bishop";
    }


    /******************************************************************
     * Method for determining if the player's move choice is valid.
     *
     * @param move the player's move
     * @param board the game board array
     * @return true or false depending on validity of move
     *****************************************************************/
    public boolean isValidMove(Move move, IChessPiece[][] board)
	{
		int ra = move.fromRow, rb = move.toRow;
		int ca = move.fromColumn, cb = move.toColumn;

		// cannot move to the same square
		if (ra==rb && ca==cb)
		{
			return false;
		}

		// has to move to same row or column
		if (rb!=ra && cb!=ca)
		{
			return false;
		}

		// target square cannot contain piece of the same color
		if (board[rb][cb] != null && board[ra][ca].player()==board[rb][cb].player())
		{
			return false;
		}

		// for example if rook is moving up-right, then dr=-1 and dc=1 (there are four possibilies)
		int dr = 0;
		if (rb-ra!=0)
			dr = (rb-ra)/Math.abs(rb-ra);
		int dc = 0;
		if (cb-ca!=0)
			dc = (cb-ca)/Math.abs(cb-ca);

		int r = ra+dr;
		int c = ca+dc;
		while (r!=rb || c!=cb)
		{
			// if a space strictly between the current space and target space is occupied
			if (board[r][c]!=null)
				return false;

			// next space
			r += dr;
			c += dc;
		}

}
