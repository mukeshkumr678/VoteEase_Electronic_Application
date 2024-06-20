import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import java.util.HashMap;

public class CreateAccount implements ActionListener {
    Idpassword idpassword = new Idpassword();
    private LoginPage loginPage;
    private HashMap<String, String> loginInfo;
    JLabel name = new JLabel("Name ");
    JLabel cms = new JLabel("CMS ID ");
    JLabel semester = new JLabel("Semester ");
    JLabel dept = new JLabel("Department");
    JLabel password = new JLabel("Password");

    JButton sign = new JButton("Create");
    JButton back = new JButton("Back");

    JTextField nameTextField = new JTextField();
    JTextField cmsTextField = new JTextField();
    JTextField semesterTextField = new JTextField();
    JTextField deptTextField = new JTextField();
    JTextField passwordTextField = new JTextField();

    JFrame frame = new JFrame();
    JLabel welcomelabel = new JLabel("CREATE YOUR ACCOUNT HERE");
    JLabel background; 

    CreateAccount(LoginPage loginPage, HashMap<String,String> loginInfo) {
        this.loginPage = loginPage;
        this.loginInfo = loginInfo;
        ImageIcon backgroundImageIcon = new ImageIcon("signup.jpg");
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(500, 600, Image.SCALE_SMOOTH);
        ImageIcon resizedBackgroundImageIcon = new ImageIcon(backgroundImage);
        background = new JLabel(resizedBackgroundImageIcon);
        background.setBounds(0, 0, 500, 600);

        name.setBounds(50, 200, 200, 30);
        cms.setBounds(50, 250, 200, 30);
        semester.setBounds(50, 300, 200, 30);
        dept.setBounds(50, 350, 200, 30);
        password.setBounds(50, 400, 200, 30);

        sign.setBounds(300, 450, 100, 30);
        sign.setBackground(new Color(16, 76, 4)); 
        sign.setFocusable(false); 
        sign.setForeground(Color.WHITE);

        back.setBounds(10, 10, 100, 30); 
        back.setBackground(new Color(255, 0, 0)); 
        back.setFocusable(false); 
        back.setForeground(Color.WHITE);


        name.setForeground(Color.WHITE);
        cms.setForeground(Color.WHITE);
        semester.setForeground(Color.WHITE);
        dept.setForeground(Color.WHITE);
        password.setForeground(Color.WHITE);
        name.setFont(new Font(null, Font.BOLD, 20));
        cms.setFont(new Font(null, Font.BOLD, 20));
        semester.setFont(new Font(null, Font.BOLD, 20));
        dept.setFont(new Font(null, Font.BOLD, 20));
        password.setFont(new Font(null, Font.BOLD, 20));

        nameTextField.setBounds(250, 200, 150, 30);
        cmsTextField.setBounds(250, 250, 150, 30);
        semesterTextField.setBounds(250, 300, 150, 30);
        deptTextField.setBounds(250, 350, 150, 30);
        passwordTextField.setBounds(250, 400, 150, 30);

        welcomelabel.setFont(new Font(null, Font.BOLD, 22));
        welcomelabel.setBounds(50, 100, 500, 50);
        welcomelabel.setForeground(Color.WHITE);

        background.add(sign);
        background.add(back);
        background.add(cms);
        background.add(name);
        background.add(semester);
        background.add(dept);
        background.add(password);

        background.add(nameTextField);
        background.add(cmsTextField);
        background.add(semesterTextField);
        background.add(deptTextField);
        background.add(passwordTextField);

        background.add(welcomelabel);
        background.setLayout(null);
        ImageIcon icon = new ImageIcon("icon.png");
        Image logo = icon.getImage();
        frame.setIconImage(logo);

        frame.setContentPane(background);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("VoteEase");
        frame.setSize(500, 600);
        frame.setResizable(false);
        frame.setVisible(true);

        sign.addActionListener(this);
        back.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sign) {
            String userName = nameTextField.getText();
            String userCmsId = cmsTextField.getText();
            String userSemester = semesterTextField.getText();
            String userDept = deptTextField.getText();
            String userPassword = passwordTextField.getText();

            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

                String dbUrl = "jdbc:ucanaccess://D://OOP_Final_Project//VoteEase//VoteEase.accdb";
                Connection connection = DriverManager.getConnection(dbUrl);

                String insertQuery = "INSERT INTO users (username, cms_id, semester, department, password) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.setString(1, userName);
                preparedStatement.setString(2, userCmsId);
                preparedStatement.setString(3, userSemester);
                preparedStatement.setString(4, userDept);
                preparedStatement.setString(5, userPassword);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected <= 0) {
                    JOptionPane.showMessageDialog(frame, "Failed to create user!");
                }
                preparedStatement.close();
                connection.close();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(frame, "User created successfully!");
                    loginInfo.put(userName, userPassword);
                    frame.dispose();
                    LoginPage newLoginPage = new LoginPage(loginInfo);
                }
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        } else if (e.getSource() == back) {
            frame.dispose();
            loginPage = new LoginPage(idpassword.getLoginInfo());
        }
    }
}
