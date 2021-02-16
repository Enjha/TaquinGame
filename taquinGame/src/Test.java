import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Test extends JPanel {

    public static JMenuItem newItem;
    public static javax.swing.Timer t;
    JButton[][] jb = new JButton[4][4];
    static int minute, second;
    static JFrame jf;

    public Test() {
        setLayout(new GridLayout(4, 4));

        int i, j, k;
        init(true);
        for (i = 0; i < jb.length; i++)
            for (j = 0; j < jb[i].length; j++)
                jb[i][j].addActionListener(
                        e -> {
                            String command = e.getActionCommand();
                            String[] indices = command.split(" ");
                            int i1 = Integer.parseInt(indices[0]);
                            int j1 = Integer.parseInt(indices[1]);
                            int[] r = {i1 - 1, i1, i1 + 1, i1};
                            int[] c = {j1, j1 + 1, j1, j1 - 1};
                            for (int k1 = 0; k1 < 4; k1++) {
                                if (r[k1] >= 0 && r[k1] < 4 && c[k1] >= 0 && c[k1] < 4){
                                    JButton button = jb[r[k1]][c[k1]];
                                    if (button.getText().equals("")) {
                                        button.setText(jb[i1][j1].getText());
                                        jb[i1][j1].setText("");
                                    }
                                }
                            }
                        });

        newItem.addActionListener(
                e -> init(false)
        );
    }
    public void init(boolean firstTime) {
        ArrayList a = new ArrayList();
        int i, j, k;
        for (i = 1; i <= 15; i++)
            a.add(i);
        Collections.shuffle(a);
        a.add(0);

        k = 0;
        for (i = 0; i < jb.length; i++)
            for (j = 0; j < jb[i].length; j++) {
                Integer val = (Integer)a.get(k++);
                if (firstTime) {
                    jb[i][j] = new JButton(val.intValue() + "");
                    jb[i][j].setActionCommand(i + " " + j);
                    add(jb[i][j]);
                }
                else
                    jb[i][j].setText(val.intValue() + "");
            }
        jb[3][3].setText("");
        minute = 0;
        second = 0;
    }

    public static void main(String[] args) {
        jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar jmb = new JMenuBar();
        jf.setJMenuBar(jmb);

        JMenu gameMenu = new JMenu("Game");
        jmb.add(gameMenu);

        newItem = new JMenuItem("New");
        gameMenu.add(newItem);

        gameMenu.addSeparator();


        Test tq = new Test();
        jf.setContentPane(tq);

        final DecimalFormat dc = new DecimalFormat("00");

        t = new javax.swing.Timer(
                1000,
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jf.setTitle(dc.format(minute) + ":" + dc.format(second));
                        second++;
                        if (second >= 60) {
                            second %= 60;
                            minute++;
                        }
                    }
                }
        );
        jf.pack();
        jf.setVisible(true);
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        int w=(int)d.getWidth();
        int h=(int)d.getHeight();
        jf.setLocation((int)(w/2-jf.getWidth()/2),(int)(h/2-jf.getHeight()/2));
        t.start();
    }
}
