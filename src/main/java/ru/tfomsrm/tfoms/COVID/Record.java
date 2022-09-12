package ru.tfomsrm.tfoms.COVID;

public class Record {
    private String column0;
    private String column1;
    private String column2;
    private String column3;
    private String column4;
    private String column5;
    private String column6;
    private String column7;
    private String column8;
    private String column9;
    private String column10;
    private String column11;
    private String column12;
    private String column13;
    private String column14;
    private String column15;
    private String column16;
    private String column17;
    private String column18;
    private String column19;
    private String column20;
    private String column21;
    private String column22;
    private String column23;
    private String column24;
    private String column25;
    private String column26;

    public String INFO;

    Record(String mass[]) {
        column0 = mass[0];
        column1 = mass[1];
        column2 = mass[2];
        column3 = mass[3];
        column4 = mass[4];
        column5 = mass[5];
        column6 = mass[6];
        column7 = mass[7];
        column8 = mass[8];
        column9 = mass[9];
        column26 = mass[10];
        column10 = mass[11];
        column11 = mass[12];
        column21 = mass[13];
        column22 = mass[14];
        column12 = mass[15];
        column13 = mass[16];
        column14 = mass[17];
        column15 = mass[18];
        column16 = mass[19];
        column17 = mass[20];
        column18 = mass[21];
        column23 = mass[22];
        column24 = mass[23];

        INFO = rowCreate();
    }

    public String rowCreate() {
        String query = "INSERT INTO [IESDB].[IES].[R_NSI_COVID_INSURED] (column0, column1, column2, column3, column4, column5, column6, column7, column8, column9, column10," +
                "column11, column12, column13, column14, column15, column16, column17, column18, DictionaryBaseID, column21, column22, column23, column24, column26) " +
                "VALUES ('" + column0 + "', '" + column1 + "', '" + column2 + "', '" + column3 + "', '" + column4 + "', '" + column5 + "', '" + column6 + "', "+
                "'" + column7 + "', '" + column8 + "', '" + column9 + "', '" + column10 + "', '" + column11 + "', '" + column12 + "', '" + column13 + "', "+
                "'" + column14 + "', '" + column15 + "', '" + column16 + "', '" + column17 + "', '" + column18 + "', newid(),'" + column21 + "', '" + column22 + "', "+
                "'" + column23 + "', '" + column24 + "', '" + column26 + "')";
        return query;
    }
}
