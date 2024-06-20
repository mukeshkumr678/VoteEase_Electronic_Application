import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;

public class Panel implements ActionListener {
    JFrame frame = new JFrame();
    JLabel welcomelabel = new JLabel("PANEL CREATION DASHBOARD");

    JLabel team = new JLabel("Team Symbol");
    JLabel president = new JLabel("PRESIDENT");
    JLabel vpresident = new JLabel("VICE PRESIDENT");
    JLabel secretary = new JLabel("SECRETARY");
    JLabel treasurer = new JLabel("TREASURER");

    JLabel presidentfname = new JLabel("FirstName");
    JLabel presidentlname = new JLabel("LastName");
    JLabel presidentcms = new JLabel("CMS ID");
    JLabel presidentsemes = new JLabel("Semester");
    JLabel presidentgpa = new JLabel("GPA");
    JLabel presidentdep = new JLabel("Department");

    JLabel vpresidentfname = new JLabel("FirstName");
    JLabel vpresidentlname = new JLabel("LastName");
    JLabel vpresidentcms = new JLabel("CMS ID");
    JLabel vpresidentsemes = new JLabel("Semester");
    JLabel vpresidentgpa = new JLabel("GPA");
    JLabel vpresidentdep = new JLabel("Department");

    JLabel secretaryfname = new JLabel("FirstName");
    JLabel secretarylname = new JLabel("LastName");
    JLabel secretarycms = new JLabel("CMS ID");
    JLabel secretarysemes = new JLabel("Semester");
    JLabel secretarygpa = new JLabel("GPA");
    JLabel secretarydep = new JLabel("Department");

    JLabel treasurerfname = new JLabel("FirstName");
    JLabel treasurerlname = new JLabel("LastName");
    JLabel treasurercms = new JLabel("CMS ID");
    JLabel treasurersemes = new JLabel("Semester");
    JLabel treasurergpa = new JLabel("GPA");
    JLabel treasurerdep = new JLabel("Department");

    JTextField presidentfnametextfield = new JTextField();
    JTextField presidentlnametextfield = new JTextField();
    JTextField presidentcmstextfield = new JTextField();
    JTextField presidentsemestextfield = new JTextField();
    JTextField presidentgpatextfield = new JTextField();
    JTextField presidentdeptextfield = new JTextField();

    JTextField vpresidentfnametextfield = new JTextField();
    JTextField vpresidentlnametextfield = new JTextField();
    JTextField vpresidentcmstextfield = new JTextField();
    JTextField vpresidentsemestextfield = new JTextField();
    JTextField vpresidentgpatextfield = new JTextField();
    JTextField vpresidentdeptextfield = new JTextField();

    JTextField secretaryfnametextfield = new JTextField();
    JTextField secretarylnametextfield = new JTextField();
    JTextField secretarycmstextfield = new JTextField();
    JTextField secretarysemestextfield = new JTextField();
    JTextField secretarygpatextfield = new JTextField();
    JTextField secretarydeptextfield = new JTextField();

    JTextField treasurerfnametextfield = new JTextField();
    JTextField treasurerlnametextfield = new JTextField();
    JTextField treasurercmstextfield = new JTextField();
    JTextField treasurersemestextfield = new JTextField();
    JTextField treasurergpatextfield = new JTextField();
    JTextField treasurerdeptextfield = new JTextField();

    JTextField symbol = new JTextField();
    JButton backButton = new JButton("Back");
    JButton create = new JButton("Create");
    JLabel message = new JLabel();

