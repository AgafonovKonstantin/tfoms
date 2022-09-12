package ru.tfomsrm.tfoms.naselenie;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

public class DBAdd {

    DBAdd(ArrayList<Record> records, Connection connection) throws Exception{

        String query = null;

        Statement statement = connection.createStatement();
        connection.setAutoCommit(false);

        for (int i = 0; i < records.size(); i++) {
            query = records.get(i).INFO;
            statement.executeUpdate(query);
        }
        statement.close();
        connection.commit();
    }

}
