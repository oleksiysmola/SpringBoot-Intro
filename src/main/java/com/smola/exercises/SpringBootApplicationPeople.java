package com.smola.exercises;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringBootApplicationPeople {

    public static void main(String[] args) {
        Person noether = new Person(1, "Emmy Noether", 30);
        Person rubin = new Person(2, "Vera Rubin", 30);
        people.add(noether);
        people.add(rubin);
        SpringApplication.run(SpringBootApplicationPeople.class, args);
    }

    // All your code should be inside this one class
    // add @RestController to you expose methods as REST services to clients
    // create a static List of type person with few people inside
    static List<Person> people = new ArrayList<>();
    // create a class called Person with following properties: id, name, age
    static class Person{
        private int id;
        private String name;
        private int age;

        public Person(int id, String name, int age){
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    // implement getPersonById
    @GetMapping("people/{id}")
    public Person getPersonById(@PathVariable("id") Integer id) {
        // filter list and return person that matches id otherwise return null
        for (Person person: people){
            if (person.id == id){
                return person;
            }
        }
        return null;
    }
    // create another method that returns all people using @GetMapping("people")
    @GetMapping("people")
    public List<Person> getPeople() {
        return people;
    }
    // test your api using chrome
}
