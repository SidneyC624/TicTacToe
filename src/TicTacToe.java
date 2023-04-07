import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe extends JFrame implements ActionListener{

	Title title_panel;
	Board button_panel;
	JButton resetButton;
	
	Random random = new Random();
	boolean player1_turn;
	
	TicTacToe() {
		
		title_panel = new Title();
		button_panel = new Board();
		resetButton = new JButton();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900, 800);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(25,25,25));
		this.setVisible(true);
		
		resetButton.setText("Reset");
		resetButton.setBounds(0,0,100,100);
		resetButton.addActionListener(this);
		
		for(int i=0; i<9; i++) {
			button_panel.buttons[i].addActionListener(this);
		}
		
		this.add(resetButton);
		this.add(title_panel);
		this.add(button_panel);
		
		firstTurn();
	}
	
	public void firstTurn() {
		
		button_panel.disableButtons();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		button_panel.enableButtons();
		
		if(random.nextInt(2)==0) {
			player1_turn = true;
			title_panel.textfield.setText("X turn");
		}
		else {
			player1_turn = false;
			title_panel.textfield.setText("O turn");
		}
	}
	
	// both
	public void check() {
		// check if x wins
		if(
				(button_panel.buttons[0].getText()=="X") && 
				(button_panel.buttons[1].getText()=="X") && 
				(button_panel.buttons[2].getText()=="X")) {
			xWins(0,1,2);
		}
		
		if(
				(button_panel.buttons[3].getText()=="X") && 
				(button_panel.buttons[4].getText()=="X") && 
				(button_panel.buttons[5].getText()=="X")) {
			xWins(3,4,5);
		}
		
		if(
				(button_panel.buttons[6].getText()=="X") && 
				(button_panel.buttons[7].getText()=="X") && 
				(button_panel.buttons[8].getText()=="X")) {
			xWins(6,7,8);
		}
		
		if(
				(button_panel.buttons[0].getText()=="X") && 
				(button_panel.buttons[3].getText()=="X") && 
				(button_panel.buttons[6].getText()=="X")) {
			xWins(0,3,6);
		}
		
		if(
				(button_panel.buttons[1].getText()=="X") && 
				(button_panel.buttons[4].getText()=="X") && 
				(button_panel.buttons[7].getText()=="X")) {
			xWins(1,4,7);
		}
		
		if(
				(button_panel.buttons[2].getText()=="X") && 
				(button_panel.buttons[5].getText()=="X") && 
				(button_panel.buttons[8].getText()=="X")) {
			xWins(2,5,8);
		}
		
		if(
				(button_panel.buttons[0].getText()=="X") && 
				(button_panel.buttons[4].getText()=="X") && 
				(button_panel.buttons[8].getText()=="X")) {
			xWins(0,4,8);
		}
		
		if(
				(button_panel.buttons[2].getText()=="X") && 
				(button_panel.buttons[4].getText()=="X") && 
				(button_panel.buttons[6].getText()=="X")) {
			xWins(2,4,6);
		}
		
		// check if o wins
		if(
				(button_panel.buttons[0].getText()=="O") && 
				(button_panel.buttons[1].getText()=="O") && 
				(button_panel.buttons[2].getText()=="O")) {
			oWins(0,1,2);
		}
		
		if(
				(button_panel.buttons[3].getText()=="O") && 
				(button_panel.buttons[4].getText()=="O") && 
				(button_panel.buttons[5].getText()=="O")) {
			oWins(3,4,5);
		}
		
		if(
				(button_panel.buttons[6].getText()=="O") && 
				(button_panel.buttons[7].getText()=="O") && 
				(button_panel.buttons[8].getText()=="O")) {
			oWins(6,7,8);
		}
		
		if(
				(button_panel.buttons[0].getText()=="O") && 
				(button_panel.buttons[3].getText()=="O") && 
				(button_panel.buttons[6].getText()=="O")) {
			oWins(0,3,6);
		}
		
		if(
				(button_panel.buttons[1].getText()=="O") && 
				(button_panel.buttons[4].getText()=="O") && 
				(button_panel.buttons[7].getText()=="O")) {
			oWins(1,4,7);
		}
		
		if(
				(button_panel.buttons[2].getText()=="O") && 
				(button_panel.buttons[5].getText()=="O") && 
				(button_panel.buttons[8].getText()=="O")) {
			oWins(2,5,8);
		}
		
		if(
				(button_panel.buttons[0].getText()=="O") && 
				(button_panel.buttons[4].getText()=="O") && 
				(button_panel.buttons[8].getText()=="O")) {
			oWins(0,4,8);
		}
		
		if(
				(button_panel.buttons[2].getText()=="O") && 
				(button_panel.buttons[4].getText()=="O") && 
				(button_panel.buttons[6].getText()=="O")) {
			oWins(2,4,6);
		}
		
		// check for tie
		
		for(int i=0; i<9; i++) {
			if(button_panel.buttons[i].getText().isBlank()) {
				break;
			}
		
			if(
					i==8 && 
					title_panel.textfield.getText()!="X wins" &&
					title_panel.textfield.getText()!="O wins"	
					// ensures buttons are filled and no player has won
					) {
				button_panel.disableButtons();
				title_panel.textfield.setText("Tie");
			}
		}
	}
	
	public void xWins(int a, int b, int c) {
		button_panel.buttons[a].setBackground(Color.green);
		button_panel.buttons[b].setBackground(Color.green);
		button_panel.buttons[c].setBackground(Color.green);
		
		button_panel.disableButtons();
		
		title_panel.textfield.setText("X wins");
	}
	
	// both
	public void oWins(int a, int b, int c) {
		button_panel.buttons[a].setBackground(Color.green);
		button_panel.buttons[b].setBackground(Color.green);
		button_panel.buttons[c].setBackground(Color.green);
		
		button_panel.disableButtons();
		
		title_panel.textfield.setText("O wins");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0; i<9; i++) {
			if(e.getSource()==button_panel.buttons[i]) {
				if(player1_turn) {
					if(button_panel.buttons[i].getText().isBlank()) {
						button_panel.buttons[i].setForeground(new Color(255,0,0));
						button_panel.buttons[i].setText("X");
						player1_turn = false;
						title_panel.textfield.setText("O turn");
						check();
					}
				}
				else {
					if(button_panel.buttons[i].getText().isBlank()) {
						button_panel.buttons[i].setForeground(new Color(0,0,255));
						button_panel.buttons[i].setText("O");
						player1_turn = true;
						title_panel.textfield.setText("X turn");
						check();
					}
				}
			}
		}
		
		// reset button
		if(e.getSource()==resetButton) {
			this.remove(title_panel);
			this.remove(button_panel);
			title_panel = new Title();
			button_panel = new Board();
			this.add(title_panel);
			this.add(button_panel);
			SwingUtilities.updateComponentTreeUI(this);
			
			for(int i=0; i<9; i++) {
				button_panel.buttons[i].addActionListener(this);
			}
			
			firstTurn();
			
		}
		
	}
		
}
