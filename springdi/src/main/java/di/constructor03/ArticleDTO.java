package di.constructor03;

public class ArticleDTO {
	String name;
	String title;
	String cotent;
	String date;
	public ArticleDTO() {
		
	}
	
	public ArticleDTO(String name, String title, String cotent, String date) {
		super();
		this.name = name;
		this.title = title;
		this.cotent = cotent;
		this.date = date;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCotent() {
		return cotent;
	}
	public void setCotent(String cotent) {
		this.cotent = cotent;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
