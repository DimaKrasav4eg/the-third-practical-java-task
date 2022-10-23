package fourthmission;

public class Shirt {
	private String id;
	private String description;
	private String color;
	private String size;
	
	public Shirt(String id, String description, String color, String size) {
		this.id = id;
		this.description = description;
		this.color = color;
		this.size = size;
	}
	
	@Override
	public String toString() {
		return new StringBuilder("Shirt[id=")
				.append(this.id)
				.append(",description=")
				.append(this.description)
				.append(",color=")
				.append(this.color)
				.append(",size=")
				.append(this.size)
				.append("]")
				.toString();
	}
}
