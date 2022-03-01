package com.example.project1;

import java.util.ArrayList;
import java.util.List;

public class ValutesModel {
    private String date;
    private String previousDate;
    private String previousURL;
    private String timestamp;


    private List<ValuteModel> valutesModelList;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPreviousDate() {
        return previousDate;
    }

    public void setPreviousDate(String previousDate) {
        this.previousDate = previousDate;
    }

    public String getPreviousURL() {
        return previousURL;
    }

    public void setPreviousURL(String previousURL) {
        this.previousURL = previousURL;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<ValuteModel> getValutesModelList() {
        return valutesModelList;
    }

    public void setValutesModelList(List<ValuteModel> valutesModelList) {
        this.valutesModelList = valutesModelList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n Date:").append(this.date);

        if (this.valutesModelList != null) {
            for (ValuteModel valuteModel: this.valutesModelList) {
                sb.append("\n").append(valuteModel.toString());
            }
        }
        return sb.toString();
    }
}