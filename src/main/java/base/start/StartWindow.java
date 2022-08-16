package base.start;

import base.button.ButtonBuilder;

import javax.swing.*;
import java.awt.*;

public class StartWindow extends JFrame {
    public StartWindow() {
        setBaseSettings();
        setPanel();
    }

    private void setPanel() {
        JPanel panel = new JPanel();
        add(panel);

        JLabel omokLabel = new JLabel();
        ImageIcon omokImg = new ImageIcon("omok.jpg");
        omokLabel.setIcon(omokImg);

        JButton startButton = ButtonBuilder.builder()
                .withText("시작")
                .withPositionX(10)
                .withPositionY(20)
                .withWidth(140)
                .withHeight(30)
                .addEvent(e -> {
                    ProgramWindowController.showStartMenu();
                    dispose();
                })
                .build();
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
                .addEvent(e -> System.exit(0))
                .build();

        panel.add(startButton);
        panel.add(scoreButton);
        panel.add(exitButton);
        panel.add(omokLabel);
        panel.setLayout(null);
        panel.setBackground(Color.gray);
    }

    private void setBaseSettings() {
        setTitle("오목");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
    }
}
