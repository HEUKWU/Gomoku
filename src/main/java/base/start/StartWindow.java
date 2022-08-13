package base.start;

import base.StartMenu;
import base.button.ButtonBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartWindow extends JFrame {
    JPanel panel = new JPanel();
    JLabel omokLabel = new JLabel();
    ImageIcon omokImg = new ImageIcon("omok.jpg");

    public StartWindow() {
        JButton startButton = ButtonBuilder.builder()
                .withText("시작")
                .withPositionX(10)
                .withPositionY(20)
                .withWidth(140)
                .withHeight(30)
                .build();
        startButton.addActionListener(e -> {
            new StartMenu();
            dispose();
        });
        JButton scoreButton = ButtonBuilder.builder()
                .withText("점수")
                .withPositionX(10)
                .withPositionY(60)
                .withWidth(140)
                .withHeight(30)
                .withColor(Color.YELLOW)
                .build();
        JButton exitButton = ButtonBuilder.builder()
                .withText("종료")
                .withPositionX(10)
                .withPositionY(300)
                .withWidth(140)
                .withHeight(30)
                .withColor(Color.YELLOW)
                .build();
        exitButton.addActionListener(e -> System.exit(0));

        setTitle("오목");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        setSize(400, 400);

        omokLabel.setIcon(omokImg);

        panel.add(startButton);
        panel.add(scoreButton);
        panel.add(exitButton);
        panel.add(omokLabel);
        panel.setLayout(null);
        panel.setBackground(Color.gray);
    }
}
