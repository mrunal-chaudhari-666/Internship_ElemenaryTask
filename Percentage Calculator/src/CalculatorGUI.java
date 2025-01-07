import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame {
    private JTextField inputField1, inputField2, resultField;
    private JComboBox<String> operationBox;
    private JButton calculateButton;

    public CalculatorGUI() {
        setTitle("Percentage Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel label1 = new JLabel("Input 1:");
        label1.setBounds(20, 20, 100, 30);
        add(label1);

        inputField1 = new JTextField();
        inputField1.setBounds(120, 20, 150, 30);
        add(inputField1);

        JLabel label2 = new JLabel("Input 2:");
        label2.setBounds(20, 60, 100, 30);
        add(label2);

        inputField2 = new JTextField();
        inputField2.setBounds(120, 60, 150, 30);
        add(inputField2);

        JLabel operationLabel = new JLabel("Operation:");
        operationLabel.setBounds(20, 100, 100, 30);
        add(operationLabel);

        operationBox = new JComboBox<>(new String[]{
                "Percentage of a Number",
                "Percentage Increase",
                "Percentage Decrease",
                "Find Whole"
        });
        operationBox.setBounds(120, 100, 200, 30);
        add(operationBox);

        calculateButton = new JButton("Calculate");
        calculateButton.setBounds(120, 150, 100, 30);
        add(calculateButton);

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(20, 190, 100, 30);
        add(resultLabel);

        resultField = new JTextField();
        resultField.setBounds(120, 190, 150, 30);
        resultField.setEditable(false);
        add(resultField);

        calculateButton.addActionListener(new CalculateAction());
        setVisible(true);
    }

    private class CalculateAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double input1 = Double.parseDouble(inputField1.getText());
                double input2 = Double.parseDouble(inputField2.getText());
                String operation = (String) operationBox.getSelectedItem();
                double result = 0;

                switch (operation) {
                    case "Percentage of a Number":
                        result = CalculatorLogic.calculatePercentage(input1, input2);
                        break;
                    case "Percentage Increase":
                        result = CalculatorLogic.percentageIncrease(input1, input2);
                        break;
                    case "Percentage Decrease":
                        result = CalculatorLogic.percentageDecrease(input1, input2);
                        break;
                    case "Find Whole":
                        result = CalculatorLogic.findWhole(input1, input2);
                        break;
                }

                resultField.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter numeric values.");
            }
        }
    }
}

