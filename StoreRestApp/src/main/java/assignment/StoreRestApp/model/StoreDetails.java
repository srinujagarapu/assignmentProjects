package assignment.StoreRestApp.model;

import java.util.List;

/**
 *  StoreDetails model class 
 */
public class StoreDetails {
	
	private long id;
	
	private String type;
	
	private String name;
	
	private String address;
	
	private String address2;
	
	private String city;
	
	private String state;
	
	private String zip;
	
	private Location location;
	
	private String hours;
	
	private List<String> services;
	
    public StoreDetails() {
		
	    }
	
	public StoreDetails(long id, String type, String name, String address, String address2, String city, String state,
			String zip, Location location, String hours, List<String> services) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.address = address;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.location = location;
		this.hours = hours;
		this.services = services;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public List<String> getServices() {
		return services;
	}

	public void setServices(List<String> services) {
		this.services = services;
	}

	

}
