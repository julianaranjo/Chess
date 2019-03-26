package Source;

import java.awt.*;
import java.awt.event.*;
import java.util.Stack;
import javax.swing.*;

/**********************************************************************
 * Class for GUI Panel. Handles the games interactivity and creation
 * of pieces and buttons.
 *
 * @author Tyler Dys, Matt Jones, Julia Naranjo
 * @version 3/25/2019
 *********************************************************************/
public class ChessPanel extends JPanel {

    /** An array of JButtons to represent the chessboard */
    private JButton[][] board;

    /** The undo JButton */
    private JButton undoButton;

    /** An instance of the ChessModel class */
    private ChessModel model;

    /** A ChessPiece Stack to store previous turns for undoing */
    private Stack<ChessPiece[][]> boardStack = new Stack<>();

    /** Image Icons for the white pieces */
    private ImageIcon wRook, wBishop, wQueen, wKing, wPawn, wKnight;

    /** Image Icons for the black pieces */
    private ImageIcon bRook, bBishop, bQueen, bKing, bPawn, bKnight;

    /** Boolean for whether or not its the first turn of the game */
    private boolean firstTurnFlag;

    /** Row that a given piece is currently in */
    private int fromRow;

    /** Row that a given piece is moving to */
    private int toRow;

    /** Column that a given piece is currently in */
    private int fromCol;

    /** Column that a given piece is moving to */
    private int toCol;

    /** Action listener for button presses */
    private listener listener;

    /******************************************************************
     * Default constructor for the chess board panel, creates the tiles
     * and icons for each of the pieces and adds buttons
     *****************************************************************/
    public ChessPanel() {
        model = new ChessModel();
        board = new JButton[model.numRows()][model.numColumns()];
        listener = new listener();
        createIcons();

        JPanel boardpanel = new JPanel();
        JPanel buttonpanel = new JPanel();
        boardpanel.setLayout(new GridLayout(model.numRows(), model.numColumns(), 1, 1));

        for (int r = 0; r < model.numRows(); r++) {
            for (int c = 0; c < model.numColumns(); c++) {
                if (model.pieceAt(r, c) == null) {
                    board[r][c] = new JButton("", null);
                    board[r][c].addActionListener(listener);
                } else if (model.pieceAt(r, c).player() == Player.WHITE) {
                    placeWhitePieces(r, c);
                } else if (model.pieceAt(r, c).player() == Player.BLACK) {
                    placeBlackPieces(r, c);
                }
                setBackGroundColor(r, c);
                boardpanel.add(board[r][c]);
            }
        }
        add(boardpanel, BorderLayout.WEST);
        boardpanel.setPreferredSize(new Dimension(600, 600));
        add(buttonpanel);
        firstTurnFlag = true;

        // creates and adds the undo button
        undoButton = new JButton("Undo");
        undoButton.addActionListener(listener);
        buttonpanel.add(undoButton);
    }

    /******************************************************************
     * Sets the backround colors for the background tiles
     *
     * @param r row
     * @param c column
     *****************************************************************/
    private void setBackGroundColor(int r, int c) {
        if ((c % 2 == 1 && r % 2 == 0) || (c % 2 == 0 && r % 2 == 1)) {
            board[r][c].setBackground(Color.LIGHT_GRAY);
        } else if ((c % 2 == 0 && r % 2 == 0) || (c % 2 == 1 && r % 2 == 1)) {
            board[r][c].setBackground(Color.WHITE);
        }
    }

