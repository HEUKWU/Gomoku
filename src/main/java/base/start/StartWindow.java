package base.start;

import base.StartMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartWindow extends JFrame {
    JPanel panel = new JPanel();
    JButton omok = new JButton("시작");
    JButton omokScore = new JButton("점수");
    JButton exit = new JButton("종료");
    JLabel omokl = new JLabel();

    ImageIcon omokImg = new ImageIcon("omok.jpg");

    public StartWindow() {
        setTitle("오목");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        setSize(400, 400);

        omok.setBounds(10,20, 140, 30);
        omokScore.setBounds(10, 60, 140, 30);
        omokScore.setBackground(Color.yellow);
        exit.setBounds(10, 300, 140, 30);
        omokl.setIcon(omokImg);

        panel.add(omok);
        panel.add(omokScore);
        panel.add(exit);
        panel.add(omokl);
        panel.setLayout(null);
        panel.setBackground(Color.gray);

        omok.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                omokl.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                omokl.setVisible(false);
            }
        });

        omok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartMenu omok = new StartMenu();
                dispose();
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}
