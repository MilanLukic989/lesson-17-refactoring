package exercises.ella;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game implements MouseListener, ActionListener {

	
	private JFrame frameGame;
	private PicturePanel panPicture;
	private SideBar bar;
	private JPanel panMain;
	private Emojis emoji;
	
	private Timer timer;
	private int time, gameNumber;
	
	private boolean checkMe1, checkMe2, checkMe3, checkMe4, checkMe5, checkMe6, checkMe7, checkMeL21,
	checkMeL22, checkMeL23, checkMeL24, checkMeL25, checkMeL26, checkMeL27;
	
	private JButton btnBalloon, btnSparkles, btnBackpack, btnDiamond, btnPawprints, btnSnake, btnRing,
	btnApple, btnBow, btnKey, btnCloud, btnChicken, btnRose, btnEarth, btnCactus;

	public static void main(String[] args) {
		Game ellasGame = new Game();
	}

	public Game() {
		frameGame = new JFrame();
		panPicture = new PicturePanel();
		bar = new SideBar();
		panMain = new JPanel();
		emoji = new Emojis();
		
		timer = new Timer(1000, this);
		time = 0;
		gameNumber = 0;
		
		checkMe1 = checkMe2 = checkMe3 = checkMe4 = checkMe5 = checkMe6 = checkMe7 = checkMeL21 =
		checkMeL22 = checkMeL23 = checkMeL24 = checkMeL25 = checkMeL26 = checkMeL27 = false;
		
		setup();
		timer.start();
	}


	private void setup() {
		// System.out.println(xList);
		frameGame.setSize(1800, 1000);
		// panMain.setPreferredSize(new Dimension(500, 500));
		frameGame.setLayout(new BorderLayout());
		panMain.add(panPicture, BorderLayout.WEST);
		panMain.add(bar, BorderLayout.EAST);
		frameGame.add(panMain);
		panPicture.setPreferredSize(new Dimension(1500, 1000));
		panPicture.setLayout(null);
		frameGame.setVisible(true);
		frameGame.addMouseListener(this);
		frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createLevelOneButtons();
	}
	
	private JButton createButton(String fileName, int xPosition, int yPosition) throws IOException {
		Image img = ImageIO.read(getClass().getResource(fileName));
		JButton btnTmp = new JButton(new ImageIcon(img));
		btnTmp.addMouseListener(this);
		btnTmp.setBorder(null);
		btnTmp.setBounds(xPosition, yPosition, 30, 30);
		return btnTmp;
	}

	private void createLevelOneButtons() {
		try {
			btnBalloon = createButton("img/balloon.png", 698, 336);
			btnSparkles = createButton("img/sparkles.png", 680, 756);
			btnBackpack = createButton("img/backpack.png", 840, 770);
			btnDiamond = createButton("img/diamond.png", 315, 900);
			btnPawprints = createButton("img/pawprints.png", 1079, 782);
			btnSnake = createButton("img/snake.png", 1100, 420);
			btnRing = createButton("img/WeddingRing.png",1460, 500);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		panPicture.add(btnBalloon);
		panPicture.add(btnSparkles);
		panPicture.add(btnBackpack);
		panPicture.add(btnDiamond);
		panPicture.add(btnPawprints);
		panPicture.add(btnSnake);
		panPicture.add(btnRing);
		panPicture.repaint();
	}
	
	

	void createLevelTwoButtons() {
		
		try {
			btnApple = createButton("img/apple.png", 503, 931);
			btnBow = createButton("img/bow.png", 953, 903);
			btnCloud = createButton("img/cloud.png", 460, 529);
			btnRose = createButton("img/rose.png", 719, 664);
			btnChicken = createButton("img/chicken.png", 351, 575);
			btnKey = createButton("img/key.png", 953, 903);
			btnEarth = createButton("img/earth.png", 1224, 879);
			btnCactus = createButton("img/cactus.png", 1224, 879);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		panPicture.add(btnApple);
		panPicture.add(btnBow);
		panPicture.add(btnCloud);
		panPicture.add(btnRose);
		panPicture.add(btnChicken);
		panPicture.add(btnSnake);
		panPicture.add(btnEarth);
		panPicture.add(btnCactus);
		panPicture.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX());
		System.out.println(e.getY());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == btnBalloon) {
			btnBalloon.setVisible(false);
			bar.foundBalloon();
			checkMe1 = true;
		}
		if (e.getSource() == btnPawprints) {
			btnPawprints.setVisible(false);
			bar.foundPawprint();
			checkMe2 = true;
		}
		if (e.getSource() == btnRing) {
			btnRing.setVisible(false);
			bar.foundRing();
			checkMe3 = true;
		}
		if (e.getSource() == btnSnake) {
			btnSnake.setVisible(false);
			bar.foundSnake();
			checkMe4 = true;
		}
		if (e.getSource() == btnBackpack) {
			btnBackpack.setVisible(false);
			bar.foundBackpack();
			checkMe5 = true;
		}
		if (e.getSource() == btnSparkles) {
			btnSparkles.setVisible(false);
			bar.foundSparkles();
			checkMe6 = true;
		}
		if (e.getSource() == btnDiamond) {
			btnDiamond.setVisible(false);
			bar.foundDiamond();
			checkMe7 = true;
		}

		if (isStageClear()) {
			timer.stop();
			JOptionPane.showMessageDialog(null, "Congratulations! You found all the pictures! \n You finished the puzzle in: " + time + " seconds. \n Ready for level 2?");
			panPicture.loadNextLevelPicture();
			bar.nextLevelBar();
			gameNumber += 1;
			checkMe1 = false;
			checkMe2 = false;
			checkMe3 = false;
			checkMe4 = false;
			checkMe5 = false;
			checkMe6 = false;
			checkMe7 = false;
			createLevelTwoButtons();
			time = 0;
			timer.restart();

		}

		if (e.getSource() == (btnApple)) {
			btnApple.setVisible(false);
			bar.foundApple();
			checkMeL21 = true;
		}
		if (e.getSource() == (btnBow)) {
			btnBow.setVisible(false);
			bar.foundBow();
			checkMeL22 = true;
		}
		if (e.getSource() == (btnRose)) {
			btnRose.setVisible(false);
			bar.foundRose();
			checkMeL23 = true;
		}
		if (e.getSource() == (btnCloud)) {
			btnCloud.setVisible(false);
			bar.foundCloud();
			checkMeL24 = true;
		}
		if (e.getSource() == (btnChicken)) {
			btnChicken.setVisible(false);
			bar.foundChicken();
			checkMeL25 = true;
		}
		if (e.getSource() == (btnEarth)) {
			btnEarth.setVisible(false);
			bar.foundEarth();
			checkMeL26 = true;
		}
		if (e.getSource() == (btnCactus)) {
			btnCactus.setVisible(false);
			bar.foundCactus();
			checkMeL27 = true;
		}
		
		if (checkMeL21 == true && checkMeL22 == true && checkMeL23 == true && checkMeL24 == true && checkMeL25 == true
				&& checkMeL26 == true && checkMeL27 == true) {
			timer.stop();
			JOptionPane.showMessageDialog(null, "Congratulations! You found all the pictures! \n You finished the puzzle in: " + time + " seconds.");
			System.exit(0);
		}
	}

	private boolean isStageClear() {
		return checkMe1 == true && checkMe2 == true && checkMe3 == true && checkMe4 == true && checkMe5 == true
				&& checkMe6 == true && checkMe7 == true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		time += 1;
		bar.showTime(time);
	}

}