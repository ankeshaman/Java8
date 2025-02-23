package main.java.service;
import java.util.*;

public class Singletonclass {
	private static Singletonclass ins=null;
    public Singletonclass(){
        
    }
    public static synchronized Singletonclass getObj(){
        if(ins==null){
            ins=new Singletonclass();
        }
        return ins;
    }
}
