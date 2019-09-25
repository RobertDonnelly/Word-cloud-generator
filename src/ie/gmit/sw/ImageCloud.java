package ie.gmit.sw;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;
import java.util.*;

public class ImageCloud
{
	static int i;
	String imageName="";

	public void GenerateImage(ArrayList<String> list,ArrayList<String>ignoreList) throws Exception {

		imageName=Menu.getImageFileName();//here we assign the image file name to the string in the (imageIO.write)

		int random1;
		int random2;
		int randomX;
		int randomY;

		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 62);
		BufferedImage image = new BufferedImage(600,600, BufferedImage.TYPE_3BYTE_BGR);
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.red);
		graphics.setFont(font);

		Random rand= new Random();

		for(i=0;i<Menu.getMaxWords();i++) {
			random1 = rand.nextInt(3);
			random2 = rand.nextInt(3);
			randomX = rand.nextInt(600);//X & Y are random int so that words appear in random cloud each time.
			randomY = rand.nextInt(600);

			if (random1 ==0) {
				font = new Font(Font.SANS_SERIF,Font.ITALIC, 42);
			}
			else if (random1 ==1) {
				font = new Font(Font.MONOSPACED,Font.ITALIC, 22);
			}
			else if (random1 ==2) {
				font = new Font(Font.MONOSPACED,Font.BOLD, 32);
			}

			if(random2 ==0) {
				graphics.setColor(Color.pink);
			}
			else if(random2 ==1) {
				graphics.setColor(Color.magenta);
			}
			else if(random2 ==2) {
				graphics.setColor(Color.orange);
			}

			graphics.drawString(list.get(i),randomX,randomY);
		}

		graphics.dispose();
		ImageIO.write(image, "png", new File(imageName));
		System.out.println("image Generated!");

	}



}