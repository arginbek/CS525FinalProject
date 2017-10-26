package edu.mum.cs.cs525.labs.exercises.project.ui.ccard;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import edu.mum.cs.cs525.labs.exercises.project.creditcard.CreditCardAccountService;
import edu.mum.cs.cs525.labs.exercises.project.creditcard.CreditCardCreateAccountTO;
import edu.mum.cs.cs525.labs.exercises.project.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.framework.AccountDAO;
import edu.mum.cs.cs525.labs.exercises.project.framework.AccountDAOImpl;
import edu.mum.cs.cs525.labs.exercises.project.framework.AccountService;
import edu.mum.cs.cs525.labs.exercises.project.framework.AccountServiceImpl;
import edu.mum.cs.cs525.labs.exercises.project.framework.AccountType;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.*;

/**
 * A basic JFC based application.
 */
public class CardFrm extends MainFrm {
	/****
	 * init variables in the object
	 ****/
	String expdate, ccnumber, email, description, cardType;
	boolean newaccount;
	CardFrm myframe;

	// javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	javax.swing.JButton JButton_NewCCAccount = new javax.swing.JButton();
	javax.swing.JButton JButton_GenBill = new javax.swing.JButton();

	public CardFrm() {
		super();
		myframe = this;

		setTitle("Credit-card processing Application.");

		model = new DefaultTableModel();
		model.addColumn("Name");
		model.addColumn("CC number");
		model.addColumn("Exp date");
		model.addColumn("Type");
		model.addColumn("Balance");
		rowdata = new Object[7];
		newaccount = false;
		JTable1 = new JTable(model);

		JPanel1.add(JScrollPane1);
		// JScrollPane1.setBounds(12,92,444,160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);
		// rowdata = new Object[8];

		JButton_NewCCAccount.setText("Add Credit-card account");
		JPanel1.add(JButton_NewCCAccount);
		JButton_NewCCAccount.setBounds(24, 20, 192, 33);
		JButton_GenBill.setText("Generate Monthly bills");
		JButton_GenBill.setActionCommand("jbutton");
		JPanel1.add(JButton_GenBill);
		JButton_GenBill.setBounds(240, 20, 192, 33);
		JButton_Withdraw.setText("Charge");

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_NewCCAccount.addActionListener(lSymAction);
		JButton_GenBill.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);

	}

	/*****************************************************
	 * The entry point for this application. Sets the Look and Feel to the System
	 * Look and Feel. Creates a new JFrame1 and makes it visible.
	 *****************************************************/
	static public void main(String args[]) {
		try {
			// Add the following code if you want the Look and Feel
			// to be set to the Look and Feel of the native system.

			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
			}

			// Create a new instance of our application's frame, and make it visible.
			(new CardFrm()).setVisible(true);
		} catch (Throwable t) {
			t.printStackTrace();
			// Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

	protected void exitApplication() {
		try {
			this.setVisible(false); // hide the Frame
			this.dispose(); // free the system resources
			System.exit(0); // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent event) {
			Object object = event.getSource();
			if (object == CardFrm.this)
				BankFrm_windowClosing(event);
		}
	}

	void BankFrm_windowClosing(java.awt.event.WindowEvent event) {
		// to do: code goes here.

		BankFrm_windowClosing_Interaction1(event);
	}

	void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(event);
			else if (object == JButton_NewCCAccount)
				JButtonNewCCAC_actionPerformed(event);
			else if (object == JButton_GenBill)
				JButtonGenerateBill_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);

		}
	}

	void JButtonNewCCAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 * JDialog_AddPAcc type object is for adding personal information construct a
		 * JDialog_AddPAcc type object set the boundaries and show it
		 */

		JDialog_AddCCAccount ccac = new JDialog_AddCCAccount(myframe);
		ccac.setBounds(450, 20, 300, 380);
		ccac.show();

		if (newaccount) {
			// add row to table
			rowdata[0] = clientName;
			rowdata[1] = ccnumber;
			rowdata[2] = expdate;
			rowdata[3] = accountType;
			rowdata[4] = "0";
			System.out.println(rowdata);
			CreditCardCreateAccountTO cardInfo = new CreditCardCreateAccountTO();
			cardInfo.setAccountNumber(ccnumber);
			cardInfo.setAccountType(accountType == "Personal" ? AccountType.personal : AccountType.company);
			cardInfo.setName(clientName);
			cardInfo.setInterestType(cardType);
			cardInfo.setEmail(email);
			cardInfo.setExpDate(LocalDate.parse(expdate));
			AccountServiceImpl obj = new CreditCardAccountService();
			obj.createAccount(cardInfo);
			model.addRow(rowdata);
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			newaccount = false;
		}
	}

	void JButtonGenerateBill_actionPerformed(java.awt.event.ActionEvent event) {
		JDialogGenBill billFrm = new JDialogGenBill();
		// billFrm.setBounds(450, 20, 400, 350);
		billFrm.setLocationRelativeTo(null);
		billFrm.show();
	}

	public void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String name = (String) model.getValueAt(selection, 0);

			// Show the dialog for adding deposit amount for the current mane
			JDialog_Deposit dep = new JDialog_Deposit(myframe, name);
			dep.setBounds(430, 15, 275, 250);
			dep.show();

			// compute new amount
			long deposit = Long.parseLong(amountDeposit);
			String samount = (String) model.getValueAt(selection, 4);
			long currentamount = Long.parseLong(samount);
			long newamount = currentamount + deposit;
			model.setValueAt(String.valueOf(newamount), selection, 4);
			AccountService accountService = new CreditCardAccountService();
			accountService.deposit(ccnumber, Double.parseDouble(amountDeposit), description);
		}
	}

	public void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String name = (String) model.getValueAt(selection, 0);

			// Show the dialog for adding withdraw amount for the current mane
			JDialog_Withdraw wd = new JDialog_Withdraw(myframe, name);
			wd.setBounds(430, 15, 275, 180);
			wd.show();

			// compute new amount
			/*
			 * long deposit = Long.parseLong(amountDeposit); String samount = (String)
			 * model.getValueAt(selection, 4); long currentamount = Long.parseLong(samount);
			 * long newamount = currentamount - deposit;
			 * model.setValueAt(String.valueOf(newamount), selection, 4); AccountService
			 * accountService = new CreditCardAccountService();
			 * accountService.withdraw(ccnumber, deposit, description); if (newamount < 0) {
			 * JOptionPane.showMessageDialog(JButton_Withdraw, name +
			 * "... Your balance is negative: $" + String.valueOf(newamount) +
			 * " !Warning: negative balance", "", JOptionPane.WARNING_MESSAGE); }
			 */

			long deposit = Long.parseLong(amountDeposit);
			AccountServiceImpl accountService = new CreditCardAccountService();
			Account account = accountService.getAccount(ccnumber);
			if (deposit > account.getMinThreshold() + account.getBalance()) {
				JOptionPane.showMessageDialog(JButton_Withdraw, name + "... Your balance is $"
						+ String.valueOf(account.getBalance()) + ". Withdraw exceed minimum balance!!!", "",
						JOptionPane.WARNING_MESSAGE);
			}
			accountService.withdraw(ccnumber, deposit, description);
			account = accountService.getAccount(ccnumber);
			model.setValueAt(account.getBalance(), selection, 4);
		}
	}
}
