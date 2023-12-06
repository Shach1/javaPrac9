package com.example.demo;

import java.util.ArrayList;

public class LabClass
{
    private ArrayList<Student> students;
    public LabClass()
    {
        students = new ArrayList<>();
    }

    public void addStudent(String fName, String lName, String sName, int score) throws EmptyStringExeption
    {
        if (fName.isEmpty()) throw new EmptyStringExeption("Не указано имя!");
        if (lName.isEmpty()) throw new EmptyStringExeption("Не указана фамилия!");
        if (sName.isEmpty()) throw new EmptyStringExeption("Не указано отчество!");

        students.add(new Student(fName, lName, sName, score));
    }

    public String serchStudentForLastName(String lName) throws StudentNotFoundException, EmptyStringExeption {
        if (lName.isEmpty()) throw new EmptyStringExeption("Вы забыли написать фамилию!");
        for (var student:students)
        {
            if (student.getLastName().equals(lName)) return student.toString();
        }
        throw new StudentNotFoundException("Студент не найден >_<");
    }

    public void sortStudents() throws StudentNotFoundException
    {
        if (students.isEmpty()) throw new StudentNotFoundException("В списке нет ни одного студента");
        students = SortStudents.mergeSort(students);
    }

    public String getListOfStudents() throws EmptyStringExeption
    {
        if (students.isEmpty()) throw new EmptyStringExeption("В списке нет ни одного студента");
        String str = "";
        for (var student:students)
        {
            str += student.toString() + "\n";
        }
        return str;
    }

}