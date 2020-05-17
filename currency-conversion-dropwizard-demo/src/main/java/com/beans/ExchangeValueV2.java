package com.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExchangeValueV2 {


    private Long id;

    private String from;

    private String to;

    private int conversionMultiple;

   // private String exchangeEnvironmentInfo;

    private String exchangeVersion="v2";

    @JsonProperty
    public String getExchangeVersion() {
        return exchangeVersion;
    }

   /* public void setExchangeEnvironmentInfo(String exchangeEnvironmentInfo) {
        this.exchangeEnvironmentInfo = exchangeEnvironmentInfo;
    }
*/
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

    /*@JsonProperty
    public String getExchangeEnvironmentInfo() {
        return exchangeEnvironmentInfo;
    }
*/
    public ExchangeValueV2() {
    }

    public ExchangeValueV2(Long id, String from, String to, int conversionMultiple) {
        super();
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }


    @Override
    public String toString() {
        return "ExchangeValueV2{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", conversionMultiple=" + conversionMultiple +
                //", exchangeEnvironmentInfo='" + exchangeEnvironmentInfo + '\'' +
                ", exchangeVersion='" + exchangeVersion + '\'' +
                '}';
    }
}
