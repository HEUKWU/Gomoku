package base;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Order extends JFrame {
    JPanel p1 = new JPanel();

    JTextField f1 = new JTextField(Gamer.g1);
    JTextField f2 = new JTextField(Gamer.g2);
    JButton b3 = new JButton("게임 시작");
    JButton b2 = new JButton("뒤로 가기");
    JTextField g1First = new JTextField(Gamer.g1);
    JTextField g2First = new JTextField(Gamer.g2);
    ImageIcon fore = new ImageIcon("fore.jpg");
    ImageIcon back = new ImageIcon("back.jpg");
    JLabel p1l = new JLabel();
    JLabel p2l = new JLabel();
    JLabel firstl = new JLabel("선공 : ");

    Order() {
        setTitle("순서 정하기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400, 400);
        add(p1);
        g1First.setEditable(false);
        g2First.setEditable(false);
        f1.setEditable(false);
        f2.setEditable(false);

        p1.add(f1);
        p1.add(f2);
        p1.add(b2);
        p1.add(b3);
        p1.add(p1l);
        p1.add(p2l);
        p1.add(firstl);
        p1.add(g1First);
        p1.add(g2First);
        p1.setLayout(null);
        g1First.setVisible(false);
        g2First.setVisible(false);

        b2.setBounds(120, 250, 140, 30);
        b3.setBounds(120, 20, 140, 30);
        f1.setBounds(10,60, 150, 30);
        f2.setBounds(210,60, 150, 30);
        p1l.setBounds(30,60,200,200);
        p2l.setBounds(240,60,200,200);
        firstl.setBounds(10, 300, 140, 30);
        g1First.setBounds(120, 300, 140, 30);
        g2First.setBounds(120, 300, 140, 30);

        Random random = new Random();
        boolean r = random.nextBoolean();
        if (r) {
            p1l.setIcon(fore);
            p2l.setIcon(back);
            g1First.setVisible(true);
            Gamer.turn = true;
        } else {
            p1l.setIcon(back);
            p2l.setIcon(fore);
            g2First.setVisible(true);
            Gamer.turn = false;
        }

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartMenu omok = new StartMenu();
                dispose();
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OmokFrame omokFrame = new OmokFrame();
                dispose();
            }
        });
    }
}

