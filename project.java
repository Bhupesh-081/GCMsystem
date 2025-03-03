import javax.swing.*;
import java.awt.*;

public class project {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Grade Card Management System");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Use null layout for custom positioning

        // Title Label
        JLabel titleLabel = new JLabel("Grade Card Management System", JLabel.CENTER);
        titleLabel.setBounds(195, 10, 400, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Set font size & bold
        frame.add(titleLabel);

        // Create a panel
        JPanel panel = new JPanel();
        panel.setBounds(0, 50, 800, 500); // Position below the title
        panel.setLayout(null);
        frame.add(panel);

        placeComponents(panel);
         Color color = new Color(0, 255, 0);
        panel.setBackground(color); // Set background color
        // Set frame visibility
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        // Label
        JLabel userLabel = new JLabel("Enter Student Name:");
        userLabel.setBounds(200, 160, 150, 25);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Improve font
        panel.add(userLabel);

        JLabel regLabel = new JLabel("Enter Reg No:");
        regLabel.setBounds(200, 190, 150, 25);
        regLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Improve font
        panel.add(regLabel);

        // Text Field 
        JTextField userText = new JTextField(20);
        userText.setBounds(350, 160, 200, 25);
        panel.add(userText);

        JTextField regText = new JTextField(20);
        regText.setBounds(350, 190, 200, 25);
        panel.add(regText);

        // Button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(360, 240, 100, 30);
        panel.add(submitButton);
    }
}
