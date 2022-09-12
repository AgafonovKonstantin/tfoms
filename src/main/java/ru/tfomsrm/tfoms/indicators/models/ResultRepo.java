package ru.tfomsrm.tfoms.indicators.models;

import java.util.ArrayList;
import java.util.Hashtable;

public class ResultRepo {
    private static ResultRepo INSTANCE;

    public ResultRepo(){}

    public static ResultRepo getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ResultRepo();
        }
        return INSTANCE;
    }

    static ArrayList<Hashtable> results = new ArrayList<>();

    public static void add(Hashtable info){
        results.add(info);
    }

    public static Hashtable get(int number){
        return results.get(number);
    }

    public static int getLength() {
        return results.size();
    }

    public void clear(){
        results = new ArrayList<>();
    }
}
