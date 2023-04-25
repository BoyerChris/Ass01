import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class TicTacToeListener implements ActionListener
{
    private static final int ROW = 3;
    private static final int COL = 3;
    private int colm = 0;
    private int rows = 0;
    private TicTacToeFrame game;

    public TicTacToeListener(TicTacToeFrame game) {
        this.game = game;
    }

    private static String[][] boarde = new String[ROW][COL];





    public void actionPerformed(ActionEvent e) {
        Scanner in = new Scanner(System.in);
        int row = -1;
        int col = -1;
        final int MOVES_FOR_WIN = 5;
        final int MOVES_FOR_TIE = 7;


        e.getSource();
        if (e.getSource() instanceof TicTacToeTile) {
            TicTacToeTile nerdTwo = (TicTacToeTile) e.getSource();
            rows = nerdTwo.getRow();
            colm = nerdTwo.getCol();



        startBoarde();

        if (isValidMove(rows, colm) == true) {
            boarde[rows][colm] = game.getPlayer();
            game.setMoveCnt(game.getMoveCnt() + 1);


           nerdTwo.setText(game.getPlayer());





            if (game.getMoveCnt() >= MOVES_FOR_WIN) {
                if (isWin(game.getPlayer())) {
                    JOptionPane.showMessageDialog(null,"Player " + game.getPlayer() + " wins!");
                    if(JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION) == 1)
                    {
                        System.exit(0);
                    }
                    clearBoarde();
                    game.clrBrd();
                    game.setPlayer("O");
                }
            }

            if (game.getMoveCnt() >= MOVES_FOR_TIE) {
                if (isTie()) {
                    JOptionPane.showMessageDialog(null,"It's a Tie!");
                    if(JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION) == 1)
                    {
                        System.exit(0);
                    }
                    clearBoarde();
                    game.clrBrd();
                    game.setPlayer("O");
                }
            }

            if (game.getPlayer().equals("X")) {
                game.setPlayer("O");
            } else {
                game.setPlayer("X");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Please Enter a valid move");
        }
    }

    }



        private static void clearBoarde()
        {
            // sets all the board elements to a space
            for (int row = 0; row < ROW; row++) {
                for (int col = 0; col < COL; col++) {
                    boarde[row][col] = " ";
                }
            }
        }
        private static void startBoarde()
        {
            for(int row=0; row < ROW; row++)
            {
                for(int col=0; col < COL; col++)
                {
                    if (boarde[row][col] == null) {
                    boarde[row][col] = " ";
                    }
                }
            }
        }




        private static boolean isValidMove ( int row, int col)
        {

            if (boarde[row][col].equals(" "))
                return true;
            else
                return false;


        }
        private static boolean isWin (String player)
        {
            if (isColWin(player) || isRowWin(player) || isDiagnalWin(player)) {
                return true;
            }

            return false;
        }
        private static boolean isColWin (String player)
        {
            for (int col = 0; col < COL; col++) {
                if (boarde[0][col].equals(player) &&
                        boarde[1][col].equals(player) &&
                        boarde[2][col].equals(player)) {
                    return true;
                }
            }
            return false;
        }
        private static boolean isRowWin (String player)
        {
            for (int row = 0; row < ROW; row++) {
                if (boarde[row][0].equals(player) &&
                        boarde[row][1].equals(player) &&
                        boarde[row][2].equals(player)) {
                    return true;
                }
            }
            return false;
        }
        private static boolean isDiagnalWin (String player)
        {
            if (boarde[0][0].equals(player) &&
                    boarde[1][1].equals(player) &&
                    boarde[2][2].equals(player)) {
                return true;
            }
            if (boarde[0][2].equals(player) &&
                    boarde[1][1].equals(player) &&
                    boarde[2][0].equals(player)) {
                return true;
            }
            return false;
        }

        private static boolean isTie ()
        {
            boolean xFlag = false;
            boolean oFlag = false;
            for (int row = 0; row < ROW; row++) {
                if (boarde[row][0].equals("X") ||
                        boarde[row][1].equals("X") ||
                        boarde[row][2].equals("X")) {
                    xFlag = true;
                }
                if (boarde[row][0].equals("O") ||
                        boarde[row][1].equals("O") ||
                        boarde[row][2].equals("O")) {
                    oFlag = true;
                }

                if (!(xFlag && oFlag)) {
                    return false;
                }

                xFlag = oFlag = false;

            }

            for (int col = 0; col < COL; col++) {
                if (boarde[0][col].equals("X") ||
                        boarde[1][col].equals("X") ||
                        boarde[2][col].equals("X")) {
                    xFlag = true;
                }
                if (boarde[0][col].equals("O") ||
                        boarde[1][col].equals("O") ||
                        boarde[2][col].equals("O")) {
                    oFlag = true;
                }

                if (!(xFlag && oFlag)) {
                    return false;
                }
            }

            xFlag = oFlag = false;

            if (boarde[0][0].equals("X") ||
                    boarde[1][1].equals("X") ||
                    boarde[2][2].equals("X")) {
                xFlag = true;
            }
            if (boarde[0][0].equals("O") ||
                    boarde[1][1].equals("O") ||
                    boarde[2][2].equals("O")) {
                oFlag = true;
            }
            if (!(xFlag && oFlag)) {
                return false;
            }
            xFlag = oFlag = false;

            if (boarde[0][2].equals("X") ||
                    boarde[1][1].equals("X") ||
                    boarde[2][0].equals("X")) {
                xFlag = true;
            }
            if (boarde[0][2].equals("O") ||
                    boarde[1][1].equals("O") ||
                    boarde[2][0].equals("O")) {
                oFlag = true;
            }
            if (!(xFlag && oFlag)) {
                return false;
            }


            return true;
        }


    }

