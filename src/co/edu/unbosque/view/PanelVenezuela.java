package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelVenezuela extends JPanel{
	private static final long serialVersionUID = 1L;
	private PanelTabla tabla = new PanelTabla();
	private PanelstatsANDoper statsANDoper = new PanelstatsANDoper();
	public static final String COUNTRYNAME = "Venezuela";
	
	public PanelVenezuela() {
		cargar();
		addComponentes();
	}
	
	public void cargar() {
		setLayout(new BorderLayout());
	}
	
	public void addComponentes() {
		add(tabla, BorderLayout.CENTER);
		add(statsANDoper, BorderLayout.EAST);
	}

	public PanelTabla getTabla() {
		return tabla;
	}

	public PanelstatsANDoper getStatsANDoper() {
		return statsANDoper;
	}
}
