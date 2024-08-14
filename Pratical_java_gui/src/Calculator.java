import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private JTextField display;
    private double currentResult;
    private String currentOperator;
    private boolean operatorClicked;

    public Calculator() {
        setTitle("Simple Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        currentResult = 0;
        currentOperator = "";
        operatorClicked = false;

        
        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        
        String[] buttonLabels = {
            "7", "8", "9", "AC",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "/", "0", "+", "="
        };

        
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 24));
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
    }

    
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if ("0123456789".contains(command)) {
                if (operatorClicked) {
                    display.setText("");
                    operatorClicked = false;
                }
                display.setText(display.getText() + command);
            } else if ("+-*/".contains(command)) {
                currentOperator = command;
                currentResult = Double.parseDouble(display.getText());
                operatorClicked = true;
            } else if ("=".equals(command)) {
                double operand = Double.parseDouble(display.getText());
                switch (currentOperator) {
                    case "+":
                        currentResult += operand;
                        break;
                    case "-":
                        currentResult -= operand;
                        break;
                    case "*":
                        currentResult *= operand;
                        break;
                    case "/":
                        if (operand != 0) {
                            currentResult /= operand;
                        } else {
                            display.setText("Error");
                            return;
                        }
                        break;
                    
                }
                display.setText(String.valueOf(currentResult));
                currentOperator = "";
            } else if("AC".equals(command)) {
            	display.setText("");
                currentResult = 0;
                currentOperator = "";
                operatorClicked = false;
            }
            
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculator().setVisible(true);
            }
        });
    }
}
