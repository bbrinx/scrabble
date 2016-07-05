import java.util.HashSet;

public class Substring {
	private HashSet<String> substrings;
	private String word;

	public Substring(String s) {
		substrings = new HashSet<>();
		this.word = s;
	}
	
	public HashSet<String> findSubstrings() {
		for (int i = 0; i < this.word.length(); i++) {
			for (int j = i+1; j < this.word.length(); j++) {
				substrings.add(this.word.substring(i,j));
			}
		}
		return substrings;
	}
}


