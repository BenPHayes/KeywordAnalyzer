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
		String FileTextStringNoPunctOneSpace = FileTextStringNoPunct.replaceAll("\\s+", " ");
		System.out.println(FileTextStringNoPunctOneSpace);
		String stringArray[] = FileTextStringNoPunctOneSpace.split(" ");
		System.out.println(Arrays.toString(stringArray));
		int i = 0;
		while (i < stringArray.length) {
			if (!keyWords.contains(stringArray[i])){
				keyWords.add(stringArray[i]);
				keyWordsNum.add(1);
			}
			else {
				int j = 0;
				while (!stringArray[i].equals(keyWords.get(j))) {
					j = j + 1;
				}
				keyWordsNum.set(j, keyWordsNum.get(j) + 1);
			}
			i = i + 1;
		}
		int k = 0;
		int max = 0;
		int max2 = 0;
		int max3 = 0;
		int maxItemNum = 0;
		int maxItemNum2 = 0;
		int maxItemNum3 = 0;
		while (k < keyWords.size()){
			if (keyWordsNum.get(k) > max) {
				max3 = max2;
				max2 = max;
				max = keyWordsNum.get(k);
				maxItemNum3 = maxItemNum2;
				maxItemNum2 = maxItemNum;
				maxItemNum = k;
			}
			k = k + 1;
		}
		System.out.println("The three most common words are " + keyWords.get(maxItemNum) + ", " + keyWords.get(maxItemNum2) + ", and " + keyWords.get(maxItemNum3) + " with " + max + ", " + max2 + ", and " + max3 + " instances, respectively.");
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
    	}
    	catch (FileNotFoundException e) {
    		System.out.println("An error occurred.");
    		e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("What is the name of your file? ");
		/// String fileName = scnr.nextLine();
		getFileText("C:\\Users\\bills\\Downloads\\AnalystInternKeywords.txt");
		findKeywords();
	}
}