package ru.tfomsrm.tfoms.naselenie;

import java.util.Date;

public class Record {
    private String NUM;
    private String TFOMS;
    private String FAM;
    private String IM;
    private String OT;
    private String W;
    private String DR;
    private String ADDR;
    private String VOZ;
    private String COVID_GR;
    private String SS;
    private String ENP;
    private String SMO;
    private String LPU;
    private String DATE_COVID;
    private String DATE_STAC;
    private String DS1;
    private String DS2;
    private String DS_DATE;
    private String STT;
    private String date_ishod;
    private String ishod;
    private String DS_J;
    private String DS_I;
    private String DS_E;
    private String DS_C;
    private String DS_V;
    private String DS_TB;
    private String DS_OTHER;
    private String DN_GROUP;
    private String DN_DS;
    private String DN_GROUP_FACT;
    private String DN_DS_FACT;
    private String DISP_DATE_OLD;
    private String DISP_TYPE_OLD;
    private String DISP_RST_OLD;
    private String DISP_DATE_2021_1;
    private String DISP_TYPE_2021_1;
    private String DISP_RSLT_2021_1;
    private String OTHER_MO;
    private String DEATH;
    private String OID;
    private String FRMO_NAME;
    private String MO_NAME;
    private String MO_ADDR;
    private String MO_ADDR2;
    private String DISP_PLAN_TYPE;
    private String DISP_PLAN_DATE;
    private String COMMENT;
    private String gis_ID;
    private String GIS_GUID;
    private String srz_pid;
    private String ENP_STR;
    private String DISP_TYPE_2021_2;
    private String DISP_RSLT_2021_2;
    private String DISP_DATE_1_2021_2;
    private String DISP_DATE_2_2021_2;
    private String DISP_PLAN_DATE_YEAR;
    private String DISP_PLAN_PRIZNAK;
    private String DATEINSERT;

    public String INFO;

    Record(String mass[]) {

        this.NUM = mass[0];
        this.TFOMS = mass[1];
        this.FAM = mass[2];
        this.IM = mass[3];
        this.OT = mass[4];
        this.W = mass[5];
        this.DR = mass[6];
        this.ADDR = mass[7];
        this.VOZ = mass[8];
        this.COVID_GR = mass[9];
        this.SS = mass[10];
        this.ENP = mass[11];
        this.SMO = mass[12];

        if (mass[13].equals("")) this.LPU = "null";
        else this.LPU = mass[13];

        this.DATE_COVID = mass[14];
        this.DATE_STAC = mass[15];
        this.DS1 = mass[16];
        this.DS2 = mass[17];
        this.DS_DATE = mass[18];
        this.STT = mass[19];
        this.date_ishod = mass[20];
        this.ishod = mass[21];
        this.DS_J = mass[22];
        this.DS_I = mass[23];
        this.DS_E = mass[24];
        this.DS_C = mass[25];
        this.DS_V = mass[26];
        this.DS_TB = mass[27];
        this.DS_OTHER = mass[28];
        this.DN_GROUP = mass[29];
        this.DN_DS = mass[30];
        this.DN_GROUP_FACT = mass[31];
        this.DN_DS_FACT = mass[32];
        this.DISP_DATE_OLD = mass[33];
        this.DISP_TYPE_OLD = mass[34];
        this.DISP_RST_OLD = mass[35];
        this.DISP_DATE_2021_1 = mass[36];
        this.DISP_TYPE_2021_1 = mass[37];
        this.DISP_RSLT_2021_1 = mass[38];
        this.DISP_TYPE_2021_2 = mass[39];
        this.DISP_RSLT_2021_2 = mass[40];
        this.DISP_DATE_1_2021_2 = mass[41];
        this.DISP_DATE_2_2021_2 = mass[42];
        this.OTHER_MO = mass[43];
        this.DEATH = mass[44];
        this.OID = mass[45];
        this.FRMO_NAME = mass[46];
        this.MO_NAME = mass[47];
        this.MO_ADDR = mass[48];
        this.MO_ADDR2 = mass[49];
        this.DISP_PLAN_TYPE = mass[50];
        this.DISP_PLAN_DATE = mass[51];
        this.DISP_PLAN_DATE_YEAR = mass[52];
        this.DISP_PLAN_PRIZNAK = mass[53];
        this.COMMENT = mass[54];
        this.gis_ID = mass[55];
        this.GIS_GUID = mass[56];

        this.INFO = rowCreate();
    }

