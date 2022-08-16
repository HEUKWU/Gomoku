package base;

import base.start.StartWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OmokFrame extends JFrame implements ActionListener{
    JPanel omokP = new JPanel();
    JButton[][] bt;
    int a = 30;
    JPanel info;
    JTextField name1, name2;
    ImageIcon w, b;
    ImageIcon p, t, nt;
    JLabel t1, t2;
    JButton exit;
    JLabel time;
    int sec;
    int indexa = 0;
    int indexb = 0;
    Timer timer;
    JTextField end;
    JLabel winner;
    JTextField winner1;
    JTextField winner2;

    OmokFrame() {
        sec = 30;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sec == 0) {
                    timer.stop();
                    timer.restart();
                    if (Gamer.black) {
                        t1.setIcon(t);
                        t2.setIcon(nt);
                    } else {
                        t1.setIcon(nt);
                        t2.setIcon(t);
                    }
                }
                time.setText(Integer.toString(sec));
                sec -= 1;
            }
        });
        timer.stop();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Gomoku");
        this.setLayout(new BorderLayout());
        this.setSize(800, 800);
        this.setResizable(false);

        Gamer.bPan = new boolean[a][a];
        Gamer.wPan = new boolean[a][a];

        omokP = new JPanel();
        omokP.setLayout(new GridLayout(a, a));
        bt = new JButton[a][a];
        w = new ImageIcon("wdol.jpg");
        b = new ImageIcon("bdol.jpg");
//        p = new ImageIcon("pandegi.jpg");
//        winner1 = new JTextField("흑");
//        winner2 = new JTextField("백");

        info = new JPanel();
        if (Gamer.turn) {
            name1 = new JTextField(Gamer.g1 + "  ");
            name2 = new JTextField(Gamer.g2 + "  ");
            winner1 = new JTextField(Gamer.g1 + "  ");
            winner2 = new JTextField(Gamer.g2 + "  ");
        } else {
            name1 = new JTextField(Gamer.g2 + "  ");
            name2 = new JTextField(Gamer.g1 + "  ");
            winner1 = new JTextField(Gamer.g2 + "  ");
            winner2 = new JTextField(Gamer.g1 + "  ");
        }
        name1.setEditable(false);
        name2.setEditable(false);

        t = new ImageIcon("turn.jpg");
        nt = new ImageIcon("noturn.jpg");
        t1 = new JLabel();
        t1.setIcon(t);
        t2 = new JLabel();
        t2.setIcon(nt);
        exit = new JButton("종료");
        time = new JLabel("시간");
        end = new JTextField("끝");

        winner = new JLabel("승자 : ");

        info.add(name1);
        info.add(t1);
        info.add(name2);
        info.add(t2);
        info.add(exit);
        info.add(time);
        info.add(end);
        info.add(winner);
        info.add(winner1);
        info.add(winner2);

        end.setBackground(Color.RED);
        end.setBorder(null);
        end.setForeground(Color.white);
        end.setVisible(false);
        winner.setVisible(false);
        winner1.setEditable(false);
        winner2.setEditable(false);
        winner1.setVisible(false);
        winner2.setVisible(false);


        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                bt[i][j] = new JButton();
                omokP.add(bt[i][j]);
                if (i > 1 && j > 1 && i < a - 1 && j < a - 1) {
                    bt[i][j].setIcon(p);
                    bt[i][j].setBorderPainted(false);
                    bt[i][j].addActionListener(this);
                } else {
                    bt[i][j].setVisible(false);
                }
            }
        }

        exit.addActionListener(this);

        add(omokP, BorderLayout.CENTER);
        add(info, BorderLayout.NORTH);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        timer.stop();
        sec = 20;
        timer.restart();
        if (e.getSource() == exit) {
            this.dispose();
            StartWindow startWindow = new StartWindow();
        }

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (!Gamer.bPan[i][j] && !Gamer.wPan[i][j]) {
                    if (e.getSource() == bt[i][j]) {
                        indexa = i;
                        indexb = j;
                        if (Gamer.black) { //black turn
//                            bt[i][j].setEnabled(false);
                            bt[i][j].setIcon(b); //black set
                            Gamer.bPan[i][j] = true; //save black index
                            Gamer.black = false;
                            t1.setIcon(nt); //black noturn
                            t2.setIcon(t); //white turn

                        } else {
//                            bt[i][j].setEnabled(false);
                            bt[i][j].setIcon(w); //black set
                            Gamer.wPan[i][j] = true; //save white index
                            Gamer.black = true;
                            t1.setIcon(t); //black turn
                            t2.setIcon(nt); //white noturn
                        }
                    }
                }
                //black win (| ㅡ \ /)
                if (Gamer.bPan[i][j] && Gamer.bPan[i + 1][j] && Gamer.bPan[i + 2][j] && Gamer.bPan[i + 3][j] && Gamer.bPan[i + 4][j]) {
                    end();
                    winnerP1();
                } else if (Gamer.bPan[i][j] && Gamer.bPan[i][j + 1] && Gamer.bPan[i][j + 2] && Gamer.bPan[i][j + 3] && Gamer.bPan[i][j + 4]) {
                    end();
                    winnerP1();
                } else if (Gamer.bPan[i][j] && Gamer.bPan[i + 1][j + 1] && Gamer.bPan[i + 2][j + 2] && Gamer.bPan[i + 3][j + 3] && Gamer.bPan[i + 4][j + 4]) {
                    end();
                    winnerP1();
                } else if (Gamer.bPan[i][j] && Gamer.bPan[i - 1][j - 1] && Gamer.bPan[i - 2][j - 2] && Gamer.bPan[i - 3][j - 3] && Gamer.bPan[i - 4][j - 4]) {
                    end();
                    winnerP1();
                } //white win
                else if (Gamer.wPan[i][j] && Gamer.wPan[i + 1][j] && Gamer.wPan[i + 2][j] && Gamer.wPan[i + 3][j] && Gamer.wPan[i + 4][j]) {
                    end();
                    winnerP2();
                } else if (Gamer.wPan[i][j] && Gamer.wPan[i][j + 1] && Gamer.wPan[i][j + 2] && Gamer.wPan[i][j + 3] && Gamer.wPan[i][j + 4]) {
                    end();
                    winnerP2();
                } else if (Gamer.wPan[i][j] && Gamer.wPan[i + 1][j + 1] && Gamer.wPan[i + 2][j + 2] && Gamer.wPan[i + 3][j + 3] && Gamer.wPan[i + 4][j + 4]) {
                    end();
                    winnerP2();
                } else if (Gamer.wPan[i][j] && Gamer.wPan[i - 1][j - 1] && Gamer.wPan[i - 2][j - 2] && Gamer.wPan[i - 3][j - 3] && Gamer.wPan[i - 4][j - 4]) {
                    end();
                    winnerP2();
                }
            }
        }
    }

    void end() {
        time.setVisible(false);
        end.setVisible(true);
        Gamer.finish = true;
        winner.setVisible(true);
    }

    void winnerP1() {
        winner1.setVisible(true);
        winner2.setVisible(false);
    }

    void winnerP2() {
        winner2.setVisible(true);
        winner1.setVisible(false);
    }
}