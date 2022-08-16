package base.text;

import javax.swing.*;

public class NameTextFieldBuilder {
    private int positionX;
    private int positionY;
    private int width;
    private int height;

    private NameTextFieldBuilder () {}

    public static NameTextFieldBuilder builder() {
        return new NameTextFieldBuilder();
    }

    public NameTextFieldBuilder withPositionX(int positionX) {
        this.positionX = positionX;
        return this;
    }

    public NameTextFieldBuilder withPositionY(int positionY) {
        this.positionY = positionY;
        return this;
    }

    public NameTextFieldBuilder withwidth(int width) {
        this.width = width;
        return this;
    }

    public NameTextFieldBuilder withheight(int height) {
        this.height = height;
        return this;
    }

    public JTextField build() {
        JTextField textField = new JTextField();
        textField.setBounds(positionX, positionY, width, height);
        return textField;
    }
}
