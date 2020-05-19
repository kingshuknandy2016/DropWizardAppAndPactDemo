package com.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

public class CurrencyConversionBean {
    private Long id;

    private String from;

    private String to;

    private int conversionMultiple;

    private int quantity;

    private int totalCalculatedAmount;

    private String exchangeEnvironmentInfo;

    private String conversionEnvironmentInfo;

    public CurrencyConversionBean(Long id, String from, String to, int conversionMultiple, String exchangeEnvironmentInfo) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.exchangeEnvironmentInfo = exchangeEnvironmentInfo;
    }

    public CurrencyConversionBean(Long id, String from, String to, int conversionMultiple, int quantity, int totalCalculatedAmount, String exchangeEnvironmentInfo, String conversionEnvironmentInfo) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.quantity = quantity;
        this.totalCalculatedAmount = totalCalculatedAmount;
        this.exchangeEnvironmentInfo = exchangeEnvironmentInfo;
        this.conversionEnvironmentInfo = conversionEnvironmentInfo;
    }

    @JsonProperty
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @JsonView
    @JsonProperty
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @JsonProperty
    public int getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(int conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    @JsonProperty
    public int getQuantity() {
        return quantity;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @JsonProperty
    public int getTotalCalculatedAmount() {
        return totalCalculatedAmount;
    }

    public void setTotalCalculatedAmount(int totalCalculatedAmount) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    @JsonProperty
    public String getExchangeEnvironmentInfo() {
        return exchangeEnvironmentInfo;
    }

    public void setExchangeEnvironmentInfo(String exchangeEnvironmentInfo) {
        this.exchangeEnvironmentInfo = exchangeEnvironmentInfo;
    }

    @JsonProperty
    public String getConversionEnvironmentInfo() {
        return conversionEnvironmentInfo;
    }

    public void setConversionEnvironmentInfo(String conversionEnvironmentInfo) {
        this.conversionEnvironmentInfo = conversionEnvironmentInfo;
    }

    @Override
    public String toString() {
        return "CurrencyConversionBean{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", conversionMultiple=" + conversionMultiple +
                ", quantity=" + quantity +
                ", totalCalculatedAmount=" + totalCalculatedAmount +
                ", exchangeEnvironmentInfo='" + exchangeEnvironmentInfo + '\'' +
                ", conversionEnvironmentInfo='" + conversionEnvironmentInfo + '\'' +
                '}';
    }
}
