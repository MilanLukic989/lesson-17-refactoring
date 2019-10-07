package exercises.ella;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PicturePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static BufferedImage backgroundImg;
	private static BufferedImage backgroundImg2;
	private final int PUZZLE1_STATE = 0;
	private final int PUZZLE2_STATE = 1;
	private int currentState = PUZZLE1_STATE;

	public PicturePanel() {

		try {
			backgroundImg = ImageIO.read(this.getClass().getResourceAsStream("img/Umbrellas.jpg"));
			backgroundImg2 = ImageIO.read(this.getClass().getResourceAsStream("img/tokyo2.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void loadNextLevelPicture() {
		currentState += 1;
		if (currentState > PUZZLE2_STATE) {
			currentState = PUZZLE1_STATE;
		}
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		if (currentState == PUZZLE1_STATE) {
			g.drawImage(backgroundImg, 0, 0, null);
		} else if (currentState == PUZZLE2_STATE) {
			g.drawImage(backgroundImg2, 0, 0, null);
		}
	}
}