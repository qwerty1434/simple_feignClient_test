package com.example.hobby.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="hobby")
public class HobbyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hobby_id;
    private String hobby_name;
}
