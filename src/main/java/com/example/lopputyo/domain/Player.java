package com.example.lopputyo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//luodaan pelaaja ja annetaan sille attribuutit
@Entity
public class Player {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;

@Column(name = "firstname", nullable = false, unique = true)
private String firstName;

private String lastName, jersey, weight, height, games, goals, yellowCards, redCards;

public Player() {}


public Player(String firstName, String lastName, String jersey, String weight, String height, String games,
		String goals, String yellowCards, String redCards) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.jersey = jersey;
	this.weight = weight;
	this.height = height;
	this.games = games;
	this.goals = goals;
	this.yellowCards = yellowCards;
	this.redCards = redCards;
}
//getters and setters
public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getJersey() {
	return jersey;
}

public void setJersey(String jersey) {
	this.jersey = jersey;
}

public String getWeight() {
	return weight;
}

public void setWeight(String weight) {
	this.weight = weight;
}

public String getHeight() {
	return height;
}

public void setHeight(String height) {
	this.height = height;
}

public String getGames() {
	return games;
}

public void setGames(String games) {
	this.games = games;
}

public String getGoals() {
	return goals;
}

public void setGoals(String goals) {
	this.goals = goals;
}

public String getYellowCards() {
	return yellowCards;
}

public void setYellowCards(String yellowCards) {
	this.yellowCards = yellowCards;
}

public String getRedCards() {
	return redCards;
}

public void setRedCards(String redCards) {
	this.redCards = redCards;
}


@Override
public String toString() {
	return "Player [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", jersey=" + jersey
			+ ", weight=" + weight + ", height=" + height + ", games=" + games + ", goals=" + goals + ", yellowCards="
			+ yellowCards + ", redCards=" + redCards + "]";
}


	
}
