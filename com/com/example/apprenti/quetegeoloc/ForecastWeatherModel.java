
package com.example.apprenti.quetegeoloc;

import java.util.ArrayList;

public class ForecastWeatherModel {

    private String cod;
    private Double message;
    private Integer cnt;
    private java.util.List<com.example.apprenti.quetegeoloc.List> list = new ArrayList<com.example.apprenti.quetegeoloc.List>();
    private City city;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public java.util.List<com.example.apprenti.quetegeoloc.List> getList() {
        return list;
    }

    public void setList(java.util.List<com.example.apprenti.quetegeoloc.List> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
