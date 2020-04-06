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
					view.getDialogos().output("Toma tu query papu :v", mundo.getDb().getDate(),
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
			anadirReportesColombia();
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

	public void anadirReportesColombia() throws Exception {
		String[] fecha = mundo.getDb().getDate().split("\n");
		String[] casosActivos = mundo.getDb().getActiveCases().split("\n");
		String[] casosRecuperados = mundo.getDb().getRecoveredCases().split("\n");
		String[] casosNuevos = mundo.getDb().getNewCases().split("\n");
		String[] muertesReportadas = mundo.getDb().getDeathReported().split("\n");
		String[] totalMuertos = mundo.getDb().getTotalDeaths().split("\n");
		String[] totalCasos = mundo.getDb().getTotalDeaths().split("\n");
		for (int i = 0; i < fecha.length; i++) {
			view.getPestanas().getColombia().getTabla().anadirReporte(fecha[i], casosActivos[i], casosRecuperados[i],
					casosNuevos[i], muertesReportadas[i], totalMuertos[i], totalCasos[i]);
		}
	}
	public void insertarReporte(String Country, int ID, String Date, int ActiveCases, int RecoveredCases, int NewCases, int DeathReported, int TotalDeaths, int TotalCases) throws Exception {
		mundo.getDb().insertReport(Country, ID, Date, ActiveCases, RecoveredCases, NewCases, DeathReported, TotalDeaths, TotalCases);
		view.getPestanas().getColombia().getTabla().anadirReporte(Date, String.valueOf(ActiveCases), String.valueOf(RecoveredCases), String.valueOf(NewCases), String.valueOf(DeathReported), String.valueOf(TotalDeaths), String.valueOf(TotalCases));
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
			if(e.getActionCommand() == view.getCrearReporte().OK) {
				String Date = view.getCrearReporte().getTxFecha().getText();
				String NewCases = view.getCrearReporte().getTxNuevosCasos().getText();
				String RecoveredCases = view.getCrearReporte().getTxCasosRecuperados().getText();
				String DeathReported = view.getCrearReporte().getTxMuertesReportadas().getText();
				String[] strActiveCases = mundo.getDb().getActiveCases().split("\n");
				String[] strTotalDeaths = mundo.getDb().getTotalDeaths().split("\n");
				String[] strTotalCases = mundo.getDb().getTotalCases().split("\n");
				int ActiveCases = Integer.parseInt(strActiveCases[0])+Integer.parseInt(NewCases)-Integer.parseInt(RecoveredCases)-Integer.parseInt(DeathReported);
				int TotalDeaths = Integer.parseInt(strTotalDeaths[0])+Integer.parseInt(DeathReported);
				int TotalCases = Integer.parseInt(strTotalCases[0])+ActiveCases+Integer.parseInt(RecoveredCases);
				insertarReporte("Colombia", view.getPestanas().getColombia().getTabla().getContador(), Date, ActiveCases, Integer.parseInt(RecoveredCases), Integer.parseInt(NewCases), Integer.parseInt(DeathReported), TotalDeaths, TotalCases);
				view.getCrearReporte().setVisible(false);
				view.getCrearReporte().clean();
			}
			/*
			 * Panel Colombia
			 */
			if(e.getActionCommand() == view.getPestanas().getColombia().getOperaciones().NUEVOREGISTRO) {
				view.getCrearReporte().clean();
				view.getCrearReporte().setVisible(true);
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
