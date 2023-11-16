package com.rat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FacturaNormal extends JFrame {
    private JComboBox productosComboBox;
    private JLabel tituloLabel, codigoLabel, productoLabel, cantidadLabel, costoLabel, subtotalLabel, igvLabel, totalLabel, productoAgregadoLabel, numeroFacturaLabel, clienteLabel, rucLabel, destinoLabel, fechaLabel;
    private JTextField codigoTextField, productoTextField, cantidadTextField, costoTextField, subtotalTextField, igvTextField, totalTextField, numeroFacturaTextField, clienteTextField, rucTextField, destinoTextField, fechaTextField;
    private JButton grabarButton, nuevoButton, salirButton, calcularButton, pagarButton, finalizarButton;

    public FacturaNormal() {
        super("----COMERCIAL FERNANDEZ----");
        Container container = getContentPane();
        container.setLayout(null);

        productosComboBox = new JComboBox();
        productosComboBox.setBounds(30, 240, 332, 20);
        container.add(productosComboBox);

        tituloLabel = new JLabel("PROCESO DE FACTURA");
        tituloLabel.setFont(new Font("Sant Serif", Font.BOLD, 13));
        tituloLabel.setBackground(Color.WHITE);
        tituloLabel.setForeground(Color.BLACK);
        tituloLabel.setBounds(145, 10, 350, 10);

        codigoLabel = new JLabel("Codigo");
        codigoLabel.setFont(new Font("Sant Serif", Font.BOLD, 12));
        codigoLabel.setBounds(30, 30, 350, 15);

        productoLabel = new JLabel("Producto");
        productoLabel.setFont(new Font("Sant Serif", Font.BOLD, 12));
        productoLabel.setBounds(30, 60, 350, 10);

        cantidadLabel = new JLabel("Cantidad");
        cantidadLabel.setFont(new Font("Sant Serif", Font.BOLD, 12));
        cantidadLabel.setBounds(30, 90, 350, 10);

        costoLabel = new JLabel("Costo");
        costoLabel.setFont(new Font("Sant Serif", Font.BOLD, 12));
        costoLabel.setBounds(30, 120, 350, 10);

        subtotalLabel = new JLabel("Sub total");
        subtotalLabel.setFont(new Font("Sant Serif", Font.BOLD, 12));
        subtotalLabel.setBounds(30, 150, 350, 10);

        igvLabel = new JLabel("IGV 19%");
        igvLabel.setFont(new Font("Sant Serif", Font.BOLD, 12));
        igvLabel.setBounds(30, 175, 350, 20);

        totalLabel = new JLabel("Total");
        totalLabel.setFont(new Font("Sant Serif", Font.BOLD, 12));
        totalLabel.setBounds(30, 210, 350, 10);

        productoAgregadoLabel = new JLabel("Producto Agregado");
        productoAgregadoLabel.setFont(new Font("Sant Serif", Font.BOLD, 12));
        productoAgregadoLabel.setBounds(145, 270, 350, 20);

        container.add(tituloLabel);
        container.add(codigoLabel);
        container.add(productoLabel);
        container.add(cantidadLabel);
        container.add(costoLabel);
        container.add(subtotalLabel);
        container.add(igvLabel);
        container.add(totalLabel);
        container.add(productoAgregadoLabel);

        codigoTextField = new JTextField(20);
        codigoTextField.setBounds(100, 25, 80, 25);

        productoTextField = new JTextField(20);
        productoTextField.setBounds(100, 55, 80, 25);

        cantidadTextField = new JTextField(20);
        cantidadTextField.setBounds(100, 85, 80, 25);

        costoTextField = new JTextField(20);
        costoTextField.setBounds(100, 115, 80, 25);

        subtotalTextField = new JTextField(20);
        subtotalTextField.setBounds(100, 145, 80, 25);

        igvTextField = new JTextField(20);
        igvTextField.setBounds(100, 175, 80, 25);

        totalTextField = new JTextField(20);
        totalTextField.setBounds(100, 205, 80, 25);

        container.add(codigoTextField);
        container.add(productoTextField);
        container.add(cantidadTextField);
        container.add(costoTextField);
        container.add(subtotalTextField);
        container.add(igvTextField);
        container.add(totalTextField);

        grabarButton = new JButton("Grabar");
        grabarButton.setBounds(245, 45, 90, 20);
        grabarButton.setHorizontalTextPosition(SwingConstants.CENTER);
        grabarButton.setVerticalTextPosition(SwingConstants.BOTTOM);

        ManejadorBotones m2 = new ManejadorBotones();
        grabarButton.addActionListener(m2);

        nuevoButton = new JButton("Nuevo");
        nuevoButton.setBounds(245, 70, 90, 20);
        nuevoButton.setHorizontalTextPosition(SwingConstants.CENTER);
        nuevoButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        nuevoButton.addActionListener(m2);

        salirButton = new JButton("Salir");
        salirButton.setBounds(245, 95, 90, 20);
        salirButton.setHorizontalTextPosition(SwingConstants.CENTER);
        salirButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        salirButton.addActionListener(m2);

        calcularButton = new JButton("Calcular");
        calcularButton.setBounds(245, 120, 90, 20);
        calcularButton.setHorizontalTextPosition(SwingConstants.CENTER);
        calcularButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        calcularButton.addActionListener(m2);

        pagarButton = new JButton("Pagar");
        pagarButton.setBounds(245, 145, 90, 20);
        pagarButton.setHorizontalTextPosition(SwingConstants.CENTER);
        pagarButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        pagarButton.addActionListener(m2);

        container.add(grabarButton);
        container.add(nuevoButton);
        container.add(salirButton);
        container.add(calcularButton);
        container.add(pagarButton);

        setSize(400, 400);
        getContentPane().setBackground(Color.CYAN);
        show();
    }

    private class ManejadorBotones implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == grabarButton) {
                productosComboBox.addItem(cantidadTextField.getText() + " " + productoTextField.getText() + " " + totalTextField.getText());
            }
            if (e.getSource() == nuevoButton) {
                codigoTextField.setText("");
                productoTextField.setText("");
                cantidadTextField.setText("");
                costoTextField.setText("");
                subtotalTextField.setText("");
                igvTextField.setText("");
                totalTextField.setText("");
            }
            if (e.getSource() == salirButton) {
                System.exit(0);
            }
            if (e.getSource() == calcularButton) {
                double cantidadDouble, costoDouble, subTotalDouble, igvDouble, totalDouble;

                cantidadDouble = Double.parseDouble(cantidadTextField.getText());
                costoDouble = Double.parseDouble(costoTextField.getText());
                subTotalDouble = cantidadDouble * costoDouble;
                igvDouble = 0.19 * subTotalDouble;
                totalDouble = subTotalDouble + igvDouble;

                subtotalTextField.setText(String.valueOf(subTotalDouble));
                subtotalTextField.setForeground(Color.BLACK);
                igvTextField.setText(String.valueOf(igvDouble));
                igvTextField.setForeground(Color.BLACK);
                totalTextField.setText(String.valueOf(totalDouble));
                totalTextField.setForeground(Color.BLACK);
            }

            if (e.getSource() == pagarButton) {
                JFrame frame = new JFrame("Datos del Cliente");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 400);

                Container clienteContainer = frame.getContentPane();
                clienteContainer.setLayout(null);

                numeroFacturaLabel = new JLabel("Nro Factura");
                numeroFacturaLabel.setFont(new Font("Sant Serif", Font.BOLD, 12));
                numeroFacturaLabel.setBounds(30, 10, 350, 15);

                clienteLabel = new JLabel("Cliente");
                clienteLabel.setFont(new Font("Sant Serif", Font.BOLD, 12));
                clienteLabel.setBounds(30, 40, 350, 10);

                rucLabel = new JLabel("RUC");
                rucLabel.setFont(new Font("Sant Serif", Font.BOLD, 12));
                rucLabel.setBounds(30, 70, 350, 10);

                destinoLabel = new JLabel("Destino");
                destinoLabel.setFont(new Font("Sant Serif", Font.BOLD, 12));
                destinoLabel.setBounds(30, 100, 350, 10);

                fechaLabel = new JLabel("Fecha");
                fechaLabel.setFont(new Font("Sant Serif", Font.BOLD, 12));
                fechaLabel.setBounds(30, 130, 350, 10);

                clienteContainer.add(numeroFacturaLabel);
                clienteContainer.add(clienteLabel);
                clienteContainer.add(rucLabel);
                clienteContainer.add(destinoLabel);
                clienteContainer.add(fechaLabel);

                numeroFacturaTextField = new JTextField(20);
                numeroFacturaTextField.setBounds(100, 10, 80, 25);

                clienteTextField = new JTextField(20);
                clienteTextField.setBounds(100, 40, 80, 25);

                rucTextField = new JTextField(20);
                rucTextField.setBounds(100, 70, 80, 25);

                destinoTextField = new JTextField(20);
                destinoTextField.setBounds(100, 100, 80, 25);

                fechaTextField = new JTextField(20);
                fechaTextField.setBounds(100, 130, 80, 25);

                clienteContainer.add(numeroFacturaTextField);
                clienteContainer.add(clienteTextField);
                clienteContainer.add(rucTextField);
                clienteContainer.add(destinoTextField);
                clienteContainer.add(fechaTextField);

                finalizarButton = new JButton("Finalizar");
                //grabarButton.setBounds(245, 45, 90, 20);

                finalizarButton.setBounds(245, 45, 90, 20);
                finalizarButton.setHorizontalTextPosition(SwingConstants.CENTER);
                finalizarButton.setVerticalTextPosition(SwingConstants.BOTTOM);

                clienteContainer.add(finalizarButton);

                finalizarButton.addActionListener(event -> {
                    String mensaje = "Cliente: " + clienteTextField.getText() + "\n\n" + "Productos: " + "\n\n";

                    for (int i = 0; i < productosComboBox.getItemCount(); i++) {
                        mensaje += productosComboBox.getItemAt(i).toString() + "\n";
                    }

                    JOptionPane.showMessageDialog(null, mensaje, "Factura", JOptionPane.INFORMATION_MESSAGE);
                });

                setSize(400, 100);
                frame.getContentPane().setBackground(Color.GRAY);
                frame.setVisible(true);

            }

        }
    }

    public static void main(String args[]) {
        FacturaNormal app = new FacturaNormal();
        app.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.out.println(0);
                    }
                }
        );
    }
}