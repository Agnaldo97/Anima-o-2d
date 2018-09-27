package escalonamento;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Agnaldo Rogério
 */
public class FCFC extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLabel gatoPreto = new JLabel(new ImageIcon(getClass().getResource("gatoPretoParado.png")));
	JLabel gatoVermelho = new JLabel(new ImageIcon(getClass().getResource("gatoVermelhoParado.png")));
	JLabel gatoAzul = new JLabel(new ImageIcon(getClass().getResource("gatoAzulParado.png")));
	JLabel casinha = new JLabel(new ImageIcon(getClass().getResource("casinha.png")));
	JLabel fundo = new JLabel(new ImageIcon(getClass().getResource("fundo.jpg")));
	JLabel labelDescricao = new JLabel(new ImageIcon(getClass().getResource("FCFC.png")));


	public FCFC() {
		editarJanela();
		new Movimento().start();
	}

	public void editarJanela() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1220, 480);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		gatoPreto.setBounds(0, 280, 230, 195);
		gatoVermelho.setBounds(200, 280, 230, 195);
		gatoAzul.setBounds(360, 280, 230, 195);
		casinha.setBounds(800, 100, 450, 420);
		fundo.setBounds(0, 0, 1300, 480);
		labelDescricao.setBounds(30, 0, 600, 200);
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
				if (gatoAzul.getX() <= 830) {
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
					gatoVermelho.setIcon(new javax.swing.ImageIcon(getClass().getResource("gatoVermelhoParado.png")));
					gatoVermelho.setBounds(gatoVermelho.getX() + 20, 280, 230, 195);
					try {
						sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					gatoVermelho.setIcon(new javax.swing.ImageIcon(getClass().getResource("gatoVermelhoAndando.png")));
				}
				// RegraGatoPreto
				if (gatoVermelho.getX() >= 830 && gatoPreto.getX() <= 830) {
					gatoPreto.setIcon(new javax.swing.ImageIcon(getClass().getResource("gatoPretoParado.png")));
					gatoPreto.setBounds(gatoPreto.getX() + 20, 280, 230, 195);
					try {
						sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					gatoPreto.setIcon(new javax.swing.ImageIcon(getClass().getResource("gatoPretoAndando.png")));
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
		new FCFC();
	}
}