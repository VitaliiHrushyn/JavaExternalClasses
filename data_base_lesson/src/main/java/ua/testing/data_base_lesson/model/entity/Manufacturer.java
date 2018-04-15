package ua.testing.data_base_lesson.model.entity;

public class Manufacturer {
	
	private int id;
	private String manufacture;
	private int discount;
	
	public Manufacturer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	 @Override
	    public String toString() {
	        return "Manufacturer{" +
	                System.identityHashCode(this)+
	                ", id=" + id +
	                ", manufacture='" + manufacture + '\'' +
	                ", discount=" + discount +
	                '}';
	    }
}
