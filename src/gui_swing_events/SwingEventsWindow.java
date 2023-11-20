package gui_swing_events;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SwingEventsWindow extends JFrame implements ItemListener,ActionListener{

    private int rdoChecked = 1;

    JFrame frame = new JFrame("Swing Events Window");

    JPanel mainPanel = new JPanel();

    // First JPanel with text
    JPanel panel1 = new JPanel();
    JLabel label1 = new JLabel("Excel Functions");
    JLabel label2 = new JLabel("Enter your numbers separated by spaces:");

    // Second JPanel with textarea
    JPanel panel2 = new JPanel();
    JTextField textArea1 = new JTextField(30);

    // Third JPanel with 4 radio buttons
    JPanel panel3 = new JPanel();
    JRadioButton radioButton1 = new JRadioButton("AutoSum", true);
    JRadioButton radioButton2 = new JRadioButton("Average");
    JRadioButton radioButton3 = new JRadioButton("Maximum");
    JRadioButton radioButton4 = new JRadioButton("Minimum");
    ButtonGroup buttonGroup = new ButtonGroup();

    JPanel panel4 = new JPanel();
    JButton calculateButton = new JButton("Calculate");

    JPanel panel5 = new JPanel();
    JLabel label5 = new JLabel("Result:");
    JTextField textField5 = new JTextField(20);

    public SwingEventsWindow() {

        //Create and set up the window.
        super("Swing Events Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        // Set the layout for the main panel
        mainPanel.setLayout(new GridLayout(5, 1));
        frame.add(mainPanel);

        // First JPanel with text
        panel1.add(label1);
        panel1.add(label2);
        mainPanel.add(panel1);

        // Second JPanel with textarea
        panel2.add(textArea1);
        mainPanel.add(panel2);

        // Third JPanel with 4 radio buttons
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);
        buttonGroup.add(radioButton4);

        radioButton1.addItemListener(this);
        radioButton2.addItemListener(this);
        radioButton3.addItemListener(this);
        radioButton4.addItemListener(this);

        panel3.add(radioButton1);
        panel3.add(radioButton2);
        panel3.add(radioButton3);
        panel3.add(radioButton4);
        mainPanel.add(panel3);

        // Fourth JPanel with "calculate" button
        panel4.add(calculateButton);
        calculateButton.addActionListener(this);
        mainPanel.add(panel4);

        // Fifth JPanel with "result" text field
        textField5.setEditable(false);
        panel5.add(label5);
        panel5.add(textField5);
        mainPanel.add(panel5);

        frame.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getItemSelectable() == radioButton1) {
            rdoChecked = 1;
        } else if (e.getItemSelectable() == radioButton2) {
            rdoChecked = 2;
        } else if (e.getItemSelectable() == radioButton3) {
            rdoChecked = 3;
        } else if (e.getItemSelectable() == radioButton4) {
            rdoChecked = 4;
        }
    }

    // Add event handler for the calculate button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            String input = textArea1.getText();
            Excel excel = new Excel(input);
            if (rdoChecked == 1) {
                textField5.setText(Double.toString(excel.getTotal()));
            } else if (rdoChecked == 2) {
                textField5.setText(Double.toString(excel.getAverage()));
            } else if (rdoChecked == 3) {
                textField5.setText(Double.toString(excel.getMaximum()));
            } else if (rdoChecked == 4) {
                textField5.setText(Double.toString(excel.getMinimum()));
            }
        }
    }
}