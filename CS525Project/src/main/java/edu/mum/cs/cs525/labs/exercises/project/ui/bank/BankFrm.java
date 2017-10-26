package edu.mum.cs.cs525.labs.exercises.project.ui.bank;

import java.awt.*;
import java.util.ArrayList;

import edu.mum.cs.cs525.labs.exercises.project.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.framework.AccountService;
import edu.mum.cs.cs525.labs.exercises.project.framework.AccountServiceImpl;
import edu.mum.cs.cs525.labs.exercises.project.framework.AccountType;
import edu.mum.cs.cs525.labs.exercises.project.framework.CreateAbstractFactory;
import edu.mum.cs.cs525.labs.exercises.project.framework.CreateAccountTO;
import edu.mum.cs.cs525.labs.exercises.project.ui.bank.JDialogGenBill;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.*;//.MainFrm;
import edu.mum.cs.cs525.labs.exercises.project.bank.*;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

/**
 * A basic JFC based application.
 */

public class BankFrm extends MainFrm {
	/****
	 * init variables in the object
	 ****/
	String accountnr, clientType;

	javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
	javax.swing.JButton JButton_CompAC = new javax.swing.JButton();
	javax.swing.JButton JButton_Addinterest = new javax.swing.JButton();
	javax.swing.JButton JButton_GenBill = new javax.swing.JButton();
	

	BankFrm myframe;

	public BankFrm() {
		super();
		myframe = this;

		setTitle("Bank Application.");

		model = new DefaultTableModel();

		initModelCol();
		fillTable();
		rowdata = new Object[8];
		newaccount = false;
		JTable1 = new JTable(model);

		JPanel1.add(JScrollPane1);
		// JScrollPane1.setBounds(12,92,444,160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);
		// rowdata = new Object[8];

		JButton_PerAC.setText("Add personal account");
		JPanel1.add(JButton_PerAC);
		JButton_PerAC.setBounds(24, 20, 192, 33);
		JButton_CompAC.setText("Add company account");
		JButton_CompAC.setActionCommand("jbutton");
		JPanel1.add(JButton_CompAC);
		JButton_CompAC.setBounds(240, 20, 192, 33);
		JButton_Addinterest.setBounds(448, 20, 106, 33);
		JButton_Addinterest.setText("Add interest");
		JPanel1.add(JButton_Addinterest);
		
		
		JButton_GenBill.setText("Generate Monthly bills");
		JButton_GenBill.setActionCommand("jbutton");
		JPanel1.add(JButton_GenBill);
		JButton_GenBill.setBounds(140, 50, 192, 33);

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_PerAC.addActionListener(lSymAction);
		JButton_CompAC.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton_Addinterest.addActionListener(lSymAction);
		JButton_GenBill.addActionListener(lSymAction);

	}

	private void initModelCol() {
		model.addColumn("AccountNr");
		model.addColumn("Name");
		model.addColumn("City");
		model.addColumn("P/C");
		model.addColumn("Ch/S");
		model.addColumn("Amount");
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
			(new BankFrm()).setVisible(true);
		} catch (Throwable t) {
			t.printStackTrace();
			// Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent event) {
			Object object = event.getSource();
			if (object == BankFrm.this)
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
			else if (object == JButton_PerAC)
				JButtonPerAC_actionPerformed(event);
			else if (object == JButton_CompAC)
				JButtonCompAC_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			else if (object == JButton_Addinterest)
				JButtonAddinterest_actionPerformed(event);
			else if (object == JButton_GenBill)
				JButtonGenerateBill_actionPerformed(event);

		}
	}

	void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 * JDialog_AddPAcc type object is for adding personal information construct a
		 * JDialog_AddPAcc type object set the boundaries and show it
		 */

		JDialog_AddPAcc pac = new JDialog_AddPAcc(myframe);
		pac.setBounds(450, 20, 300, 330);
		pac.show();

		// fill the data table
		//
		fillTable();

	}

	private void fillTable() {
		AccountService accSer = new BankAccountService();
		ArrayList<BankAccount> accounts = (ArrayList<BankAccount>) accSer.getAccounts();

		// clean model
		while (model.getRowCount() >= 1) {
			System.out.println(model.getRowCount());
			model.removeRow(model.getRowCount() - 1);
		}
		for (BankAccount bankAccount : accounts) {
			rowdata[0] = bankAccount.getAccountNumber();
			rowdata[1] = bankAccount.getName();
			rowdata[2] = bankAccount.getCity();
			if (bankAccount instanceof PersonalAccount)
				rowdata[3] = AccountType.personal.toString();
			else
				rowdata[3] = AccountType.company.toString();
			if (bankAccount.getInterestType() instanceof CheckingInterest)
				rowdata[4] = "Checking";
			else
				rowdata[4] = "Saving";
			rowdata[5] = bankAccount.getBalance();
			model.addRow(rowdata);
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			newaccount = false;
		}
		// JTable1 = new JTable(model);
	}

	void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 * construct a JDialog_AddCompAcc type object set the boundaries and show it
		 */

		JDialog_AddCompAcc pac = new JDialog_AddCompAcc(myframe);
		pac.setBounds(450, 20, 300, 330);
		pac.show();

		if (newaccount) {
			// add row to table
			rowdata[0] = accountnr;
			rowdata[1] = clientName;
			rowdata[2] = city;
			rowdata[3] = "C";
			rowdata[4] = accountType;
			rowdata[5] = "0";
			model.addRow(rowdata);
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			newaccount = false;
		}

	}

	void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event) {
		AccountService accountService = new BankAccountService();
		accountService.addInterest();
		JOptionPane.showMessageDialog(JButton_Addinterest, "Interest is added to all accounts",
				"Add interest to all accounts", JOptionPane.WARNING_MESSAGE);

		fillTable();
	}
	
	void JButtonGenerateBill_actionPerformed(java.awt.event.ActionEvent event) {
		JDialogGenBill billFrm = new JDialogGenBill();
		//billFrm.setBounds(450, 20, 400, 350);
		billFrm.setLocationRelativeTo(null);
		billFrm.show();
	}

}
