package Source;

public class Pawn extends ChessPiece {
    private boolean firstMove;
    private boolean enPassanteAble;
    private ChessModel model;

    public Pawn(Player player) {
        super(player);
        this.firstMove = true;
    }

    public String type() {
        return "Pawn";
    }

    // determines if the move is valid for a pawn piece
    public boolean isValidMove(Move move, IChessPiece[][] board) {
        boolean valid = true;
//        valid = super.isValidMove(move, board);
//        System.out.println(move);

        if (player().equals(Player.WHITE)) {
            if (move.toRow > move.fromRow)
                valid = false;
        } else {
            if (move.toRow < move.fromRow)
                valid = false;
        }

        if (move.toColumn == move.fromColumn) {
            // Not taking a piece
            if (player().equals(Player.WHITE)) {
                if (board[move.fromRow - 1][move.fromColumn] != null)
                    valid = false;
            } else {
                if (board[move.fromRow + 1][move.fromColumn] != null)
                    valid = false;
            }

            if (Math.abs(move.toRow - move.fromRow) > 2)
                valid = false;
            else if (Math.abs(move.toRow - move.fromRow) == 2) {
                //Advancing two spaces at beginning
                if (!firstMove)
                    valid = false;

                if (player().equals(Player.WHITE)) {
                    if (board[move.fromRow - 2][move.fromColumn] != null)
                        valid = false;
                } else {
                    if (board[move.fromRow + 2][move.fromColumn] != null)
                        valid = false;
                }
            }
        } else {
            //Taking a piece
            if (Math.abs(move.toColumn - move.fromColumn) != 1 || Math.abs(move.toRow - move.fromRow) != 1)
                valid = false;

            if (board[move.toRow][move.toColumn] == null) {
                valid = false;
            }
        }
        firstMove = false;
        return valid;
    }
}
