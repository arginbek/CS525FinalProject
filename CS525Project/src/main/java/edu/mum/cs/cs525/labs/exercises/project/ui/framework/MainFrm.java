package edu.mum.cs.cs525.labs.exercises.project.ui.framework;

import java.awt.BorderLayout;

import javax.swing.table.DefaultTableModel;
//
import edu.mum.cs.cs525.labs.exercises.project.ui.bank.*;
//import edu.mum.cs.cs525.labs.exercises.project.ui.bank.JDialog_Withdraw;

//import edu.mum.cs.cs525.labs.exercises.project.ui.ccard.JDialog_Withdraw;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

public class MainFrm extends javax.swing.JFrame {

	
	 /****
     * init variables in the object
     ****/
    public String accountnr, clientName,street,city,zip,state,accountType,amountDeposit;
    public boolean newaccount;
    protected DefaultTableModel model;
    protected JTable JTable1;
    protected JScrollPane JScrollPane1;
    protected MainFrm myframe;
    protected Object rowdata[];
    
    protected javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	protected javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Exit = new javax.swing.JButton();
    
	public MainFrm()
	{
		myframe = this;

		setTitle("Bank Application.");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		setSize(575,310);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0,0,575,310);
		/*
		/Add five buttons on the pane 
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
        JScrollPane1 = new JScrollPane();
        
        
        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12,92,444,160);
        
		
        
       
		JButton_Deposit.setText("Deposit");
		JPanel1.add(JButton_Deposit);
		JButton_Deposit.setBounds(468,104,96,33);
		JButton_Withdraw.setText("Withdraw");
		JPanel1.add(JButton_Withdraw);
		JButton_Withdraw.setBounds(468,164,96,33);
		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468,248,96,31);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		
	}

	
	/*****************************************************
	 * The entry point for this application.
	 * Sets the Look and Feel to the System Look and Feel.
	 * Creates a new JFrame1 and makes it visible.
	 *****************************************************/
	static public void main(String args[])
	{
		try {
		    // Add the following code if you want the Look and Feel
		    // to be set to the Look and Feel of the native system.
		    
		    try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (Exception e) { 
		    }
		    
			//Create a new instance of our application's frame, and make it visible.
			(new MainFrm()).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}


	

	protected void exitApplication()
	{
		try {
		    	this.setVisible(false);    // hide the Frame
		    	this.dispose();            // free the system resources
		    	System.exit(0);            // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == MainFrm.this)
				MainFrm_windowClosing(event);
		}
	}

	void MainFrm_windowClosing(java.awt.event.WindowEvent event)
	{
		// to do: code goes here.
			 
		MainFrm_windowClosing_Interaction1(event);
	}

	void MainFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(event);
			
		}
	}
    
    //When the Exit button is pressed this code gets executed
    //this will exit from the system
     protected void JButtonExit_actionPerformed(java.awt.event.ActionEvent event)
	{
		System.exit(0);
	}
     
     
    protected void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event)
 	{
 	    // get selected name
         int selection = JTable1.getSelectionModel().getMinSelectionIndex();
         if (selection >=0){
             String name = (String)model.getValueAt(selection, 0);

 		    //Show the dialog for adding withdraw amount for the current mane
 		    JDialog_Withdraw wd = new JDialog_Withdraw(myframe,name);
 		    wd.setBounds(430, 15, 275, 140);
 		    wd.show();
     		
 		    // compute new amount
 		   double deposit = Double.parseDouble(amountDeposit);
           double samount =Double.parseDouble( model.getValueAt(selection, 5).toString());
           //long currentamount = Long.parseLong(samount);
 		    double newamount=samount-deposit;
 		    model.setValueAt(String.valueOf(newamount),selection, 5);
 		    if (newamount <0){
 		       JOptionPane.showMessageDialog(JButton_Withdraw, " "+name+" Your balance is negative: $"+String.valueOf(newamount)+" !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
 		    }
 		}
 		
 		
 	}
	public void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event)
	{
	    // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String accnr = (String)model.getValueAt(selection, 0);
    	    
		    //Show the dialog for adding deposit amount for the current mane
		    JDialog_Deposit dep = new JDialog_Deposit(myframe,accnr);
		    dep.setBounds(430, 15, 275, 140);
		    dep.show();
    		 
		    
		    System.out.println(amountDeposit);
		    // compute new amount
            double deposit = Double.parseDouble(amountDeposit);
            double samount =Double.parseDouble( model.getValueAt(selection, 5).toString());
            //long currentamount = Long.parseLong(samount);
		    double newamount=samount+deposit;
		    model.setValueAt(String.valueOf(newamount),selection, 5);
		}
		
		
	}

}
