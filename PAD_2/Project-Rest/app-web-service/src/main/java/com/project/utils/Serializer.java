
package com.project.utils;

import com.project.entity.Transaction;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;


public class Serializer {
    private static XStream xstream;
    private static Gson gson;

    static{
        xstream=new XStream();
        xstream.processAnnotations(Transaction.class);
        gson=new Gson();
    }
        
    
    
    
    public static String serializeToXML(Transaction transaction){
        return xstream.toXML(transaction);
    }
    
    
    public static Transaction deserializeFromXML(String serializedTransaction){
        return (Transaction) xstream.fromXML(serializedTransaction);
    }
    
    public static String serializeToJson(Transaction transaction){
        return gson.toJson(transaction);
    }
    
    public static Transaction deserializeFromJson(String serializedTransaction){
        return (Transaction) gson.fromJson(serializedTransaction, Transaction.class);
    }
    
}
