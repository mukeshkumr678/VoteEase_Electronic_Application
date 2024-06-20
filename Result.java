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

public class Result implements ActionListener {
    JFrame frame = new JFrame();
    JLabel resultboard = new JLabel("RESULTS");
    JTextField winnerTextField = new JTextField();
    JButton logoutButton = new JButton("Main Page");
    Idpassword idpassword = new Idpassword();

    JTable resultTable;
    JScrollPane scrollPane;

    Result() {
        logoutButton.setBounds(8, 8, 100, 25); 
        logoutButton.setFocusable(false);
        logoutButton.setBackground(new Color(255, 0, 0)); 
        logoutButton.setForeground(Color.WHITE); 
        logoutButton.addActionListener(this);

        frame.setLayout(null);
        resultboard.setFont(new Font(null, Font.BOLD, 25)); 
        resultboard.setBounds(440, 50, 400, 30); 
        resultboard.setForeground(Color.WHITE);

        winnerTextField.setBounds(50, 100, 900, 40);
        winnerTextField.setEditable(false);
        winnerTextField.setFocusable(false); 
        winnerTextField.setFont(new Font(null, Font.BOLD, 18));
        winnerTextField.setHorizontalAlignment(JTextField.CENTER); 

        frame.getContentPane().setBackground(Color.DARK_GRAY);

        ImageIcon icon = new ImageIcon("icon.png");
        frame.setIconImage(icon.getImage());

        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600); 
        frame.setTitle("VoteEase");
        frame.setResizable(false); 
        frame.setVisible(true);

        try {
            String dbUrl = "jdbc:ucanaccess://D://OOP_Final_Project//VoteEase//VoteEase.accdb";
            Connection connection = DriverManager.getConnection(dbUrl);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT TeamSymbol, Votes FROM PanelData ORDER BY Votes DESC");

            DefaultTableModel model = new DefaultTableModel(new String[]{"Team Symbol", "Votes"}, 0);
            while (resultSet.next()) {
                String teamSymbol = resultSet.getString("TeamSymbol");
                int votes = resultSet.getInt("Votes");
                model.addRow(new Object[]{teamSymbol, votes});
            }
            resultTable = new JTable(model);
            resultTable.setFont(new Font(null, Font.PLAIN, 14));

            JTableHeader header = resultTable.getTableHeader();
            header.setFont(new Font(null, Font.BOLD, 16));

            scrollPane = new JScrollPane(resultTable);
            scrollPane.setBounds(50, 150, 900, 350); 
            frame.add(resultboard);
            frame.add(winnerTextField);
            frame.add(scrollPane);
            frame.add(logoutButton);

            if (model.getRowCount() > 0) {
                String winnerTeamSymbol = (String) model.getValueAt(0, 0); 
                int winnerVotes = (int) model.getValueAt(0, 1); 
                winnerTextField.setText("Winner Team: " + winnerTeamSymbol + " (Votes: " + winnerVotes + ")");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logoutButton) {
            frame.dispose();
            LoginPage loginPage = new LoginPage(idpassword.getLoginInfo());
        }
    }
}
