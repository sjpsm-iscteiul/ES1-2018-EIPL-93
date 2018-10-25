package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		/** CHANNEL ICON */
		JPanel north = new JPanel();
		ImageIcon icon = new ImageIcon("images/facebook_icon.png");
		JLabel channel = new JLabel(icon);
		north.add(channel);
		
		add(north, BorderLayout.NORTH);
		
		/** TEXT AREA */
		JPanel post = new JPanel();
		message = new JTextArea(text);
		message.setLineWrap(true);
		message.setWrapStyleWord(true);
        message.setEditable(false);
		// SCROLL PANE
		JScrollPane scrollPane = new JScrollPane(message, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(400, 110));
		post.add(scrollPane);
		add(post);
		
		
		/** INFO */
		JPanel info = new JPanel(new GridLayout(2, 2));
		JLabel author = new JLabel("Autor: ");
		JLabel dateTime = new JLabel("Data e Hora: ");
		JButton reply = new JButton("Responder");
		reply.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Carregaste no botão 'Responder'. Substituir por método");
			}
		});
		info.add(author);
		info.add(dateTime);
		info.add(reply);

		add(info, BorderLayout.SOUTH);
		
	}
	
}

