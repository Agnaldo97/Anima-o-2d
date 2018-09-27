package escalonamento;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Agnaldo Rogério
 */
public class SJF extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel gatoPreto = new JLabel(new ImageIcon(getClass().getResource("gatoPretoParadoPequeno.png")));
	JLabel gatoVermelho = new JLabel(new ImageIcon(getClass().getResource("gatoVermelhoParadoGrande.png")));
	JLabel gatoAzul = new JLabel(new ImageIcon(getClass().getResource("gatoAzulParado.png")));
	JLabel casinha = new JLabel(new ImageIcon(getClass().getResource("casinha.png")));
	JLabel fundo = new JLabel(new ImageIcon(getClass().getResource("fundo.jpg")));
	JLabel labelDescricao = new JLabel(new ImageIcon(getClass().getResource("SJF.png")));
	JLabel legenda = new JLabel(new ImageIcon(getClass().getResource("paletaSJF.png")));

	public SJF() {
		editarJanela();
		new Movimento().start();
	}

	public void editarJanela() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1220, 480);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		gatoPreto.setBounds(0, 280, 230, 225);
		gatoVermelho.setBounds(200, 280, 270, 180);
		gatoAzul.setBounds(360, 280, 230, 195);
		casinha.setBounds(800, 100, 450, 420);
		fundo.setBounds(0, 0, 1280, 700);
		labelDescricao.setBounds(30, 0, 600, 200);
		legenda.setBounds(500, 2, 600, 200);
		add(legenda);
		add(labelDescricao);
		add(gatoPreto);
		add(gatoVermelho);
		add(gatoAzul);
		add(casinha);
		add(fundo);

	}

	public class Movimento extends Thread {
		public void run() {
			while (true) {
				try {
					sleep(200);
				} catch (Exception erro) {

				}
				// RegraGatoPreto
				if (gatoPreto.getX() <= 830) {
					gatoPreto.setIcon(new javax.swing.ImageIcon(getClass().getResource("gatoPretoParadoPequeno.png")));
					gatoPreto.setBounds(gatoPreto.getX() + 20, 280, 230, 225);
					try {
						sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					gatoPreto.setIcon(new javax.swing.ImageIcon(getClass().getResource("gatoPretoAndandoPequeno.png")));

				}
				// RegraGatoPreto
				if (gatoPreto.getX() >= 830 && gatoAzul.getX() <= 830) {
					gatoAzul.setIcon(new javax.swing.ImageIcon(getClass().getResource("gatoAzulParado.png")));
					gatoAzul.setBounds(gatoAzul.getX() + 20, 280, 230, 195);
					try {
						sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					gatoAzul.setIcon(new javax.swing.ImageIcon(getClass().getResource("gatoAzulAndando.png")));
				}
				// RegraGatoPreto
				if (gatoAzul.getX() >= 830 && gatoVermelho.getX() <= 830) {
					gatoVermelho.setIcon(new javax.swing.ImageIcon(getClass().getResource("gatoVermelhoParadoGrande.png")));
					gatoVermelho.setBounds(gatoVermelho.getX() + 20, 280, 270, 180);
					try {
						sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					gatoVermelho.setIcon(new javax.swing.ImageIcon(getClass().getResource("gatoVermelhoAndandoGrande.png")));
				}

				if (gatoPreto.getX() >= 830) {
					gatoPreto.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
				}
				if (gatoAzul.getX() >= 830) {
					gatoAzul.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
				}
				if (gatoVermelho.getX() >= 830) {
					gatoVermelho.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
				}

			}
		}
	}

	public static void main(String[] args) {
		new SJF();
	}
}