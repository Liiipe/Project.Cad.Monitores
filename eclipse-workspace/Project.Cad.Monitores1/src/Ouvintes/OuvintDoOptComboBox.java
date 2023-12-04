package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Telas.TelaDeCadastro;


public class OuvintDoOptComboBox implements ActionListener{
	TelaDeCadastro tela;
	
	public OuvintDoOptComboBox(TelaDeCadastro telaCadastro) {
		this.tela = telaCadastro;
	}
	//To ficando doido AAAAAAAAAAAAAAAAAAAAAAaaaaaaaa
	
	public void actionPerformed(ActionEvent e) {
		String opt = (String) tela.getOpcao().getSelectedItem();
		
		switch(opt) {
		case "Aluno":
		case "Monitor":
			tela.getIdentificadoCPF().setVisible(true);
			tela.getIdentificadoMatricula().setVisible(false);
			break;
			
		case "Coordenador":
			tela.getIdentificadoCPF().setVisible(false);
			tela.getIdentificadoMatricula().setVisible(false);
			break;
		}
	}

}
