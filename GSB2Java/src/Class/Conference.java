package Class;

public class Conference {
	//Atribue
	private int id;
	private String theme;
	
	//Constructeur
	public Conference(int unId,String unTheme) {
		this.id = unId;
		this.theme = unTheme;
	}

	public Conference(String unTheme) {
		// TODO Auto-generated constructor stub
		this.theme = unTheme;
	}

	//Getters et Setters
	public String getTheme() {
		return theme;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
}
