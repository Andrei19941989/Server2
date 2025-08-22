package com.example.server2;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;//кгонструктор со всеми параметрами
import lombok.Getter;//автоматическое создание геттеров дял всех полей класса
import lombok.NoArgsConstructor;
import lombok.Setter;
@Table(name="users")//анатоция с какой таблицей связан класс
@AllArgsConstructor
@Setter
@Getter
@Entity
@NoArgsConstructor
public class User {
    private String username;
    private String password;
    private String name;
    private String secondname;
    private int age;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public User( String username,String password,String name,String secondname,int age)
    {
        this.username=username;
        this.password=password;
        this.name=name;
        this.secondname=secondname;
        this.age=age;
    }

}