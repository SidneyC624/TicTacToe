import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe extends JFrame implements ActionListener{

	Title title_panel;
	Board button_panel;
	JButton resetButton;
	
	Random random;
	boolean player1_turn;
	int[][] winCombArray = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};;
	ArrayList<Integer> xArrayList;
	ArrayList<Integer> oArrayList;
	int winComb;
	boolean win = false;
	
	TicTacToe() {
		
		title_panel = new Title();
		button_panel = new Board();
		resetButton = new JButton();
		
		random = new Random();
		xArrayList = new ArrayList<Integer>();
		oArrayList = new ArrayList<Integer>();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900, 800);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(25,25,25));
		this.setVisible(true);
		
		resetButton.setText("Reset");
		resetButton.setBounds(0,0,100,100);
		resetButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
		resetButton.setFocusable(false);
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
	
	public boolean checkWin(ArrayList<Integer> arrayList) {
		// check if x or o wins
		for(int i=0; i<8; i++) {
			for(int j=0; j<3; j++) {
				if(arrayList.contains(winCombArray[i][j])) {
					if(j==2) {
						winComb = i;
						win = true;
						// accelerate outer loop to terminate
						i = 7;
					}
				}
				else {
					break;
				}
			}
		}
		return win;
	}
	
	public void xWins(int a, int b, int c) {
		button_panel.buttons[a].setBackground(Color.green);
		button_panel.buttons[b].setBackground(Color.green);
		button_panel.buttons[c].setBackground(Color.green);
		
		button_panel.disableButtons();
		
		title_panel.textfield.setText("X wins");
	}
	
	public void oWins(int a, int b, int c) {
		button_panel.buttons[a].setBackground(Color.green);
		button_panel.buttons[b].setBackground(Color.green);
		button_panel.buttons[c].setBackground(Color.green);
		
		button_panel.disableButtons();
		
		title_panel.textfield.setText("O wins");
	}

	public void checkTie() {
		for(int j=0; j<9; j++) {
			if(button_panel.buttons[j].getText().isBlank()) {
				break;
			}
		
			if(
					j==8 && 
					title_panel.textfield.getText()!="X wins" &&
					title_panel.textfield.getText()!="O wins"	
					// ensures buttons are filled and no player has won
					) {
				button_panel.disableButtons();
				title_panel.textfield.setText("Tie");
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0; i<9; i++) {
			if(e.getSource()==button_panel.buttons[i] &&
					button_panel.buttons[i].getText().isBlank()) {
				if(player1_turn) {
					
					button_panel.buttons[i].setForeground(new Color(255,0,0));
					button_panel.buttons[i].setText("X");
					player1_turn = false;
					title_panel.textfield.setText("O turn");
					xArrayList.add(i);
					if(checkWin(xArrayList)) {
						xWins(winCombArray[winComb][0], 
								winCombArray[winComb][1], 
								winCombArray[winComb][2]);
					}
				}
				else {
					button_panel.buttons[i].setForeground(new Color(0,0,255));
					button_panel.buttons[i].setText("O");
					player1_turn = true;
					title_panel.textfield.setText("X turn");
					oArrayList.add(i);
					if(checkWin(oArrayList)) {
						oWins(winCombArray[winComb][0], 
								winCombArray[winComb][1], 
								winCombArray[winComb][2]);
					}
				}
				checkTie();
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
