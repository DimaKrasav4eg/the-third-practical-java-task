package secondmission;

public class Person {

	public static void main(String[] args) {
		Person jojo = new Person("Joestar", "Joseph", "George");
		System.out.println(jojo.getFullName());
	}
	
	private String sName;
	private String fName;
	private String fatherName;
	
	public Person(String sName, String fName, String fatherName) {
		this.sName = sName;
		this.fName = fName;
		this.fatherName = fatherName;
	}
	
	public String getFullName() {
		StringBuilder str = new StringBuilder(this.sName);
		if (this.fName != null && this.fName.length() != 0) {
			str.append(" ")
			   .append(this.fName.charAt(0))
			   .append(".");
		}
		if (this.fatherName != null && this.fatherName.length() != 0) {
			str.append(" ")
			   .append(this.fatherName.charAt(0))
			   .append(".");
		}
		return str.toString();
	}
}
