package com.gmail.mattdiamond98.communicaide.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import com.gmail.mattdiamond98.communicaide.Main;

public class ApplicationFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = -7618677227281415545L;
	
	/*
	 * Eventually this should be read from some stored properties file
	 */
	private static final Dimension preferredSize = new Dimension(1200, 800);
	
	public static JTextArea messageTextArea = new JTextArea();
	
	public ApplicationFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(preferredSize);
		setTitle("Communicaide");
		
		initMenuBar();		
		initContentPanes();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("send")) {
			System.out.println("Attempting to send message - ");
			Main.sendMessage(messageTextArea.getText());
		}
	}
	
	private void initContentPanes() {
		JPanel contentPane = new JPanel(new BorderLayout());
		
		messageTextArea = new JTextArea();
		contentPane.add(messageTextArea);
		messageTextArea.setEditable(true);
		
		JSplitPane splitPanes = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				leftFrame(), messageTextArea);
		contentPane.add(splitPanes, BorderLayout.CENTER);
		
		setContentPane(contentPane);
	}
	
	private JPanel leftFrame() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setMinimumSize(new Dimension(100, 400));

		JLabel label = new JLabel("Contact Lists");
		label.setFont(new Font("", 0, 14));
		panel.add(label, BorderLayout.NORTH);
		
		JButton button = new JButton("Send");
		button.addActionListener(this);
		button.setActionCommand("send");
		panel.add(button, BorderLayout.SOUTH);
		
		return panel;
	}
	
	private void initMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		
		JMenu messagesMenu = new JMenu("Messages");
		menuBar.add(messagesMenu);
		messagesMenu.add(new JMenuItem("New Message"));
		
		
		setJMenuBar(menuBar);
	}
	
	
	public void display() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	
}
