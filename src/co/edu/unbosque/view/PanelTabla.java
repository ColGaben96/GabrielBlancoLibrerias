package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class PanelTabla extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scroll;
	private int contador = 0;
	
	public PanelTabla() {
		cargar();
		addComponentes();
	}
	
	public void cargar() {
		table  = new JTable(new DefaultTableModel(new Object[] {"Fecha", "Casos Activos", "Casos Recuperados", "Casos Nuevos", "Muertes Reportadas", "Total Muertes", "Total Casos"}, contador));
		model = (DefaultTableModel) table.getModel();
		table.setAutoscrolls(true);
		scroll = new JScrollPane(table);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setViewportView(table);
		setLayout(new BorderLayout());
		contador++;
	}
	
	public void addComponentes() {
		add(scroll, BorderLayout.CENTER);
	}
	
	public void anadirReporte(String fecha, String casosActivos, String casosRecuperados, String casosNuevos, String muertesReportadas, String totalMuertos, String totalCasos) {
		model.addRow(new Object[] {fecha, casosActivos, casosRecuperados, casosNuevos, muertesReportadas, totalMuertos, totalCasos});
		contador++;
	}

	public JTable getTable() {
		return table;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public int getContador() {
		return contador;
	}
}
