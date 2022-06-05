package com.tstDak.vo;

public class TestVo {
	private long id;
    private String name;
    private String email;
    private String country;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "TestVo [id=" + id + ", name=" + name + ", email=" + email + ", country=" + country + "]";
	}

}
