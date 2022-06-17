import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class keywordMain {
	private static StringBuilder FileTextSB = new StringBuilder();
	private static ArrayList<String> keyWords = new ArrayList<String>();
	private static ArrayList<Integer> keyWordsNum = new ArrayList<Integer>();

	public static void findKeywords() {
		String FileTextString = FileTextSB.toString();
		String FileTextStringNoPunct = removePunctuations(FileTextString);
		String FileTextStringNoPunctOneSpaceLowercase = FileTextStringNoPunct.toLowerCase().replaceAll("\\s+", " ");
		String stringArray[] = FileTextStringNoPunctOneSpaceLowercase.split(" ");
		int i = 0;
		while (i < stringArray.length) {
			if (!keyWords.contains(stringArray[i])) {
				keyWords.add(stringArray[i]);
				keyWordsNum.add(1);
			} else {
				int j = 0;
				while (!stringArray[i].equals(keyWords.get(j))) {
					j = j + 1;
				}
				keyWordsNum.set(j, keyWordsNum.get(j) + 1);
			}
			i = i + 1;
		}
		int k = 0;
		int p;
		int g;
		int maxArray[] = new int[keyWords.size()];
		int maxItemNum[] = new int[keyWords.size()];
		while (k < keyWords.size()) {
			p = 0;
			while (keyWordsNum.get(k) <= maxArray[p]) {
				p = p + 1;
			}
			g = 50;
			while (g > p) {
				maxArray[g] = maxArray[g - 1];
				maxItemNum[g] = maxItemNum[g - 1];
				g = g - 1;
			}
			maxArray[p] = keyWordsNum.get(k);
			maxItemNum[p] = k;
			k = k + 1;
		}
		System.out.println("50 most common words and number of instances: ");
		int y = 0;
		while (y < 50) {
			System.out.println(keyWords.get(maxItemNum[y]) + "		" + keyWordsNum.get(maxItemNum[y]));
			y = y + 1;
		}
	}

	public static void findKeyPhraseTwo() {

	}

	public static void findKeyPhraseThree() {

	}

	public static String removePunctuations(String source) {
		return source.replaceAll("\\p{Punct}", "");
	}

	public static void getFileText(String fileName) {
		try {
			String str;
			File myFile = new File(fileName);
			Scanner myReader = new Scanner(myFile);
			while (myReader.hasNextLine()) {
				str = myReader.nextLine();
				FileTextSB.append(str + " ");
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("What is the name/path of your file? ");
		String fileName = scnr.nextLine();
		getFileText(fileName);
		findKeywords();
	}
}