
package customer;

public class CustomerDTO {
	private String id;
	private String pass;
	private String name;
	private String grade; // �ֹ��� ���� �ı⸦ 5�� �̻� ���� ���� VVIP, �������� GOLD
	
	public CustomerDTO() {
		
	}

	public CustomerDTO(String id, String pass, String name, String grade) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.grade = grade;
	}


	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", pass=" + pass + ", name=" + name + ", grade=" + grade + "]";
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}