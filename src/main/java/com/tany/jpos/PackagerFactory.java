package com.tany.jpos;

import com.tany.jpos.interfaces.Packager;
import com.tany.jpos.io.Resource;

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

    public Packager buildPackager(Resource resource){
        return new ISOPackager();
    }

}
