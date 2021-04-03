package view;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Buttons;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField fieldSize;
	public static JPanel field,panel;
	public static JRadioButton horiz,vertical;
	public static JLabel message;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		horiz = new JRadioButton("Horizontal");
		horiz.setBounds(6, 28, 109, 23);
		contentPane.add(horiz);
		
		vertical = new JRadioButton("Vertical");
		vertical.setBounds(6, 68, 109, 23);
		contentPane.add(vertical);
		
		JLabel lblSizeOfField = new JLabel("Size of field:");
		lblSizeOfField.setBounds(150, 32, 69, 14);
		contentPane.add(lblSizeOfField);
		
		fieldSize = new JTextField();
		fieldSize.setBounds(221, 29, 86, 20);
		contentPane.add(fieldSize);
		fieldSize.setColumns(10);
		
		JButton build = new JButton("Build field");
		build.setBounds(332, 28, 89, 23);
		contentPane.add(build);
		
		JButton check = new JButton("Check");
		check.setBounds(332, 68, 89, 23);
		contentPane.add(check);
		
		panel = new JPanel();
		panel.setBounds(0, 116, 848, 431);
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		message = new JLabel("Error:");
		message.setBounds(150, 72, 159, 19);
		contentPane.add(message);
		
		field = new JPanel();
		field.setBackground(Color.WHITE);
		field.setAlignmentX(Component.CENTER_ALIGNMENT);
		field.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		build.addActionListener(new ActionListener() 
		{			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				Runnable build = () ->
				{
				int size = Integer.valueOf(fieldSize.getText());
				field.setBounds(848/2-size/2*20, 432/2-size/2*20, size*20, size*20);					
				Buttons.createButtonsField(size);				
				panel.add(field);	
				System.out.println("Clicked" + size + " " + field.countComponents());
				panel.repaint();
				};
				Thread buildThread = new Thread(build);
				buildThread.start();
			}
		});	
		
		check.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{	
				if(!(Buttons.size%2==0))
				{
					System.out.println("Nie można rozmieścic na tej plansze!");
				}
				else 
				{
				Runnable check = () ->
				{
				Buttons.checkInsertBlocks();
				};
				Thread checkThread = new Thread(check);
				checkThread.start();
				try {
					checkThread.join();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
			
		});
	}
}
