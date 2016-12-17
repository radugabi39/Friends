package fmi.friends.hibernateEntities;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="TITLE", 
	   uniqueConstraints={@UniqueConstraint(columnNames={"ID"})})
public class Title {


	private int id;
	private String name;
	private Set<UserTitle> userTitles = new HashSet<UserTitle>(0);
	
	public Title() {
		super();
	}
	public Title(int id, String name, Set<UserTitle> userTitles) {
		super();
		this.id = id;
		this.name = name;
		this.userTitles = userTitles;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true, length=11)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="NAME", length=20, nullable=true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "title")
	 @JsonManagedReference
	public Set<UserTitle> getUserTitles() {
		return userTitles;
	}

	public void setUserTitles(Set<UserTitle> userTitles) {
		this.userTitles = userTitles;
	}
}