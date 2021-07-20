package fahrtenbuch.gui;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

public class StartPanel extends JPanel {

	private int width;
	private int height;

	private final static int OFFSET = 20;

	private Point mClickedPoint = new Point(-1, -1);
	private Point mPositionPoint = new Point(-1, -1);

	private Shape scaleBorderShape;
	private Shape startShape;
	private List<Shape> playerShapes = new ArrayList<Shape>();
	private List<Shape> scaleShapes = new ArrayList<Shape>();

	private List<Boolean> activeScale = new ArrayList<Boolean>();
	private List<Boolean> pressedScale = new ArrayList<Boolean>();
	private List<Boolean> activePlayer = new ArrayList<Boolean>();

	private boolean resized= false; 

	private int playerCount = -1;

	private String[] playerNames = new String[16];

	double modifyer;
	double imageHeight;
	double imageWidth;

	public StartPanel(int widthInput, int heightInput) {

		modifyer = 17;
		imageHeight = heightInput / 7;
		imageWidth = widthInput / 17;

		this.width = widthInput;
		this.height = heightInput;

		setMaximumSize(new Dimension(widthInput, heightInput));
		setPreferredSize(new Dimension(widthInput, heightInput));
		setMinimumSize(new Dimension(widthInput, heightInput));

		setBackground(Color.white);
		repaint();
		Toolkit.getDefaultToolkit().sync();

		// BufferedImage myPicture = ImageIO.read(new File("./1.PNG"));

		setScaleShape();
		setPlayerShapes();

		initialiseActiveScales();
		setPresedScales();

		for (int i = 0; i < playerNames.length; i++) {
			Integer nameSub = i + 1;
			playerNames[i] = nameSub.toString();
		}

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mClickedPoint.setLocation(e.getX() - OFFSET, e.getY() - OFFSET);
				int x = e.getX();
				int y = e.getY();

				if (startShape.contains(x, y) && playerCount != -1) {
					
					System.out.println(width);
					System.out.println(height);
					
				}

				for (int i = 0; i < pressedScale.size(); i++) {
					if (scaleShapes.get(i).contains(x, y)) {
						playerCount = i + 3;
						resetPresedScales();
						pressedScale.set(i, true);
					}
				}

				for (int i = 0; i < playerShapes.size(); i++) {
					if (playerShapes.get(i).contains(x, y) && i <= playerCount - 1) {
						String newName = JOptionPane.showInputDialog(null,
								"Geben sie den Name für Spieler " + (i + 1) + " ein", "Spieler " + (i + 1),
								JOptionPane.PLAIN_MESSAGE);
						if (!newName.equals("")) {
							playerNames[i] = newName;
						}

					}
				}

				repaint();
				Toolkit.getDefaultToolkit().sync();
			}

		});

		addMouseMotionListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {
				mPositionPoint.setLocation(e.getX() - OFFSET, e.getY() - OFFSET);
				int x = e.getX();
				int y = e.getY();

				for (int i = 0; i < activeScale.size(); i++) {
					if (scaleShapes.get(i).contains(x, y)) {
						activeScale.set(i, true);
					} else {
						activeScale.set(i, false);
					}

				}
				repaint();
				Toolkit.getDefaultToolkit().sync();

			}
		});
	}
	
	public void setDimesions(int heightInput, int widthInput) {
		this.height=heightInput;
		this.width=widthInput;
		
		setMaximumSize(new Dimension(widthInput, heightInput));
		setPreferredSize(new Dimension(widthInput, heightInput));
		setMinimumSize(new Dimension(widthInput, heightInput));

		resized = true;
	}

	private void initialiseActiveScales() {
		for (int i = 0; i < 14; i++) {
			activeScale.add(false);
		}
	}

	private void setPresedScales() {
		for (int i = 0; i < 14; i++) {
			pressedScale.add(false);
		}
	}

	private void resetPresedScales() {
		for (int i = 0; i < pressedScale.size(); i++) {
			pressedScale.set(i, false);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (width != getWidth() || height != getHeight()||resized) {
			System.out.println("resize");
			width = getWidth();
			height = getHeight();
			imageHeight = height / 7;
			imageWidth = width / 17;

			resetScaleShape();
			resetPlayerShapes();
			resized=false;
		}

		final Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(new Color(205, 0, 0));
		Shape randowmShape = new Rectangle2D.Double(0, 0, width, height);
		g2d.fill(randowmShape);
		g2d.setColor(Color.black);
		g2d.draw(scaleBorderShape);

		g2d.setFont(new Font(((Graphics2D) g).getFont().getFontName(), Font.PLAIN, getHeight() / 30));

		for (int i = 0; i < 16; i++) {
			g2d.setColor(Color.black);
			g2d.draw(playerShapes.get(i));
			if (i <= playerCount - 1) {
				g2d.setColor(new Color(0, 205, 0));
			} else {
				g2d.setColor(Color.lightGray);
			}
			g2d.fill(playerShapes.get(i));

		}

		g2d.setColor(Color.black);

		for (int i = 0; i < 4; i++) {
			g2d.drawString(playerNames[i], (int) (imageWidth * ((i * 4) + 1)), (int) (imageHeight * 2.825));

		}

		for (int i = 0; i < 4; i++) {
			g2d.drawString(playerNames[i + 4], (int) (imageWidth * ((i * 4) + 1)), (int) (imageHeight * 3.825));

		}

		for (int i = 0; i < 4; i++) {
			g2d.drawString(playerNames[i + 8], (int) (imageWidth * ((i * 4) + 1)), (int) (imageHeight * 4.825));

		}

		for (int i = 0; i < 4; i++) {
			g2d.drawString(playerNames[i + 12], (int) (imageWidth * ((i * 4) + 1)), (int) (imageHeight * 5.825));

		}

		g2d.setColor(Color.black);
		g2d.setFont(new Font(((Graphics2D) g).getFont().getFontName(), Font.PLAIN, getHeight() / 20));

		for (int i = 0; i < activeScale.size(); i++) {
			if (activeScale.get(i)) {

				g2d.setColor(Color.darkGray);
			} else {
				g2d.setColor(Color.lightGray);
			}

			if (pressedScale.get(i)) {

				g2d.setColor(Color.darkGray);
			} else {
				g2d.setColor(Color.lightGray);
			}
			g2d.fill(scaleShapes.get(i));

			if (activeScale.get(i)) {
				g2d.setColor(Color.white);
				Integer intString = i + 3;
				g2d.drawString(intString.toString(), (int) (imageWidth + ((imageWidth * 15 / 14) * i)),
						(int) imageHeight * 2);
			}

			if (pressedScale.get(i)) {
				g2d.setColor(new Color(0, 205, 0));
				g2d.draw(scaleShapes.get(i));
				Integer intString = i + 3;
				g2d.drawString(intString.toString(), (int) (imageWidth + ((imageWidth * 15 / 14) * i)),
						(int) imageHeight * 2);

			}
		}

		if (playerCount != -1) {
			g2d.setColor(new Color(0,205, 0));
		} else {
			g2d.setColor(new Color(205, 0, 0));
		}

		startShape = new Rectangle2D.Double(imageWidth, imageHeight * 6.5, imageWidth * 15, imageHeight / 2);
		g2d.fill(startShape);
		
		g2d.setColor(Color.black);
		if (playerCount != -1) {
			g2d.drawString("Weiter", (int) (width/2-imageWidth),
					(int) (imageHeight * 6.85));

		}

	}

	public void setScaleShape() {
		scaleBorderShape = new Rectangle2D.Double(imageWidth - 1, imageHeight - 1, imageWidth * 15 + 1,
				imageHeight + 1);
		for (int i = 0; i < 14; i++) {
			scaleShapes.add(new Rectangle2D.Double(imageWidth + ((imageWidth * 15 / 14) * i), imageHeight,
					imageWidth * 15 / 16, imageHeight));

		}
	}

	private void resetScaleShape() {
		scaleBorderShape = new Rectangle2D.Double(imageWidth - 1, imageHeight - 1, imageWidth * 15 + 1,
				imageHeight + 1);
		for (int i = 0; i < 14; i++) {
			scaleShapes.set(i, new Rectangle2D.Double(imageWidth + ((imageWidth * 15 / 14) * i), imageHeight,
					imageWidth * 15 / 16, imageHeight));

		}

	}

	public void setPlayerShapes() {
		for (int i = 0; i < 4; i++) {
			playerShapes.add(new Rectangle2D.Double(imageWidth * ((i * 4) + 1), imageHeight * 2.5, imageWidth * 2,
					imageHeight / 2));
		}

		for (int i = 0; i < 4; i++) {
			playerShapes.add(new Rectangle2D.Double(imageWidth * ((i * 4) + 1), imageHeight * 3.5, imageWidth * 2,
					imageHeight / 2));
		}

		for (int i = 0; i < 4; i++) {
			playerShapes.add(new Rectangle2D.Double(imageWidth * ((i * 4) + 1), imageHeight * 4.5, imageWidth * 2,
					imageHeight / 2));
		}

		for (int i = 0; i < 4; i++) {
			playerShapes.add(new Rectangle2D.Double(imageWidth * ((i * 4) + 1), imageHeight * 5.5, imageWidth * 2,
					imageHeight / 2));
		}
	}

	private void resetPlayerShapes() {
		for (int i = 0; i < 4; i++) {
			playerShapes.set(i, new Rectangle2D.Double(imageWidth * ((i * 4) + 1), imageHeight * 2.5, imageWidth * 2,
					imageHeight / 2));
		}

		for (int i = 0; i < 4; i++) {
			playerShapes.set(i + 4, new Rectangle2D.Double(imageWidth * ((i * 4) + 1), imageHeight * 3.5,
					imageWidth * 2, imageHeight / 2));
		}

		for (int i = 0; i < 4; i++) {
			playerShapes.set(i + 8, new Rectangle2D.Double(imageWidth * ((i * 4) + 1), imageHeight * 4.5,
					imageWidth * 2, imageHeight / 2));
		}

		for (int i = 0; i < 4; i++) {
			playerShapes.set(i + 12, new Rectangle2D.Double(imageWidth * ((i * 4) + 1), imageHeight * 5.5,
					imageWidth * 2, imageHeight / 2));
		}

	}
}

/*
 * BufferedImage myPicture=null;
 * 
 * try { myPicture = ImageIO.read(new File("./1.PNG")); } catch (IOException e)
 * { // TODO Auto-generated catch block e.printStackTrace(); }
 * g.drawImage(myPicture, 20,20, 100, 100,null);
 */