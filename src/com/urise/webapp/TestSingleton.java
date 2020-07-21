package com.urise.webapp;

import com.urise.webapp.model.SectionType;

public class TestSingleton {
    // Lazy singleton, doesn't work for мультипоточность
    private static TestSingleton singleton;
    public static TestSingleton getSingleton(){
        if (singleton==null){
            singleton = new TestSingleton();
        }
        return singleton;
    }


    /*private TestSingleton(){};


    private static TestSingleton singleton = new TestSingleton();
    public static TestSingleton getSingleton(){
        return singleton;
    }*/
    private TestSingleton(){};

    public static void main(String[] args) {
        for(SectionType e : SectionType.values()){
            System.out.println(e + " " + e.getTitle());
        }
    }
}
