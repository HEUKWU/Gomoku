package base.text;

import javax.swing.*;
import java.awt.*;

public class TextFieldBuilder {

    private String text;
    private int positionX;
    private int positionY;
    private int width;
    private int height;
    private Color color;

    private boolean editable;

    private TextFieldBuilder() {}

    public static TextFieldBuilder builder() {
        return new TextFieldBuilder();
    }

    public TextFieldBuilder withText(String text) {
        this.text = text;
        return this;
    }

    public TextFieldBuilder withPositionX(int positionX) {
        this.positionX = positionX;
        return this;
    }

    public TextFieldBuilder withPositionY(int positionY) {
        this.positionY = positionY;
        return this;
    }

    public TextFieldBuilder withwidth(int width) {
        this.width = width;
        return this;
    }

    public TextFieldBuilder withheight(int height) {
        this.height = height;
        return this;
    }

    public TextFieldBuilder withColor(Color color) {
        this.color = color;
        return this;
    }

    public TextFieldBuilder setEditalbe(boolean editable) {
        this.editable = editable;
        return this;
    }

    public JTextField build() {
        JTextField textField = new JTextField(text);
        textField.setBounds(positionX, positionY, width, height);
        if (color != null) {
            textField.setBackground(color);
        }
        textField.setEditable(editable);

        return textField;
    }
}
