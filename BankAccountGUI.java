import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class BankAccount {

    // Data Members
    private String accountHolder;
    private long accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder,
                       long accountNumber,
                       double balance) {

        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Deposit Method
    public String deposit(double amount) {

        balance += amount;

        return "₹" + amount + " Deposited Successfully!";
    }

    // Withdraw Method
    public String withdraw(double amount) {

        if (amount <= balance) {

            balance -= amount;

            return "₹" + amount + " Withdrawn Successfully!";

        } else {

            return "Insufficient Balance!";
        }
    }

    // Display Account Details
    public String displayBalance() {

        return 
                "Account Holder : " + accountHolder + "\n" +
                "Account Number : " + accountNumber + "\n" +
                "Current Balance: ₹" + balance;
    }
}

public class BankAccountGUI extends JFrame implements ActionListener {

    JLabel titleLabel, nameLabel, accLabel,
            balanceLabel, amountLabel;

    JTextField nameField, accField,
            balanceField, amountField;

    JButton createButton, depositButton,
            withdrawButton, displayButton;

    JTextArea resultArea;

    BankAccount account;

    public BankAccountGUI() {

        // Frame Settings
        setTitle("Bank Account System");
        setSize(600, 650);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(230, 240, 255));

        // Heading
        titleLabel = new JLabel("BANK ACCOUNT SYSTEM");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(140, 20, 350, 30);
        add(titleLabel);

        // Account Holder
        nameLabel = new JLabel("Account Holder:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        nameLabel.setBounds(50, 90, 150, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(220, 90, 250, 30);
        add(nameField);

        // Account Number
        accLabel = new JLabel("Account Number:");
        accLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        accLabel.setBounds(50, 140, 150, 25);
        add(accLabel);

        accField = new JTextField();
        accField.setBounds(220, 140, 250, 30);
        add(accField);

        // Initial Balance
        balanceLabel = new JLabel("Initial Balance:");
        balanceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        balanceLabel.setBounds(50, 190, 150, 25);
        add(balanceLabel);

        balanceField = new JTextField();
        balanceField.setBounds(220, 190, 250, 30);
        add(balanceField);

        // Create Button
        createButton = new JButton("Create Account");
        createButton.setBounds(180, 250, 180, 40);
        createButton.setFont(new Font("Arial", Font.BOLD, 16));
        createButton.addActionListener(this);
        add(createButton);

        // Amount Label
        amountLabel = new JLabel("Enter Amount:");
        amountLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        amountLabel.setBounds(50, 330, 150, 25);
        add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(220, 330, 250, 30);
        add(amountField);

        // Deposit Button
        depositButton = new JButton("Deposit");
        depositButton.setBounds(60, 390, 130, 40);
        depositButton.setFont(new Font("Arial", Font.BOLD, 15));
        depositButton.addActionListener(this);
        add(depositButton);

        // Withdraw Button
        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(220, 390, 130, 40);
        withdrawButton.setFont(new Font("Arial", Font.BOLD, 15));
        withdrawButton.addActionListener(this);
        add(withdrawButton);

        // Display Button
        displayButton = new JButton("Display Balance");
        displayButton.setBounds(390, 390, 150, 40);
        displayButton.setFont(new Font("Arial", Font.BOLD, 15));
        displayButton.addActionListener(this);
        add(displayButton);

        // Result Area
        resultArea = new JTextArea();
        resultArea.setBounds(50, 470, 490, 100);
        resultArea.setFont(new Font("Monospaced", Font.BOLD, 16));
        resultArea.setEditable(false);
        add(resultArea);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            // Create Account
            if (e.getSource() == createButton) {

                String name = nameField.getText();

                long accNo = Long.parseLong(accField.getText());

                double balance =
                        Double.parseDouble(balanceField.getText());

                account = new BankAccount(name, accNo, balance);

                resultArea.setText(
                        "Bank Account Created Successfully!");
            }

            // Deposit
            else if (e.getSource() == depositButton) {

                if (account != null) {

                    double amount =
                            Double.parseDouble(amountField.getText());

                    resultArea.setText(account.deposit(amount));

                } else {

                    resultArea.setText(
                            "Please Create Account First!");
                }
            }

            // Withdraw
            else if (e.getSource() == withdrawButton) {

                if (account != null) {

                    double amount =
                            Double.parseDouble(amountField.getText());

                    resultArea.setText(account.withdraw(amount));

                } else {

                    resultArea.setText(
                            "Please Create Account First!");
                }
            }

            // Display Balance
            else if (e.getSource() == displayButton) {

                if (account != null) {

                    resultArea.setText(
                            account.displayBalance());

                } else {

                    resultArea.setText(
                            "Please Create Account First!");
                }
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this,
                    "Please Enter Valid Details!");
        }
    }

    public static void main(String[] args) {

        new BankAccountGUI();
    }
}