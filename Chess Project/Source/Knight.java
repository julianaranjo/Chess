public class Knight extends ChessPiece {

    public Knight(Player player) {
        super(player);
    }

    public String type() {
        return "Knight";
    }

    public boolean isValidMove(Move move, IChessPiece[][] board) {

        boolean valid = false;

        if (move.toColumn > board.length || move.toRow > board.length) {
            valid = false;
        }

        if (move.toColumn < 0 || move.toRow < 0) {
            valid = false;
        }

        if (move.toColumn == move.fromColumn + 0 || move.toRow == move.fromRow + 0) {
            valid = false;
        }

        if (move.toColumn == move.fromColumn + 1) {
            if (move.toRow == move.fromRow + 2) {
                valid = true;
            }

            else if (move.toRow == move.fromRow - 2) {
                valid = true;
            }
        }

        if (move.toColumn == move.fromColumn - 1) {
            if (move.toRow == move.fromRow + 2) {
                valid = true;
            }

            else if (move.toRow == move.fromRow - 2) {
                valid = true;
            }
        }

        if (move.toColumn == move.fromColumn + 2) {
            if (move.toRow == move.fromRow + 1) {
                valid = true;
            }

            else if (move.toRow == move.fromRow - 1) {
                valid = true;
            }
        }

        if (move.toColumn == move.fromColumn - 2) {
            if (move.toRow == move.fromRow + 1) {
                valid = true;
            }

            else if (move.toRow == move.fromRow - 1) {
                valid = true;
            }
        }

        return valid;
    }

}
