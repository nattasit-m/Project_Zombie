package render;

import input.InputUtility;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameTitle extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean isTitle = true;
	private boolean swap = false;

	private int R = 0, G = 0, B = 0;
	private JLabel start = new JLabel("Press Any Key to Start", JLabel.CENTER);

	public GameTitle() {
		this.setPreferredSize(new Dimension(Resource.screenWidth,
				Resource.screenHeight));
		this.setLayout(new BorderLayout());

		// North Panel

		JLabel titleName = new JLabel("Hello .. it's Me!", JLabel.CENTER);
		titleName.setFont(Resource.wordFont);
		titleName.setForeground(Color.BLUE);

		this.add(titleName, BorderLayout.NORTH);

		// Center Panel

		start.setFont(Resource.biggerFont);
		this.add(start, BorderLayout.CENTER);

		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				InputUtility.setKeyPressed(e.getKeyCode(), true);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				InputUtility.setKeyPressed(e.getKeyCode(), false);
			}
		});

	}

	public void paintComponent(Graphics g) {
		if (!isTitle())
			return;
		super.paintComponent(g);
	}

	public void update() {
		if (!isTitle())
			return;
		R += 10;
		G += 10;
		B += 10;
		if (R <= 255 && G <= 255 && B <= 255)
			start.setForeground(new Color(R, G, B));
		else {
			R = 0;
			G = 0;
			B = 0;
		}
		for (int i = 0; i < 255; i++) {
			if (InputUtility.getKeyPressed(i)) {
				System.out.println("Swap");
				setTitle(false);
				setSwap(true);
				return;
			}
		}

	}

	public boolean isTitle() {
		return isTitle;
	}

	public void setTitle(boolean isTitle) {
		this.isTitle = isTitle;
	}

	public boolean isSwap() {
		return swap;
	}

	public void setSwap(boolean swap) {
		this.swap = swap;
	}

}
