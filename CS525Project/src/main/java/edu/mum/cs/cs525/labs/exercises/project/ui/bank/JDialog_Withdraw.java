package edu.mum.cs.cs525.labs.exercises.project.ui.bank;

import edu.mum.cs.cs525.labs.exercises.project.bank.BankAccountService;
import edu.mum.cs.cs525.labs.exercises.project.framework.AccountService;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.*;



public class JDialog_Withdraw extends JDialog_Withdraw_Main
{
   

	public JDialog_Withdraw(MainFrm parent, String aaccnr)
	{
		super(parent,aaccnr);
	
	}




	protected void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {

		AccountService accountService = new BankAccountService();
		accountService.withdraw(super.JTextField_NAME.getText(), Double.valueOf(JTextField_AMT.getText()), "withdraw");
        super.parentframe.amountDeposit=super.JTextField_AMT.getText();
		dispose();
	}

	
}