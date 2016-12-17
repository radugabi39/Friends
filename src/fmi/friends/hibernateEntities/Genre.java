package fmi.friends.hibernateEntities;

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
@Table(name = "GENRE", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Genre {

	private int id;
	private String name;

	private Set<Shows> shows = new HashSet<Shows>(
			0);


	public Genre(int id, String name, Set<Shows> shows) {
		super();
		this.id = id;
		this.name = name;
		this.shows = shows;
	}

	public Genre() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true, length = 11)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "NAME", length = 20, nullable = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genre")
	 @JsonManagedReference
	public Set<Shows> getShows() {
		return shows;
	}

	public void setShows(Set<Shows> shows) {
		this.shows = shows;
	}

}