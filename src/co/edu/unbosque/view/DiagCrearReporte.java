package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class DiagCrearReporte extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private JLabel lbFecha = new JLabel("Fecha"), lbNuevosCasos = new JLabel("Casos Nuevos"), lbCasosRecuperados = new JLabel("Casos Recuperados"), lbMuertesReportadas = new JLabel("Muertes Reportadas");
	private JTextField txFecha = new JTextField(), txNuevosCasos = new JTextField(), txCasosRecuperados = new JTextField(), txMuertesReportadas = new JTextField();
	private JButton Ok = new JButton("Ok"), Cancelar = new JButton("Cancelar");
	public final String OK = "RPRTOK", CANCELAR = "RPRTCANCEL";
	
	public DiagCrearReporte() {
		cargar();
		addComponente();
	}
	
	public void cargar() {
		setLayout(new GridLayout(5, 2));
		setSize(300, 200);
		setLocationRelativeTo(null);
		Ok.setActionCommand(OK);
		Cancelar.setActionCommand(CANCELAR);
	}
	
	public void addComponente() {
		add(lbFecha); add(txFecha);
		add(lbNuevosCasos); add(txNuevosCasos);
		add(lbCasosRecuperados); add(txCasosRecuperados);
		add(lbMuertesReportadas); add(txMuertesReportadas);
		add(Ok); add(Cancelar);
	}
	
	public void clean() {
		txFecha.setText("");
		txNuevosCasos.setText("");
		txCasosRecuperados.setText("");
		txMuertesReportadas.setText("");
	}

	public JTextField getTxFecha() {
		return txFecha;
	}

	public JTextField getTxNuevosCasos() {
		return txNuevosCasos;
	}

	public JTextField getTxCasosRecuperados() {
		return txCasosRecuperados;
	}

	public JTextField getTxMuertesReportadas() {
		return txMuertesReportadas;
	}

	public JButton getOk() {
		return Ok;
	}

	public JButton getCancelar() {
		return Cancelar;
	}
	
	

}
