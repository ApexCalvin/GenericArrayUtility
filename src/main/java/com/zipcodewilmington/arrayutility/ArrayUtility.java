package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    //<T> makes the class generic
    T[] inputArr;

    public ArrayUtility(T[] inputArr) {
        //created generic arr to constructor
        this.inputArr = inputArr;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        int count = 0;
        //newArr[] = inputArr[] + arrayToMerger[]
        ArrayList<T> al = new ArrayList<>();
        al.addAll(List.of(inputArr));
        al.addAll(List.of(arrayToMerge));

        for (T obj : al) {
            if (obj == valueToEvaluate) {
                count++;
            }
        }
        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        ArrayList<T> al = new ArrayList<>();
        al.addAll(List.of(inputArr));
        al.addAll(List.of(arrayToMerge));

        T mostCommon = null;
        int count = 0;

        for (int i = 0; i < al.size(); i++) {
            T tempValue = al.get(i);
            int tempCount = 1;
            //System.out.println("Value '"+tempValue+"' count: "+tempCount);
            for (int j = i+1; j < al.size(); j++) {
                if(tempValue == al.get(j)) {
                    tempCount++;
                    //System.out.println("Value '"+tempValue+"' count: "+tempCount);
                }
            }
            if(tempCount > count) {
                count = tempCount;
                mostCommon = tempValue;
                //System.out.println("New most common: "+tempValue+", count: "+count);
            }
        }
        return mostCommon;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        int count = 0;
        for (T obj : inputArr) {
            if (obj == valueToEvaluate) {
                count++;
            }
        }
        return count;
    }

    public T[] removeValue(T valueToRemove) {
        ArrayList<T> newAL = new ArrayList<>();
        for (T obj : inputArr) {
            if (obj != valueToRemove) {
                newAL.add(obj);
            }
        }

        //T[] arr = new T[newAL.size()];
        //1. Arrays.copyOf
        T[] arr = Arrays.copyOf(inputArr, (newAL.size()));
        //2. (T[]) Array.newInstance()

        for (int i = 0; i < arr.length; i++) {
            arr[i] = newAL.get(i);
        }

        return arr;
    }

}
