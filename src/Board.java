import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Board extends JPanel{

	JButton[] buttons = new JButton[9];
	
	Board() {
		
		this.setBounds(100,100,800,550);
		this.setLayout(new GridLayout(3,3));
		this.setBackground(new Color(150,150,150));
		
		for(int i=0; i<9; i++) {
			buttons[i] = new JButton();
			this.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			buttons[i].setFocusable(false);
		}
	}
	
	
	public void disableButtons() {
		for(int i=0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
	}
	
	public void enableButtons() {
		for(int i=0; i<9; i++) {
			buttons[i].setEnabled(true);
		}
	}

}
