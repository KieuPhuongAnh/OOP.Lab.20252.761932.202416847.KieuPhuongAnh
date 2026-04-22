public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    
    // Getter
 	public String getTitle() {
 		return title;
 	}
 	public String getCategory() {
 		return category;
 	}
 	public String getDirector() {
 		return director;
 	}
 	public int getLength() {
 		return length;
 	}
 	public float getCost() {
 		return cost;
 	}

    // Constructor 1: title
    public DigitalVideoDisc(String title) {
        this.title = title;
    }

    // Constructor 2: category, title, cost
    public DigitalVideoDisc(String category, String title, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    // Constructor 3: director, category, title, cost
    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    // Constructor 4: full
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }
    
}