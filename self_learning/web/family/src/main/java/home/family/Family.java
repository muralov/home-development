package home.family;

import java.time.LocalDate;

public class Family {
	
	private String name;
	private LocalDate startDate;
	private String location;
	
	public Family(String name, LocalDate startDate, String location) {
		this.name = name;
		this.startDate = startDate;
		this.location = location;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
