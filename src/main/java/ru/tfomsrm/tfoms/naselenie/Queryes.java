package ru.tfomsrm.tfoms.naselenie;

import java.sql.Connection;
import java.sql.Statement;

public class Queryes {

    private static Connection connection;

    Queryes(Connection connection) {
        this.connection = connection;
    }

    public void query_1_run() throws Exception {
        String query = "update sz\n" +
                "\tset srz_pid = \n" +
                "\tsrz3_00.dbo.getPID(\n" +
                "\t\n" +
                "\t\t 'lpu'\n" +
                "\t\t ,case when sz.enp is not null then sz.enp\n" +
                "\t\t\t\telse null end\n" +
                "\t\t ,sz.fam,sz.im,sz.ot,sz.dr,null,sz.ss,null,null\n" +
                "\t\t ,null\n" +
                "\t\t ,null\n" +
                "\t\t ,null,null\n" +
                "\t\t --sz.DOCTYPE\n" +
                "\t\t )\n" +
                "  from [IESDB_analiz].[dbo].[DISP_GISOMS_100] sz";

        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
    }

    public void query_2_run() throws Exception {
        String query = "update sz\n" +
                "set srz_pid=p.id\n" +
                "--select *\n" +
                "from [IESDB_analiz].[dbo].[DISP_GISOMS_100] sz\n" +
                "inner join srz3_00.dbo.PEOPLE p on p.ss=sz.ss\n" +
                "\n" +
                "where --zu.id between @startid and @stopid and\n" +
                "sz.srz_pid is null and p.id is not null";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
    }

    public void query_3_run() throws Exception {
        String query = "update sz\n" +
                "set srz_pid=p.id\n" +
                "\n" +
                "from [IESDB_analiz].[dbo].[DISP_GISOMS_100] sz\n" +
                "\n" +
                "inner join srz3_00.dbo.HISTENP he on he.ENP=rtrim(ltrim(sz.ENP))\n" +
                "inner join srz3_00.dbo.PEOPLE p on he.pid=p.id\n" +
                "\n" +
                "where \n" +
                "sz.srz_pid is null and p.id is not null";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
    }

}
