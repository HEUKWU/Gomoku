package base.button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ButtonBuilder {
    private String text;
    private int positionX;
    private int positionY;
    private int width;
    private int height;
    private Color color;
    private List<ActionListener> actionListners = new ArrayList<>();

    private ButtonBuilder() {}

    public static ButtonBuilder builder() {
        return new ButtonBuilder();
    }

    public ButtonBuilder withText(String text) {
        this.text = text;
        return this;
    }

    public ButtonBuilder withPositionX(int positionX) {
        this.positionX = positionX;
        return this;
    }

    public ButtonBuilder withPositionY(int positionY) {
        this.positionY = positionY;
        return this;
    }

    public ButtonBuilder withWidth(int width) {
        this.width = width;
        return this;
    }

    public ButtonBuilder withHeight(int height) {
        this.height = height;
        return this;
    }

    public ButtonBuilder withColor(Color color) {
        this.color = color;
        return this;
    }

    public ButtonBuilder addEvent(ActionListener event) {
        this.actionListners.add(event);
        return this;
    }

    public JButton build() {
        JButton button = new JButton(text);
        button.setBounds(positionX, positionY, width, height);
        if (color != null) {
            button.setBackground(color);
        }
        for (ActionListener actionLister : actionListners) {
            button.addActionListener(actionLister);
        }
        return button;
    }
}
