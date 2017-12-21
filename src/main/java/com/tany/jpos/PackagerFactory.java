package com.tany.jpos;

import com.tany.jpos.interfaces.MsgPackager;
import com.tany.jpos.io.Resource;
import com.tany.jpos.iso.ISOMsgPackager;

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

    public MsgPackager buildPackager(){
        return new ISOMsgPackager();
    }

    public MsgPackager buildPackager(Resource resource){
        return new ISOMsgPackager();
    }

}
