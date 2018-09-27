package escalonamento;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Agnaldo Rogério
 */
public class RoudRobin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel carrinho1 = new JLabel(new ImageIcon(getClass().getResource("carrinho1Fruta.png")));
	int carrinho1Vezes = 0;
	boolean carrinho1Voltando = false;
	
	JLabel carrinho2 = new JLabel(new ImageIcon(getClass().getResource("carrinho3Fruta.png")));
	int carrinho2Vezes = 0;
	boolean carrinho2Voltando = false;
	boolean carrinho2Saiu = false;
	
	boolean teste = false;
	boolean teste2 = false;

	
	
	JLabel carrinho3 = new JLabel(new ImageIcon(getClass().getResource("carrinho5Fruta.png")));
	int carrinho3Vezes = 0;
	boolean carrinho3Voltando = false;
	boolean carrinho3Saiu = false;
	
	JLabel caixa = new JLabel(new ImageIcon(getClass().getResource("caixa.png")));
	JLabel fundo = new JLabel(new ImageIcon(getClass().getResource("")));
	JLabel labelDescricao = new JLabel(new ImageIcon(getClass().getResource("roud.png")));

	public RoudRobin() {
		editarJanela();
		new Movimento().start();
	}

	public void editarJanela() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1220, 480);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		carrinho1.setBounds(0, 280, 230, 185);
		carrinho2.setBounds(180, 280, 230, 185);
		carrinho3.setBounds(360, 280, 230, 185);
		caixa.setBounds(800, 100, 450, 480);
		fundo.setBounds(0, 0, 1280, 700);
		labelDescricao.setBounds(30, 0, 600, 200);
		add(labelDescricao);
		add(carrinho3);
		add(carrinho2);
		add(carrinho1);
		add(caixa);
		add(fundo);

	}

	public class Movimento extends Thread {
		public void run() {
			while (true) {
				try {
					sleep(200);
				} catch (Exception erro) {

				}
				if (carrinho3.getX() <= 830 && carrinho3Voltando != true) {
					carrinho3.setBounds(carrinho3.getX() + 15, 280, 230, 185);
					teste2 = true;
				} else {
					carrinho3Voltando = true;
					if(teste2 == true && carrinho3Vezes == 0) {
						carrinho3.setIcon(new javax.swing.ImageIcon(getClass().getResource("carrinho3Fruta.png")));
						carrinho3Vezes = 1;
						teste2 = false;	
					}
					if(teste2 == true && carrinho3Vezes == 1) {
						carrinho3.setIcon(new javax.swing.ImageIcon(getClass().getResource("carrinho1Fruta.png")));
						carrinho3Vezes = 2;
						teste2 = false;	
					}
					if(teste2 == true && carrinho3Vezes == 2) {
						carrinho3.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
						teste = false;	
					}
					teste2 = false;	
					
				}
				if (carrinho3Voltando) {
					if (carrinho3Vezes <= 2 && carrinho3.getX() >= 0) {
						carrinho3.setBounds(carrinho3.getX() - 15, 0, 230, 185);
					} else {
						carrinho3.setBounds(carrinho3.getX() + 15, 280, 230, 185);
						carrinho3Voltando = false;
					}
				}
				
				if(carrinho3.getX() >= 420 || carrinho3Saiu == true){
					carrinho3Saiu = true;
					if (carrinho2.getX() <= 830 && carrinho2Voltando != true) {
						carrinho2.setBounds(carrinho2.getX() + 15, 280, 230, 185);
						teste = true;
					
					} else {
						carrinho2Voltando = true;
						if(teste == true && carrinho3Vezes == 1) {
							carrinho2.setIcon(new javax.swing.ImageIcon(getClass().getResource("carrinho1Fruta.png")));
							teste = false;	
						}
						if(teste == true && carrinho3Vezes == 2) {
							carrinho2.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
							teste = false;	
						}
						teste = false;	
					}
					if (carrinho2Voltando) {
						if (carrinho2Vezes <= 2 && carrinho2.getX() >= 0) {
							carrinho2.setBounds(carrinho2.getX() - 15, 0, 230, 185);
						} else {
							carrinho2.setBounds(carrinho2.getX() + 15, 280, 230, 185);
							carrinho2Voltando = false;
						}
					}
				}
				
			
				if(carrinho2.getX() >= 240 || carrinho2Saiu == true){
					carrinho2Saiu = true;
					if (carrinho1.getX() <= 830) {
						carrinho1.setBounds(carrinho1.getX() + 15, 280, 230, 185);
					} else {
						carrinho1.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
					
					}
					
				}
				
				// RegraGatoPreto
				/*
			
				*/
			}
		}
	}

	public static void main(String[] args) {
		new RoudRobin();
	}
}