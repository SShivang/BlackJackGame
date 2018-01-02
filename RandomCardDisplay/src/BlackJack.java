import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BlackJack implements ActionListener {
	
	// instance variables for this class
	
	private ImageIcon image = new ImageIcon("D2.jpg");
	private JLabel label = new JLabel("", image, JLabel.CENTER);
	private static JButton hit = new JButton("Hit");
	private static JButton stand = new JButton("Stand");
	private static JPanel options = new JPanel();
	private static JPanel card1 = new JPanel();
	private static JFrame window = new JFrame();
	private static JPanel win = new JPanel(new BorderLayout());
	private static JPanel panel = new JPanel(new FlowLayout());
	private static int tot = 0;
	private static int rounds = 0;
	private static JLabel Score = new JLabel("Score:" + tot);
	private static JPanel dealer = new JPanel(new FlowLayout());
	private ImageIcon initial = new ImageIcon("D2.jpg");
	private JLabel a = new JLabel("", initial, JLabel.CENTER);
	private int index = 1;
	private ArrayList<Integer> card = new ArrayList();
	private boolean ace = false;

	/*

	The default constuctor for the blackjack class
	*/
	
	public BlackJack() {

		window.setSize(500, 500);
		options.setLayout(new BoxLayout(options, BoxLayout.PAGE_AXIS));
		options.add(hit);
		options.add(stand);
		win.add(dealer, BorderLayout.NORTH);
		dealer.add(a);
		win.add(panel, BorderLayout.SOUTH);
		window.add(win);
		panel.add(options);
		panel.add(card1);
		hit.addActionListener(this);
		stand.addActionListener(this);
		panel.add(Score, FlowLayout.LEFT);
		window.setVisible(true);
	}

	public static void main(String args[]) {

		new BlackJack();

	}

	public void actionPerformed(ActionEvent a) {

		if (a.getSource().equals(hit)) {
			String a1 = rand();
			ImageIcon image = new ImageIcon(a1);

			JLabel w = new JLabel("", image, JLabel.CENTER);
			index++;
			card1.add(w);
			card.add(index);
			Score.setText("Score:" + tot);

			if (ace) {
				Score.setText("Score:" + " soft " + tot);
			}

			if (tot > 21) {

				Score.setText("Bust !");
				tot = 0;
				rounds++;			
				reset();


			}

			if (tot == 21) {

				Score.setText("BlackJack");
				tot = 0;
				reset();

			}

		}
		if (a.getSource().equals(stand)) {
			tot = 0;
			reset();
			Score.setText("Score:" + tot);
		}

	}

	public void reset() {

		card1.removeAll();
	}

	public String rand() {
		int random1 = (int) (Math.random() * 13 + 1);
		int random2 = (int) (Math.random() * 4 + 1);
		String name = "";

		if (random2 == 1) {
			name = "C" + random1 + ".jpg";

		}
		if (random2 == 2) {
			name = "D" + random1 + ".jpg";
		}
		if (random2 == 3) {
			name = "H" + random1 + ".jpg";
		}
		if (random2 == 4) {
			name = "S" + random1 + ".jpg";
		}

		if (random1 > 10) {
			tot = tot + 10;
		} else {
			tot = tot + random1;
		}

		if (random1 == 1) {
			tot = tot + 10;
			ace = true;

		}

		if (ace == true && tot > 21) {
			tot = tot - 10;
			tot++;
			ace = false;
		}

		return name;

	}

}
