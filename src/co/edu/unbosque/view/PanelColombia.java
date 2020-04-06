package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelColombia extends JPanel {

	private static final long serialVersionUID = 1L;
	private PanelTabla tabla = new PanelTabla();
	private PanelOperaciones operaciones = new PanelOperaciones();
	public final static String COUNTRYNAME = "Colombia";
	
	public PanelColombia() {
		cargar();
		addComponentes();
	}
	
	public void cargar() {
		setLayout(new BorderLayout());
	}
	
	public void addComponentes() {
		add(tabla, BorderLayout.CENTER);
		add(operaciones, BorderLayout.EAST);
	}

	public PanelTabla getTabla() {
		return tabla;
	}

	public PanelOperaciones getOperaciones() {
		return operaciones;
	}
}
