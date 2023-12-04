package main;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import Repositorio.CentralDeTudo;
import Repositorio.Persistencia;
import Telas.TelaDeCadastro;
import Telas.TelaLogin;



public class Main {
	public static void main(String[] args) {
		Persistencia persistencia = new Persistencia();
		CentralDeTudo central = persistencia.recuperarCentral();
		System.out.println("Estoi loko");
		//new	TelaPadrao("Kratos");
		//TelaDeCadastro tela	= 	new TelaDeCadastro();
		//new TelaDeLogin();
		//new TelaRecuperarSenha();
			if(central.getAdm().isEmpty()) {
				new TelaDeCadastro();
			}else {
				new TelaLogin();
			}
	}

}
