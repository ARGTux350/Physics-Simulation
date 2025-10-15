import javax.swing.*;
import java.awt.event.*;

public class GUI{
	private JFrame frame;
	private JPanel panel;
	private JTextField startVelo, angle;
	private JLabel label1, label2, label3;
	private JButton button;
	private JComboBox cb, options;
	private String[] points = {"3","5","7","9","11","13"};
	private String[] inputOptions = {"vo + a", "v + a","v + a + h" };
	private Boolean calculateCheck = false;
	
	public GUI() {
		frame = new JFrame("projectileMotion");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
			
		panel = new JPanel();	
		
		label3 = new JLabel("points");
		panel.add(label3);
		
		cb = new JComboBox(points);
		cb.setSelectedIndex(0);
		cb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String choice = (String)cb.getSelectedItem();
				
				if(choice.equals("3")) {
					
				}else if(choice.equals("5")) {
					
				}else if(choice.equals("7")) {
					
				}else if(choice.equals("9")) {
					
				}else if(choice.equals("11")) {
					
				}else if(choice.equals("13")) {
					
				}
			}
			
		});
		panel.add(cb);
		
		options = new JComboBox(inputOptions);
		options.setSelectedIndex(0);
		options.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String choice = (String)cb.getSelectedItem();
				
				if(choice.equals("vo + a")) {
					
				}else if(choice.equals("v + a")) {
					
				}else if(choice.equals("v + a + h")) {
					
				}
				
			}
			
		});
		panel.add(options);
		
		label1 = new JLabel("Starting Velocity");
		panel.add(label1);
		
		startVelo = new JTextField(10); 
		panel.add(startVelo);
		
		label2 = new JLabel("Launch angle");
		panel.add(label2);
		
		angle = new JTextField(10); 
		panel.add(angle);
		
		
		button = new JButton ("calculate");
		button.setActionCommand("calculate");
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				calculateCheck = true;	
			}			
		});
		panel.add(button);
		
		frame.setContentPane(panel);
		frame.setVisible(true);
		}	
	}
