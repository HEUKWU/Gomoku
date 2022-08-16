package base;

import base.button.ButtonBuilder;
import base.start.ProgramWindowController;
import base.text.NameTextFieldBuilder;
import base.text.TextFieldBuilder;

import javax.swing.*;
import java.awt.*;

public class StartMenu extends JFrame {

    public StartMenu(){
        setBaseSettings();
        setPanel();
    }
    private void setPanel() {
        JPanel inputOmok = new JPanel();
        add(inputOmok);
        inputOmok.setLayout(null);

        JButton homeButton = ButtonBuilder.builder()
                .withText("Home")
                .withPositionX(120)
                .withPositionY(280)
                .withWidth(140)
                .withHeight(30)
                .addEvent(e -> {
                    ProgramWindowController.start();
                    dispose();
                })
                .build();

        JTextField userName1 = TextFieldBuilder.builder()
                .withText("User1 Name")
                .withPositionX(10)
                .withPositionY(60)
                .withwidth(150)
                .withheight(30)
                .setEditalbe(false)
                .build();

        JTextField userName2 = TextFieldBuilder.builder()
                .withText("User1 Name")
                .withPositionX(200)
                .withPositionY(60)
                .withwidth(150)
                .withheight(30)
                .setEditalbe(false)
                .build();

        JTextField getUserName1 = NameTextFieldBuilder.builder()
                .withPositionX(10)
                .withPositionY(100)
                .withwidth(150)
                .withheight(30)
                .build();

        JTextField getUserName2 = NameTextFieldBuilder.builder()
                .withPositionX(200)
                .withPositionY(100)
                .withwidth(150)
                .withheight(30)
                .build();

        JButton orderButton = ButtonBuilder.builder()
                .withText("order")
                .withPositionX(120)
                .withPositionY(20)
                .withWidth(140)
                .withHeight(30)
                .addEvent(e -> {
                    Gamer.g1 = getUserName1.getText();
                    Gamer.g2 = getUserName2.getText();
                    new Order();
                    dispose();
                })
                .build();

        JTextField info = TextFieldBuilder.builder()
                .withText("   ** 흑이 먼저 돌을 놓습니다 **")
                .withPositionX(100)
                .withPositionY(240)
                .withwidth(180)
                .withheight(30)
                .setEditalbe(false)
                .withColor(Color.red)
                .build();

        inputOmok.add(userName1);
        inputOmok.add(userName2);
        inputOmok.add(getUserName1);
        inputOmok.add(getUserName2);
        inputOmok.add(info);
        inputOmok.add(orderButton);
        inputOmok.add(homeButton);
    }

    private void setBaseSettings() {
        setTitle("오목 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }
}


