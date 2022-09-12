package ru.tfomsrm.tfoms.COVID;


import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

public class DBAdd {
    DBAdd(ArrayList<Record> records, Connection connection) throws Exception {
        String query = null;
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();

        query = "USE [IESDB]; \n" +
                "DISABLE TRIGGER [IES].R_NSI_COVID_INSURED_AfterInsertUpdate ON [IESDB].[IES].[R_NSI_COVID_INSURED];\n";
        statement.executeUpdate(query);

        for (int i = 0; i < records.size(); i++) {
            query = records.get(i).INFO;
            statement.executeUpdate(query);
        }

        query = "USE [IESDB]; \n" +
                "ENABLE TRIGGER [IES].R_NSI_COVID_INSURED_AfterInsertUpdate ON [IESDB].[IES].[R_NSI_COVID_INSURED];\n";
        statement.executeUpdate(query);

        query = "USE [IESDB]; \n" +
                "ENABLE TRIGGER [IES].R_NSI_COVID_INSURED_AfterInsertUpdate ON [IESDB].[IES].[R_NSI_COVID_INSURED];\n";
        statement.executeUpdate(query);

        query = "UPDATE [IESDB].[IES].[R_NSI_COVID_INSURED] SET column19 = 'programm' WHERE column19 IS NULL;";
        statement.executeUpdate(query);

        statement.close();
        connection.setAutoCommit(false);
        connection.commit();
    }
}

