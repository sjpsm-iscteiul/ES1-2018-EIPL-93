package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class DetailPopup extends JFrame {
	
	private String text;
//	private Post p;
	private JTextArea message;
	
	public DetailPopup(String text) {
		this.text = text;
		setLayout(new BorderLayout());
		setTitle("Detalhe do post");
		addContent();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void addContent() {
		/** NORTH - CHANNEL ICON */
		JPanel north = new JPanel();
		ImageIcon icon = new ImageIcon("images/twitter_icon.png");
		JLabel channel = new JLabel(icon);
		north.add(channel);
		add(north, BorderLayout.NORTH);
		
		/** CENTER - TEXT AREA */
		JPanel post = new JPanel(new GridLayout(1, 0));
		message = new JTextArea(text);
		message.setLineWrap(true);
		message.setWrapStyleWord(true);
        message.setEditable(false);
		// SCROLL PANE
		JScrollPane scrollPane = new JScrollPane(message, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(400, 110));
		post.add(scrollPane);
		add(post);
		
		/** SOUTH PANEL */
		JPanel south = new JPanel(new GridLayout(2, 1));
			// info panel
		JPanel info = new JPanel(new GridLayout(1, 0));		
		JLabel author = new JLabel("Autor: ");
		JLabel dateTime = new JLabel("Data e Hora: ");
		info.add(author);
		info.add(dateTime);
		
			//reply panel
		JPanel reply = new JPanel(new GridLayout(2, 1));
				// reply text ara
		JTextArea replyText = new JTextArea();
		JScrollPane replyScroll = new JScrollPane(replyText);
		replyScroll.setPreferredSize(new Dimension(100, 50));
		
				// buttonPanel
		JPanel button = new JPanel();
		
			// send button
		JButton send = new JButton("Responder");
		send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Enviar a resposta para a plataforma adequada. switch nas plataformas????");
				System.out.println("A resposta foi: \n" + replyText.getText());
			}
		});
		button.add(send);
		reply.add(replyScroll);
		reply.add(button);
		
		south.add(info);
		south.add(reply);

		add(south, BorderLayout.SOUTH);
		
	}
	
}

