import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Corrida extends JFrame implements Runnable{
	
	private int posRato [] = { 10, 10, 10, 10 };
	private JButton bt = new JButton("Correr");
	private Thread th;

	public Corrida() {
		super("Corrida");
		this.getContentPane().setBackground(Color.GREEN);
		this.setSize(500,500);
		//this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pn = new JPanel();
		pn.add(bt);
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				correr();
			}
		});
		this.add(pn,BorderLayout.SOUTH);
		this.setVisible(true);
		this.repaint(); // prevenir bugs, se nao aparecer nada;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawString("~(1):->",posRato[0],100); // coord, coord, largura, altura
		g.drawString("~(2):->",posRato[1],150);
		g.drawString("~(3):->",posRato[2],200);
		g.drawString("~(4):->",posRato[3],250);
	}
	
	public static void main(String[] args) {
		new Corrida();
	}
	
	public void correr() {
		posRato = new int[]{ 10, 10, 10, 10 };
		th = new Thread(this);
		th.start();
	}
	
	public void run() {
		while(
				posRato[0] < 450 && posRato[1] < 450 &&
				posRato[2] < 450 && posRato[3] < 450
			) {
				posRato[(int)(Math.random()*4)]+=3;
				repaint();
				try {
				th.sleep(5); //milisegundos
				}catch(InterruptedException e) {
					
				}
			}
		int rato = 3;
		if(posRato[0] == 470) {
			rato = 0;
		}else if (posRato[1] == 470){
			rato = 1;
		}else if (posRato[2] == 470){
			rato = 2;
		}
		//JOptionPane.showMessageDialog(this, "O rato vencedor foi o : Rato ", posRato);
		JOptionPane.showMessageDialog(this, "O rato vencedor foi o: Rato " + (rato + 1 ), "Vencedor", JOptionPane.INFORMATION_MESSAGE);
	}
}