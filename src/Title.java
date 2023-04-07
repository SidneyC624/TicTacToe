import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Title extends JPanel{
	
	JLabel textfield = new JLabel();
	
	Title() {
		
		this.setLayout(new BorderLayout());
		this.setBounds(100,0,800,100);
		
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
		textfield.setOpaque(true);
		textfield.setText("Tic Tac Toe");
		textfield.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(textfield);
		
	}
	
	
}