    Panel() {

        team.setBounds(470, 150, 100, 35);
        team.setForeground(Color.WHITE);
        symbol.setBounds(560, 150, 100, 35);
        message.setBounds(1000, 600, 200, 30);

        president.setBounds(300, 200, 100, 40);
        vpresident.setBounds(790, 200, 200, 40);
        secretary.setBounds(300, 400, 100, 40);
        treasurer.setBounds(790, 400, 100, 40);

        presidentfname.setBounds(100, 250, 100, 35);
        presidentlname.setBounds(350, 250, 100, 35);
        presidentcms.setBounds(100, 290, 100, 35);
        presidentsemes.setBounds(350, 290, 100, 35);
        presidentgpa.setBounds(100, 330, 100, 35);
        presidentdep.setBounds(350, 330, 100, 35);

        vpresidentfname.setBounds(600, 250, 100, 35);
        vpresidentlname.setBounds(850, 250, 100, 35);
        vpresidentcms.setBounds(600, 290, 100, 35);
        vpresidentsemes.setBounds(850, 290, 100, 35);
        vpresidentgpa.setBounds(600, 330, 100, 35);
        vpresidentdep.setBounds(850, 330, 100, 35);

        secretaryfname.setBounds(100, 450, 100, 35);
        secretarylname.setBounds(350, 450, 100, 35);
        secretarycms.setBounds(100, 490, 100, 35);
        secretarysemes.setBounds(350, 490, 100, 35);
        secretarygpa.setBounds(100, 530, 100, 35);
        secretarydep.setBounds(350, 530, 100, 35);

        treasurerfname.setBounds(600, 450, 100, 35);
        treasurerlname.setBounds(850, 450, 100, 35);
        treasurercms.setBounds(600, 490, 100, 35);
        treasurersemes.setBounds(850, 490, 100, 35);
        treasurergpa.setBounds(600, 530, 100, 35);
        treasurerdep.setBounds(850, 530, 100, 35);

        presidentfnametextfield.setBounds(200, 250, 100, 27);
        presidentlnametextfield.setBounds(450, 250, 100, 27);
        presidentcmstextfield.setBounds(200, 290, 100, 27);
        presidentsemestextfield.setBounds(450, 290, 100, 27);
        presidentgpatextfield.setBounds(200, 330, 100, 27);
        presidentdeptextfield.setBounds(450, 330, 100, 27);

        vpresidentfnametextfield.setBounds(700, 250, 100, 27);
        vpresidentlnametextfield.setBounds(950, 250, 100, 27);
        vpresidentcmstextfield.setBounds(700, 290, 100, 27);
        vpresidentsemestextfield.setBounds(950, 290, 100, 27);
        vpresidentgpatextfield.setBounds(700, 330, 100, 27);
        vpresidentdeptextfield.setBounds(950, 330, 100, 27);

        secretaryfnametextfield.setBounds(200, 450, 100, 27);
        secretarylnametextfield.setBounds(450, 450, 100, 27);
        secretarycmstextfield.setBounds(200, 490, 100, 27);
        secretarysemestextfield.setBounds(450, 490, 100, 27);
        secretarygpatextfield.setBounds(200, 530, 100, 27);
        secretarydeptextfield.setBounds(450, 530, 100, 27);

        treasurerfnametextfield.setBounds(700, 450, 100, 27);
        treasurerlnametextfield.setBounds(950, 450, 100, 27);
        treasurercmstextfield.setBounds(700, 490, 100, 27);
        treasurersemestextfield.setBounds(950, 490, 100, 27);
        treasurergpatextfield.setBounds(700, 530, 100, 27);
        treasurerdeptextfield.setBounds(950, 530, 100, 27);

        presidentfname.setForeground(Color.WHITE);
        presidentlname.setForeground(Color.WHITE);
        presidentcms.setForeground(Color.WHITE);
        presidentsemes.setForeground(Color.WHITE);
        presidentgpa.setForeground(Color.WHITE);
        presidentdep.setForeground(Color.WHITE);

        vpresidentfname.setForeground(Color.WHITE);
        vpresidentlname.setForeground(Color.WHITE);
        vpresidentcms.setForeground(Color.WHITE);
        vpresidentsemes.setForeground(Color.WHITE);
        vpresidentgpa.setForeground(Color.WHITE);
        vpresidentdep.setForeground(Color.WHITE);

        secretaryfname.setForeground(Color.WHITE);
        secretarylname.setForeground(Color.WHITE);
        secretarycms.setForeground(Color.WHITE);
        secretarysemes.setForeground(Color.WHITE);
        secretarygpa.setForeground(Color.WHITE);
        secretarydep.setForeground(Color.WHITE);

        treasurerfname.setForeground(Color.WHITE);
        treasurerlname.setForeground(Color.WHITE);
        treasurercms.setForeground(Color.WHITE);
        treasurersemes.setForeground(Color.WHITE);
        treasurergpa.setForeground(Color.WHITE);
        treasurerdep.setForeground(Color.WHITE);

        create.setBounds(600, 600, 100, 35);
        create.setForeground(Color.BLACK);
        create.setBackground(new Color(16, 76, 4)); 
        create.setForeground(Color.WHITE);
        create.setFocusable(false);
        create.addActionListener(this);

        backButton.setBounds(450, 600, 100, 35);
        backButton.setBackground(new Color(255, 0, 0));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        president.setForeground(Color.WHITE);
        vpresident.setForeground(Color.WHITE);
        secretary.setForeground(Color.WHITE);
        treasurer.setForeground(Color.WHITE);

        welcomelabel.setFont(new Font(null, Font.BOLD, 35));
        frame.getContentPane().setBackground(Color.WHITE);
        welcomelabel.setBounds(340, 80, 600, 35);
        welcomelabel.setForeground(Color.white);

        frame.add(team);
        frame.add(symbol);
        frame.add(create);
        frame.add(backButton);

        frame.add(president);
        frame.add(vpresident);
        frame.add(secretary);
        frame.add(treasurer);

        frame.add(presidentfname);
        frame.add(presidentlname);
        frame.add(presidentcms);
        frame.add(presidentsemes);
        frame.add(presidentgpa);
        frame.add(presidentdep);

        frame.add(presidentfnametextfield);
        frame.add(presidentlnametextfield);
        frame.add(presidentcmstextfield);
        frame.add(presidentsemestextfield);
        frame.add(presidentgpatextfield);
        frame.add(presidentdeptextfield);

        frame.add(vpresidentfname);
        frame.add(vpresidentlname);
        frame.add(vpresidentcms);
        frame.add(vpresidentsemes);
        frame.add(vpresidentgpa);
        frame.add(vpresidentdep);

        frame.add(vpresidentfnametextfield);
        frame.add(vpresidentlnametextfield);
        frame.add(vpresidentcmstextfield);
        frame.add(vpresidentsemestextfield);
        frame.add(vpresidentgpatextfield);
        frame.add(vpresidentdeptextfield);

        frame.add(secretaryfname);
        frame.add(secretarylname);
        frame.add(secretarycms);
        frame.add(secretarysemes);
        frame.add(secretarygpa);
        frame.add(secretarydep);

        frame.add(secretaryfnametextfield);
        frame.add(secretarylnametextfield);
        frame.add(secretarycmstextfield);
        frame.add(secretarysemestextfield);
        frame.add(secretarygpatextfield);
        frame.add(secretarydeptextfield);

        frame.add(treasurerfname);
        frame.add(treasurerlname);
        frame.add(treasurercms);
        frame.add(treasurersemes);
        frame.add(treasurergpa);
        frame.add(treasurerdep);

        frame.add(treasurerfnametextfield);
        frame.add(treasurerlnametextfield);
        frame.add(treasurercmstextfield);
        frame.add(treasurersemestextfield);
        frame.add(treasurergpatextfield);
        frame.add(treasurerdeptextfield);

        frame.add(message);

        frame.add(welcomelabel);
        ImageIcon icon = new ImageIcon("icon.png");
        Image logo = icon.getImage();
        frame.setIconImage(logo);

        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("VoteEase");
        frame.setSize(1200, 700);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == create) {
           
            String teamSymbol = symbol.getText();
            String presidentFirstName = presidentfnametextfield.getText();
            String presidentLastName = presidentlnametextfield.getText();
            String presidentCmsId = presidentcmstextfield.getText();
            String presidentSemester = presidentsemestextfield.getText();
            String presidentGpa = presidentgpatextfield.getText();
            String presidentDepartment = presidentdeptextfield.getText();

            String vicePresidentFirstName = vpresidentfnametextfield.getText();
            String vicePresidentLastName = vpresidentlnametextfield.getText();
            String vicePresidentCmsId = vpresidentcmstextfield.getText();
            String vicePresidentSemester = vpresidentsemestextfield.getText();
            String vicePresidentGpa = vpresidentgpatextfield.getText();
            String vicePresidentDepartment = vpresidentdeptextfield.getText();

            String secretaryFirstName = secretaryfnametextfield.getText();
            String secretaryLastName = secretarylnametextfield.getText();
            String secretaryCmsId = secretarycmstextfield.getText();
            String secretarySemester = secretarysemestextfield.getText();
            String secretaryGpa = secretarygpatextfield.getText();
            String secretaryDepartment = secretarydeptextfield.getText();

            String treasurerFirstName = treasurerfnametextfield.getText();
            String treasurerLastName = treasurerlnametextfield.getText();
            String treasurerCmsId = treasurercmstextfield.getText();
            String treasurerSemester = treasurersemestextfield.getText();
            String treasurerGpa = treasurergpatextfield.getText();
            String treasurerDepartment = treasurerdeptextfield.getText();

            
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

                String dbUrl = "jdbc:ucanaccess://D://OOP_Final_Project//VoteEase//VoteEase.accdb";
                Connection connection = DriverManager.getConnection(dbUrl);

                String insertQuery = "INSERT INTO PanelData (TeamSymbol, PresidentFirstName, PresidentLastName, " +
                        "PresidentCmsId, PresidentSemester, PresidentGpa, PresidentDepartment, " +
                        "VicePresidentFirstName, VicePresidentLastName, VicePresidentCmsId, VicePresidentSemester, " +
                        "VicePresidentGpa, VicePresidentDepartment, SecretaryFirstName, SecretaryLastName, " +
                        "SecretaryCmsId, SecretarySemester, SecretaryGpa, SecretaryDepartment, TreasurerFirstName, " +
                        "TreasurerLastName, TreasurerCmsId, TreasurerSemester, TreasurerGpa, TreasurerDepartment) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.setString(1, teamSymbol);
                preparedStatement.setString(2, presidentFirstName);
                preparedStatement.setString(3, presidentLastName);
                preparedStatement.setString(4, presidentCmsId);
                preparedStatement.setString(5, presidentSemester);
                preparedStatement.setString(6, presidentGpa);
                preparedStatement.setString(7, presidentDepartment);
                preparedStatement.setString(8, vicePresidentFirstName);
                preparedStatement.setString(9, vicePresidentLastName);
                preparedStatement.setString(10, vicePresidentCmsId);
                preparedStatement.setString(11, vicePresidentSemester);
                preparedStatement.setString(12, vicePresidentGpa);
                preparedStatement.setString(13, vicePresidentDepartment);
                preparedStatement.setString(14, secretaryFirstName);
                preparedStatement.setString(15, secretaryLastName);
                preparedStatement.setString(16, secretaryCmsId);
                preparedStatement.setString(17, secretarySemester);
                preparedStatement.setString(18, secretaryGpa);
                preparedStatement.setString(19, secretaryDepartment);
                preparedStatement.setString(20, treasurerFirstName);
                preparedStatement.setString(21, treasurerLastName);
                preparedStatement.setString(22, treasurerCmsId);
                preparedStatement.setString(23, treasurerSemester);
                preparedStatement.setString(24, treasurerGpa);
                preparedStatement.setString(25, treasurerDepartment);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    message.setForeground(Color.GREEN);
                    message.setText("Panel created successfully!");
                } else {
                    message.setForeground(Color.RED);
                    message.setText("Failed to create panel!");
                }

                preparedStatement.close();
                connection.close();
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
                message.setForeground(Color.RED);
                message.setText("Error: " + ex.getMessage());
            }
        } else if (e.getSource() == backButton) {
            frame.dispose(); 
            WelcomePage welcomePage = new WelcomePage(); 
        }
    }

}
