package Source;

public class ChessModel implements IChessModel {
    private ChessPiece[][] board;
    private Player player;

    // declare other instance variables as needed

    public ChessModel() {
        board = new ChessPiece[8][8];
        player = Player.WHITE;

        // place all white pieces
        board[7][0] = new Rook(Player.WHITE);
        board[7][1] = new Knight(Player.WHITE);
        board[7][2] = new Bishop(Player.WHITE);
        board[7][3] = new Queen(Player.WHITE);
        board[7][4] = new King(Player.WHITE);
        board[7][5] = new Bishop(Player.WHITE);
        board[7][6] = new Knight(Player.WHITE);
        board[7][7] = new Rook(Player.WHITE);
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(Player.WHITE);
        }

        board[0][0] = new Rook(Player.BLACK);
        board[0][1] = new Knight(Player.BLACK);
        board[0][2] = new Bishop(Player.BLACK);
        board[0][3] = new Queen(Player.BLACK);
        board[0][4] = new King(Player.BLACK);
        board[0][5] = new Bishop(Player.BLACK);
        board[0][6] = new Knight(Player.BLACK);
        board[0][7] = new Rook(Player.BLACK);
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(Player.BLACK);
        }
    }

    public boolean isComplete() {
        boolean valid = false;
        return valid;
    }

    public boolean isValidMove(Move move) {
        boolean valid = false;

        if (move.fromRow == move.toRow && move.fromColumn == move.toColumn)
            return false;

        if (board[move.fromRow][move.fromColumn] != null)
            if (board[move.fromRow][move.fromColumn].isValidMove(move, board))
                valid = true;

        return valid;
    }

    public void move(Move move) {
        board[move.toRow][move.toColumn] = board[move.fromRow][move.fromColumn];
        board[move.fromRow][move.fromColumn] = null;
    }

    /******************************************************************
	 * class with method that implements the action listeners for each
	 * button
	 ******************************************************************/
	public boolean inCheck(Player p)
	{
		// initializes boolean to return
		boolean check = false;
		// initializes unknown (for now) location of king
		int endRow = 0;
		int endCol = 0;

		// for loops to find king
		for (int r = 0; r < 8; r++)
		{
			for (int c = 0; c < 8; c++)
			{
				if (model.pieceAt(r, c).type().equals("King"))
				{
					endRow = r;
					endCol = c;
				}
			}
		}

		// for loops to try moves
		for (int r = 0; r < 8; r++)
		{
			for (int c = 0; c < 8; c++)
			{
				Move m = new Move(fromRow, fromCol, endRow, endCol);
				if ((model.isValidMove(m)))
				{
					return true;
				}
			}
		}
		return check;
	}


    public Player currentPlayer() {
        return player;
    }

    public int numRows() {
        return 8;
    }

    public int numColumns() {
        return 8;
    }

    public ChessPiece pieceAt(int row, int column) {
        return board[row][column];
    }

    public void setNextPlayer() {
        player = player.next();
    }

    public void setPiece(int row, int column, ChessPiece piece) {
        board[row][column] = piece;
    }

    public void AI() {
        /*
         * Write a simple AI set of rules in the following order.
         * a. Check to see if you are in check.
         * 		i. If so, get out of check by moving the king or placing a piece to block the check
         *
         * b. Attempt to put opponent into check (or checkmate).
         * 		i. Attempt to put opponent into check without losing your piece
         *		ii. Perhaps you have won the game.
         *
         *c. Determine if any of your pieces are in danger,
         *		i. Move them if you can.
         *		ii. Attempt to protect that piece.
         *
         *d. Move a piece (pawns first) forward toward opponent king
         *		i. check to see if that piece is in danger of being removed, if so, move a different piece.
         */

    }

    public boolean attemptToRemoveFromDanger() {
        Move attemptMove;
        for (int fromRow = 0; fromRow < numRows(); fromRow++)
            for (int fromColumn = 0; fromColumn < numColumns(); fromColumn++)
                if (board[fromRow][fromColumn] != null)
                    if (board[fromRow][fromColumn].player().equals(Player.WHITE))
                        for (int toRow = 0; toRow < numRows(); toRow++)
                            for (int toColumn = 0; toColumn < numColumns(); toColumn++)
                                if (board[toRow][toColumn] != null)
                                    if (board[toRow][toColumn].player().equals(Player.BLACK)) {
                                        attemptMove = new Move(fromRow, fromColumn, toRow, toColumn);
                                        if (board[fromRow][fromColumn].isValidMove(attemptMove, board))
                                            if (FindAPlaceToMoveThisPiece(toRow, toColumn) == true)
                                                return true;
                                    }
        return false;
    }

    public boolean FindAPlaceToMoveThisPiece(int row, int column) {

        return true;
    }

    public ChessPiece[][] getBoardState() {
        ChessPiece[][] boardCopy = new ChessPiece[8][8];
        for (int r = 0; r < numRows(); r++) {
            for (int c = 0; c < numColumns(); c++) {
                if (pieceAt(r, c) == null) {
                    boardCopy[r][c] = null;
                } else if (pieceAt(r, c).player() == Player.WHITE) {
                    if (pieceAt(r, c).type().equals("King"))
                        boardCopy[r][c] = new King(Player.WHITE);
                    else if (pieceAt(r, c).type().equals("Queen"))
                        boardCopy[r][c] = new Queen(Player.WHITE);
                    else if (pieceAt(r, c).type().equals("Bishop"))
                        boardCopy[r][c] = new Bishop(Player.WHITE);
                    else if (pieceAt(r, c).type().equals("Rook"))
                        boardCopy[r][c] = new Rook(Player.WHITE);
                    else if (pieceAt(r, c).type().equals("Knight"))
                        boardCopy[r][c] = new Knight(Player.WHITE);
                    else if (pieceAt(r, c).type().equals("Pawn")) {
                        if (r == 6)
                            boardCopy[r][c] = new Pawn(Player.WHITE, true);
                        else {
                            boardCopy[r][c] = new Pawn(Player.WHITE, false);
                        }
                    }
                } else if (pieceAt(r, c).player() == Player.BLACK) {
                    if (pieceAt(r, c).type().equals("King"))
                        boardCopy[r][c] = new King(Player.BLACK);
                    else if (pieceAt(r, c).type().equals("Queen"))
                        boardCopy[r][c] = new Queen(Player.BLACK);
                    else if (pieceAt(r, c).type().equals("Bishop"))
                        boardCopy[r][c] = new Bishop(Player.BLACK);
                    else if (pieceAt(r, c).type().equals("Rook"))
                        boardCopy[r][c] = new Rook(Player.BLACK);
                    else if (pieceAt(r, c).type().equals("Knight"))
                        boardCopy[r][c] = new Knight(Player.BLACK);
                    else if (pieceAt(r, c).type().equals("Pawn")) {
                        if (r == 1)
                            boardCopy[r][c] = new Pawn(Player.BLACK, true);
                        else
                            boardCopy[r][c] = new Pawn(Player.BLACK, false);
                    }
                }
            }
        }
        return boardCopy;
    }

    public void setBoardState(ChessPiece[][] newBoard) {
        board = newBoard;
    }
}
