package assignment.StoreRestApp.jpaEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STOREDETAILS")
public class StoreDetailsEntity {
		
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	   private long id;
		
	  @Column(name="type")
		private String type;
	  @Column(name="name")
		private String name;
	  @Column(name="address")
		private String address;
	  @Column(name="address2")
		private String address2;
	  @Column(name="city")
		private String city;
	  @Column(name="state")
		private String state;
	  @Column(name="zip")
		private String zip;
	 
		@Column(name="hours")
		private String hours;
		@Column(name="services")
		private String services;
		
	    public StoreDetailsEntity() {
			
		    }
		
		public StoreDetailsEntity(long id, String type, String name, String address, String address2, String city, String state,
				String zip, String hours,String services) {
			super();
			this.id = id;
			this.type = type;
			this.name = name;
			this.address = address;
			this.address2 = address2;
			this.city = city;
			this.state = state;
			this.zip = zip;
		
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

	
		public String getHours() {
			return hours;
		}

		public void setHours(String hours) {
			this.hours = hours;
		}

		public String getServices() {
			
			
			return services;
		}

		public void setServices(String services) {
			this.services = services;
		}



}
