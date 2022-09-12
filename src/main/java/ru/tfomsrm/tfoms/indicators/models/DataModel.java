package ru.tfomsrm.tfoms.indicators.models;

public class DataModel {

    private String nam_mok;
    private String count;

    public DataModel() {
    }

    public DataModel(String nam_mok, String count) {
        this.nam_mok = nam_mok;
        this.count = count;
    }

    public String getNam_mok() {
        return nam_mok;
    }

    public void setNam_mok(String nam_mok) {
        this.nam_mok = nam_mok;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
