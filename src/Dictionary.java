import java.io.*;
import java.util.*;

public class Dictionary {
	private ArrayList<Bucket> buckets;
	private ArrayList<String> words;

	public Dictionary() {
		buckets = new ArrayList<>();
	}

	public static void main(String[] args) throws IOException {
		Dictionary dic = new Dictionary();
		dic.readFile();
		dic.buildHashTable();
		
		dic.find("stranger");

	}

	public void readFile() {
		try {
			File input = new File("dictionary1.txt");
			BufferedReader br = new BufferedReader(new FileReader(input));
			String line;
			words = new ArrayList<>();
			while ((line = br.readLine()) != null) {
					words.add(line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void buildHashTable() {
		for (String line : words) {
			boolean found = false;
			int hashNumber = hashNumber(line);

			for (Bucket bucket : buckets) {
				if (bucket.getId() == hashNumber && !bucket.isDuplicate(line)) {
					bucket.add(line);
					found = true;
				}
			}
			if (!found) {
				buckets.add(new Bucket(hashNumber, line));
			}
		}
	}

	private String sortTheWord(String word) {
		String wordToBeSorted = word;
		char[] charArray = wordToBeSorted.toCharArray();
		Arrays.sort(charArray);
		word = new String(charArray);
		return word;
	}

	private int hashNumber(String hashingWord) {
		long sum = 0;
		hashingWord = sortTheWord(hashingWord);
		for (int i = 0; i < hashingWord.length(); i++) {
			int exp = i + 1;
			int hashValue = hashingWord.charAt(i);
			long deluxeHash = (long) Math.pow(hashValue, exp);
			sum += deluxeHash;
		}
		int hash = (int) (sum % findPrimeNumber());
		return hash;
	}

	private boolean isPrime(int number) {
		for (int i = 2; i < Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	private long findPrimeNumber() {
		int number = words.size();
		if (isPrime(number) == true) {
			return number;
		} else {
			while (!isPrime(number)) {
				number++;
			}
		}
		return number;
	}

	public int whosGotTheLongest() {
		int longest = 0;
		for (Bucket bucket : buckets) {
			int temp = 0;
			for (String s : bucket.getValues()) {
				temp++;
			}
			if (temp > longest) {
				longest = temp;
			}
		}
		return longest;
	}

	private void lookup(String line) {
		int hashNumber = hashNumber(line);

		for (Bucket bucket : buckets) {
			if (bucket.getId() == hashNumber) {
				for(String value : bucket.getValues()) {
					if(isPermultation(value, line)) {
						System.out.println(value);
					}
				}
			}
		}
	}
	
	private void find(String line) {
		Substring substring = new Substring(line);
		HashSet<String> substrings = substring.findSubstrings();
		
		for(String s : substrings) {
			lookup(s);
		}
	}

	protected boolean isPermultation(String word1, String word2) {
		if (sortTheWord(word1).equals(sortTheWord(word2))) {
			return true;
		} else {
			return false;
		}
	}

	public char randomWord() {
		Random rnd = new Random();
		String s = "";
		for (int i = 0; i < 7; i++) {
			s += (char)(97 + rnd.nextInt(26));
		}
		System.out.println(s);
		return 0;
	}
}