package escalonamento;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Prioridade extends JFrame {

	JLabel man = new JLabel(new ImageIcon(getClass().getResource("man.png")));
	JLabel idoso = new JLabel(new ImageIcon(getClass().getResource("idoso.png")));
	JLabel jovem = new JLabel(new ImageIcon(getClass().getResource("jovem.png")));
	JLabel medico = new JLabel(new ImageIcon(getClass().getResource("medico.gif")));
	JLabel fundo = new JLabel(new ImageIcon(getClass().getResource("fundo2.jpg")));
	JLabel hospital = new JLabel(new ImageIcon(getClass().getResource("hospital.jpg")));
	JLabel labelOptions = new JLabel("Escalonamento por Prioridade:");
	JLabel labelDescricao = new JLabel("No escalonamento por prioridades, a cada tarefa Ã© associada uma prioridade");
	JLabel labelDescricao1 = new JLabel(
			"(nÃºmero inteiro) usada para escolher a prÃ³xima tarefa a receber o processador,");
	JLabel labelDescricao2 = new JLabel("a cada troca de contexto.");

	public Prioridade() {
		editarJanela();
		new Movimento().start();
	}

	public void editarJanela() {
		labelDescricao.setFont(new Font("Dialog", Font.PLAIN, 16));
		labelDescricao1.setFont(new Font("Dialog", Font.PLAIN, 16));
		labelDescricao2.setFont(new Font("Dialog", Font.PLAIN, 16));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 480);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		man.setBounds(200, 30, 200, 400);
		idoso.setBounds(350, 120, 250, 380);
		jovem.setBounds(600, 40, 200, 400);
		medico.setBounds(800, 10, 400, 400);
		fundo.setBounds(0, 0, 1200, 1200);
		hospital.setBounds(10, 0, 140, 100);
		add(man);
		add(idoso);
		add(jovem);
		add(medico);
		add(fundo);
		add(hospital);

	}

	public class Movimento extends Thread {
		public void run() {
			while (true) {
				try {
					sleep(50);
				} catch (Exception erro) {

				}
				idoso.setBounds(idoso.getX() + 3, 50, 250, 380);
				if (idoso.getX() >= 730) {
					jovem.setBounds(jovem.getX() + 3, 50, 250, 400);
					remove(idoso);
				}
				if (jovem.getX() >= 730) {
					man.setBounds(man.getX() + 3, 50, 250, 400);
					remove(jovem);
				}
				if (man.getX() >= 700) {
					remove(man);
				}

			}
		}
	}

	public static void main(String[] args) {
		new Prioridade();
	}
}