import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginPage implements ActionListener {

    JFrame frame = new JFrame();
    JLabel loginpage = new JLabel("Welcome To VoteEase");
    JButton loginbutton = new JButton("LOGIN");
    JButton resetbutton = new JButton("CLEAR");
    JTextField userIDfield = new JTextField();
    JPasswordField userPasswordfield = new JPasswordField();
    JLabel userIDlabel = new JLabel("USER ID:");
    JLabel userPasswordlabel = new JLabel("PASSWORD:");
    JLabel messagelabel = new JLabel();
    JLabel signup = new JLabel("If you are new here, Please Register.");
    JButton create = new JButton("Register");
    JButton show = new JButton("Show Result");

    HashMap<String, String> logininfo = new HashMap<String, String>();

    LoginPage(HashMap<String, String> loginInfoOriginal) {
        loginpage.setFont(new Font("Arial", Font.BOLD, 40));
        loginpage.setBounds(275, 60, 600, 50);
        loginpage.setForeground(Color.WHITE);

        logininfo = loginInfoOriginal;
        signup.setBounds(360, 300, 500, 35);
        signup.setFont(new Font(null, Font.BOLD, 17));
        signup.setForeground(Color.white);
        create.setBounds(395, 350, 200, 35);
        create.setFocusable(false);
        create.addActionListener(this);

        show.setBounds(395, 400, 200, 35);
        show.setFocusable(false);
        show.addActionListener(this);

        userIDlabel.setBounds(375, 100, 100, 125);
        userIDlabel.setForeground(Color.white);
        userPasswordlabel.setBounds(355, 105, 150, 200);
        userPasswordlabel.setForeground(Color.WHITE);

        messagelabel.setBounds(410, 400, 200, 230);
        messagelabel.setFont(new Font(null, Font.ITALIC, 20));

        userIDfield.setBounds(445, 150, 150, 32);
        userPasswordfield.setBounds(445, 190, 150, 32);

        loginbutton.setBounds(325, 250, 165, 35);
        loginbutton.setFocusable(false);
        loginbutton.addActionListener(this);

        resetbutton.setBounds(505, 250, 165, 35);
        resetbutton.setFocusable(false);
        resetbutton.addActionListener(this);

        ImageIcon backgroundImageIcon = new ImageIcon("fifth.jpg");
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
        ImageIcon resizedBackgroundImageIcon = new ImageIcon(backgroundImage);
        JLabel backgroundLabel = new JLabel(resizedBackgroundImageIcon);
        backgroundLabel.setBounds(0, 0, 1000, 600);

        backgroundLabel.setLayout(null);
        backgroundLabel.add(userIDlabel);
        backgroundLabel.add(userPasswordlabel);
        backgroundLabel.add(messagelabel);
        backgroundLabel.add(userIDfield);
        backgroundLabel.add(userPasswordfield);
        backgroundLabel.add(loginbutton);
        backgroundLabel.add(resetbutton);
        backgroundLabel.add(loginpage);
        backgroundLabel.add(signup);
        backgroundLabel.add(create);
        backgroundLabel.add(show);

        ImageIcon icon = new ImageIcon("icon.png");
        Image logo = icon.getImage();
        frame.setIconImage(logo);


        frame.getContentPane().add(backgroundLabel);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("VoteEase");
        frame.setSize(1000, 600);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void disposeLoginPage() {
        frame.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetbutton) {
            userIDfield.setText("");
            userPasswordfield.setText("");
        } else if (e.getSource() == loginbutton) {
            String ID = userIDfield.getText();
            String Password = String.valueOf(userPasswordfield.getPassword());
            if (logininfo.containsKey(ID)) {
                if (logininfo.get(ID).equals(Password)) {
                    if (ID.equals("Admin")) {
                        frame.dispose();
                        WelcomePage welcomepage = new WelcomePage();
                    } else {
                        frame.dispose();
                        Castvote castVote = new Castvote(ID);
                    }
                    messagelabel.setForeground(Color.GREEN);
                    messagelabel.setText("Login successful ");
                } else {
                    messagelabel.setForeground(Color.RED);
                    messagelabel.setText("Wrong password!");
                }
            } else {
                messagelabel.setForeground(Color.RED);
                messagelabel.setText("Username not found. ");
            }
        } else if (e.getSource() == create) {
            frame.dispose();
            CreateAccount account = new CreateAccount(this, logininfo);
        } else if (e.getSource() == show) {
            frame.dispose();
            Result result = new Result();
        }
    }

}
    