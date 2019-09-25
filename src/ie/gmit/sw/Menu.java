package ie.gmit.sw;

import java.util.*;
import java.io.*;

public class Menu {
	private static final int MAX_WORDS = 25;// default max words incase user dosen't specify

	private static Scanner console = new Scanner(System.in);

	private static String imageFileName="image.png";
	private static String inputFileName;
	private static String url;
	private static int maxWords =MAX_WORDS;
	boolean fileReal;
	public  int isFile=0; // using int instead of a boolean because i was getting errors constantly and using an int worked.
	boolean running = true;

	public Menu()  {
		String contentType;
		maxWords = MAX_WORDS;
		System.out.println("Word Cloud Generator - Robert Donnelly - G00358931");
		System.out.println("--------------------------------------------------");
		// user chooses file or url
		do {
			System.out.print("Type f to use a text file or url for a URL");
			contentType = console.next().toUpperCase();
		} while (!contentType.equals("F") && !contentType.equals("URL"));

		if (contentType.equals("F")) {
			isFile = 0;
			setFile();// runs the file input function
		} else if (contentType.equals("URL")) {
			isFile = 1;
			setURL();// runs the url input function
		}

	}

	// menu for user to select what they want to do.
	public void displayMenu() throws Throwable {
		String choice;
		System.out.println("______________________________MENU___________________________");
		System.out.println("_____________________________________________________________");
		System.out.println("please enter 1 to generate word cloud");
		System.out.println("please enter 2 to set image name");
		System.out.println("please enter 3 to set max number of words to display in image");
		System.out.println("please enter 4 to Exit/Terminate");
		System.out.printf("current max words is: %d\n",getMaxWords());
		System.out.printf("current image name is %s",getImageFileName());
		choice = console.next();

		if (choice.equals("1")) {
			Parser parser = new Parser();//parses file/url
			parser.fileIgnoreParse();
			System.out.println("==================================================");
			// if statement dictates if we parse file or url
			if (isFile == (int) 0) {
					parser.parseFile(new FileInputStream(Menu.getFile()));
					}
			else {
				System.out.println(getURL());	
				parser.parseUrl(getURL());
				}
			
			//after parsing the image
			ImageCloud img=new ImageCloud();
			img.GenerateImage(parser.list, parser.ignoreList);
		//	parser.parseFile(hashmap);
		//	img.GenerateImage(hashmap);
		} else if (choice.equals("2")) {
			setImageFileName();
		} else if (choice.equals("3")) {
			setMaxWords();
		} else if (choice.equals("4")) {
			System.out.println("GoodBye!");
			running = false;
		} else {
			System.out.println();
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("that is not a option :( enter again:");
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			choice = console.nextLine();
		}
		// while running is true the app will run, if not app closes
		while (running == true) {
			displayMenu();
		}
		System.exit(0);

	}

	// the user enters the file to be parsed
	public void setFile() {
		// TODO Auto-generated method stub
		String input = "";
		boolean fileReal = false;

		while (!fileReal) {
			System.out.println("please enter file name(please include the (.txt)\n");
			input = console.next();
			if (new File(input).isFile()) { // checks if file exists
				fileReal = true;
			} else {
				System.out.println("thats not a file try again");
			}
		}
		inputFileName = input;

	}// end of function
	public static String getFile() {
		return inputFileName;
	}

	// the user enters the url to be parsed
	public void setURL() {
		// TODO Auto-generated method stub
		String inputUrl = null;
		boolean validURL = false;

			while (!validURL) {
				System.out.print("please enter the full url you want to use: ");
				inputUrl = console.next();
				
				if (inputUrl.startsWith("http://") || inputUrl.startsWith("https://")) {
					validURL = true;
				} else {
					System.out.println("please enter a valid url.");
				}
			}
			url = inputUrl;// sets url

		
	}// end of function
	public static String getURL() {
		return url;
	}
	// the user enters the file name for the png image
	
	public void setImageFileName() {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner console = new Scanner(System.in);
		System.out.println("please enter a name for your png file:\n (do not enter .png only the name of the file)");
		imageFileName = console.nextLine();
		imageFileName += ".png";
		System.out.printf("your image name is now %s\n", imageFileName);
	}
	public static String getImageFileName() {
		return imageFileName;
	}

	// user enter the number of words to be outputted
	private void setMaxWords() {
		// TODO Auto-generated method stub
		int maxWords = getMaxWords();
		System.out.printf("the maximum number of words is: %d\n", maxWords);
		System.out.println("please enter the max number of words to be displayed:");
		maxWords = console.nextInt();
		System.out.printf("the maximum number of words is now %d\n", maxWords);// lets us know that the max numbers was
																				// changed
		Menu.maxWords = maxWords;// sets max words

	}
	public static int getMaxWords() {
		return maxWords;
	}

}// end of class
