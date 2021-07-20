package fahrtenbuch.gui;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;


public class Gui extends JFrame {
	private StartPanel start;

	private int width = 1366;
	private int height = 768;
	private GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	// private int width = gd.getDisplayMode().getWidth() / 2;
	// private int height = gd.getDisplayMode().getHeight() / 2;

	private int playerCount;

	public Gui() {

		super("Test");
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		setLocationRelativeTo(null);
		setBackground(Color.lightGray);
		System.out.println("gui gestartet");

	}

	public void setWidth(int widthInput) {
		this.width = widthInput;
		System.out.println(width);
	}

	public void setHeighht(int heightInput) {
		this.height = heightInput;
		System.out.println(height);
	}

	public void setPlayerCount(int playerCount) {
		this.playerCount = playerCount;
	}
	
	public void addStart() {
		start = new StartPanel(width, height);
		add(start);
		pack();
		revalidate();
		repaint();
		Toolkit.getDefaultToolkit().sync();
	}
	
	public StartPanel getStart() {
		return start;
	}

}
