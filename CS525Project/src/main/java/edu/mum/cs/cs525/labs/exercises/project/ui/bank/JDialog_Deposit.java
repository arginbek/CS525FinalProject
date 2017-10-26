package edu.mum.cs.cs525.labs.exercises.project.ui.bank;

import edu.mum.cs.cs525.labs.exercises.project.bank.BankAccountService;
import edu.mum.cs.cs525.labs.exercises.project.framework.AccountService;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.*;

public class JDialog_Deposit extends JDialog_Deposit_Main
{

    
	public JDialog_Deposit(MainFrm parent, String aaccnr)
	{
		super(parent, aaccnr);

	}

	protected void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
        super.parentframe.amountDeposit=super.JTextField_Deposit.getText();
		AccountService accountService = new BankAccountService();
		accountService.deposit(super.JTextField_NAME.getText(), Double.valueOf(JTextField_Deposit.getText()), "Deposit");

        dispose();
	}


}