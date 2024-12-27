
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// View representing the GUI components for Polynomial Calculator
class PolynomialView extends JFrame {
    private JTextField inputField1, inputField2, resultField;
    JButton addButton;
    JButton subtractButton;
    JButton multiplyButton;
    JButton divideButton;
    JButton derivativeButton;
    JButton integrationButton; // Integration button
    private JLabel remainderLabel;
    private JTextField remainderField;

    public PolynomialView() {
        setTitle("Polynomial Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel label1 = new JLabel("Enter polynomial 1:");
        inputField1 = new JTextField();
        JLabel label2 = new JLabel("Enter polynomial 2:");
        inputField2 = new JTextField();

        inputPanel.add(label1);
        inputPanel.add(inputField1);
        inputPanel.add(label2);
        inputPanel.add(inputField2);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        multiplyButton = new JButton("Multiply");
        divideButton = new JButton("Divide");
        derivativeButton = new JButton("Derivative");
        integrationButton = new JButton("Integrate"); // Integration button

        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(derivativeButton);
        buttonPanel.add(integrationButton); // Add integration button to the panel

        JPanel resultPanel = new JPanel(new GridBagLayout());
        resultPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField();
        resultField.setEditable(false);
        resultPanel.add(resultLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        resultPanel.add(resultField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        resultPanel.add(Box.createVerticalStrut(10), gbc); // Add some space between result and remainder

        gbc.gridy = 2;
        remainderLabel = new JLabel("Remainder:");
        remainderField = new JTextField();
        remainderField.setEditable(false);
        resultPanel.add(remainderLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        resultPanel.add(remainderField, gbc);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    // Add action listeners for buttons
    public void addAdditionListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void addSubtractionListener(ActionListener listener) {
        subtractButton.addActionListener(listener);
    }

    public void addMultiplicationListener(ActionListener listener) {
        multiplyButton.addActionListener(listener);
    }

    public void addDivisionListener(ActionListener listener) {
        divideButton.addActionListener(listener);
    }

    public void addDerivativeListener(ActionListener listener) {
        derivativeButton.addActionListener(listener);
    }

    public void addIntegrationListener(ActionListener listener) { // Add listener for integration
        integrationButton.addActionListener(listener);
    }

    public void setResult(String result) {
        resultField.setText(result);
    }

    public void setRemainder(String remainder) {
        remainderField.setText(remainder);
    }

    public String getInput1() {
        return inputField1.getText();
    }

    public String getInput2() {
        return inputField2.getText();
    }
}
