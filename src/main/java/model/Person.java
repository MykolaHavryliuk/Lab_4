package model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Person {
    public enum Gender{
        male, female, child;
    }

    @Size(min = 2, max = 16, message = "Name must be between 2 and 16 symbols")
    private String name;
    private String surname;

    @Min(value = 1900, message = "Must be not lower then 1900")
    @Max(value = 2020, message = "Must be not higher then 2020")
    private int year;

    @NotNull
    private Gender gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Person(){

    }

    private Person(Builder builder){
        this.name = builder.name;
        this.surname = builder.surname;
        this.year = builder.year;
        this.gender = builder.gender;
    }

    public static class Builder{
        private String name;
        private String surname;
        private int year;
        private Gender gender;

        public Builder(String name, String surname){
            this.name = name;
            this.surname = surname;
        }

        public Builder setYear(int year){
            this.year = year;
            return this;
        }


        public Builder setGender(Gender gender){
            this.gender = gender;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) &&
                surname.equals(person.surname) &&
                Objects.equals(year, person.year) &&
                gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year, gender);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdate=" + year +
                ", gender=" + gender +
                '}';
    }
}
