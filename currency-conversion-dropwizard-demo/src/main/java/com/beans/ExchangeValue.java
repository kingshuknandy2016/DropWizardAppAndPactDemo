package com.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class ExchangeValue {


    private Long id;

    private String from;

    private String to;

    private int conversionMultiple;

    private String exchangeEnvironmentInfo;

    public void setExchangeEnvironmentInfo(String exchangeEnvironmentInfo) {
        this.exchangeEnvironmentInfo = exchangeEnvironmentInfo;
    }

    @JsonProperty
    public Long getId() {
        return id;
    }

    @JsonProperty
    public String getFrom() {
        return from;
    }

    @JsonProperty
    public String getTo() {
        return to;
    }

    @JsonProperty
    public int getConversionMultiple() {
        return conversionMultiple;
    }

    @JsonProperty
    public String getExchangeEnvironmentInfo() {
        return exchangeEnvironmentInfo;
    }

    public ExchangeValue() {
    }

    public ExchangeValue(Long id, String from, String to, int conversionMultiple) {
        super();
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }

    @Override
    public String toString() {
        return "ExchangeValue{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", conversionMultiple=" + conversionMultiple +
                ", exchangeEnvironmentInfo='" + exchangeEnvironmentInfo + '\'' +
                '}';
    }
}
