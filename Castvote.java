import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Castvote implements ActionListener {
    Idpassword idpassword = new Idpassword();
    JLabel name = new JLabel("Name ");
    JLabel cms = new JLabel("CMS ID ");
    JLabel semester = new JLabel("Semester ");
    JLabel dept = new JLabel("Department");
    JButton cast = new JButton("Cast");
    JButton logoutButton = new JButton("Logout");

    JTextField nameTextField = new JTextField();
    JTextField cmsTextField = new JTextField();
    JTextField semesterTextField = new JTextField();
    JTextField deptTextField = new JTextField();

    JLabel voteFor = new JLabel("Vote For ");
    JComboBox comboBox = new JComboBox();

    JFrame frame = new JFrame();

    Castvote(String username) {
        ImageIcon backgroundImageIcon = new ImageIcon("first.jpg");
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH);
        ImageIcon resizedBackgroundImageIcon = new ImageIcon(backgroundImage);
        JLabel backgroundLabel = new JLabel(resizedBackgroundImageIcon);
        backgroundLabel.setBounds(0, 0, 600, 600);

        backgroundLabel.setLayout(null);

        name.setBounds(100, 200, 200, 30);
        cms.setBounds(100, 250, 200, 30);
        semester.setBounds(100, 300, 200, 30);
        dept.setBounds(100, 340, 200, 50);

        name.setForeground(Color.BLACK);
        cms.setForeground(Color.BLACK);
        semester.setForeground(Color.BLACK);
        dept.setForeground(Color.BLACK);

        name.setFont(new Font(null, Font.BOLD, 20));
        cms.setFont(new Font(null, Font.BOLD, 20));
        semester.setFont(new Font(null, Font.BOLD, 20));
        dept.setFont(new Font(null, Font.BOLD, 20));

        nameTextField.setBounds(300, 200, 150, 30);
        cmsTextField.setBounds(300, 250, 150, 30);
        semesterTextField.setBounds(300, 300, 150, 30);
        deptTextField.setBounds(300, 350, 150, 30);

        voteFor.setBounds(100, 390, 200, 50);
        voteFor.setFont(new Font(null, Font.BOLD, 20));
        voteFor.setForeground(Color.BLACK);

        comboBox.setBounds(300, 400, 150, 30);

        cast.setBounds(400, 500, 100, 30);
        cast.setForeground(Color.WHITE);
        cast.setFocusable(false);
        cast.setBackground(new Color(16, 76, 4, 231));
        cast.addActionListener(this);


        logoutButton.setBounds(10, 10, 100, 30);
        logoutButton.setFocusable(false);
        logoutButton.setBackground(new Color(255, 0, 0));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.addActionListener(this);

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String dbUrl = "jdbc:ucanaccess://D://OOP_Final_Project//VoteEase//VoteEase.accdb";
            Connection connection = DriverManager.getConnection(dbUrl);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT TeamSymbol FROM PanelData");

            while (resultSet.next()) {
                String symbol = resultSet.getString("TeamSymbol");
                comboBox.addItem(symbol);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String dbUrl = "jdbc:ucanaccess://D://OOP_Final_Project//VoteEase//VoteEase.accdb";
            Connection connection = DriverManager.getConnection(dbUrl);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username = '" + username + "'");

            if (resultSet.next()) {
                nameTextField.setText(resultSet.getString("username"));
                cmsTextField.setText(resultSet.getString("cms_id"));
                semesterTextField.setText(resultSet.getString("semester"));
                deptTextField.setText(resultSet.getString("department"));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        backgroundLabel.add(cast);
        backgroundLabel.add(voteFor);
        backgroundLabel.add(comboBox);
        backgroundLabel.add(cms);
        backgroundLabel.add(name);
        backgroundLabel.add(semester);
        backgroundLabel.add(dept);
        backgroundLabel.add(nameTextField);
        backgroundLabel.add(cmsTextField);
        backgroundLabel.add(semesterTextField);
        backgroundLabel.add(deptTextField);
        backgroundLabel.add(logoutButton);

        frame.getContentPane().add(backgroundLabel); 
        ImageIcon icon = new ImageIcon("icon.png");
        Image logo = icon.getImage();
        frame.setIconImage(logo);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setTitle("VoteEase");
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cast) {
           
            String selectedSymbol = (String) comboBox.getSelectedItem();
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                String dbUrl = "jdbc:ucanaccess://D://OOP_Final_Project//VoteEase//VoteEase.accdb";
                Connection connection = DriverManager.getConnection(dbUrl);
                Statement statement = connection.createStatement();
                String query = "UPDATE PanelData SET Votes = Votes + 1 WHERE TeamSymbol = '" + selectedSymbol + "'";
                statement.executeUpdate(query);
                statement.close();
                connection.close();
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
            frame.dispose();
            LoginPage login = new LoginPage(idpassword.getLoginInfo());
        } else if (e.getSource() == logoutButton) {
            frame.dispose();
            LoginPage login = new LoginPage(idpassword.getLoginInfo());
        }
    }
}