    public String rowCreate() {
        String query = "INSERT INTO DISP_GISOMS_100 (NUM, TFOMS, FAM, IM, OT, W, DR, ADDR, VOZ, COVID_GR, SS, ENP, SMO, LPU, DATE_COVID, DATE_STAC," +
                "DS1, DS2, DS_DATE, STT, DS_J, DS_I, DS_E, DS_C, DS_V, DS_TB, DS_OTHER, DN_GROUP, DN_DS, DN_GROUP_FACT, DN_DS_FACT ,DISP_DATE_OLD, DISP_TYPE_OLD, " +
                "DISP_RST_OLD, DISP_DATE_2021_1, DISP_TYPE_2021_1, DISP_RSLT_2021_1, OTHER_MO, DEATH, OID, FRMO_NAME, MO_NAME, MO_ADDR, MO_ADDR2, " +
                "DISP_PLAN_TYPE, DISP_PLAN_DATE, DISP_PLAN_PRIZNAK, COMMENT, gis_ID_NEW, GIS_GUID, srz_pid, DISP_TYPE_2021_2, DISP_RSLT_2021_2, DISP_DATE_1_2021_2, " +
                "DISP_DATE_2_2021_2, DATEINSERT, date_ishod, ishod) VALUES (CONVERT(int," + NUM + "), CONVERT(tinyint," + TFOMS + "), '" + FAM + "', '" + IM + "', '" + OT + "', '" + W +
                "' , CONVERT(DATE,'" + DR + "', 104), CONVERT(varchar(250), '" + addrConverter(ADDR) + "'), '" + VOZ + "', CONVERT(tinyint," + COVID_GR + "), '" + SS +
                "', '" + ENP + "', CONVERT(int," + SMO + "), CONVERT(int," + LPU + "), CONVERT(DATE,'" + DATE_COVID + "', 104)," +
                " CONVERT(DATE,'" + DATE_STAC + "', 104), CONVERT(varchar(250),'" + DS1 + "'), CONVERT(varchar(250), '" + DS2 + "'), CONVERT(DATE,'" + DS_DATE + "', 104), '" +
                STT + "', '" + DS_J + "', '" + DS_I + "', '" + DS_E + "', '" + DS_C + "', '" + DS_V + "', '" + DS_TB + "', '" + DS_OTHER + "', '" +
                DN_GROUP + "', '" + DN_DS + "', '" + DN_GROUP_FACT + "', '" + DN_DS_FACT + "', CONVERT(DATE,'" + DISP_DATE_OLD + "', 104), '" +
                DISP_TYPE_OLD + "', '" + DISP_RST_OLD + "', CONVERT(DATE,'" + DISP_DATE_2021_1 + "', 104), '" + DISP_TYPE_2021_1 +
                "', '" + DISP_RSLT_2021_1 + "', '" + OTHER_MO + "', '" + DEATH + "', '" + OID + "', '" + FRMO_NAME +
                "', '" + MO_NAME + "', '" + MO_ADDR + "', '" + MO_ADDR2 + "', '" + DISP_PLAN_TYPE + "', '" + DISP_PLAN_DATE + " " + DISP_PLAN_DATE_YEAR + "', '" + DISP_PLAN_PRIZNAK + "', " +
                "'" + COMMENT + "', CONVERT(varchar(20)," + gis_ID + "), CONVERT(nvarchar(50),'" + GIS_GUID + "'), CONVERT(int," + srz_pid + "), '"
                + DISP_TYPE_2021_2 + "', '" + DISP_RSLT_2021_2 + "', CONVERT(DATE,'" + DISP_DATE_1_2021_2 + "', 104), CONVERT(DATE,'"
                + DISP_DATE_2_2021_2 + "', 104), CONVERT(DATE, '" + dateConverter() + "', 104), '" + date_ishod + "', '" + ishod + "')\n\n";
        return query;
    }

    public String addrConverter(String str) {
        String[] words = str.split("\'");
        String result = "";
        for (int i = 0; i < words.length; i++) {
            result += words[i] + " ";
        }
        return result;

    }

    public String dateConverter() {
        Date current = new Date();
        String[] date = current.toString().split(" ");

        switch (date[1]) {
            case "Jan":
                date[1] = "01";
                break;
            case "Feb":
                date[1] = "02";
                break;
            case "Mar":
                date[1] = "03";
                break;
            case "Apr":
                date[1] = "04";
                break;
            case "May":
                date[1] = "05";
                break;
            case "Jun":
                date[1] = "06";
                break;
            case "Jul":
                date[1] = "07";
                break;
            case "Aug":
                date[1] = "08";
                break;
            case "Sept":
                date[1] = "09";
                break;
            case "Oct":
                date[1] = "10";
                break;
            case "Nov":
                date[1] = "11";
                break;
            case "Dec":
                date[1] = "12";
                break;
        }
        return DATEINSERT = date[2] + "." + date[1] + "." + date[5];

    }
}
