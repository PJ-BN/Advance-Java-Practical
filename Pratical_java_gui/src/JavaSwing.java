


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaSwing extends JFrame {
    private JLabel textLabel;
    private JButton changeTextButton;

    public JavaSwing() {
        
        setTitle("Image and Text Display");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

       
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\prajw\\eclipse-workspace\\JavaPraticalGUI\\src\\a.jpg");
        JLabel imageLabel = new JLabel(imageIcon);

        
        textLabel = new JLabel("This is the initial text", JLabel.CENTER);
        textLabel.setFont(new Font("Serif", Font.PLAIN, 20));

        
        changeTextButton = new JButton("Change Text and Image");
        changeTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ImageIcon icon = new ImageIcon("C:\\\\Users\\\\prajw\\\\eclipse-workspace\\\\JavaPraticalGUI\\\\src\\\\b.jpg");
            	imageLabel.setIcon(icon);
                textLabel.setText("The text has been changed!");
            }
        });

        
        add(imageLabel, BorderLayout.CENTER);
        add(textLabel, BorderLayout.SOUTH);
        add(changeTextButton, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JavaSwing().setVisible(true);
            }
        });
    }
}
