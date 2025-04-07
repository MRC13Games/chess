//Christian Murillo
//03/20/25
//This class represents the Rook piece in our chess game. It is able to move directly forward, backwards, left or right the length as the board unless there is a piece infront of it. Basically just how a normal rook works in chess.
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

//you will need to implement two functions in this file.
public class Rook extends Piece {
// constructor
public Rook(boolean isWhite, String img_file) {
    super(isWhite, img_file);
    }

    public String toString(){
        return "A " + super.toString() + " Rook";
    }
// Pre-condition: b is a non-null board that contains the 8 by 8 square board. The currentSquare is non-null and present in the board.
// Post-condition: Returns all controlled squares this piece has.
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
        ArrayList<Square> controlledSquares = new ArrayList<>();
        int startRow = start.getRow();
        int startCol = start.getCol();
        boolean startColor = start.getOccupyingPiece().getColor(); // Get the color of the piece at start
    
        // Up
        for (int i = startRow - 1; i >= 0; i--) {
            if (board[i][startCol].getOccupyingPiece() == null) {
                controlledSquares.add(board[i][startCol]);
            } else {
                if (board[i][startCol].getOccupyingPiece().getColor() != startColor) {
                    controlledSquares.add(board[i][startCol]); // Can capture opponent piece
                }
                break; // Stop at first occupied square
            }
        }
    
        // Down
        for (int i = startRow + 1; i < board.length; i++) {
            if (board[i][startCol].getOccupyingPiece() == null) {
                controlledSquares.add(board[i][startCol]);
            } else {
                if (board[i][startCol].getOccupyingPiece().getColor() != startColor) {
                    controlledSquares.add(board[i][startCol]);
                }
                break;
            }
        }
    
        // Left
        for (int i = startCol - 1; i >= 0; i--) {
            if (board[startRow][i].getOccupyingPiece() == null) {
                controlledSquares.add(board[startRow][i]);
            } else {
                if (board[startRow][i].getOccupyingPiece().getColor() != startColor) {
                    controlledSquares.add(board[startRow][i]);
                }
                break;
            }
        }
    
        // Right
        for (int i = startCol + 1; i < board[startRow].length; i++) {
            if (board[startRow][i].getOccupyingPiece() == null) {
                controlledSquares.add(board[startRow][i]);
            } else {
                if (board[startRow][i].getOccupyingPiece().getColor() != startColor) {
                    controlledSquares.add(board[startRow][i]);
                }
                break;
            }
        }
    
        return controlledSquares;
    }

// Pre-condition: b is a non-null board that contains the 8 by 8 square board. The currentSquare is non-null and present in the board.
// Post-condition: Returns all legally accessable squares by this piece
    //This makes my piece move how a regular rook moves in chess, straight up, down, left, and right
    public ArrayList<Square> getLegalMoves(Board b, Square start) {
        ArrayList<Square> legalMoves = new ArrayList<>();
        Square[][] board = b.getSquareArray();
        int startRow = start.getRow();
        int startCol = start.getCol();
        boolean startColor = start.getOccupyingPiece().getColor(); // Get the color of the piece at start
    
        // Up
        for (int i = startRow - 1; i >= 0; i--) {
            if (board[i][startCol].getOccupyingPiece() == null) {
                legalMoves.add(board[i][startCol]);
            } else {
                if (board[i][startCol].getOccupyingPiece().getColor() != startColor) {
                    legalMoves.add(board[i][startCol]);
                }
                break;
            }
        }
    
        // Down
        for (int i = startRow + 1; i < board.length; i++) {
            if (board[i][startCol].getOccupyingPiece() == null) {
                legalMoves.add(board[i][startCol]);
            } else {
                if (board[i][startCol].getOccupyingPiece().getColor() != startColor) {
                    legalMoves.add(board[i][startCol]);
                }
                break;
            }
        }
    
        // Left
        for (int i = startCol - 1; i >= 0; i--) {
            if (board[startRow][i].getOccupyingPiece() == null) {
                legalMoves.add(board[startRow][i]);
            } else {
                if (board[startRow][i].getOccupyingPiece().getColor() != startColor) {
                    legalMoves.add(board[startRow][i]);
                }
                break;
            }
        }
    
        // Right
        for (int i = startCol + 1; i < board[startRow].length; i++) {
            if (board[startRow][i].getOccupyingPiece() == null) {
                legalMoves.add(board[startRow][i]);
            } else {
                if (board[startRow][i].getOccupyingPiece().getColor() != startColor) {
                    legalMoves.add(board[startRow][i]);
                }
                break;
            }
        }
    
        return legalMoves;
    }
  }