package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelPestanas extends JTable {
	
	private static final long serialVersionUID = 1L;
	private JTabbedPane pestanas = new JTabbedPane();
	private PanelColombia colombia = new PanelColombia();
	
	public PanelPestanas() {
		cargar();
		addComponentes();
	}
	
	public void cargar() {
		setLayout(new BorderLayout());
		pestanas.add(colombia, "Colombia");
	}
	
	public void addComponentes() {
		add(pestanas, BorderLayout.CENTER);
	}

	public PanelColombia getColombia() {
		return colombia;
	}
}
