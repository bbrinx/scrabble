import java.util.ArrayList;

public class Bucket {
	private ArrayList<String> values;
	private final int ID;

	public Bucket(int id) {
		values = new ArrayList<>();
		this.ID = id;
	}
	
	public Bucket(int id, String value) {
		values = new ArrayList<>();
		this.ID = id;
		this.values.add(value);
	}
	
	public int getId() {
		return this.ID;
	}
	
	public void add(String value){
		values.add(value);
	}
	
	public boolean isDuplicate(String word) {
		boolean duplicate = false;
		for(String s : values) {
			if(word.equals(s)) {
				duplicate = true;
			}
		}
		return duplicate;
	}
	
	public ArrayList<String> getValues() {
		return this.values;
	}
	
	@Override
	public String toString() {
		String result = "";
		for(String s : values) {
			result += s + " ";
		}
		result += "ID: " + this.ID + "\n";
		return result;
	}
}
