package ie.gmit.sw;

public class Runner {

	public static String myUrl;// this url string will be assigned url from menu.setURL and will be read into
								// parser.(line 23)

	public static void main(String[] args) throws Throwable {

		Menu menu = new Menu();
		
		menu.displayMenu();

	}

}
