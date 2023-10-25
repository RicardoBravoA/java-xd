package com.rat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        createForm();
    }

    private static void createForm() {
        JFrame frame = new JFrame("Promedio de Notas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel nameLabel = new JLabel("Nombre:");
        JTextField nameTextField = new JTextField(30);

        JLabel note1Label = new JLabel("Nota 1:");
        JTextField note1TextField = new JTextField(5);

        JLabel note2Label = new JLabel("Nota 2:");
        JTextField note2TextField = new JTextField(5);

        JLabel note3Label = new JLabel("Nota 3:");
        JTextField note3TextField = new JTextField(5);

        JButton averageButton = new JButton("Calcular Promedio");
        averageButton.setPreferredSize(new Dimension(100, 50));

        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(note1Label);
        panel.add(note1TextField);
        panel.add(note2Label);
        panel.add(note2TextField);
        panel.add(note3Label);
        panel.add(note3TextField);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(averageButton, BorderLayout.CENTER);
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        averageButton.addActionListener(e -> {
            String name = nameTextField.getText();
            String note1String = note1TextField.getText();
            String note2String = note2TextField.getText();
            String note3String = note3TextField.getText();

            if (validateString(name, "Ingrese el nombre", nameTextField)) {
                return;
            }

            if (validateString(note1String, "Ingrese Nota 1", note1TextField)) {
                return;
            }

            if (isValidNote(note1String, "Nota 1 debe ser un valor numérico entre 0 y 20", note1TextField)) {
                return;
            }

            if (validateString(note2String, "Ingrese Nota 2", note2TextField)) {
                return;
            }

            if (isValidNote(note2String, "Nota 2 debe ser un valor numérico entre 0 y 20", note2TextField)) {
                return;
            }

            if (validateString(note3String, "Ingrese Nota 3", note3TextField)) {
                return;
            }

            if (isValidNote(note3String, "Nota 3 debe ser un valor numérico entre 0 y 20", note3TextField)) {
                return;
            }

            double note1 = Double.parseDouble(note1String);
            double note2 = Double.parseDouble(note2String);
            double note3 = Double.parseDouble(note3String);

            double average = (note1 + note2 + note3) / 3;
            double rounded = Math.round(average * 100.0) / 100.0;

            JOptionPane.showMessageDialog(null, "El promedio de " + name + " es: " + rounded, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static boolean validateString(String value, String message, JTextField textField) {
        if (value.isEmpty()) {
            JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
            textField.requestFocus();
            return true;
        }
        return false;
    }

    private static boolean isValidNote(String value, String message, JTextField textField) {
        try {
            double note = Double.parseDouble(value);

            if (note >= 0 && note <= 20) {
                return false;
            } else {
                clearText(message, textField);
                return true;
            }
        } catch (NumberFormatException exception) {
            clearText(message, textField);
            return true;
        }
    }

    private static void clearText(String message, JTextField textField) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
        textField.setText("");
        textField.requestFocus();
    }

}