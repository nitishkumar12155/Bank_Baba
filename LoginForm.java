import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginForm extends JFrame {

    LoginForm() {
        setTitle("Login Form");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new LoginPanel());

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}

class LoginPanel extends JPanel {

    JTextField username;
    JPasswordField password;
    JButton loginButton;

    LoginPanel() {
        setLayout(null);
        setBackground(Color.WHITE);

        username = new JTextField();
        password = new JPasswordField();

        username.setBounds(180, 110, 200, 35);
        password.setBounds(180, 170, 200, 35);

        add(username);
        add(password);

        loginButton = new JButton("LOGIN");
        loginButton.setBounds(180, 230, 200, 40);

        add(loginButton);

        loginButton.addActionListener(e -> {
            String user = username.getText();
            String pass = new String(password.getPassword());

            if (user.equals("admin") && pass.equals("1234")) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password!");
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // Enable smooth drawing
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        // Title
        g2.setFont(new Font("Arial", Font.BOLD, 28));
        g2.setColor(Color.BLACK);
        g2.drawString("LOGIN FORM", 165, 60);

        // Username
        g2.setFont(new Font("Arial", Font.BOLD, 16));
        g2.drawString("Username:", 80, 132);

        // Password
        g2.drawString("Password:", 80, 192);

        // Border around form
        g2.setColor(Color.GRAY);
        g2.drawRoundRect(50, 80, 400, 230, 15, 15);
    }
}