package com.revature.beans;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Table(name="Recipe")
public class Recipe {
	@Id
	@Column(name="Id")
	@SequenceGenerator(name="RECIPEID_SEQ", sequenceName="RECIPEID_SEQ", allocationSize=1)
	@GeneratedValue(generator="RECIPEID_SEQ", strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	@ManyToMany(mappedBy = "favorites")
    private List<User> users = new ArrayList<User>();
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
        name = "IngredientList", 
        joinColumns = { @JoinColumn(name = "RecipeId") }, 
        inverseJoinColumns = { @JoinColumn(name = "IngredientId") }
    )
    Set<Ingredient> ingredients = new HashSet<Ingredient>();
	
	public Recipe() {
		super();
	}
	public Set<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", description=" + description + ", ingredients=" + ingredients
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recipe other = (Recipe) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (ingredients == null) {
			if (other.ingredients != null)
				return false;
		} else if (!ingredients.equals(other.ingredients))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
