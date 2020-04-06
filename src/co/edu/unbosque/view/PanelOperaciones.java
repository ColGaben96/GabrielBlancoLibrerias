package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelOperaciones extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JButton nuevoRegistro = new JButton("Nuevo Registro"), verGrafica = new JButton("Ver Gráfica");
	public final String NUEVOREGISTRO = "OPERNUEVOREGISTRO", VERGRAFICA = "OPERVERGRAFICA";
	
	public PanelOperaciones() {
		cargar();
		addComponentes();
	}
	
	public void cargar() {
		setLayout(new GridLayout(2, 1));
		nuevoRegistro.setActionCommand(NUEVOREGISTRO);
		verGrafica.setActionCommand(VERGRAFICA);
	}
	
	public void addComponentes() {
		add(nuevoRegistro);
		add(verGrafica);
	}

	public JButton getNuevoRegistro() {
		return nuevoRegistro;
	}

	public JButton getVerGrafica() {
		return verGrafica;
	}
	
	
}
