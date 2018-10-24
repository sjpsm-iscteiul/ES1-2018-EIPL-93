import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BDAFrame {
	
	private static final String[] columnNames = {"Data", "Título", "Autor", "Canal"};
	private JFrame frame = new JFrame();
	
	public BDAFrame() {
		//frame.setSize(500, 500);
		frame.setLayout(new BorderLayout());
		frame.setTitle("Bom Dia Academia");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addContent();
		frame.setVisible(true);
		frame.pack();
	}
	
	private void addContent() {
		// CENTER PANEL - Content Table
		JPanel center = new JPanel();
		Object[][] data = {{
						"Facebook", "Olá", "olá a todos", "hoje"}};

		JTable table = new JTable(data, columnNames);
//        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
//        table.setFillsViewportHeight(true);
        
		JScrollPane scrollPane = new JScrollPane(table);
		center.add(scrollPane);
		frame.add(center);
		
		// NORTH PANEL
		JPanel north = new JPanel();
		JMenu menu = new JMenu("BDA");
		north.add(menu);
		frame.add(north, BorderLayout.NORTH);
	}
	
	public static void main(String[] args) {
		BDAFrame a = new BDAFrame();
	}
	
}
