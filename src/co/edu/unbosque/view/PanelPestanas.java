package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelPestanas extends JTable {
	
	private static final long serialVersionUID = 1L;
	private JTabbedPane pestanas = new JTabbedPane();
	private PanelArgentina argentina = new PanelArgentina();
	private PanelBrasil brasil = new PanelBrasil();
	private PanelBolivia bolivia = new PanelBolivia();
	private PanelChile chile = new PanelChile();
	private PanelColombia colombia = new PanelColombia();
	private PanelEcuador ecuador = new PanelEcuador();
	private PanelGuyana guyana = new PanelGuyana();
	private PanelGuyanaFrancesa guyanaF = new PanelGuyanaFrancesa();
	private PanelParaguay paraguay = new PanelParaguay();
	private PanelPeru peru = new PanelPeru();
	private PanelSuriname suriname = new PanelSuriname();
	private PanelUruguay uruguay = new PanelUruguay();
	private PanelVenezuela venezuela = new PanelVenezuela();
	
	
	public PanelPestanas() {
		cargar();
		addComponentes();
	}
	
	@SuppressWarnings("static-access")
	public void cargar() {
		setLayout(new BorderLayout());
		pestanas.add(argentina, argentina.COUNTRYNAME);
		pestanas.add(brasil, brasil.COUNTRYNAME);
		pestanas.add(bolivia, bolivia.COUNTRYNAME);
		pestanas.add(chile, chile.COUNTRYNAME);
		pestanas.add(colombia, colombia.COUNTRYNAME);
		pestanas.add(ecuador, ecuador.COUNTRYNAME);
		pestanas.add(guyana, guyana.COUNTRYNAME);
		pestanas.add(guyanaF, guyanaF.COUNTRYNAME);
		pestanas.add(paraguay, paraguay.COUNTRYNAME);
		pestanas.add(peru, peru.COUNTRYNAME);
		pestanas.add(suriname, suriname.COUNTRYNAME);
		pestanas.add(uruguay, uruguay.COUNTRYNAME);
		pestanas.add(venezuela, venezuela.COUNTRYNAME);
	}
	
	public void addComponentes() {
		add(pestanas, BorderLayout.CENTER);
	}

	public PanelColombia getColombia() {
		return colombia;
	}

	public PanelArgentina getArgentina() {
		return argentina;
	}

	public PanelBolivia getBolivia() {
		return bolivia;
	}

	public PanelChile getChile() {
		return chile;
	}

	public PanelEcuador getEcuador() {
		return ecuador;
	}

	public PanelGuyana getGuyana() {
		return guyana;
	}

	public PanelGuyanaFrancesa getGuyanaF() {
		return guyanaF;
	}

	public PanelParaguay getParaguay() {
		return paraguay;
	}

	public PanelPeru getPeru() {
		return peru;
	}

	public PanelSuriname getSuriname() {
		return suriname;
	}

	public PanelUruguay getUruguay() {
		return uruguay;
	}

	public PanelVenezuela getVenezuela() {
		return venezuela;
	}

	public JTabbedPane getPestanas() {
		return pestanas;
	}

	public PanelBrasil getBrasil() {
		return brasil;
	}
	
	
}
