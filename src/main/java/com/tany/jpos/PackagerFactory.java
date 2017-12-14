package com.tany.jpos;

import com.tany.jpos.interfaces.Packager;

public class PackagerFactory {
    private static PackagerFactory factory;

    private PackagerFactory(){

    }

    public static PackagerFactory getFactory(){
        if(factory != null){
            factory = new PackagerFactory();
        }
        return  factory;
    }

    public Packager buildPackager(){
        return new ISOPackager();
    }

}
