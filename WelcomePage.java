import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class WelcomePage implements ActionListener {
    JButton createPanel = new JButton("Create Panel");
    JButton seePanel = new JButton("See Panel");
    JButton result = new JButton("Result");
    JButton logoutButton = new JButton("Logout"); 

    JFrame frame = new JFrame();
    JLabel welcomelabel = new JLabel("VOTING MANAGEMENT DASHBOARD");
    Idpassword idpassword = new Idpassword();

    WelcomePage() {
        logoutButton.setBounds(10, 10, 100, 30);
        logoutButton.setFocusable(false);
        logoutButton.setBackground(new Color(255, 0, 0)); 
        logoutButton.setForeground(Color.WHITE); 
        logoutButton.addActionListener(this);

        createPanel.setBounds(150, 300, 200, 50);
        seePanel.setBounds(400, 300, 200, 50);
        result.setBounds(650, 300, 200, 50);
        createPanel.setFocusable(false);
        seePanel.setFocusable(false);
        result.setFocusable(false);
        createPanel.setBackground(new Color(0, 255, 0)); 
        seePanel.setBackground(new Color(4, 27, 76)); 
        result.setBackground(new Color(255, 165, 0)); 
        createPanel.setForeground(Color.WHITE); 
        seePanel.setForeground(Color.WHITE); 
        result.setForeground(Color.WHITE); 
        createPanel.addActionListener(this);
        seePanel.addActionListener(this);
        result.addActionListener(this);

        welcomelabel.setFont(new Font("Arial", Font.BOLD, 32));
        welcomelabel.setBounds(220, 100, 600, 35);
        welcomelabel.setForeground(Color.black);

       
        ImageIcon backgroundImageIcon = new ImageIcon("second.jpg");
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
        ImageIcon resizedBackgroundImageIcon = new ImageIcon(backgroundImage);
        JLabel backgroundLabel = new JLabel(resizedBackgroundImageIcon);
        backgroundLabel.setBounds(0, 0, 1000, 600);

        
        backgroundLabel.add(logoutButton);
        backgroundLabel.add(createPanel);
        backgroundLabel.add(seePanel);
        backgroundLabel.add(result);
        backgroundLabel.add(welcomelabel);
        ImageIcon icon = new ImageIcon("icon.png");
        Image logo = icon.getImage();
        frame.setIconImage(logo);


        frame.setLayout(null);
        frame.getContentPane().add(backgroundLabel);

        frame.setResizable(false);
        frame.setTitle("VoteEase");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (createPanel == e.getSource()) {
            frame.dispose();
            Panel panel = new Panel();
        } else if (e.getSource() == seePanel) {
            frame.dispose();
            SeePanel seepanel = new SeePanel();
        } else if (e.getSource() == result) {
            frame.dispose();
            Result result = new Result();
        } else if (e.getSource() == logoutButton) {
            frame.dispose();
            LoginPage loginPage = new LoginPage(idpassword.getLoginInfo());
        }
    }
}
