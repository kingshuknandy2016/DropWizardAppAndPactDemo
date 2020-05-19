package com.db;

import com.beans.ExchangeValue;
import com.beans.ExchangeValueV2;

import java.util.ArrayList;
import java.util.Iterator;

public class CurrencyDBV2 {

    //public static ArrayList<ExchangeValue> exchangeValues=new ArrayList<ExchangeValue>();
    public static ArrayList<ExchangeValueV2> exchangeValues=new ArrayList<ExchangeValueV2>();

    static{
        /*exchangeValues.add(new ExchangeValue(10001l, "USD", "INR", 65));
        exchangeValues.add(new ExchangeValue(10002l, "EUR", "INR", 75));
        exchangeValues.add(new ExchangeValue(10003l, "AUD", "INR", 25));*/

        exchangeValues.add(new ExchangeValueV2(10001l, "USD", "INR", 65));
        exchangeValues.add(new ExchangeValueV2(10002l, "EUR", "INR", 75));
        exchangeValues.add(new ExchangeValueV2(10003l, "AUD", "INR", 25));

    }
/*    public static ExchangeValue getTheDesiredConversion(String from, String to) {

        Iterator iterator=exchangeValues.iterator();
        ExchangeValue exchangeValue=null;
        while (iterator.hasNext()){
            exchangeValue = (ExchangeValue) iterator.next();
            if(exchangeValue.getFrom().equalsIgnoreCase(from)&& exchangeValue.getTo().equalsIgnoreCase(to)){
                break;
            }
            exchangeValue=null;
        }
        System.out.println(exchangeValue);
        return exchangeValue;
    }*/

    public static ExchangeValueV2 getTheDesiredConversionV2(String from, String to) {

        Iterator iterator=exchangeValues.iterator();
        ExchangeValueV2 exchangeValue=null;
        while (iterator.hasNext()){
            exchangeValue = (ExchangeValueV2) iterator.next();
            if(exchangeValue.getFrom().equalsIgnoreCase(from)&& exchangeValue.getTo().equalsIgnoreCase(to)){
                break;
            }
            exchangeValue=null;
        }
        System.out.println(exchangeValue);
        return exchangeValue;
    }

    public static void main(String[] args) {
        ExchangeValueV2 exchangeValue= CurrencyDBV2.getTheDesiredConversionV2("EUR","INR");
        System.out.println(exchangeValue);
    }
}
