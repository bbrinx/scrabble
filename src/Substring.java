import java.util.Arrays;
import java.util.HashSet;

public class Substring {
	private HashSet<String> substrings;
	private HashSet<String> permutations;
	private String word;

	public Substring(String s) {
		substrings = new HashSet<>();
		permutations = new HashSet<>();
		this.word = s;
	}
	
	public HashSet<String> findSubstrings() {
		for (int i = 0; i < this.word.length(); i++) {
			for (int j = i+1; j <= this.word.length(); j++) {
				String sub = sortTheWord(this.word.substring(i,j));
				if(sub.length()>1) {
					substrings.add(sub);
				}
			}
		}
		return substrings;
	}
	
	public HashSet<String> findSubstrings2() {
		permutation("",this.word);
		for(String s : permutations) {
			for (int i = 0; i < s.length(); i++) {
				for (int j = i+1; j <= s.length(); j++) {
					
					String sub = sortTheWord(s.substring(i, j));
					if(sub.length()>1) {
						substrings.add(sub);
					}
				}
			}
		}
		
		return substrings;
	}
	
	private String sortTheWord(String word) {
		String wordToBeSorted = word.toLowerCase();
		char[] charArray = wordToBeSorted.toCharArray();
		Arrays.sort(charArray);
		word = new String(charArray);
		return word;
	}
	
	private HashSet<String> permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) permutations.add(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	    return permutations;
	}
	
	public static void main(String[] args) {
		Substring s = new Substring("Java");
		System.out.println(s.findSubstrings2());
	}
}


