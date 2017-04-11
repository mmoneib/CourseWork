package hello;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/*
 * The @JsonIdentityInfo was added to avoid recursive serialization of the
 *  many-tomany relationship. This indicates that each Language object will
 *  be serialized only once inside the JSON. When further serialization is 
 *  called for, its identity ("id" property) will be printed instead.
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
public class Language {
	@Id
	@GeneratedValue
	@Column(name = "LANGUAGE_ID", unique = true, nullable = false)
	private int id;

	private String language;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "languages")
	private Set<User> users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
