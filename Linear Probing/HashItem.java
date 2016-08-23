package linearProbingHashing;

public class HashItem {
	private int key;
	private String value;
	
	HashItem(int key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public int getKey() {
		return key;
	}
	
	public String getValue() {
		return value;
	}
}
