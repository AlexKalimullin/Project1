package com.example.project1;

public class ValuteModel {
    private String id;
    private String numCode;
    private String charCode;
    private int nominal;
    private String name;
    private double value;
    private double previous;

    public ValuteModel() {

    }

    public ValuteModel(String id, String numCode, String charCode, int nominal, String name, double value, double previous) {
        this.id = id;
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
        this.previous = previous;
    }

    public String getId() {
        return this.id;
    }

    public String getNumCode() {
        return this.numCode;
    }

    public String getCharCode() {
        return this.charCode;
    }

    public int getNominal() {
        return this.nominal;
    }

    public String getName() {
        return this.name;
    }

    public double getValue() {
        return this.value;
    }

    public double getPrevious() {
        return this.previous;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setPrevious(double previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {

        return "\tВалюта:\t" + this.charCode + "\n" +
                "\tноминал:\t" + this.nominal + "\n" +
                "\tнаименование:\t" + this.name + "\n" +
                "\tкурс к рублю:\t" + this.value + "\n";
    }
}

