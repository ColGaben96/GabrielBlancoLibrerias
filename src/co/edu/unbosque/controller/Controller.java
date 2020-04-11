package co.edu.unbosque.controller;

import java.awt.AWTException;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Mundo;
import co.edu.unbosque.view.View;

/**
 * @author Gabriel Blanco Clase Controlador
 *
 */
public class Controller implements ActionListener {

	private Mundo mundo = new Mundo();
	private View view = new View();
	public final static String NOMBREPROYECTO = "Librerias: Casos Coronavirus en LATAM-SUR";

	/**
	 * Método Constructor del Controlador
	 * 
	 * @throws IOException
	 */
	public Controller() throws Exception {
		Consola();
	}

	/**
	 * Método para probar casos puntuales en consola
	 * 
	 * @throws IOException
	 */
	public void Consola() throws Exception {
		// Se inicializa gui aqui ya que es necesario para probar por via JOptionPane
		/*
		 * TODO: Buscar un método mas eficiente para mostrar TODOS los errores por
		 * JOptionPane
		 */
		boolean activo = true;
		while (activo) {
			try {
				int comando = Integer.parseInt(view.getDialogos().input(System.in, NOMBREPROYECTO + ": DebuggerMode",
						view.getDialogos().ayuda(), JOptionPane.PLAIN_MESSAGE));
				switch (comando) {
				default:
					view.getDialogos().output("Error", "Bad command!", JOptionPane.ERROR_MESSAGE);
					break;
				case 0:
					activo = false;
					System.out.println(mundo.getDb().closeConnection());
					break;
				case 1:
					activo = false;
					GUI();
					break;
				case 2:
					view.getDialogos().output("Toma tu query papu :v", mundo.getDb().getDate("Colombia"),
							JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			} catch (Exception e) {
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				view.getDialogos().notification("File created successfully",
						mundo.getArchivo().makeLog(errors.toString()), MessageType.INFO);
				view.getDialogos().output("Error", "Ha ocurrido un error inesperado\n"
						+ "Se ha creado en <proyecto>/docs/Output un archivo myLog.log en donde aparece el detalle específico del error causado.",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Método para iniciar la GUI
	 */
	public void GUI() throws Exception {
		try {
			view.setTitle(NOMBREPROYECTO);
			view.iniciar(this);
			anadirReportesArgentina();
			anadirReportesBolivia();
			anadirReportesBrasil();
			anadirReportesChile();
			anadirReportesColombia();
			anadirReportesEcuador();
			anadirReportesGuyana();
			anadirReportesGuyanaFrancesa();
			anadirReportesParaguay();
			anadirReportesPeru();
			anadirReportesSuriname();
			anadirReportesUruguay();
			anadirReportesVenezuela();
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			view.getDialogos().notification("File created successfully", mundo.getArchivo().makeLog(errors.toString()),
					MessageType.INFO);
			view.getDialogos().output("Error", "Ha ocurrido un error inesperado\n"
					+ "Se ha creado en <proyecto>/docs/Output un archivo myLog.log en donde aparece el detalle específico del error causado.",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void anadirReportesArgentina() throws Exception {
		String[] fecha = mundo.getDb().getDate("Argentina").split("\n");
		String[] casosActivos = mundo.getDb().getActiveCases("Argentina").split("\n");
		String[] casosRecuperados = mundo.getDb().getRecoveredCases("Argentina").split("\n");
		String[] casosNuevos = mundo.getDb().getNewCases("Argentina").split("\n");
		String[] muertesReportadas = mundo.getDb().getDeathReported("Argentina").split("\n");
		String[] totalMuertos = mundo.getDb().getTotalDeaths("Argentina").split("\n");
		String[] totalCasos = mundo.getDb().getTotalDeaths("Argentina").split("\n");
		for (int i = 0; i < fecha.length; i++) {
			view.getPestanas().getArgentina().getTabla().anadirReporte(fecha[i], casosActivos[i], casosRecuperados[i],
					casosNuevos[i], muertesReportadas[i], totalMuertos[i], totalCasos[i]);
		}
	}
	
	public void anadirReportesBrasil() throws Exception {
		String[] fecha = mundo.getDb().getDate("Brasil").split("\n");
		String[] casosActivos = mundo.getDb().getActiveCases("Brasil").split("\n");
		String[] casosRecuperados = mundo.getDb().getRecoveredCases("Brasil").split("\n");
		String[] casosNuevos = mundo.getDb().getNewCases("Brasil").split("\n");
		String[] muertesReportadas = mundo.getDb().getDeathReported("Brasil").split("\n");
		String[] totalMuertos = mundo.getDb().getTotalDeaths("Brasil").split("\n");
		String[] totalCasos = mundo.getDb().getTotalDeaths("Brasil").split("\n");
		for (int i = 0; i < fecha.length; i++) {
			view.getPestanas().getBrasil().getTabla().anadirReporte(fecha[i], casosActivos[i], casosRecuperados[i],
					casosNuevos[i], muertesReportadas[i], totalMuertos[i], totalCasos[i]);
		}
	}
	
	public void anadirReportesBolivia() throws Exception {
		String[] fecha = mundo.getDb().getDate("Bolivia").split("\n");
		String[] casosActivos = mundo.getDb().getActiveCases("Bolivia").split("\n");
		String[] casosRecuperados = mundo.getDb().getRecoveredCases("Bolivia").split("\n");
		String[] casosNuevos = mundo.getDb().getNewCases("Bolivia").split("\n");
		String[] muertesReportadas = mundo.getDb().getDeathReported("Bolivia").split("\n");
		String[] totalMuertos = mundo.getDb().getTotalDeaths("Bolivia").split("\n");
		String[] totalCasos = mundo.getDb().getTotalDeaths("Bolivia").split("\n");
		for (int i = 0; i < fecha.length; i++) {
			view.getPestanas().getBolivia().getTabla().anadirReporte(fecha[i], casosActivos[i], casosRecuperados[i],
					casosNuevos[i], muertesReportadas[i], totalMuertos[i], totalCasos[i]);
		}
	}
	
	public void anadirReportesChile() throws Exception {
		String[] fecha = mundo.getDb().getDate("Chile").split("\n");
		String[] casosActivos = mundo.getDb().getActiveCases("Chile").split("\n");
		String[] casosRecuperados = mundo.getDb().getRecoveredCases("Chile").split("\n");
		String[] casosNuevos = mundo.getDb().getNewCases("Chile").split("\n");
		String[] muertesReportadas = mundo.getDb().getDeathReported("Chile").split("\n");
		String[] totalMuertos = mundo.getDb().getTotalDeaths("Chile").split("\n");
		String[] totalCasos = mundo.getDb().getTotalDeaths("Chile").split("\n");
		for (int i = 0; i < fecha.length; i++) {
			view.getPestanas().getChile().getTabla().anadirReporte(fecha[i], casosActivos[i], casosRecuperados[i],
					casosNuevos[i], muertesReportadas[i], totalMuertos[i], totalCasos[i]);
		}
	}
	
	public void anadirReportesColombia() throws Exception {
		String[] fecha = mundo.getDb().getDate("Colombia").split("\n");
		String[] casosActivos = mundo.getDb().getActiveCases("Colombia").split("\n");
		String[] casosRecuperados = mundo.getDb().getRecoveredCases("Colombia").split("\n");
		String[] casosNuevos = mundo.getDb().getNewCases("Colombia").split("\n");
		String[] muertesReportadas = mundo.getDb().getDeathReported("Colombia").split("\n");
		String[] totalMuertos = mundo.getDb().getTotalDeaths("Colombia").split("\n");
		String[] totalCasos = mundo.getDb().getTotalDeaths("Colombia").split("\n");
		for (int i = 0; i < fecha.length; i++) {
			view.getPestanas().getColombia().getTabla().anadirReporte(fecha[i], casosActivos[i], casosRecuperados[i],
					casosNuevos[i], muertesReportadas[i], totalMuertos[i], totalCasos[i]);
		}
	}
	
	public void anadirReportesEcuador() throws Exception {
		String[] fecha = mundo.getDb().getDate("Ecuador").split("\n");
		String[] casosActivos = mundo.getDb().getActiveCases("Ecuador").split("\n");
		String[] casosRecuperados = mundo.getDb().getRecoveredCases("Ecuador").split("\n");
		String[] casosNuevos = mundo.getDb().getNewCases("Ecuador").split("\n");
		String[] muertesReportadas = mundo.getDb().getDeathReported("Ecuador").split("\n");
		String[] totalMuertos = mundo.getDb().getTotalDeaths("Ecuador").split("\n");
		String[] totalCasos = mundo.getDb().getTotalDeaths("Ecuador").split("\n");
		for (int i = 0; i < fecha.length; i++) {
			view.getPestanas().getEcuador().getTabla().anadirReporte(fecha[i], casosActivos[i], casosRecuperados[i],
					casosNuevos[i], muertesReportadas[i], totalMuertos[i], totalCasos[i]);
		}
	}
	
	public void anadirReportesGuyana() throws Exception {
		String[] fecha = mundo.getDb().getDate("Guyana").split("\n");
		String[] casosActivos = mundo.getDb().getActiveCases("Guyana").split("\n");
		String[] casosRecuperados = mundo.getDb().getRecoveredCases("Guyana").split("\n");
		String[] casosNuevos = mundo.getDb().getNewCases("Guyana").split("\n");
		String[] muertesReportadas = mundo.getDb().getDeathReported("Guyana").split("\n");
		String[] totalMuertos = mundo.getDb().getTotalDeaths("Guyana").split("\n");
		String[] totalCasos = mundo.getDb().getTotalDeaths("Guyana").split("\n");
		for (int i = 0; i < fecha.length; i++) {
			view.getPestanas().getGuyana().getTabla().anadirReporte(fecha[i], casosActivos[i], casosRecuperados[i],
					casosNuevos[i], muertesReportadas[i], totalMuertos[i], totalCasos[i]);
		}
	}
	
	public void anadirReportesGuyanaFrancesa() throws Exception {
		String[] fecha = mundo.getDb().getDate("Guyana Francesa").split("\n");
		String[] casosActivos = mundo.getDb().getActiveCases("Guyana Francesa").split("\n");
		String[] casosRecuperados = mundo.getDb().getRecoveredCases("Guyana Francesa").split("\n");
		String[] casosNuevos = mundo.getDb().getNewCases("Guyana Francesa").split("\n");
		String[] muertesReportadas = mundo.getDb().getDeathReported("Guyana Francesa").split("\n");
		String[] totalMuertos = mundo.getDb().getTotalDeaths("Guyana Francesa").split("\n");
		String[] totalCasos = mundo.getDb().getTotalDeaths("Guyana Francesa").split("\n");
		for (int i = 0; i < fecha.length; i++) {
			view.getPestanas().getGuyanaF().getTabla().anadirReporte(fecha[i], casosActivos[i], casosRecuperados[i],
					casosNuevos[i], muertesReportadas[i], totalMuertos[i], totalCasos[i]);
		}
	}
	
	public void anadirReportesParaguay() throws Exception {
		String[] fecha = mundo.getDb().getDate("Paraguay").split("\n");
		String[] casosActivos = mundo.getDb().getActiveCases("Paraguay").split("\n");
		String[] casosRecuperados = mundo.getDb().getRecoveredCases("Paraguay").split("\n");
		String[] casosNuevos = mundo.getDb().getNewCases("Paraguay").split("\n");
		String[] muertesReportadas = mundo.getDb().getDeathReported("Paraguay").split("\n");
		String[] totalMuertos = mundo.getDb().getTotalDeaths("Paraguay").split("\n");
		String[] totalCasos = mundo.getDb().getTotalDeaths("Paraguay").split("\n");
		for (int i = 0; i < fecha.length; i++) {
			view.getPestanas().getParaguay().getTabla().anadirReporte(fecha[i], casosActivos[i], casosRecuperados[i],
					casosNuevos[i], muertesReportadas[i], totalMuertos[i], totalCasos[i]);
		}
	}
	
	public void anadirReportesPeru() throws Exception {
		String[] fecha = mundo.getDb().getDate("Peru").split("\n");
		String[] casosActivos = mundo.getDb().getActiveCases("Peru").split("\n");
		String[] casosRecuperados = mundo.getDb().getRecoveredCases("Peru").split("\n");
		String[] casosNuevos = mundo.getDb().getNewCases("Peru").split("\n");
		String[] muertesReportadas = mundo.getDb().getDeathReported("Peru").split("\n");
		String[] totalMuertos = mundo.getDb().getTotalDeaths("Peru").split("\n");
		String[] totalCasos = mundo.getDb().getTotalDeaths("Peru").split("\n");
		for (int i = 0; i < fecha.length; i++) {
			view.getPestanas().getPeru().getTabla().anadirReporte(fecha[i], casosActivos[i], casosRecuperados[i],
					casosNuevos[i], muertesReportadas[i], totalMuertos[i], totalCasos[i]);
		}
	}
	
	public void anadirReportesSuriname() throws Exception {
		String[] fecha = mundo.getDb().getDate("Suriname").split("\n");
		String[] casosActivos = mundo.getDb().getActiveCases("Suriname").split("\n");
		String[] casosRecuperados = mundo.getDb().getRecoveredCases("Suriname").split("\n");
		String[] casosNuevos = mundo.getDb().getNewCases("Suriname").split("\n");
		String[] muertesReportadas = mundo.getDb().getDeathReported("Suriname").split("\n");
		String[] totalMuertos = mundo.getDb().getTotalDeaths("Suriname").split("\n");
		String[] totalCasos = mundo.getDb().getTotalDeaths("Suriname").split("\n");
		for (int i = 0; i < fecha.length; i++) {
			view.getPestanas().getSuriname().getTabla().anadirReporte(fecha[i], casosActivos[i], casosRecuperados[i],
					casosNuevos[i], muertesReportadas[i], totalMuertos[i], totalCasos[i]);
		}
	}
	
	public void anadirReportesUruguay() throws Exception {
		String[] fecha = mundo.getDb().getDate("Uruguay").split("\n");
		String[] casosActivos = mundo.getDb().getActiveCases("Uruguay").split("\n");
		String[] casosRecuperados = mundo.getDb().getRecoveredCases("Uruguay").split("\n");
		String[] casosNuevos = mundo.getDb().getNewCases("Uruguay").split("\n");
		String[] muertesReportadas = mundo.getDb().getDeathReported("Uruguay").split("\n");
		String[] totalMuertos = mundo.getDb().getTotalDeaths("Uruguay").split("\n");
		String[] totalCasos = mundo.getDb().getTotalDeaths("Uruguay").split("\n");
		for (int i = 0; i < fecha.length; i++) {
			view.getPestanas().getUruguay().getTabla().anadirReporte(fecha[i], casosActivos[i], casosRecuperados[i],
					casosNuevos[i], muertesReportadas[i], totalMuertos[i], totalCasos[i]);
		}
	}
	
	public void anadirReportesVenezuela() throws Exception {
		String[] fecha = mundo.getDb().getDate("Venezuela").split("\n");
		String[] casosActivos = mundo.getDb().getActiveCases("Venezuela").split("\n");
		String[] casosRecuperados = mundo.getDb().getRecoveredCases("Venezuela").split("\n");
		String[] casosNuevos = mundo.getDb().getNewCases("Venezuela").split("\n");
		String[] muertesReportadas = mundo.getDb().getDeathReported("Venezuela").split("\n");
		String[] totalMuertos = mundo.getDb().getTotalDeaths("Venezuela").split("\n");
		String[] totalCasos = mundo.getDb().getTotalDeaths("Venezuela").split("\n");
		for (int i = 0; i < fecha.length; i++) {
			view.getPestanas().getVenezuela().getTabla().anadirReporte(fecha[i], casosActivos[i], casosRecuperados[i],
					casosNuevos[i], muertesReportadas[i], totalMuertos[i], totalCasos[i]);
		}
	}

	public void insertarReporte(String Country, int ID, String Date, int ActiveCases, int RecoveredCases, int NewCases,
			int DeathReported, int TotalDeaths, int TotalCases) throws Exception {
		mundo.getDb().insertReport(Country, ID, Date, ActiveCases, RecoveredCases, NewCases, DeathReported, TotalDeaths,
				TotalCases);
		if(obtenerTituloPestanaSeleccionada() == "Argentina") {
			view.getPestanas().getArgentina().getTabla().anadirReporte(Date, String.valueOf(ActiveCases),
					String.valueOf(RecoveredCases), String.valueOf(NewCases), String.valueOf(DeathReported),
					String.valueOf(TotalDeaths), String.valueOf(TotalCases));
		}
		if(obtenerTituloPestanaSeleccionada() == "Brasil") {
			view.getPestanas().getBrasil().getTabla().anadirReporte(Date, String.valueOf(ActiveCases),
					String.valueOf(RecoveredCases), String.valueOf(NewCases), String.valueOf(DeathReported),
					String.valueOf(TotalDeaths), String.valueOf(TotalCases));
		}
		if(obtenerTituloPestanaSeleccionada() == "Bolivia") {
			view.getPestanas().getBolivia().getTabla().anadirReporte(Date, String.valueOf(ActiveCases),
					String.valueOf(RecoveredCases), String.valueOf(NewCases), String.valueOf(DeathReported),
					String.valueOf(TotalDeaths), String.valueOf(TotalCases));
		}
		if(obtenerTituloPestanaSeleccionada() == "Chile") {
			view.getPestanas().getChile().getTabla().anadirReporte(Date, String.valueOf(ActiveCases),
					String.valueOf(RecoveredCases), String.valueOf(NewCases), String.valueOf(DeathReported),
					String.valueOf(TotalDeaths), String.valueOf(TotalCases));
		}
		if(obtenerTituloPestanaSeleccionada() == "Colombia") {
			view.getPestanas().getColombia().getTabla().anadirReporte(Date, String.valueOf(ActiveCases),
					String.valueOf(RecoveredCases), String.valueOf(NewCases), String.valueOf(DeathReported),
					String.valueOf(TotalDeaths), String.valueOf(TotalCases));
		}
		if(obtenerTituloPestanaSeleccionada() == "Ecuador") {
			view.getPestanas().getEcuador().getTabla().anadirReporte(Date, String.valueOf(ActiveCases),
					String.valueOf(RecoveredCases), String.valueOf(NewCases), String.valueOf(DeathReported),
					String.valueOf(TotalDeaths), String.valueOf(TotalCases));
		}
		if(obtenerTituloPestanaSeleccionada() == "Guyana") {
			view.getPestanas().getGuyana().getTabla().anadirReporte(Date, String.valueOf(ActiveCases),
					String.valueOf(RecoveredCases), String.valueOf(NewCases), String.valueOf(DeathReported),
					String.valueOf(TotalDeaths), String.valueOf(TotalCases));
		}
		if(obtenerTituloPestanaSeleccionada() == "Guyana Francesa") {
			view.getPestanas().getGuyanaF().getTabla().anadirReporte(Date, String.valueOf(ActiveCases),
					String.valueOf(RecoveredCases), String.valueOf(NewCases), String.valueOf(DeathReported),
					String.valueOf(TotalDeaths), String.valueOf(TotalCases));
		}
		if(obtenerTituloPestanaSeleccionada() == "Paraguay") {
			view.getPestanas().getParaguay().getTabla().anadirReporte(Date, String.valueOf(ActiveCases),
					String.valueOf(RecoveredCases), String.valueOf(NewCases), String.valueOf(DeathReported),
					String.valueOf(TotalDeaths), String.valueOf(TotalCases));
		}
		if(obtenerTituloPestanaSeleccionada() == "Peru") {
			view.getPestanas().getPeru().getTabla().anadirReporte(Date, String.valueOf(ActiveCases),
					String.valueOf(RecoveredCases), String.valueOf(NewCases), String.valueOf(DeathReported),
					String.valueOf(TotalDeaths), String.valueOf(TotalCases));
		}
		if(obtenerTituloPestanaSeleccionada() == "Suriname") {
			view.getPestanas().getSuriname().getTabla().anadirReporte(Date, String.valueOf(ActiveCases),
					String.valueOf(RecoveredCases), String.valueOf(NewCases), String.valueOf(DeathReported),
					String.valueOf(TotalDeaths), String.valueOf(TotalCases));
		}
		if(obtenerTituloPestanaSeleccionada() == "Uruguay") {
			view.getPestanas().getUruguay().getTabla().anadirReporte(Date, String.valueOf(ActiveCases),
					String.valueOf(RecoveredCases), String.valueOf(NewCases), String.valueOf(DeathReported),
					String.valueOf(TotalDeaths), String.valueOf(TotalCases));
		}
		if(obtenerTituloPestanaSeleccionada() == "Venezuela") {
			view.getPestanas().getVenezuela().getTabla().anadirReporte(Date, String.valueOf(ActiveCases),
					String.valueOf(RecoveredCases), String.valueOf(NewCases), String.valueOf(DeathReported),
					String.valueOf(TotalDeaths), String.valueOf(TotalCases));
		}
	}

	public String obtenerTituloPestanaSeleccionada() {
		return view.getPestanas().getPestanas().getTitleAt(view.getPestanas().getPestanas().getSelectedIndex());
	}

	/**
	 * @author Carl Quinn Método para escuchar los eventos de la vista
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			/*
			 * Panel Funciones Superiores
			 */
			if (e.getActionCommand() == view.getToolbar().NUEVOARCHIVO) {
				// Poner accion aquí
			}
			if (e.getActionCommand() == view.getToolbar().GUARDAR) {
				view.guardarArchivo();
			}
			if (e.getActionCommand() == view.getToolbar().CARGAR) {
				view.cargarArchivo();
			}
			if (e.getActionCommand() == view.getToolbar().SALIR) {
				System.out.println(mundo.getDb().closeConnection());
				view.dispose();
			}
			if (e.getActionCommand() == view.getToolbar().ACERCADE) {
				view.getDialogos().output("Acerca De", NOMBREPROYECTO + " by The Forest Software Company\nv1.0\n"
						+ "Referencias Bibliográficas para este trabajo\nWorldometer - https://www.worldometers.info/coronavirus (para el resto de los paises)\n"
						+ "Twitter de MinSalud de Colombia\n" + "Twitter de Presidencia de Colombia",
						JOptionPane.INFORMATION_MESSAGE);
			}
			/*
			 * Panel Crear Reporte
			 */
			if (obtenerTituloPestanaSeleccionada() == "Argentina") {
				if (e.getActionCommand() == view.getCrearReporte().OK) {
					String Date = view.getCrearReporte().getTxFecha().getText();
					String NewCases = view.getCrearReporte().getTxNuevosCasos().getText();
					String RecoveredCases = view.getCrearReporte().getTxCasosRecuperados().getText();
					String DeathReported = view.getCrearReporte().getTxMuertesReportadas().getText();
					String[] strActiveCases = mundo.getDb().getActiveCases("Argentina").split("\n");
					String[] strTotalDeaths = mundo.getDb().getTotalDeaths("Argentina").split("\n");
					String[] strTotalCases = mundo.getDb().getTotalCases("Argentina").split("\n");
					int ActiveCases = Integer.parseInt(strActiveCases[0]) + Integer.parseInt(NewCases)
							- Integer.parseInt(RecoveredCases) - Integer.parseInt(DeathReported);
					int TotalDeaths = Integer.parseInt(strTotalDeaths[0]) + Integer.parseInt(DeathReported);
					int TotalCases = Integer.parseInt(strTotalCases[0]) + ActiveCases
							+ Integer.parseInt(RecoveredCases);
					insertarReporte("Argentina",
							view.getPestanas().getArgentina().getTabla().getContador(), Date, ActiveCases,
							Integer.parseInt(RecoveredCases), Integer.parseInt(NewCases),
							Integer.parseInt(DeathReported), TotalDeaths, TotalCases);
					view.getCrearReporte().setVisible(false);
					view.getCrearReporte().clean();
				}
			}
			if (obtenerTituloPestanaSeleccionada() == "Brasil") {
				if (e.getActionCommand() == view.getCrearReporte().OK) {
					String Date = view.getCrearReporte().getTxFecha().getText();
					String NewCases = view.getCrearReporte().getTxNuevosCasos().getText();
					String RecoveredCases = view.getCrearReporte().getTxCasosRecuperados().getText();
					String DeathReported = view.getCrearReporte().getTxMuertesReportadas().getText();
					String[] strActiveCases = mundo.getDb().getActiveCases("Brasil").split("\n");
					String[] strTotalDeaths = mundo.getDb().getTotalDeaths("Brasil").split("\n");
					String[] strTotalCases = mundo.getDb().getTotalCases("Brasil").split("\n");
					int ActiveCases = Integer.parseInt(strActiveCases[0]) + Integer.parseInt(NewCases)
							- Integer.parseInt(RecoveredCases) - Integer.parseInt(DeathReported);
					int TotalDeaths = Integer.parseInt(strTotalDeaths[0]) + Integer.parseInt(DeathReported);
					int TotalCases = Integer.parseInt(strTotalCases[0]) + ActiveCases
							+ Integer.parseInt(RecoveredCases);
					insertarReporte("Brasil",
							view.getPestanas().getBrasil().getTabla().getContador(), Date, ActiveCases,
							Integer.parseInt(RecoveredCases), Integer.parseInt(NewCases),
							Integer.parseInt(DeathReported), TotalDeaths, TotalCases);
					view.getCrearReporte().setVisible(false);
					view.getCrearReporte().clean();
				}
			}
			if (obtenerTituloPestanaSeleccionada() == "Bolivia") {
				if (e.getActionCommand() == view.getCrearReporte().OK) {
					String Date = view.getCrearReporte().getTxFecha().getText();
					String NewCases = view.getCrearReporte().getTxNuevosCasos().getText();
					String RecoveredCases = view.getCrearReporte().getTxCasosRecuperados().getText();
					String DeathReported = view.getCrearReporte().getTxMuertesReportadas().getText();
					String[] strActiveCases = mundo.getDb().getActiveCases("Bolivia").split("\n");
					String[] strTotalDeaths = mundo.getDb().getTotalDeaths("Bolivia").split("\n");
					String[] strTotalCases = mundo.getDb().getTotalCases("Bolivia").split("\n");
					int ActiveCases = Integer.parseInt(strActiveCases[0]) + Integer.parseInt(NewCases)
							- Integer.parseInt(RecoveredCases) - Integer.parseInt(DeathReported);
					int TotalDeaths = Integer.parseInt(strTotalDeaths[0]) + Integer.parseInt(DeathReported);
					int TotalCases = Integer.parseInt(strTotalCases[0]) + ActiveCases
							+ Integer.parseInt(RecoveredCases);
					insertarReporte("Bolivia",
							view.getPestanas().getBolivia().getTabla().getContador(), Date, ActiveCases,
							Integer.parseInt(RecoveredCases), Integer.parseInt(NewCases),
							Integer.parseInt(DeathReported), TotalDeaths, TotalCases);
					view.getCrearReporte().setVisible(false);
					view.getCrearReporte().clean();
				}
			}
			if (obtenerTituloPestanaSeleccionada() == "Chile") {
				if (e.getActionCommand() == view.getCrearReporte().OK) {
					String Date = view.getCrearReporte().getTxFecha().getText();
					String NewCases = view.getCrearReporte().getTxNuevosCasos().getText();
					String RecoveredCases = view.getCrearReporte().getTxCasosRecuperados().getText();
					String DeathReported = view.getCrearReporte().getTxMuertesReportadas().getText();
					String[] strActiveCases = mundo.getDb().getActiveCases("Chile").split("\n");
					String[] strTotalDeaths = mundo.getDb().getTotalDeaths("Chile").split("\n");
					String[] strTotalCases = mundo.getDb().getTotalCases("Chile").split("\n");
					int ActiveCases = Integer.parseInt(strActiveCases[0]) + Integer.parseInt(NewCases)
							- Integer.parseInt(RecoveredCases) - Integer.parseInt(DeathReported);
					int TotalDeaths = Integer.parseInt(strTotalDeaths[0]) + Integer.parseInt(DeathReported);
					int TotalCases = Integer.parseInt(strTotalCases[0]) + ActiveCases
							+ Integer.parseInt(RecoveredCases);
					insertarReporte("Chile",
							view.getPestanas().getChile().getTabla().getContador(), Date, ActiveCases,
							Integer.parseInt(RecoveredCases), Integer.parseInt(NewCases),
							Integer.parseInt(DeathReported), TotalDeaths, TotalCases);
					view.getCrearReporte().setVisible(false);
					view.getCrearReporte().clean();
				}
			}
			if (obtenerTituloPestanaSeleccionada() == "Colombia") {
				if (e.getActionCommand() == view.getCrearReporte().OK) {
					String Date = view.getCrearReporte().getTxFecha().getText();
					String NewCases = view.getCrearReporte().getTxNuevosCasos().getText();
					String RecoveredCases = view.getCrearReporte().getTxCasosRecuperados().getText();
					String DeathReported = view.getCrearReporte().getTxMuertesReportadas().getText();
					String[] strActiveCases = mundo.getDb().getActiveCases("Colombia").split("\n");
					String[] strTotalDeaths = mundo.getDb().getTotalDeaths("Colombia").split("\n");
					String[] strTotalCases = mundo.getDb().getTotalCases("Colombia").split("\n");
					int ActiveCases = Integer.parseInt(strActiveCases[0]) + Integer.parseInt(NewCases)
							- Integer.parseInt(RecoveredCases) - Integer.parseInt(DeathReported);
					int TotalDeaths = Integer.parseInt(strTotalDeaths[0]) + Integer.parseInt(DeathReported);
					int TotalCases = Integer.parseInt(strTotalCases[0]) + ActiveCases
							+ Integer.parseInt(RecoveredCases);
					insertarReporte("Colombia",
							view.getPestanas().getColombia().getTabla().getContador(), Date, ActiveCases,
							Integer.parseInt(RecoveredCases), Integer.parseInt(NewCases),
							Integer.parseInt(DeathReported), TotalDeaths, TotalCases);
					view.getCrearReporte().setVisible(false);
					view.getCrearReporte().clean();
				}
				if (obtenerTituloPestanaSeleccionada() == "Ecuador") {
					if (e.getActionCommand() == view.getCrearReporte().OK) {
						String Date = view.getCrearReporte().getTxFecha().getText();
						String NewCases = view.getCrearReporte().getTxNuevosCasos().getText();
						String RecoveredCases = view.getCrearReporte().getTxCasosRecuperados().getText();
						String DeathReported = view.getCrearReporte().getTxMuertesReportadas().getText();
						String[] strActiveCases = mundo.getDb().getActiveCases("Ecuador").split("\n");
						String[] strTotalDeaths = mundo.getDb().getTotalDeaths("Ecuador").split("\n");
						String[] strTotalCases = mundo.getDb().getTotalCases("Ecuador").split("\n");
						int ActiveCases = Integer.parseInt(strActiveCases[0]) + Integer.parseInt(NewCases)
								- Integer.parseInt(RecoveredCases) - Integer.parseInt(DeathReported);
						int TotalDeaths = Integer.parseInt(strTotalDeaths[0]) + Integer.parseInt(DeathReported);
						int TotalCases = Integer.parseInt(strTotalCases[0]) + ActiveCases
								+ Integer.parseInt(RecoveredCases);
						insertarReporte("Ecuador",
								view.getPestanas().getEcuador().getTabla().getContador(), Date, ActiveCases,
								Integer.parseInt(RecoveredCases), Integer.parseInt(NewCases),
								Integer.parseInt(DeathReported), TotalDeaths, TotalCases);
						view.getCrearReporte().setVisible(false);
						view.getCrearReporte().clean();
					}
				}
				if (obtenerTituloPestanaSeleccionada() == "Guyana") {
					if (e.getActionCommand() == view.getCrearReporte().OK) {
						String Date = view.getCrearReporte().getTxFecha().getText();
						String NewCases = view.getCrearReporte().getTxNuevosCasos().getText();
						String RecoveredCases = view.getCrearReporte().getTxCasosRecuperados().getText();
						String DeathReported = view.getCrearReporte().getTxMuertesReportadas().getText();
						String[] strActiveCases = mundo.getDb().getActiveCases("Guyana").split("\n");
						String[] strTotalDeaths = mundo.getDb().getTotalDeaths("Guyana").split("\n");
						String[] strTotalCases = mundo.getDb().getTotalCases("Guyana").split("\n");
						int ActiveCases = Integer.parseInt(strActiveCases[0]) + Integer.parseInt(NewCases)
								- Integer.parseInt(RecoveredCases) - Integer.parseInt(DeathReported);
						int TotalDeaths = Integer.parseInt(strTotalDeaths[0]) + Integer.parseInt(DeathReported);
						int TotalCases = Integer.parseInt(strTotalCases[0]) + ActiveCases
								+ Integer.parseInt(RecoveredCases);
						insertarReporte("Guyana",
								view.getPestanas().getGuyana().getTabla().getContador(), Date, ActiveCases,
								Integer.parseInt(RecoveredCases), Integer.parseInt(NewCases),
								Integer.parseInt(DeathReported), TotalDeaths, TotalCases);
						view.getCrearReporte().setVisible(false);
						view.getCrearReporte().clean();
					}
				}
				if (obtenerTituloPestanaSeleccionada() == "Guyana Francesa") {
					if (e.getActionCommand() == view.getCrearReporte().OK) {
						String Date = view.getCrearReporte().getTxFecha().getText();
						String NewCases = view.getCrearReporte().getTxNuevosCasos().getText();
						String RecoveredCases = view.getCrearReporte().getTxCasosRecuperados().getText();
						String DeathReported = view.getCrearReporte().getTxMuertesReportadas().getText();
						String[] strActiveCases = mundo.getDb().getActiveCases("Guyana Francesa").split("\n");
						String[] strTotalDeaths = mundo.getDb().getTotalDeaths("Guyana Francesa").split("\n");
						String[] strTotalCases = mundo.getDb().getTotalCases("Guyana Francesa").split("\n");
						int ActiveCases = Integer.parseInt(strActiveCases[0]) + Integer.parseInt(NewCases)
								- Integer.parseInt(RecoveredCases) - Integer.parseInt(DeathReported);
						int TotalDeaths = Integer.parseInt(strTotalDeaths[0]) + Integer.parseInt(DeathReported);
						int TotalCases = Integer.parseInt(strTotalCases[0]) + ActiveCases
								+ Integer.parseInt(RecoveredCases);
						insertarReporte("Guyana Francesa",
								view.getPestanas().getGuyanaF().getTabla().getContador(), Date, ActiveCases,
								Integer.parseInt(RecoveredCases), Integer.parseInt(NewCases),
								Integer.parseInt(DeathReported), TotalDeaths, TotalCases);
						view.getCrearReporte().setVisible(false);
						view.getCrearReporte().clean();
					}
				}
				if (obtenerTituloPestanaSeleccionada() == "Paraguay") {
					if (e.getActionCommand() == view.getCrearReporte().OK) {
						String Date = view.getCrearReporte().getTxFecha().getText();
						String NewCases = view.getCrearReporte().getTxNuevosCasos().getText();
						String RecoveredCases = view.getCrearReporte().getTxCasosRecuperados().getText();
						String DeathReported = view.getCrearReporte().getTxMuertesReportadas().getText();
						String[] strActiveCases = mundo.getDb().getActiveCases("Paraguay").split("\n");
						String[] strTotalDeaths = mundo.getDb().getTotalDeaths("Paraguay").split("\n");
						String[] strTotalCases = mundo.getDb().getTotalCases("Paraguay").split("\n");
						int ActiveCases = Integer.parseInt(strActiveCases[0]) + Integer.parseInt(NewCases)
								- Integer.parseInt(RecoveredCases) - Integer.parseInt(DeathReported);
						int TotalDeaths = Integer.parseInt(strTotalDeaths[0]) + Integer.parseInt(DeathReported);
						int TotalCases = Integer.parseInt(strTotalCases[0]) + ActiveCases
								+ Integer.parseInt(RecoveredCases);
						insertarReporte("Paraguay",
								view.getPestanas().getParaguay().getTabla().getContador(), Date, ActiveCases,
								Integer.parseInt(RecoveredCases), Integer.parseInt(NewCases),
								Integer.parseInt(DeathReported), TotalDeaths, TotalCases);
						view.getCrearReporte().setVisible(false);
						view.getCrearReporte().clean();
					}
				}
				if (obtenerTituloPestanaSeleccionada() == "Peru") {
					if (e.getActionCommand() == view.getCrearReporte().OK) {
						String Date = view.getCrearReporte().getTxFecha().getText();
						String NewCases = view.getCrearReporte().getTxNuevosCasos().getText();
						String RecoveredCases = view.getCrearReporte().getTxCasosRecuperados().getText();
						String DeathReported = view.getCrearReporte().getTxMuertesReportadas().getText();
						String[] strActiveCases = mundo.getDb().getActiveCases("Peru").split("\n");
						String[] strTotalDeaths = mundo.getDb().getTotalDeaths("Peru").split("\n");
						String[] strTotalCases = mundo.getDb().getTotalCases("Peru").split("\n");
						int ActiveCases = Integer.parseInt(strActiveCases[0]) + Integer.parseInt(NewCases)
								- Integer.parseInt(RecoveredCases) - Integer.parseInt(DeathReported);
						int TotalDeaths = Integer.parseInt(strTotalDeaths[0]) + Integer.parseInt(DeathReported);
						int TotalCases = Integer.parseInt(strTotalCases[0]) + ActiveCases
								+ Integer.parseInt(RecoveredCases);
						insertarReporte("Peru",
								view.getPestanas().getPeru().getTabla().getContador(), Date, ActiveCases,
								Integer.parseInt(RecoveredCases), Integer.parseInt(NewCases),
								Integer.parseInt(DeathReported), TotalDeaths, TotalCases);
						view.getCrearReporte().setVisible(false);
						view.getCrearReporte().clean();
					}
				}
				if (obtenerTituloPestanaSeleccionada() == "Suriname") {
					if (e.getActionCommand() == view.getCrearReporte().OK) {
						String Date = view.getCrearReporte().getTxFecha().getText();
						String NewCases = view.getCrearReporte().getTxNuevosCasos().getText();
						String RecoveredCases = view.getCrearReporte().getTxCasosRecuperados().getText();
						String DeathReported = view.getCrearReporte().getTxMuertesReportadas().getText();
						String[] strActiveCases = mundo.getDb().getActiveCases("Suriname").split("\n");
						String[] strTotalDeaths = mundo.getDb().getTotalDeaths("Suriname").split("\n");
						String[] strTotalCases = mundo.getDb().getTotalCases("Suriname").split("\n");
						int ActiveCases = Integer.parseInt(strActiveCases[0]) + Integer.parseInt(NewCases)
								- Integer.parseInt(RecoveredCases) - Integer.parseInt(DeathReported);
						int TotalDeaths = Integer.parseInt(strTotalDeaths[0]) + Integer.parseInt(DeathReported);
						int TotalCases = Integer.parseInt(strTotalCases[0]) + ActiveCases
								+ Integer.parseInt(RecoveredCases);
						insertarReporte("Suriname",
								view.getPestanas().getSuriname().getTabla().getContador(), Date, ActiveCases,
								Integer.parseInt(RecoveredCases), Integer.parseInt(NewCases),
								Integer.parseInt(DeathReported), TotalDeaths, TotalCases);
						view.getCrearReporte().setVisible(false);
						view.getCrearReporte().clean();
					}
				}
				if (obtenerTituloPestanaSeleccionada() == "Uruguay") {
					if (e.getActionCommand() == view.getCrearReporte().OK) {
						String Date = view.getCrearReporte().getTxFecha().getText();
						String NewCases = view.getCrearReporte().getTxNuevosCasos().getText();
						String RecoveredCases = view.getCrearReporte().getTxCasosRecuperados().getText();
						String DeathReported = view.getCrearReporte().getTxMuertesReportadas().getText();
						String[] strActiveCases = mundo.getDb().getActiveCases("Uruguay").split("\n");
						String[] strTotalDeaths = mundo.getDb().getTotalDeaths("Uruguay").split("\n");
						String[] strTotalCases = mundo.getDb().getTotalCases("Uruguay").split("\n");
						int ActiveCases = Integer.parseInt(strActiveCases[0]) + Integer.parseInt(NewCases)
								- Integer.parseInt(RecoveredCases) - Integer.parseInt(DeathReported);
						int TotalDeaths = Integer.parseInt(strTotalDeaths[0]) + Integer.parseInt(DeathReported);
						int TotalCases = Integer.parseInt(strTotalCases[0]) + ActiveCases
								+ Integer.parseInt(RecoveredCases);
						insertarReporte("Uruguay",
								view.getPestanas().getUruguay().getTabla().getContador(), Date, ActiveCases,
								Integer.parseInt(RecoveredCases), Integer.parseInt(NewCases),
								Integer.parseInt(DeathReported), TotalDeaths, TotalCases);
						view.getCrearReporte().setVisible(false);
						view.getCrearReporte().clean();
					}
				}
				if (obtenerTituloPestanaSeleccionada() == "Venezuela") {
					if (e.getActionCommand() == view.getCrearReporte().OK) {
						String Date = view.getCrearReporte().getTxFecha().getText();
						String NewCases = view.getCrearReporte().getTxNuevosCasos().getText();
						String RecoveredCases = view.getCrearReporte().getTxCasosRecuperados().getText();
						String DeathReported = view.getCrearReporte().getTxMuertesReportadas().getText();
						String[] strActiveCases = mundo.getDb().getActiveCases("Venezuela").split("\n");
						String[] strTotalDeaths = mundo.getDb().getTotalDeaths("Venezuela").split("\n");
						String[] strTotalCases = mundo.getDb().getTotalCases("Venezuela").split("\n");
						int ActiveCases = Integer.parseInt(strActiveCases[0]) + Integer.parseInt(NewCases)
								- Integer.parseInt(RecoveredCases) - Integer.parseInt(DeathReported);
						int TotalDeaths = Integer.parseInt(strTotalDeaths[0]) + Integer.parseInt(DeathReported);
						int TotalCases = Integer.parseInt(strTotalCases[0]) + ActiveCases
								+ Integer.parseInt(RecoveredCases);
						insertarReporte("Venezuela",
								view.getPestanas().getVenezuela().getTabla().getContador(), Date, ActiveCases,
								Integer.parseInt(RecoveredCases), Integer.parseInt(NewCases),
								Integer.parseInt(DeathReported), TotalDeaths, TotalCases);
						view.getCrearReporte().setVisible(false);
						view.getCrearReporte().clean();
					}
				}
			}
			/*
			 * Cualquier Panel
			 */
			if (obtenerTituloPestanaSeleccionada() == "Argentina") {
				if (e.getActionCommand() == view.getPestanas().getArgentina().getStatsANDoper().getOperaciones().NUEVOREGISTRO) {
					view.getCrearReporte().clean();
					view.getCrearReporte().setVisible(true);
					view.getCrearReporte().setTitle("Crear nuevo reporte para Argentina");
				}
			}
			if (obtenerTituloPestanaSeleccionada() == "Brasil") {
				if (e.getActionCommand() == view.getPestanas().getBrasil().getStatsANDoper().getOperaciones().NUEVOREGISTRO) {
					view.getCrearReporte().clean();
					view.getCrearReporte().setVisible(true);
					view.getCrearReporte().setTitle("Crear nuevo reporte para Brasil");
				}
			}
			if (obtenerTituloPestanaSeleccionada() == "Bolivia") {
				if (e.getActionCommand() == view.getPestanas().getBolivia().getStatsANDoper().getOperaciones().NUEVOREGISTRO) {
					view.getCrearReporte().clean();
					view.getCrearReporte().setVisible(true);
					view.getCrearReporte().setTitle("Crear nuevo reporte para Bolivia");
				}
			}
			if (obtenerTituloPestanaSeleccionada() == "Chile") {
				if (e.getActionCommand() == view.getPestanas().getChile().getStatsANDoper().getOperaciones().NUEVOREGISTRO) {
					view.getCrearReporte().clean();
					view.getCrearReporte().setVisible(true);
					view.getCrearReporte().setTitle("Crear nuevo reporte para Chile");
				}
			}
			if (obtenerTituloPestanaSeleccionada() == "Colombia") {
				if (e.getActionCommand() == view.getPestanas().getColombia().getStatsANDoper().getOperaciones().NUEVOREGISTRO) {
					view.getCrearReporte().clean();
					view.getCrearReporte().setVisible(true);
					view.getCrearReporte().setTitle("Crear nuevo reporte para Colombia");
				}
			}
			if (obtenerTituloPestanaSeleccionada() == "Ecuador") {
				if (e.getActionCommand() == view.getPestanas().getEcuador().getStatsANDoper().getOperaciones().NUEVOREGISTRO) {
					view.getCrearReporte().clean();
					view.getCrearReporte().setVisible(true);
					view.getCrearReporte().setTitle("Crear nuevo reporte para Ecuador");
				}
			}
			if (obtenerTituloPestanaSeleccionada() == "Guyana") {
				if (e.getActionCommand() == view.getPestanas().getGuyana().getStatsANDoper().getOperaciones().NUEVOREGISTRO) {
					view.getCrearReporte().clean();
					view.getCrearReporte().setVisible(true);
					view.getCrearReporte().setTitle("Crear nuevo reporte para Guyana");
				}
			}
			if (obtenerTituloPestanaSeleccionada() == "Guyana Francesa") {
				if (e.getActionCommand() == view.getPestanas().getGuyanaF().getStatsANDoper().getOperaciones().NUEVOREGISTRO) {
					view.getCrearReporte().clean();
					view.getCrearReporte().setVisible(true);
					view.getCrearReporte().setTitle("Crear nuevo reporte para Guyana Francesa");
				}
			}
			if (obtenerTituloPestanaSeleccionada() == "Paraguay") {
				if (e.getActionCommand() == view.getPestanas().getParaguay().getStatsANDoper().getOperaciones().NUEVOREGISTRO) {
					view.getCrearReporte().clean();
					view.getCrearReporte().setVisible(true);
					view.getCrearReporte().setTitle("Crear nuevo reporte para Paraguay");
				}
			}
			if (obtenerTituloPestanaSeleccionada() == "Peru") {
				if (e.getActionCommand() == view.getPestanas().getPeru().getStatsANDoper().getOperaciones().NUEVOREGISTRO) {
					view.getCrearReporte().clean();
					view.getCrearReporte().setVisible(true);
					view.getCrearReporte().setTitle("Crear nuevo reporte para Peru");
				}
			}
			if (obtenerTituloPestanaSeleccionada() == "Suriname") {
				if (e.getActionCommand() == view.getPestanas().getSuriname().getStatsANDoper().getOperaciones().NUEVOREGISTRO) {
					view.getCrearReporte().clean();
					view.getCrearReporte().setVisible(true);
					view.getCrearReporte().setTitle("Crear nuevo reporte para Suriname");
				}
			}
			if (obtenerTituloPestanaSeleccionada() == "Uruguay") {
				if (e.getActionCommand() == view.getPestanas().getUruguay().getStatsANDoper().getOperaciones().NUEVOREGISTRO) {
					view.getCrearReporte().clean();
					view.getCrearReporte().setVisible(true);
					view.getCrearReporte().setTitle("Crear nuevo reporte para Uruguay");
				}
			}
			if (obtenerTituloPestanaSeleccionada() == "Venezuela") {
				if (e.getActionCommand() == view.getPestanas().getVenezuela().getStatsANDoper().getOperaciones().NUEVOREGISTRO) {
					view.getCrearReporte().clean();
					view.getCrearReporte().setVisible(true);
					view.getCrearReporte().setTitle("Crear nuevo reporte para Venezuela");
				}
			}

		}
		/*
		 * Estas líneas son para controlar en caso de que por falta de memoria no genere
		 * el log. Esto es vital para el programa ya que me permite llevar una
		 * trazabilidad
		 */
		catch (Exception e2) {
			StringWriter errors = new StringWriter();
			e2.printStackTrace(new PrintWriter(errors));
			try {
				view.getDialogos().notification("File created successfully",
						mundo.getArchivo().makeLog(errors.toString()), MessageType.INFO);
				view.getDialogos().output("Error", "Ha ocurrido un error inesperado\n"
						+ "Se ha creado en <proyecto>/docs/Output un archivo myLog.log en donde aparece el detalle específico del error causado.",
						JOptionPane.ERROR_MESSAGE);
			} catch (IOException e1) {
				view.getDialogos().output("Error Fatal",
						"Ha ocurrido un error inesperado donde se debe salir del programa.\nMotivo: Error creando el log de archivos",
						JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			} catch (AWTException e1) {
				// TODO Auto-generated catch block

			}
			view.getDialogos().output("Error", "Ha ocurrido un error inesperado\n"
					+ "Se ha creado en <proyecto>/docs/Output un archivo myLog.log en donde aparece el detalle específico del error causado.",
					JOptionPane.ERROR_MESSAGE);
		}

	}

}
