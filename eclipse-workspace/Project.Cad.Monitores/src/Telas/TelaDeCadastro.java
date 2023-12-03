package Telas;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Ouvintes.OuvintDoOptComboBox;
import Ouvintes.OuvinteBotaoVoltar;
import Ouvintes.OuvinteDaTeclaEnter;
import Ouvintes.OuvinteTeclaFecharEsc;
import Repositorio.CentralDeTudo;
import Repositorio.Componentes;
import Repositorio.Persistencia;








public class TelaDeCadastro extends TelaPadrao {
	
	public TelaDeCadastro(String Titulo) {
		super(Titulo);
		// TODO Auto-generated constructor stub
	}
	Persistencia persistenci = new Persistencia();
	CentralDeTudo central = persistenci.recuperarCentral();
	
	public TelaDeCadastro() {
		super("Tela de Cadastro");
		setSize(800, 900);
		botao();
		comboBox(this);
		maskFormat();
		tituloTela();
		repaint();
		
		setVisible(true);
		
	}
	private JComboBox<String> opcao;
	private JTextField identificadoCPF;
	private JTextField identificadoMatricula;
	private JTextField nome;
	private JTextField email;
	private JPasswordField senha;
	private JPasswordField confimarsenha;
	private JButton cadastrar;
	private JButton voltar;
	
	public void maskFormat() {
		try {
			identificadoCPF = Componentes.formatadoTxt("###.###.###-##", identificadoCPF, this, 160, 410, 260, 30);
			identificadoMatricula = Componentes.formatadoTxt("############", identificadoMatricula, this, 160, 410, 260,
					30);
			identificadoCPF.addKeyListener(new OuvinteDaTeclaEnter(this, cadastrar, identificadoCPF));
			identificadoMatricula.addKeyListener(new OuvinteDaTeclaEnter(this, cadastrar, identificadoMatricula));
			if (!central.getAdm().isEmpty()) {
				identificadoCPF.addKeyListener(new OuvinteTeclaFecharEsc(this, voltar, identificadoCPF));
				identificadoMatricula.addKeyListener(new OuvinteTeclaFecharEsc(this, voltar, identificadoMatricula));

			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		identificadoCPF.setVisible(false);
		identificadoMatricula.setVisible(true);

		if (central.getAdm().isEmpty()) {
			identificadoCPF.setVisible(false);
			identificadoMatricula.setVisible(false);
		}

	}
	
	public void comboBox(JFrame tela) {
		Persistencia persistencia = new Persistencia();
		CentralDeTudo central = persistencia.recuperarCentral();

		String[] tipoDeCadastro = { "Administrador" };
		ArrayList<String> cadastro = new ArrayList<>(Arrays.asList(tipoDeCadastro));

		if (central.getAdm().size() > 0) {
			cadastro.remove(0);
			cadastro.add("Aluno");
			cadastro.add("Monitor");

		}
		opcao = Componentes.adicionarComboBox(this, cadastro, 160, 460, 260, 30);
		OuvintDoOptComboBox ouvintOpcao = new OuvintDoOptComboBox(this);
		opcao.setSelectedIndex(0);
		opcao.addActionListener(ouvintOpcao);
		opcao.addKeyListener(new OuvinteDaTeclaEnter(this, cadastrar));
		opcao.addKeyListener(new OuvinteTeclaFecharEsc(this, voltar));
		repaint();

	}
	
	public void botao() {
		Ouvintes.OuvinteTelaCadastro ouvinteBotaoCadastro = new Ouvintes.OuvinteTelaCadastro(this);
		cadastrar = Componentes.addButao(this, "Cadastrar", 160, 510, 260, 30);
		cadastrar.addActionListener(ouvinteBotaoCadastro);
		if (central.getAdm().size() != 0) {
			voltar = Componentes.addButao(this, "Voltar", 160, 550, 260, 30);
			voltar.addActionListener(new OuvinteBotaoVoltar(this));
		}
	}
	
	public void tituloTela() {
		Componentes.adicionarTitulo(null, 0, 0, 850, 95);
	}
	public JComboBox<String> getOpcao() {
		return opcao;
	}
	public void setOpcao(JComboBox<String> opcao) {
		this.opcao = opcao;
	}
	
	public JTextField getIdentificadoCPF() {
		return identificadoCPF;
	}

	public void setIdentificadoCPF(JTextField identificadoCPF) {
		this.identificadoCPF = identificadoCPF;
	}

	public JTextField getIdentificadoMatricula() {
		return identificadoMatricula;
	}

	public void setIdentificadoMatricula(JTextField identificadoMatricula) {
		this.identificadoMatricula = identificadoMatricula;
	}

	public JTextField getNome() {
		return nome;
	}
	public void setNome(JTextField nome) {
		this.nome = nome;
	}
	public JTextField getEmail() {
		return email;
	}
	public void setEmail(JTextField email) {
		this.email = email;
	}
	public JPasswordField getSenha() {
		return senha;
	}
	public void setSenha(JPasswordField senha) {
		this.senha = senha;
	}
	public JPasswordField getConfimarsenha() {
		return confimarsenha;
	}
	public void setConfimarsenha(JPasswordField confimarsenha) {
		this.confimarsenha = confimarsenha;
	}
	public JButton getCadastrar() {
		return cadastrar;
	}
	public void setCadastrar(JButton cadastrar) {
		this.cadastrar = cadastrar;
	}
	public JButton getVoltar() {
		return voltar;
	}
	public void setVoltar(JButton voltar) {
		this.voltar = voltar;
	}
	
	
}