    /******************************************************************
     * Places the white player's pieces on the board
     *
     * @param r row
     * @param c column
     *****************************************************************/
    private void placeWhitePieces(int r, int c) {
        if (model.pieceAt(r, c).type().equals("Pawn")) {
            board[r][c] = new JButton(null, wPawn);
            board[r][c].addActionListener(listener);
        }
        if (model.pieceAt(r, c).type().equals("Rook")) {
            board[r][c] = new JButton(null, wRook);
            board[r][c].addActionListener(listener);
        }
        if (model.pieceAt(r, c).type().equals("Knight")) {
            board[r][c] = new JButton(null, wKnight);
            board[r][c].addActionListener(listener);
        }
        if (model.pieceAt(r, c).type().equals("Bishop")) {
            board[r][c] = new JButton(null, wBishop);
            board[r][c].addActionListener(listener);
        }
        if (model.pieceAt(r, c).type().equals("Queen")) {
            board[r][c] = new JButton(null, wQueen);
            board[r][c].addActionListener(listener);
        }
        if (model.pieceAt(r, c).type().equals("King")) {
            board[r][c] = new JButton(null, wKing);
            board[r][c].addActionListener(listener);
        }
    }

    /******************************************************************
     * Places the white player's pieces on the board
     *
     * @param r row
     * @param c column
     *****************************************************************/
    private void placeBlackPieces(int r, int c) {
        if (model.pieceAt(r, c).type().equals("Pawn")) {
            board[r][c] = new JButton(null, bPawn);
            board[r][c].addActionListener(listener);
        }
        if (model.pieceAt(r, c).type().equals("Rook")) {
            board[r][c] = new JButton(null, bRook);
            board[r][c].addActionListener(listener);
        }
        if (model.pieceAt(r, c).type().equals("Knight")) {
            board[r][c] = new JButton(null, bKnight);
            board[r][c].addActionListener(listener);
        }
        if (model.pieceAt(r, c).type().equals("Bishop")) {
            board[r][c] = new JButton(null, bBishop);
            board[r][c].addActionListener(listener);
        }
        if (model.pieceAt(r, c).type().equals("Queen")) {
            board[r][c] = new JButton(null, bQueen);
            board[r][c].addActionListener(listener);
        }
        if (model.pieceAt(r, c).type().equals("King")) {
            board[r][c] = new JButton(null, bKing);
            board[r][c].addActionListener(listener);
        }
    }

    /******************************************************************
     * Locates and creates the icons for the player pieces
     *****************************************************************/
    private void createIcons() {
        // Sets the Image for white player pieces
        wRook = new ImageIcon("./Chess Project/Source/Icons/wRook.png");
        wBishop = new ImageIcon("./Chess Project/Source/Icons/wBishop.png");
        wQueen = new ImageIcon("./Chess Project/Source/Icons/wQueen.png");
        wKing = new ImageIcon("./Chess Project/Source/Icons/wKing.png");
        wPawn = new ImageIcon("./Chess Project/Source/Icons/wPawn.png");
        wKnight = new ImageIcon("./Chess Project/Source/Icons/wKnight.png");
        bRook = new ImageIcon("./Chess Project/Source/Icons/bRook.png");
        bBishop = new ImageIcon("./Chess Project/Source/Icons/bBishop.png");
        bQueen = new ImageIcon("./Chess Project/Source/Icons/bQueen.png");
        bKing = new ImageIcon("./Chess Project/Source/Icons/bKing.png");
        bPawn = new ImageIcon("./Chess Project/Source/Icons/bPawn.png");
        bKnight = new ImageIcon("./Chess Project/Source/Icons/bKnight.png");
//        bTile = new ImageIcon("./Chess Project/Source/Icons/bTile.png");
    }

