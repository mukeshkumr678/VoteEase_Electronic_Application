import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class SeePanel implements ActionListener {
    JFrame frame = new JFrame();
    JLabel welcomelabel = new JLabel("CANDIDATES");

    JButton back = new JButton("Back");
    JTable panelTable;
    JScrollPane scrollPane;
    JLabel background; 


    SeePanel() {
        welcomelabel.setFont(new Font(null, Font.BOLD, 30));
        welcomelabel.setBounds(400, 50, 400, 35);
        welcomelabel.setForeground(Color.WHITE);
        back.setBounds(10, 10, 100, 30);
        back.setBackground(new Color(255, 0, 0)); 
        back.setFocusable(false); 
        back.setForeground(Color.WHITE);
        back.addActionListener(this);

        ImageIcon backgroundImageIcon = new ImageIcon("black.jpg");
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
        ImageIcon resizedBackgroundImageIcon = new ImageIcon(backgroundImage);
        background = new JLabel(resizedBackgroundImageIcon); 
        background.setBounds(0, 0, 1000, 600);


        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String dbUrl = "jdbc:ucanaccess://D://OOP_Final_Project//VoteEase//VoteEase.accdb";
            Connection connection = DriverManager.getConnection(dbUrl);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PanelData");

            DefaultTableModel model = new DefaultTableModel(new String[]{"Team", "President", "Vice President", "Secretary", "Treasurer"}, 0);

            while (resultSet.next()) {
                String teamSymbol = resultSet.getString("TeamSymbol");
                String president = resultSet.getString("PresidentFirstName") + " " + resultSet.getString("PresidentLastName");
                String vicePresident = resultSet.getString("VicePresidentFirstName") + " " + resultSet.getString("VicePresidentLastName");
                String secretary = resultSet.getString("SecretaryFirstName") + " " + resultSet.getString("SecretaryLastName");
                String treasurer = resultSet.getString("TreasurerFirstName") + " " + resultSet.getString("TreasurerLastName");

                model.addRow(new Object[]{teamSymbol, president, vicePresident, secretary, treasurer});
            }

            panelTable = new JTable(model);
            panelTable.setFont(new Font(null, Font.PLAIN, 14)); 

            JTableHeader header = panelTable.getTableHeader();
            header.setFont(new Font(null, Font.BOLD, 16));

            scrollPane = new JScrollPane(panelTable);
            scrollPane.setBounds(50, 120, 900, 400); 
            background.add(scrollPane);

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        background.add(back);
        background.add(welcomelabel);
        ImageIcon icon = new ImageIcon("icon.png");
        Image logo = icon.getImage();
        frame.setIconImage(logo);


        frame.setContentPane(background);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("VoteEase");
        frame.setSize(1000, 600); 
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (back == e.getSource()) {
            frame.dispose();
            WelcomePage welcomepage = new WelcomePage();
        }
    }

}