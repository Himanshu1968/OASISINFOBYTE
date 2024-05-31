import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class GuessTheNumberJava extends JFrame {
    private JTextField userGuessField;
    private JLabel resultLabel;
    private JLabel attemptsLabel;
    private int randomNumber;
    private int attempts;

    public GuessTheNumberJava() {
        setTitle("Guess the Number");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        JLabel titleLabel = new JLabel("Welcome to Guess the Number!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        userGuessField = new JTextField();
        userGuessField.setHorizontalAlignment(JTextField.CENTER);
        JButton submitButton = new JButton("Submit Guess");
        resultLabel = new JLabel("", SwingConstants.CENTER);
        attemptsLabel = new JLabel("", SwingConstants.CENTER);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        panel.add(titleLabel);
        panel.add(new JLabel("I'm thinking of a number between 1 and 100.", SwingConstants.CENTER));
        panel.add(new JLabel("Can you guess what it is?", SwingConstants.CENTER));
        panel.add(userGuessField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel, BorderLayout.CENTER);
        add(attemptsLabel, BorderLayout.SOUTH);

        randomNumber = (int) (Math.random() * 100) + 1;
        attempts = 0;
        attemptsLabel.setText("Attempts: " + attempts);
    }

    private void checkGuess() {
        try {
            int userGuess = Integer.parseInt(userGuessField.getText());

            if (userGuess < 1 || userGuess > 100) {
                JOptionPane.showMessageDialog(this, "Please enter a number between 1 and 100.");
                return;
            }

            attempts++;

            if (userGuess == randomNumber) {
                resultLabel.setText("Congratulations! You guessed the correct number in " + attempts + " attempts.");
            } else if (userGuess < randomNumber) {
                resultLabel.setText("Too low! Try again.");
            } else {
                resultLabel.setText("Too high! Try again.");
            }

            attemptsLabel.setText("Attempts: " + attempts);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuessTheNumberJava().setVisible(true);
            }
        });
    }
}