    /******************************************************************
     * Method that displays and updates the board
     *****************************************************************/
    private void displayBoard() {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++)
                if (model.pieceAt(r, c) == null)
                    board[r][c].setIcon(null);
                else if (model.pieceAt(r, c).player() == Player.WHITE) {
                    if (model.pieceAt(r, c).type().equals("Pawn"))
                        board[r][c].setIcon(wPawn);

                    if (model.pieceAt(r, c).type().equals("Rook"))
                        board[r][c].setIcon(wRook);

                    if (model.pieceAt(r, c).type().equals("Knight"))
                        board[r][c].setIcon(wKnight);

                    if (model.pieceAt(r, c).type().equals("Bishop"))
                        board[r][c].setIcon(wBishop);

                    if (model.pieceAt(r, c).type().equals("Queen"))
                        board[r][c].setIcon(wQueen);

                    if (model.pieceAt(r, c).type().equals("King"))
                        board[r][c].setIcon(wKing);

                } else if (model.pieceAt(r, c).player() == Player.BLACK) {
                    if (model.pieceAt(r, c).type().equals("Pawn"))
                        board[r][c].setIcon(bPawn);

                    if (model.pieceAt(r, c).type().equals("Rook"))
                        board[r][c].setIcon(bRook);

                    if (model.pieceAt(r, c).type().equals("Knight"))
                        board[r][c].setIcon(bKnight);

                    if (model.pieceAt(r, c).type().equals("Bishop"))
                        board[r][c].setIcon(bBishop);

                    if (model.pieceAt(r, c).type().equals("Queen"))
                        board[r][c].setIcon(bQueen);

                    if (model.pieceAt(r, c).type().equals("King"))
                        board[r][c].setIcon(bKing);
                }
        }
        repaint();
    }

    /******************************************************************
     * Displays a unit promotion pop up when a player's pawn makes it
     * to the top / bottom row of the board
     *
     * @param row row
     * @param col column
     *****************************************************************/
    public void promoteUnit(int row, int col) {
        if (model.pieceAt(row, col).type().equals("Pawn") && (row == 0 || row == 7)) {
            String[] promotions = {"Queen", "Knight", "Rook", "Bishop"};
            int output = JOptionPane.showOptionDialog(null, "Please choose your promotion",
                    "Unit Promotion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                    promotions, promotions[0]);
            if (output == -1){
                promoteUnit(row, col);
            }
            // user selected Queen
            if (output == 0) {
                if (model.pieceAt(row, col).player() == Player.WHITE)
                    model.setPiece(row, col, new Queen(Player.WHITE));
                else
                    model.setPiece(row, col, new Queen(Player.BLACK));

            // user selected Knight
            } else if (output == 1) {
                if (model.pieceAt(row, col).player() == Player.WHITE)
                    model.setPiece(row, col, new Knight(Player.WHITE));
                else
                    model.setPiece(row, col, new Knight(Player.BLACK));

            // user selected Rook
            } else if (output == 2) {
                if (model.pieceAt(row, col).player() == Player.WHITE)
                    model.setPiece(row, col, new Rook(Player.WHITE));
                else
                    model.setPiece(row, col, new Rook(Player.BLACK));

            // user selected Bishop
            } else if (output == 3) {
                if (model.pieceAt(row, col).player() == Player.WHITE)
                    model.setPiece(row, col, new Bishop(Player.WHITE));
                else
                    model.setPiece(row, col, new Bishop(Player.BLACK));
            }
        }
    }

    /******************************************************************
     * Inner action listener class that handles the users inputs to
     * move pieces and handle button presses
     *****************************************************************/
    private class listener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            for (int r = 0; r < model.numRows(); r++)
                for (int c = 0; c < model.numColumns(); c++)
                    if (board[r][c] == event.getSource())
                        if (firstTurnFlag) {
                            fromRow = r;
                            fromCol = c;
                            firstTurnFlag = false;
                        } else {
                            toRow = r;
                            toCol = c;
                            firstTurnFlag = true;
                            Move m = new Move(fromRow, fromCol, toRow, toCol);
                            if ((model.isValidMove(m))) {
                                boardStack.push(model.getBoardState());
                                model.move(m);
                                model.enPassant(m.toRow, m.toColumn);
                                promoteUnit(m.toRow, m.toColumn);
                                displayBoard();
                            }
                        }
            if (undoButton == event.getSource()) {
                if (!boardStack.isEmpty()) {
                    model.setBoardState(boardStack.pop());
                } else {
                    JOptionPane.showMessageDialog(null, "No undos available");
                }
                displayBoard();
            }
        }
    }
}
