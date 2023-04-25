import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TicTacToeFrame extends JFrame {
    JPanel mainPnl, gamePnl, exitPnl;
    JButton tlBtn, tcBtn, trBtn, mlBtn, mcBtn, mrBtn, blBtn, bcBtn, brBtn, quitBtn;
    JTextArea infoTA;
    JScrollPane infoPane;
    ImageIcon xIcn, oIcn;
    private static final int ROW = 3;
    private static final int COL = 3;
    private TicTacToeTile[][] board = new TicTacToeTile[ROW][COL];

    int timesClicked = 0;

    public TicTacToeTile[][] getBoard() {
        return board;
    }

    public void setBoard(TicTacToeTile[][] board) {
        this.board = board;
    }

    public TicTacToeFrame() {
        createGUI();
        setTitle("TicTacToe Game");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createGUI() {
        mainPnl = new JPanel();
        gamePnl = new JPanel();
        exitPnl = new JPanel();

        mainPnl.setLayout(new BorderLayout());
        mainPnl.add(gamePnl, BorderLayout.NORTH);
        mainPnl.add(exitPnl, BorderLayout.SOUTH);

        add(mainPnl);
        createTopPnl();
        createBottomPnl();
    }

    private void createTopPnl()
    {

        gamePnl.setLayout(new GridBagLayout());

        for( int row = 0; row < 3; row++)
            for(int col= 0; col < 3; col++)
            {
                GridBagConstraints nerd = new GridBagConstraints();
                nerd.gridx = col;
                nerd.gridy = row;

                board[row][col] = new TicTacToeTile(row, col);
                board[row][col].setPreferredSize(new Dimension(120,120));
                board[row][col].setText("");

                board[row][col].addActionListener(new TicTacToeListener(this));

                gamePnl.add(board[row][col], nerd);
            }
        //JOptionPane.showMessageDialog(null, "You Win");
    }

    private void createBottomPnl()
    {
        quitBtn = new JButton("END THE APPLICATION");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        exitPnl.add(quitBtn);


    }


    public void clrBrd()
    {
        for( int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col].setText("");
            }
        }
    }

    private String player = "X";
    private int moveCnt = 0;

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getMoveCnt() {
        return moveCnt;
    }

    public void setMoveCnt(int moveCnt) {
        this.moveCnt = moveCnt;
    }

}