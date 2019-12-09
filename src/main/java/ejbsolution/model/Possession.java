package ejbsolution.model;

import ejbsolution.enums.Possession_Type;
import javax.persistence.*;

@Entity
public class Possession {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="poss_id")
	private int id;
	
	@Column(name="poss_name")
	private String name;
	
	@Column(name="poss_type")
	private Possession_Type type;
	
	@Column(name="poss_maxperson")
	private int maxPerson;
	
	@Column(name="poss_price")
	private double price;
	
	@Column(name="poss_surface")
	private int surface;
	
	@Column(name="poss_description")
	private String description;

    public Possession() {}
    
	public Possession(String name, Possession_Type type, int maxPerson, double price, int surface, String description) {
		super();
		this.name = name;
		this.type = type;
		this.maxPerson = maxPerson;
		this.price = price;
		this.surface = surface;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Possession_Type getType() {
		return type;
	}

	public void setType(Possession_Type type) {
		this.type = type;
	}
	
	public int getMaxPerson() {
		return maxPerson;
	}

	public void setMaxPerson(int maxPerson) {
		this.maxPerson = maxPerson;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSurface() {
		return surface;
	}

	public void setSurface(int surface) {
		this.surface = surface;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Possession [id=" + id + ", name=" + name + ", type=" + type + ", maxPerson=" + maxPerson + ", price="
				+ price + ", surface=" + surface + ", description=" + description + "]";
	}
   
}
