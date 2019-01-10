package com.revature.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Fridge")
public class Fridge {
	@Id
	@Column(name="Id")
	@SequenceGenerator(name="FRIDGEID_SEQ", sequenceName="FRIDGEID_SEQ")
	@GeneratedValue(generator="FRIDGEID_SEQ", strategy=GenerationType.AUTO)	
	private int id;
	private int userId;
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="Fridge_Ingredients",
			joinColumns=@JoinColumn(name="FridgeId"),
			inverseJoinColumns=@JoinColumn(name="IngredientId"))
	private Set<Ingredient> ingredients;
	
	public Fridge() {
		super();
	}

	public Fridge(int id, int userId, Set<Ingredient> ingredients) {
		super();
		this.id = id;
		this.userId = userId;
		this.ingredients = ingredients;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
		result = prime * result + userId;
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
		Fridge other = (Fridge) obj;
		if (id != other.id)
			return false;
		if (ingredients == null) {
			if (other.ingredients != null)
				return false;
		} else if (!ingredients.equals(other.ingredients))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fridge [id=" + id + ", userId=" + userId + ", ingredients=" + ingredients + "]";
	}
}
