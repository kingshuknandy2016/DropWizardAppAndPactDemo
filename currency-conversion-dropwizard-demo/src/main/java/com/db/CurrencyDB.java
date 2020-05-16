package com.db;

import com.beans.ExchangeValue;

import java.util.ArrayList;
import java.util.Iterator;

public class CurrencyDB {

    public static ArrayList<ExchangeValue> exchangeValues=new ArrayList<ExchangeValue>();

    static{
        exchangeValues.add(new ExchangeValue(10001l, "USD", "INR", 65));
        exchangeValues.add(new ExchangeValue(10002l, "EUR", "INR", 75));
        exchangeValues.add(new ExchangeValue(10003l, "AUD", "INR", 25));

    }
    public static ExchangeValue getTheDesiredConversion(String from, String to) {

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
    }

    public static void main(String[] args) {
        ExchangeValue exchangeValue= CurrencyDB.getTheDesiredConversion("EUR","INR");
        System.out.println(exchangeValue);
    }
}
