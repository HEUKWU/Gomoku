package base;

import base.start.StartWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartMenu extends JFrame implements ActionListener {

    JPanel inputOmok = new JPanel();
    JButton exitGame = new JButton("시작 화면");
    JButton order = new JButton("순서");
    JButton start = new JButton("게임 시작");
    JTextField f1,f2, f3, f4, info;

    public StartMenu(){
        // 프레임 설정
        setTitle("오목 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        add(inputOmok);
        inputOmok.setLayout(null);

        f1 = new JTextField("사용자 1 이름");
        f2 = new JTextField("사용자 2 이름");
        f3 = new JTextField(); // 사용자 1 이름 입력받음
        f4 = new JTextField();// 사용자 2 이름 입력받음
        info = new JTextField("   ** 흑이 먼저 돌을 놓습니다 **");

        // 컴포넌트 위치 설정
        f1.setEditable(false);
        f2.setEditable(false);

        info.setEditable(false);
        info.setBackground(Color.red);
        info.setForeground(Color.white);
        exitGame.setBounds(120, 280, 140, 30);
        f1.setBounds(10,60, 150, 30);
        f2.setBounds(200,60, 150, 30);
        f3.setBounds(10,100, 150, 30);
        f4.setBounds(200,100, 150, 30);
        info.setBounds(100, 240, 180, 30);
        order.setBounds(120, 20, 140, 30);

        inputOmok.add(exitGame);
        inputOmok.add(start);
        inputOmok.add(f1);
        inputOmok.add(f2);
        inputOmok.add(f3);
        inputOmok.add(f4);
        inputOmok.add(info);
        inputOmok.add(order);

        exitGame.addActionListener(this); // 게임 종료
        order.addActionListener(this); // 순서 정하기
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exitGame) {
            StartWindow game = new StartWindow();
            dispose();
        }
        if (e.getSource() == order) {
            Gamer.g1 = f3.getText();
            Gamer.g2 = f4.getText();
            Order order = new Order();
            dispose();
        }
    }
}


