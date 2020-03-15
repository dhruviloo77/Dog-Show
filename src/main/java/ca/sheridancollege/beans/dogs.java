package ca.sheridancollege.beans;

public class dogs {
	public dogs(int id, String name, String ownerName, String breed, String groups, String gender,
			String ranking,String email) {
		super();
		this.id = id;
		this.name = name;
		this.ownerName = ownerName;
		this.breed = breed;
		this.groups = groups;
		this.gender = gender;
		this.ranking = ranking;
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public dogs() {
		super();
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getGroups() {
		return groups;
	}
	public void setGroups(String groups) {
		this.groups = groups;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRanking() {
		return ranking;
	}
	public void setRanking(String ranking) {
		this.ranking = ranking;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	int id;
	String name;
	String ownerName;
	String breed;
	String groups;
	String gender;
	String ranking;
	String email;
}