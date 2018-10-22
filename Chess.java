public class Chess {
    String[][] board;
    String p1_postfix = "_1";
    String p2_postfix = "_2"; 
    String[] pieces = new String[]{"RL", "KL", "BL", "Qu", "Ki", "BR", "KR", "RR"};
    String space = "----";
    String[] p1;
    String[] p2;

    public Chess() {
        board = new String[8][8];
        p1 = new String[pieces.length];
        p2 = new String[pieces.length];
        for (int i = 0; i<p1.length; i++) {
            p1[i] = pieces[i] + p1_postfix;
        }
        for (int i = 0; i<p1.length; i++) {
            p2[i] = pieces[i] + p2_postfix;
        }
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                board[row][column] = space;
            }
        }
    }

    public void drawBoard() {
        for (int row = 0; row < board.length; row++) {
            System.out.print("    " + row);
        }
        System.out.println();
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (column == 0) System.out.print(row + "  ");
                System.out.print(board[row][column] + " ");
            }
            System.out.println("\n");
        }
        System.out.println();
    }

    public void initialize() {
        //Fill top
        fillWithPawns(1, p2_postfix);
        fillDefaultLine(p2);
        
        //Fill bottom
        fillWithPawns(6, p1_postfix);
        fillDefaultLine(p1);              
        drawBoard();
    }

    public void movePiece(String piece, int row, int column) {
        if (!board[row][column].equals(space)) {
            System.out.println("No space available");
            return; //Jump out of method
        }
        boolean found = false;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c].trim().equals(piece)) {
                    board[r][c] = space;
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        board[row][column] = piece;
        drawBoard();
    }

    private void fillWithPawns(int row, String player) {
        for (int column = 0; column < board[row].length; column++) {
            board[row][column] = "P" + (column+1) + player;
        }
    }

    private void fillDefaultLine(String[] player) {
        if (player == p2) {
            for (int column = 0; column < board.length; column++) {
                board[0][column] = player[column];
            }
        } else {
            for (int column = 0; column < board.length; column++) {
                board[7][column] = player[column];
            }
        }
    }
    
    public String[][] getBoard() {
        return board;
    }
    
}