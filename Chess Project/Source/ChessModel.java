package Source;

/**********************************************************************
 * Class for the game logic. Includes creating pieces as well as
 * various gameplay features.
 *
 * @author Tyler Dys, Matt Jones, Julia Naranjo
 * @version 3/25/2019
 *********************************************************************/
public class ChessModel implements IChessModel {

    /** An array of ChessPiece's to represent the chessboard */
    private ChessPiece[][] board;

    /** The current Player */
    private Player player;

    /** Boolean for a white pawn performing an en Passant */
    private static boolean enPassantW = false;

    /** Boolean for a black pawn performing an en Passant */
    private static boolean enPassantB = false;

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

        //place all the black pieces
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

    /******************************************************************
     * Sets the EnPassantW boolean to true for the enPassant method
     *****************************************************************/
    public static void setEnPassantW() {
        enPassantW = true;
    }

    /******************************************************************
     * Sets the EnPassantB boolean to true for the enPassant method
     *****************************************************************/
    public static void setEnPassantB() {
        enPassantB = true;
    }

    /******************************************************************
     * En Passant method that removes a piece that has been
     * En Passant(ed).
     *
     * @param row pawn's row
     * @param col pawn's column
     *****************************************************************/
    public void enPassant(int row, int col) {
        if (enPassantW) {
            board[row + 1][col] = null;
            enPassantW = false;
        } else if (enPassantB) {
            board[row - 1][col] = null;
            enPassantB = false;
        }
    }

    /******************************************************************
     * Method that checks whether a player reaches CheckMate.
     *
     * @return true if game is over.
     *****************************************************************/
    public boolean isComplete() {
        boolean valid = false;
        return valid;
    }

    /******************************************************************
     * Method that takes a move object and determines if it's valid
     * based on what type of piece it is.
     *
     * @param move move object to be validated.
     * @return true if move is valid
     *****************************************************************/
    public boolean isValidMove(Move move) {
        boolean valid = false;

        if (move.fromRow == move.toRow && move.fromColumn == move.toColumn)
            return false;

        if (board[move.fromRow][move.fromColumn] != null)
            if (board[move.fromRow][move.fromColumn].isValidMove(move, board))
                valid = true;

        return valid;
    }

    /******************************************************************
     * Method that moves the piece from one location on the board to
     * another.
     *
     * @param move move object with new and old location
     *****************************************************************/
    public void move(Move move) {
        board[move.toRow][move.toColumn] = board[move.fromRow][move.fromColumn];
        board[move.fromRow][move.fromColumn] = null;
    }

    /******************************************************************
     * Checks to see if the current player is in Check
     *
     * @param p the Player
     * @return true if move is valid
     *****************************************************************/
    public boolean inCheck(Player p) {
        // initializes boolean to return
        boolean check = false;
        // initializes unknown (for now) location of king
        int endRow = 0;
        int endCol = 0;

        // for loops to find king
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (pieceAt(r, c).type().equals("King")) {
                    endRow = r;
                    endCol = c;
                }
            }
        }

        // for loops to try moves
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Move m = new Move(r, c, endRow, endCol);
                if ((isValidMove(m))) {
                    return true;
                }
            }
        }
        return check;
    }

    /******************************************************************
     * Method that returns the current player
     *
     * @return the Current Player
     *****************************************************************/
    public Player currentPlayer() {
        return player;
    }

    /******************************************************************
     * Method that returns the number of rows on the board
     *
     * @return number of rows (8)
     *****************************************************************/
    public int numRows() {
        return 8;
    }

    /******************************************************************
     * Method that returns the number of columns on the board
     *
     * @return number of columns (8)
     *****************************************************************/
    public int numColumns() {
        return 8;
    }

    /******************************************************************
     * Method that returns the piece at the requested location
     *
     * @param row piece's row
     * @param column piece's column
     * @return the chesspiece at that location
     *****************************************************************/
    public ChessPiece pieceAt(int row, int column) {
        return board[row][column];
    }

    /******************************************************************
     * Method that sets the next player as the current player
     *****************************************************************/
    public void setNextPlayer() {
        player = player.next();
    }

    /******************************************************************
     * Sets a new piece at the desired location
     *
     * @param row piece's row
     * @param column piece's column
     * @param piece the chess piece to be placed.
     *****************************************************************/
    public void setPiece(int row, int column, ChessPiece piece) {
        board[row][column] = piece;
    }

    /******************************************************************
     * Rudamentary Chess AI method for the player to play against
     *****************************************************************/
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

    /******************************************************************
     * Method for the AI to use to remove its pieces from places
     * where they can be captured.
     *
     * @return //FIXME
     *****************************************************************/
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
                                            if (FindAPlaceToMoveThisPiece(toRow, toColumn))
                                                return true;
                                    }
        return false;
    }

    /******************************************************************
     * Method for the AI to find a place to move its piece to.
     *
     * @return //FIXME
     *****************************************************************/
    public boolean FindAPlaceToMoveThisPiece(int row, int column) {

        return true;
    }

    /******************************************************************
     * Method for copying the current board state for use in the undo
     * method / button.
     *****************************************************************/
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
                        // if the pawn is at row 6, it hasn't moved
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
                        // if the pawn is at row 1, it hasn't moved.
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

    /******************************************************************
     * Method overwrites the current board with a new board. Used
     * for the undo method / button
     *
     * @param newBoard the new board used to overwrite the current
     *****************************************************************/
    public void setBoardState(ChessPiece[][] newBoard) {
        board = newBoard;
    }
}
