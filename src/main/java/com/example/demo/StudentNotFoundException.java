package com.example.demo;

import java.io.IOException;

public class StudentNotFoundException extends IOException
{
    public StudentNotFoundException(String errorMessage)
    {
        super(errorMessage);
    }
}