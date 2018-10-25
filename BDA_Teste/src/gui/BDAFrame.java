package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class BDAFrame {
	
	private final String[] columnNames = {"Data", "Preview", "Autor", "Canal"};
	private JFrame frame = new JFrame();
	
	public BDAFrame() {
		frame.setLayout(new BorderLayout());
		frame.setTitle("Bom Dia Academia");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addContent();
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private void addContent() {
		addCentralTable();
		addMenu();
		addStateLabel();
	}
	

	private void addMenu() {
		JPanel north =  new JPanel(new GridLayout(1, 2));
		JMenuBar menuBar = new JMenuBar();
		
		/**
		 * MENU
		 */
		JMenu menu = new JMenu("Menu");
//      menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items"); // ainda nao parece fazer nada
		menuBar.add(menu);
		
		/** MENU ITEMS */
		// Work online
		ImageIcon onlineIcon = new ImageIcon("images/online.png");
		JMenuItem online = new JMenuItem("Trabalhar online", onlineIcon);
		online.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Carregaste em \"Trabalhar online\". Inserir método que faça algo");
			}
		});
		menu.add(online);
		
		// Work offline
		ImageIcon offlineIcon = new ImageIcon("images/offline.png");
		JMenuItem offline = new JMenuItem("Trabalhar offline", offlineIcon);
		offline.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Carregaste em \"Trabalhar offline\". Inserir método que faça algo");
			}
		});
		menu.add(offline);
		
		
		/**
		 * FILTERS
		 */
		JMenu filters = new JMenu("Filtros");
        menuBar.add(filters);
        
		// add the menu to the frame
		north.add(menuBar);
		frame.add(north, BorderLayout.NORTH);
	}

	
	
	private void addCentralTable() {
		JPanel center = new JPanel();
		// é preciso aqui um método para ir buscar os dados
		Object[][] data = {{"hoje", "olá", "eu", "facebook"}, {"Ontem", "Reunião de Ano freferngre ger gregerwgersdvgre gtr vsh grgrtere vfsvtrgtr vbsfgvrt referngre ger gregerwgersdvgre gtr vsh grgrtere vfsv", "Delegado", "Twitter"}};
		JTable table = new JTable(data, columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(e.getClickCount() == 2) {
				JTable target =(JTable)e.getSource();
				int row = target.getSelectedRow();
				
				// row's preview is
				String preview = (String)data[row][1];
				DetailPopup i = new DetailPopup(preview);
				}
			}
		});
		
//        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
//        table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		center.add(scrollPane);
		frame.add(center);
	}
	
	
	/**
	 * STATE LABEL & username (Online/Offline)
	 */
	private void addStateLabel() {
		JPanel south = new JPanel(new BorderLayout());
		
		Label username = new Label("Nome do utilizador");
		ImageIcon image = new ImageIcon("images/online.png");
		JLabel state = new JLabel(image);
		state.setIcon(image);
		
		south.add(username);
		south.add(state, BorderLayout.WEST);
		
		frame.add(south, BorderLayout.SOUTH);
	}
	

	
	

	
	
	
	
	
	public static void main(String[] args) {
		BDAFrame a = new BDAFrame();
	}
	
}
