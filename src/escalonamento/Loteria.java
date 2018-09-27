package escalonamento;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Loteria  extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLabel menino = new JLabel(new ImageIcon(getClass().getResource("menino.png")));
	JLabel menina = new JLabel(new ImageIcon(getClass().getResource("menina2.png")));
	JLabel menina2 = new JLabel(new ImageIcon(getClass().getResource("menina.png")));
	JLabel casinha = new JLabel(new ImageIcon(getClass().getResource("escola.png")));
	JLabel labelDescricao = new JLabel(new ImageIcon(getClass().getResource("loteria.png")));


	public Loteria() {
		editarJanela();
		new Movimento().start();
	}

	public void editarJanela() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1220, 480);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		menino.setBounds(0, 220, 300, 220);
		menina.setBounds(200,  220, 300, 220);
		menina2.setBounds(360,  220, 300, 220);
		casinha.setBounds(700, 100, 450, 420);
		labelDescricao.setBounds(30, 0, 600, 200);
		add(labelDescricao);
		add(menino);
		add(menina);
		add(menina2);
		add(casinha);

	}

	public class Movimento extends Thread {
		public void run() {
			while (true) {
				try {
					sleep(200);
				} catch (Exception erro) {

				}
				// Regramenino
				if (menino.getX() <= 830) {
					menino.setBounds(menino.getX() + 15, 220, 300, 220);

 				}
				// Regramenino
				if (menino.getX() >= 830 && menina2.getX() <= 830) {
					menina2.setBounds(menina2.getX() + 15, 220, 300, 220);
				}
				// Regramenino
				if (menina2.getX() >= 830 && menina.getX() <= 830) {
					menina.setBounds(menina.getX() + 15,  220, 300, 220);

				}
				if (menino.getX() >= 830) {
					menino.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
				}
				if (menina2.getX() >= 830) {
					menina2.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
				}
				if (menina.getX() >= 830) {
					menina.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
				}

			}
		}
	}

	public static void main(String[] args) {
		new Loteria();
	}
}
