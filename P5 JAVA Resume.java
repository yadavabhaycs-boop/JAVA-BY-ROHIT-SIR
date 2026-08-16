import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class P5_Resume extends JFrame implements ActionListener {

    JTextField nameField, dobField, emailField, phoneField;
    JTextArea addressArea, summaryArea;

    JRadioButton male, female, other;
    ButtonGroup genderGroup;

    JComboBox<String> educationBox;

    JCheckBox java, python, cpp, html;

    JButton submitButton, clearButton;

    public P5_Resume() {

        setTitle("My Resume");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(190, 255, 190));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel title = new JLabel("My Resume (S120)");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setHorizontalAlignment(JLabel.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(title, gbc);

        // Name
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(new JLabel("Full Name:"), gbc);

        nameField = new JTextField(20);
        gbc.gridx = 1;
        mainPanel.add(nameField, gbc);

        // Gender
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(new JLabel("Gender:"), gbc);

        JPanel genderPanel = new JPanel();
        genderPanel.setBackground(new Color(190, 255, 190));

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");

        genderPanel.add(male);
        genderPanel.add(female);
        genderPanel.add(other);

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        gbc.gridx = 1;
        mainPanel.add(genderPanel, gbc);

        // Date of Birth
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(new JLabel("Date of Birth:"), gbc);

        dobField = new JTextField();
        gbc.gridx = 1;
        mainPanel.add(dobField, gbc);

        // Email
        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(new JLabel("Email:"), gbc);

        emailField = new JTextField();
        gbc.gridx = 1;
        mainPanel.add(emailField, gbc);

        // Phone
        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(new JLabel("Phone Number:"), gbc);

        phoneField = new JTextField();
        gbc.gridx = 1;
        mainPanel.add(phoneField, gbc);

        // Address
        gbc.gridx = 0;
        gbc.gridy = 6;
        mainPanel.add(new JLabel("Address:"), gbc);

        addressArea = new JTextArea(3, 20);
        gbc.gridx = 1;
        mainPanel.add(new JScrollPane(addressArea), gbc);

        // Education
        gbc.gridx = 0;
        gbc.gridy = 7;
        mainPanel.add(new JLabel("Education:"), gbc);

        String[] education = {
            "High School",
            "Diploma",
            "BSc",
            "BCA",
            "MCA",
            "MSc"
        };

        educationBox = new JComboBox<>(education);

        gbc.gridx = 1;
        mainPanel.add(educationBox, gbc);

        // Skills
        gbc.gridx = 0;
        gbc.gridy = 8;
        mainPanel.add(new JLabel("Skills:"), gbc);

        JPanel skillsPanel = new JPanel();
        skillsPanel.setBackground(new Color(190, 255, 190));

        java = new JCheckBox("Java");
        python = new JCheckBox("Python");
        cpp = new JCheckBox("C++");
        html = new JCheckBox("HTML");

        skillsPanel.add(java);
        skillsPanel.add(python);
        skillsPanel.add(cpp);
        skillsPanel.add(html);

        gbc.gridx = 1;
        mainPanel.add(skillsPanel, gbc);

        // Resume Summary
        gbc.gridx = 0;
        gbc.gridy = 9;
        mainPanel.add(new JLabel("Resume Summary:"), gbc);

        summaryArea = new JTextArea(4, 20);

        gbc.gridx = 1;
        mainPanel.add(new JScrollPane(summaryArea), gbc);

        // Buttons
        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");

        submitButton.setBackground(Color.GREEN);
        clearButton.setBackground(Color.PINK);

        submitButton.addActionListener(this);
        clearButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(190, 255, 190));

        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);

        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;

        mainPanel.add(buttonPanel, gbc);

        add(mainPanel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitButton) {

            String gender = "";

            if (male.isSelected())
                gender = "Male";
            else if (female.isSelected())
                gender = "Female";
            else if (other.isSelected())
                gender = "Other";

            String skills = "";

            if (java.isSelected())
                skills += "Java ";

            if (python.isSelected())
                skills += "Python ";

            if (cpp.isSelected())
                skills += "C++ ";

            if (html.isSelected())
                skills += "HTML ";

            String message =
                    "Resume Submitted Successfully!\n\n" +
                    "Name: " + nameField.getText() + "\n" +
                    "Gender: " + gender + "\n" +
                    "DOB: " + dobField.getText() + "\n" +
                    "Email: " + emailField.getText() + "\n" +
                    "Phone: " + phoneField.getText() + "\n" +
                    "Address: " + addressArea.getText() + "\n" +
                    "Education: " + educationBox.getSelectedItem() + "\n" +
                    "Skills: " + skills + "\n" +
                    "Summary: " + summaryArea.getText();

            JOptionPane.showMessageDialog(
                    this,
                    message,
                    "Resume Submitted",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }

        if (e.getSource() == clearButton) {

            nameField.setText("");
            dobField.setText("");
            emailField.setText("");
            phoneField.setText("");
            addressArea.setText("");
            summaryArea.setText("");

            genderGroup.clearSelection();

            java.setSelected(false);
            python.setSelected(false);
            cpp.setSelected(false);
            html.setSelected(false);

            educationBox.setSelectedIndex(0);
        }
    }

    public static void main(String[] args) {
        new P5_Resume();
    }
}
