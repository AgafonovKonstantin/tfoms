package ru.tfomsrm.tfoms.indicators.queries;

import ru.tfomsrm.tfoms.other.MYConnection;
import ru.tfomsrm.tfoms.other.SQLReader;
import ru.tfomsrm.tfoms.indicators.models.ResultRepo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;

public class Fifteenth {

    public Fifteenth(int year, int month, String uploadPath) throws Exception {

        Connection connection = MYConnection.getConnection();
        String query = null;
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();

        query = "declare @month int = " + month + "\n" +
                "declare @year int = " + year + "\n" +

        new SQLReader(uploadPath + "/queries", "15.txt").read();

        ResultSet result_1 = statement.executeQuery(query);

        Hashtable table = new Hashtable();

        while (result_1.next()) {
            String nam_mok = result_1.getString("nam_mok");
            int count = result_1.getInt("col");

            table.put(nam_mok, count);
        }

        ResultRepo.getInstance().add(table);

        table = null;

        MYConnection.getInstance().closeConnection();

    }
}
