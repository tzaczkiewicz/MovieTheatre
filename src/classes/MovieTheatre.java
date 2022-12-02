package classes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MovieTheatre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5747445547938049092L;
	private Seat[][] seats;
	private JTextField text;
	
	private class Seat extends JButton{
		private boolean reserved;
		private JTextField textField;
		
		private Seat(String text, JTextField textField) {
			super(text);
			reserved=false;
			this.textField = textField;
			this.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					((Seat) e.getSource()).onClick();
					
				}
			});
		}
		public void onClick() {
			if(!reserved) {
				if(text.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter a name for the reservation.");
				}
				else {
					this.setText(text.getText().trim());
					reserved=true;
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Seat is already reserved by " + this.getText() + ".");
			}
		}
	}
	
	public MovieTheatre(String name) {
		super(name);
		seats = new Seat[5][5];

		this.setSize(610, 698);
		this.setLayout(null);
		
		for(int i=0; i<seats.length; i++) {
			for(int j=0; j<seats[0].length; j++) {
				
				seats[i][j]=new Seat("", text);
				seats[i][j].setBounds(120*i, 120*j, 120, 120);
				this.add(seats[i][j]);
			}
		}
		JLabel label = new JLabel("Enter the name for the seat reservation and click on the desired seat:");
		label.setBounds(0, 600, 600, 30);
		this.add(label);
		text=new JTextField("Bob");
		text.setBounds(0, 630, 600, 30);
		this.add(text);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		
		
		
		this.setVisible(true);
	}
	
	public JTextField getTextField() {
		return text;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MovieTheatre("MovieTheatre");
	}

}
