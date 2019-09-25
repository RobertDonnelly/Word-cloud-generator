package ie.gmit.sw;

import java.util.*;
import java.net.*;
import java.io.*;

public class Parser {
	// declarations
	private static final String IGNORE_FILE = "ignorewords.txt";

	// HashMap hashmap = new HashMap();
	// HashSet<String> ignore = new HashSet<String>();

	public ArrayList<String> list = new ArrayList<>();//these lists are populated by file/url and are passed into imageCloud
	public ArrayList<String> ignoreList = new ArrayList<>();

	// parse ignore file.
	public void fileIgnoreParse() throws IOException {
		long start = System.currentTimeMillis();
		BufferedReader ignoreFile = new BufferedReader(new FileReader(IGNORE_FILE));
		String next = null;


		while ((next = ignoreFile.readLine()) != null) {
			//O(1)
			ignoreList.add(next.toLowerCase());

			if (next.isEmpty())
				continue;

		}
		System.out.printf("parsing %s...\n", IGNORE_FILE);
		System.out.println("Time (ms):" + (System.currentTimeMillis() - start));
		System.out.println("Time Complexity = 0(n) where n = " + ignoreList.size());
		ignoreFile.close();
	}

	// parse in the input file
	public void parseFile(InputStream in) throws Exception {
		// "inputFile takes in the text file from the menu class"
		long start = System.currentTimeMillis();

		BufferedReader inputFile = new BufferedReader(new InputStreamReader(in));
		String next = null;

		while ((next = inputFile.readLine()) != null) {
			String[] words = next.split(" ");

			for (String word : words) {
					//O(n)
				if (!ignoreList.contains(word)) {// checks if word is in ignorefile and if it is not then it adds to ArrayList
					//O(1)
					list.add(word);
				}
			}
		}
		// System.out.println(list);
		System.out.printf("parsing %s...\n", Menu.getFile());
		System.out.println("Time (ms):" + (System.currentTimeMillis() - start));
		System.out.println("Time Complexity = 0(n) where n = " + list.size());
	}

	// parse the url
	public void parseUrl(String myUrl) throws IOException {
		long start = System.currentTimeMillis();

		URL useUrl = new URL(myUrl);
		BufferedReader inputUrl = new BufferedReader(new InputStreamReader(useUrl.openStream()));
		String next = null;

		while ((next = inputUrl.readLine()) != null) {
			String[] words = next.split(" ");

			for (String word : words) {
					//O(n)
				if (!ignoreList.contains(word)) {// checks if word is in ignorefile and if it is not then it adds to ArrayList
					//O(1)
					list.add(word);
				}
			}
		}

		// System.out.println(list);
		System.out.printf("parsing %s...\n", Menu.getURL());
		System.out.println("Time (ms):" + (System.currentTimeMillis() - start));
		System.out.println("Time Complexity = 0(n) where n = " + list.size());
	}

}