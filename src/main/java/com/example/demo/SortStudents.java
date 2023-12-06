package com.example.demo;


import java.util.ArrayList;

public class SortStudents
{
    public static ArrayList<Student> merge(ArrayList<Student> arr1, ArrayList<Student> arr2)
    {
        ArrayList<Student> result = new ArrayList<Student>();
        return merge(arr1, arr2, result);
    }

    public static ArrayList<Student> merge(ArrayList<Student> arr1, ArrayList<Student> arr2, ArrayList<Student> result)
    {
        if (arr1.isEmpty() && arr2.isEmpty())
        {
            return result;
        }
        else if (arr1.isEmpty())
        {
            result.addAll(arr2);
            arr2.clear();
            return result;
        }
        else if (arr2.isEmpty())
        {
            result.addAll(arr1);
            arr1.clear();
            return result;
        }
        else
        {
            if (arr1.get(0).compareTo(arr2.get(0)) < 0)
            {
                result.add(arr1.get(0));
                arr1.remove(0);
            }
            else
            {
                result.add(arr2.get(0));
                arr2.remove(0);
            }
            return merge(arr1, arr2, result);
        }
    }



    public static ArrayList<Student> mergeSort(ArrayList<Student> arr)
    {
        if (arr.size() < 2) return arr;
        else
        {
            ArrayList<Student> arr1 = new ArrayList<Student>();
            ArrayList<Student> arr2 = new ArrayList<Student>();
            arr1.addAll(arr.subList(0, arr.size() / 2));
            arr2.addAll(arr.subList(arr.size() / 2, arr.size()));
            return merge(mergeSort(arr1), mergeSort(arr2));
        }
    }
}