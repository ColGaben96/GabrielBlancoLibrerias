package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import co.edu.unbosque.controller.Controller;

import java.awt.*;
import java.io.IOException;

/**
 * @author Gabriel Blanco
 * Clase para definir la ventana principal
 */
public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private Dialogos dialogos = new Dialogos();
	private PanelFuncionesSuperiores toolbar = new PanelFuncionesSuperiores();
	private PanelPestanas pestanas = new PanelPestanas();
	private DiagCrearReporte crearReporte = new DiagCrearReporte();
	
	/**
	 * M�todo para iniciar la ventana principal
	 * @author Gabriel Blanco
	 * @param control
	 */
	public void iniciar(Controller control) {
		cargar();
		addComponentes();
		escucharComponentes(control);
	}
	/**
	 * M�todo para cargar la configuraci�n de la ventana principal
	 * @author Gabriel Blanco
	 */
	public void cargar() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000,600);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setVisible(true);
	}
	
	/**
	 * M�todo para a�adir los componentes de la ventana principal
	 * @author Gabriel Blanco
	 */
	public void addComponentes() {
		add(toolbar, BorderLayout.NORTH);
		add(pestanas, BorderLayout.CENTER);
		//TODO: A�adir aqu� los componentes
		
	}
	
	/**
	 * M�todo para escuchar los componentes donde <pre>Controller</pre> va a manejar todas
	 * estas excepciones.
	 * @author Gabriel Blanco
	 * @param control
	 */
	public void escucharComponentes(Controller control) {
		//PanelFuncionesSuperiores
		toolbar.getAcercaDe().addActionListener(control);
		toolbar.getNuevo().addActionListener(control);
		toolbar.getGuardar().addActionListener(control);
		toolbar.getCargar().addActionListener(control);
		toolbar.getSalir().addActionListener(control);
		//PanelCrearReporte
		crearReporte.getOk().addActionListener(control);
		crearReporte.getCancelar().addActionListener(control);
		//PanelArgentina
		pestanas.getArgentina().getStatsANDoper().getOperaciones().getNuevoRegistro().addActionListener(control);
		pestanas.getArgentina().getStatsANDoper().getOperaciones().getVerGrafica().addActionListener(control);
		//PanelBrasil
		pestanas.getBrasil().getStatsANDoper().getOperaciones().getNuevoRegistro().addActionListener(control);
		pestanas.getBrasil().getStatsANDoper().getOperaciones().getVerGrafica().addActionListener(control);
		//PanelBolivia
		pestanas.getBolivia().getStatsANDoper().getOperaciones().getNuevoRegistro().addActionListener(control);
		pestanas.getBolivia().getStatsANDoper().getOperaciones().getVerGrafica().addActionListener(control);
		//PanelChile
		pestanas.getChile().getStatsANDoper().getOperaciones().getNuevoRegistro().addActionListener(control);
		pestanas.getChile().getStatsANDoper().getOperaciones().getVerGrafica().addActionListener(control);
		//PanelColombia
		pestanas.getColombia().getStatsANDoper().getOperaciones().getNuevoRegistro().addActionListener(control);
		pestanas.getColombia().getStatsANDoper().getOperaciones().getVerGrafica().addActionListener(control);
		//PanelEcuador
		pestanas.getEcuador().getStatsANDoper().getOperaciones().getNuevoRegistro().addActionListener(control);
		pestanas.getEcuador().getStatsANDoper().getOperaciones().getVerGrafica().addActionListener(control);
		//PanelGuyana
		pestanas.getGuyana().getStatsANDoper().getOperaciones().getNuevoRegistro().addActionListener(control);
		pestanas.getGuyana().getStatsANDoper().getOperaciones().getVerGrafica().addActionListener(control);
		//PanelGuyanaFrancesa
		pestanas.getGuyanaF().getStatsANDoper().getOperaciones().getNuevoRegistro().addActionListener(control);
		pestanas.getGuyanaF().getStatsANDoper().getOperaciones().getVerGrafica().addActionListener(control);
		//PanelParaguay
		pestanas.getParaguay().getStatsANDoper().getOperaciones().getNuevoRegistro().addActionListener(control);
		pestanas.getParaguay().getStatsANDoper().getOperaciones().getVerGrafica().addActionListener(control);
		//PanelPeru
		pestanas.getPeru().getStatsANDoper().getOperaciones().getNuevoRegistro().addActionListener(control);
		pestanas.getPeru().getStatsANDoper().getOperaciones().getVerGrafica().addActionListener(control);
		//PanelSuriname
		pestanas.getSuriname().getStatsANDoper().getOperaciones().getNuevoRegistro().addActionListener(control);
		pestanas.getSuriname().getStatsANDoper().getOperaciones().getVerGrafica().addActionListener(control);
		//PanelUruguay
		pestanas.getUruguay().getStatsANDoper().getOperaciones().getNuevoRegistro().addActionListener(control);
		pestanas.getUruguay().getStatsANDoper().getOperaciones().getVerGrafica().addActionListener(control);
		//PanelVenezuela
		pestanas.getVenezuela().getStatsANDoper().getOperaciones().getNuevoRegistro().addActionListener(control);
		pestanas.getVenezuela().getStatsANDoper().getOperaciones().getVerGrafica().addActionListener(control);
	}
	
	public String cargarArchivo() throws IOException {
		String path = "";
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Forest Binary Files", new String[] {"TEXTFILES"});
		chooser.addChoosableFileFilter(filter);
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(chooser);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			path = chooser.getSelectedFile().getAbsolutePath();
			return path;
		} else {
			//No hace nada
			return null;
		}
	}
	
	/**
	 * M�todo para guardar un archivo via JFileChooser
	 * @author Gabriel Blanco
	 * @param linea
	 * @throws IOException
	 */
	public String guardarArchivo() throws IOException {
		String path = "";
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", new String[] {"TXT"});
		chooser.addChoosableFileFilter(filter);
		chooser.setFileFilter(filter);
		int returnVal = chooser.showSaveDialog(chooser);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			path = chooser.getSelectedFile().getAbsolutePath();
		} 
		else {
			//No hace nada
		}
		return path;
	}

	public Dialogos getDialogos() {
		return dialogos;
	}
	public PanelFuncionesSuperiores getToolbar() {
		return toolbar;
	}
	public PanelPestanas getPestanas() {
		return pestanas;
	}
	public DiagCrearReporte getCrearReporte() {
		return crearReporte;
	}
	
	
	
}
