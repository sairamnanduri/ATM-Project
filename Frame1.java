import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.FlowLayout;

import javax.swing.JButton;

public class Frame1 extends JFrame implements ActionListener, java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private JPanel cards;
	private JPanel contentPane;
	private JPanel secondPane;
	private JPanel thirdPane;
	private JPanel fourthPane;
	private JTextField textField;
	private JTextField textField_1;
    public static final int SMALL_WIDTH = 200; //for confirm window
    public static final int SMALL_HEIGHT = 100;//for confirm window
    public static Account accountUsed = new Account();
    public static Account createdAccount = new Account();
	public CardLayout cardLayout = new CardLayout();
	private JTextField textFieldAcctTransfer;
	private JTextField textFieldAmntTransfer;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

    private class CheckOnExit implements WindowListener
    {
        public void windowOpened(WindowEvent e)
        {}

        public void windowClosing(WindowEvent e)
        {
            ConfirmWindow checkers = new ConfirmWindow();
            checkers.setVisible(true);
        }

        public void windowClosed(WindowEvent e)
        {}

        public void windowIconified(WindowEvent e)
        {}

         public void windowDeiconified(WindowEvent e)
        {}

        public void windowActivated(WindowEvent e)
        {}

        public void windowDeactivated(WindowEvent e)
        {}
    } //End of inner class CheckOnExit

    private class ConfirmWindow extends JFrame implements ActionListener
    {
		private static final long serialVersionUID = 1L;

		public ConfirmWindow()
        {
            setSize(SMALL_WIDTH, SMALL_HEIGHT);
            setLayout(new BorderLayout());

            JLabel confirmLabel = new JLabel("Are you sure you want to exit?");
            add(confirmLabel, BorderLayout.CENTER);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout());

            JButton exitButton = new JButton("Yes");
            exitButton.addActionListener(this);
            buttonPanel.add(exitButton);

            JButton cancelButton = new JButton("No");
            cancelButton.addActionListener(this);
            buttonPanel.add(cancelButton);

            add(buttonPanel, BorderLayout.SOUTH);
        }

        public void actionPerformed(ActionEvent e) 
        {
            String actionCommand = e.getActionCommand( );

            if (actionCommand.equals("Yes")) 
                System.exit(0);
            else if (actionCommand.equals("No"))
                dispose();//Destroys only the ConfirmWindow.
            else
                System.out.println("Unexpected Error in Confirm Window.");
        }
    } //End of inner class ConfirmWindow

	public static void main(String[] args) {
		 EventQueue.invokeLater(new Runnable() {
	        public void run() {
		Frame1 demoWindow = new Frame1( );
        demoWindow.setVisible(true);
	        }
		 });
	}
	public Frame1(){
		setTitle("ATM Machine");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new CheckOnExit());
		setBounds(100, 100, 450, 300);
		cards = new JPanel();
		cards.setLayout(cardLayout);
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Account Name:");
		lblNewLabel_1.setBounds(58, 91, 97, 14);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setBounds(58, 116, 88, 23);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(190, 88, 160, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCreateNew = new JButton("Create New");
		btnCreateNew.setBounds(234, 150, 116, 23);
		contentPane.add(btnCreateNew);
		btnCreateNew.addActionListener(this);
		
		textField_1 = new JTextField();
		textField_1.setBounds(190, 113, 160, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(58, 150, 97, 23);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(this);
		
		secondPane = new JPanel();
		secondPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		secondPane.setLayout(null);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(this);
		btnDeposit.setBounds(48, 47, 150, 23);
		secondPane.add(btnDeposit);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setBounds(237, 47, 150, 23);
		btnWithdraw.addActionListener(this);
		secondPane.add(btnWithdraw);
		
		JButton btnCheckBalance = new JButton("Check Balance");
		btnCheckBalance.setBounds(48, 106, 150, 23);
		btnCheckBalance.addActionListener(this);
		secondPane.add(btnCheckBalance);
		
		JButton btnTransfer = new JButton("Make a Transfer");
		btnTransfer.setBounds(237, 106, 150, 23);
		btnTransfer.addActionListener(this);
		secondPane.add(btnTransfer);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(237, 173, 150, 23);
		btnLogout.addActionListener(this);
		secondPane.add(btnLogout);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBounds(48, 173, 150, 23);
		btnChangePassword.addActionListener(this);
		secondPane.add(btnChangePassword);
		
		thirdPane = new JPanel();
		thirdPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		thirdPane.setLayout(null);
		
		textFieldAcctTransfer = new JTextField();
		textFieldAcctTransfer.setBounds(205, 61, 132, 20);
		thirdPane.add(textFieldAcctTransfer);
		textFieldAcctTransfer.setColumns(10);
		
		textFieldAmntTransfer = new JTextField();
		textFieldAmntTransfer.setBounds(205, 112, 132, 20);
		thirdPane.add(textFieldAmntTransfer);
		textFieldAmntTransfer.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(248, 187, 89, 23);
		btnBack.addActionListener(this);
		thirdPane.add(btnBack);
		
		JButton btnMake_Transfer = new JButton("Transfer");
		btnMake_Transfer.setBounds(60, 187, 89, 23);
		btnMake_Transfer.addActionListener(this);
		thirdPane.add(btnMake_Transfer);
		
		JLabel lblEnterAccountNumber = new JLabel("Enter Account Number");
		lblEnterAccountNumber.setBounds(60, 64, 124, 14);
		thirdPane.add(lblEnterAccountNumber);
		
		JLabel lblEnterAmountTo = new JLabel("Enter Amount to Transfer");
		lblEnterAmountTo.setBounds(60, 115, 135, 14);
		thirdPane.add(lblEnterAmountTo);
		
		fourthPane = new JPanel();
		fourthPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		fourthPane.setLayout(null);
		
		JLabel lblEnterAccountName = new JLabel("Enter Account Name:");
		lblEnterAccountName.setBounds(57, 69, 122, 14);
		fourthPane.add(lblEnterAccountName);
		
		JLabel lblEnterPassword = new JLabel("Enter Password:");
		lblEnterPassword.setBounds(57, 104, 122, 14);
		fourthPane.add(lblEnterPassword);
		
		JLabel lblEnterYourName = new JLabel("Enter Your Name:");
		lblEnterYourName.setBounds(57, 144, 122, 14);
		fourthPane.add(lblEnterYourName);
		
		textField_2 = new JTextField();
		textField_2.setBounds(216, 66, 141, 20);
		fourthPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(216, 101, 141, 20);
		fourthPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(216, 141, 141, 20);
		fourthPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(57, 204, 89, 23);
		btnCreate.addActionListener(this);
		fourthPane.add(btnCreate);
		
		JButton btnBack_1 = new JButton("Back to login");
		btnBack_1.setBounds(235, 204, 122, 23);
		btnBack_1.addActionListener(this);
		fourthPane.add(btnBack_1);
		
		getContentPane().add(cards);
		cards.add(contentPane, "Login");
		cards.add(secondPane, "Interact");
		cards.add(thirdPane, "Transfer");
		cards.add(fourthPane, "New Account");
				
	}
	public void actionPerformed(ActionEvent e)
	{
		String buttonString = e.getActionCommand();
		if(buttonString.equals("Create New"))
		{
			cardLayout.show(cards, "New Account");
		}
		else if(buttonString.equals("Login"))
		{
			FileReader fopen;
			BufferedReader opened;
			Account a = null;
			String readAccountName, readPassword, readName;
			double readBalance;
			boolean readActive;
			try
			{
				String fileName = "" + textField.getText() + ".txt";
		        fopen = new FileReader(fileName);
		        opened = new BufferedReader(fopen);
		        readAccountName = opened.readLine();
		        readPassword = opened.readLine();
				opened.close();
				fopen.close();
			}catch(IOException i)
			{
				i.printStackTrace();
				return;
			}
			a = new Account(readAccountName, readPassword);
			String accountPassword = a.getpassword();
			String userPassword = textField_1.getText();
			if (accountPassword.equals(userPassword))
			{
				try
				{
					String fileName = "" + textField.getText() + "full.txt";
			        fopen = new FileReader(fileName);
			        opened = new BufferedReader(fopen);
			        readAccountName = opened.readLine();
			        readName = opened.readLine();
			        readBalance = Double.parseDouble(opened.readLine());
			        readActive = Boolean.valueOf(opened.readLine());
					opened.close();
					fopen.close();
				}catch(IOException i)
				{
					i.printStackTrace();
					return;
				}
				accountUsed = new Account(readAccountName,readPassword, readName, readBalance, readActive);
			    textField.setText("");
			    textField_1.setText("");
				cardLayout.show(cards, "Interact");
			}
			else
			{
			    textField.setText("");
			    textField_1.setText("");
				JOptionPane.showMessageDialog(null, "Incorrect Password");
			}

		}
		else if(buttonString.equals("Logout"))
		{
			PrintWriter outputStreamLogout = null;
			try
			{
				String fileName = "" + accountUsed.getusername() + "full.txt";
				outputStreamLogout = new PrintWriter(new FileOutputStream(fileName));
			}
			catch(FileNotFoundException e1)
			{
				System.out.println("Error opening the one or more of the files.");
			}
			outputStreamLogout.println(accountUsed.getusername());
			outputStreamLogout.println(accountUsed.getname());
			outputStreamLogout.println(accountUsed.getbalance());
			outputStreamLogout.println(accountUsed.getactive());
			outputStreamLogout.close();
		    textField.setText("");
		    textField_1.setText("");
			cardLayout.show(cards, "Login");
		}
		else if(buttonString.equals("Deposit"))
		{
			String userDeposit = JOptionPane.showInputDialog(null, "Please enter the amount you wish to deposit");
			double deposit = Double.parseDouble(userDeposit);
			double currentBalance = accountUsed.getbalance();
			double newBalance = deposit + currentBalance;
			accountUsed.setBalance(newBalance);
			System.out.println(deposit);
			System.out.println(currentBalance);
			System.out.println(accountUsed.getbalance());
			PrintWriter outputStreamDeposit = null;
			try
			{
				String fileName = "" + accountUsed.getusername() + "full.txt";
				outputStreamDeposit = new PrintWriter(new FileOutputStream(fileName));
			}
			catch(FileNotFoundException e1)
			{
				System.out.println("Error opening the one or more of the files.");
			}
			outputStreamDeposit.println(accountUsed.getusername());
			outputStreamDeposit.println(accountUsed.getname());
			outputStreamDeposit.println(accountUsed.getbalance());
			outputStreamDeposit.println(accountUsed.getactive());
			outputStreamDeposit.close();
		}
		else if(buttonString.equals("Withdraw"))
		{
			String userWithdraw = JOptionPane.showInputDialog(null, "Please enter the amount you wish to withdraw");
			double withdraw = Double.parseDouble(userWithdraw);
			double currentBalance = accountUsed.getbalance();
			double newBalance = currentBalance - withdraw;
			if(newBalance >= 0)
			{
				accountUsed.setBalance(newBalance);
				System.out.println(withdraw);
				System.out.println(currentBalance);
				System.out.println(accountUsed.getbalance());
				PrintWriter outputStreamWithdrawal = null;
				try
				{
					String fileName = "" + accountUsed.getusername() + "full.txt";
					outputStreamWithdrawal = new PrintWriter(new FileOutputStream(fileName));
				}
				catch(FileNotFoundException e1)
				{
					System.out.println("Error opening the one or more of the files.");
				}
				outputStreamWithdrawal.println(accountUsed.getusername());
				outputStreamWithdrawal.println(accountUsed.getname());
				outputStreamWithdrawal.println(accountUsed.getbalance());
				outputStreamWithdrawal.println(accountUsed.getactive());
				outputStreamWithdrawal.close();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Overdraw will occur, stopping the withdraw");
			}
		}
		else if(buttonString.equals("Check Balance"))
		{
			String out = "" + accountUsed.getbalance();
			JOptionPane.showMessageDialog(null, "The current balance is " + out);
		}
		else if(buttonString.equals("Make a Transfer"))
		{
			cardLayout.show(cards, "Transfer");
		}
		else if(buttonString.equals("Change Password"))
		{
			Account newPasswordAccount = null;
			String carriedAccountName = accountUsed.getusername();
			String newPassword = JOptionPane.showInputDialog(null, "Please enter the new password you want to use.");
			newPasswordAccount = new Account(carriedAccountName, newPassword);		
			PrintWriter outputStreamChangePassword = null;
			try
			{
				String fileName = "" + newPasswordAccount.getusername() + ".txt";
				outputStreamChangePassword = new PrintWriter(new FileOutputStream(fileName));
			}
			catch(FileNotFoundException e1)
			{
				System.out.println("Error opening the one or more of the files.");
			}
			outputStreamChangePassword.println(newPasswordAccount.getusername());
			outputStreamChangePassword.println(newPasswordAccount.getpassword());
			outputStreamChangePassword.close();
		}
		else if(buttonString.equals("Transfer"))
		{
			String userTransfer = textFieldAmntTransfer.getText();
			double transferAmount = Double.parseDouble(userTransfer);
			double afterTransfer = accountUsed.getbalance() - transferAmount;
			if(afterTransfer >= 0)
			{
				accountUsed.setBalance(afterTransfer);
				String readAccountNameT, readNameT;
				double readBalanceT;
				boolean readActiveT;
				FileReader fopenT;
				BufferedReader openedT;
				try
				{
					String fileName = "" + textFieldAcctTransfer.getText() + "full.txt";
			        fopenT = new FileReader(fileName);
			        openedT = new BufferedReader(fopenT);
			        readAccountNameT = openedT.readLine();
			        readNameT = openedT.readLine();
			        readBalanceT = Double.parseDouble(openedT.readLine());
			        readActiveT = Boolean.valueOf(openedT.readLine());
					openedT.close();
					fopenT.close();
				}catch(IOException i)
				{
					i.printStackTrace();
					return;
				}
				Account accountTransfer = new Account(readAccountNameT, readNameT, readBalanceT, readActiveT);
				double transferBalance = accountTransfer.getbalance() + transferAmount;
				accountTransfer.setBalance(transferBalance);
				PrintWriter outputStreamTransfer= null;
				try
				{
					String fileName = "" + accountTransfer.getusername() + "full.txt";
					outputStreamTransfer = new PrintWriter(new FileOutputStream(fileName));
				}
				catch(FileNotFoundException e1)
				{
					System.out.println("Error opening the one or more of the files.");
				}
				outputStreamTransfer.println(accountTransfer.getusername());
				outputStreamTransfer.println(accountTransfer.getname());
				outputStreamTransfer.println(accountTransfer.getbalance());
				outputStreamTransfer.println(accountTransfer.getactive());
				outputStreamTransfer.close();
				textFieldAmntTransfer.setText("");
				textFieldAcctTransfer.setText("");
				PrintWriter outputStreamTransfer1 = null;
				try
				{
					String fileName = "" + accountUsed.getusername() + "full.txt";
					outputStreamTransfer1 = new PrintWriter(new FileOutputStream(fileName));
				}
				catch(FileNotFoundException e1)
				{
					System.out.println("Error opening the one or more of the files.");
				}
				outputStreamTransfer1.println(accountUsed.getusername());
				outputStreamTransfer1.println(accountUsed.getname());
				outputStreamTransfer1.println(accountUsed.getbalance());
				outputStreamTransfer1.println(accountUsed.getactive());
				outputStreamTransfer1.close();
				cardLayout.show(cards, "Interact");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Overdraw will occur, stopping the withdraw");
				textFieldAmntTransfer.setText("");
			}
			
		}
		else if(buttonString.equals("Create"))
		{
			createdAccount = new Account(textField_2.getText(),textField_3.getText(),textField_4.getText() );
			PrintWriter outputStream = null;
			PrintWriter outputStream1 = null;
			try
			{
				String fileName = "" + textField_2.getText() + ".txt";
				outputStream = new PrintWriter(new FileOutputStream(fileName));
			}
			catch(FileNotFoundException e1)
			{
				System.out.println("Error opening the one or more of the files.");
			}
			outputStream.println(createdAccount.getusername());
			outputStream.println(createdAccount.getpassword());
			try
			{
				String fileName = "" + textField_2.getText() + "full.txt";
				outputStream1 = new PrintWriter(new FileOutputStream(fileName));
			}
			catch(FileNotFoundException e1)
			{
				System.out.println("Error opening the one or more of the files.");
			}
			outputStream1.println(createdAccount.getusername());
			outputStream1.println(createdAccount.getname());
			outputStream1.println(createdAccount.getbalance());
			outputStream1.println(createdAccount.getactive());
			outputStream.close();
			outputStream1.close();
		    textField_2.setText("");
		    textField_3.setText("");
		    textField_4.setText("");
			cardLayout.show(cards, "Login");
		}
		else if(buttonString.equals("Back to login"))
		{
			cardLayout.show(cards,"Login");
		}
		else if (buttonString.equals("Back"))
		{
			textFieldAmntTransfer.setText("");
			textFieldAcctTransfer.setText("");
			cardLayout.show(cards, "Interact");
		}
		}
	}
