package com.example.demo;

class Student implements Comparable<Student>
{
    private final String firstName;
    private final String lastName;
    private final String surName;
    private final int score;

    public Student(String firstName, String lastName, String surName, int score)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        this.score = score;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getSurName() {
        return surName;
    }
    public String getFullName() {return lastName + " " + firstName + " " + surName;}
    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Student student)
    {
        if (score == student.getScore()) return 0;
        if (score > student.getScore()) return -1;
        return 1;
    }
    public String toString()
    {
        return getFullName() + ": " + score;
    }
}