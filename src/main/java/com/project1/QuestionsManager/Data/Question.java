package com.project1.QuestionsManager.Data;


import jakarta.persistence.*;

@Entity
@Table(name="questions")
public class Question {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    int id;

    @Column(name="Description")
    String description;

    @Column(name="Difficulty")
    String difficulty;//EASY, MEDIUM, HARD


    //
    public Question(int id, String description, String difficulty) {
        this.id = id;
        this.description = description;
        this.difficulty = difficulty;
    }

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
