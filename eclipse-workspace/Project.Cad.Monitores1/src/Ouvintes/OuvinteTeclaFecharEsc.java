package Ouvintes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class OuvinteTeclaFecharEsc implements KeyListener{
	JPasswordField password;
	JFrame telas;
	JTextField txt;
	JButton butao;
	
	public OuvinteTeclaFecharEsc(JFrame telas, JButton butao) {
		this.telas = telas;
		this.butao = butao;
		
	}
	public OuvinteTeclaFecharEsc(JFrame telas, JButton butao,JPasswordField senha) {
		this.telas = telas;
		this.password = senha;
		this.butao = butao;
		
	}
	public OuvinteTeclaFecharEsc(JFrame telas, JButton butao,JTextField campo) {
		this.telas = telas;
		this.txt = campo;
		this.butao = butao;
		
	}
	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char key = e.getKeyChar();
		
	if(e.getSource() == txt || e.getSource() == password) {	
		if(key == KeyEvent.VK_ESCAPE) {
			butao.doClick();
		}
	}
//	
//	if(key == KeyEvent.VK_ENTER) {
//		butao.doClick();
//	}
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
