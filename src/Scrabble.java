//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.util.Arrays;
//import java.util.LinkedList;
//
//public class Scrabble {
//	protected String[] words;
//	private LinkedList<String>[] hashTable;
//	private int[] ints;
//
//	public Scrabble() {
//
//	}
//
//	private boolean isPrime(int number) {
//		for (int i = 2; i < Math.sqrt(number); i++) {
//			if (number % i == 0) {
//				return false;
//			}
//		}
//		return true;
//	}
//
//	private int findPrimeNumber(int number) {
//		if (isPrime(number) == true) {
//			return number;
//		} else {
//			while (!isPrime(number)) {
//				number++;
//			}
//		}
//		return number;
//	}
//
//	String readFile(String searchFile) {
//		String output = "";
//		try {
//			File file = new File(searchFile);
//			File outputFile = new File("sevenCharacters");
//			if (file.exists()) {
//				System.out.println("file found");
//				FileReader input = new FileReader(file);
//				BufferedReader br = new BufferedReader(input);
//				// creating buckket Array
//				while (br.ready()) {
//					output += "" + (char) br.read();
//					//sorting wordInOrig --> sorted word
//					//String w;
//					//String s = sortTheWord(w);
//					//--> create method
//					//hashing sortingWord --> hash value
//					//check if bucket exists
//					//if not: create Bucket with HashValue for id
//					//if exists -> get that bucket to add strings
//					//adding original word into bucket
//					
//				}
//				br.close();
//				words = output.split(" ");
//			} else {
//				System.out.println("file does not exist");
//			}
//		} catch (Exception e) {			
//			System.out.println(e);
//		}
//		return output;
//	}
//
//	private void hash() {
//		hashTable = new LinkedList[words.length];
//		for(String s : words) {
//			int charValue = s.charAt(0);
//			int hashValue = charValue/7;
//			
//			if(hashTable[hashValue] == null) {
//				hashTable[hashValue].add(hashValue, s); ;
//			}
//			else {
//				hashTable[hashValue].add(s);
//			}
//		}
//	}
//	
//	public void printWords() {
//		System.out.println(Arrays.toString(words));
//	}
//
//	public static void main(String[] args) {
//		Scrabble s = new Scrabble();
//		System.out.println(s.readFile("test.txt"));
//		s.printWords();
//	}
//	//private String sortTheWord(String w){
//	//char[] wCharArray = new wCharArray();
//	//Arrays.sort(wCharArray);
//	//return newString(wCharArray);}
//	}
//
