package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelstatsANDoper extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private PanelOperaciones operaciones = new PanelOperaciones();
	private PanelStats estadisticas = new PanelStats();
	
	public PanelstatsANDoper() {
		cargar();
		addComponentes();
	}
	
	public void cargar() {
		setLayout(new BorderLayout());
	}
	
	public void addComponentes() {
		add(operaciones, BorderLayout.NORTH);
		add(estadisticas, BorderLayout.CENTER);
	}

	public PanelOperaciones getOperaciones() {
		return operaciones;
	}

	public PanelStats getEstadisticas() {
		return estadisticas;
	}

}
