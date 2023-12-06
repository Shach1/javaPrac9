package com.example.demo;

import java.io.IOException;

public class EmptyStringExeption extends IOException
{
    public EmptyStringExeption(String errorMessage)
    {
        super(errorMessage);
    }
}
