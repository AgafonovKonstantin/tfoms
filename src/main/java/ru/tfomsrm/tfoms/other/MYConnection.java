package ru.tfomsrm.tfoms.other;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MYConnection {

    private static MYConnection instance;

    private static String url = "jdbc:sqlserver://blue\\medexp;User=***;Password=***;encrypt=true;trustServerCertificate=true;";
    private MYConnection(){}

    public static MYConnection getInstance() { // #3
        if (instance == null) {        //если объект еще не создан
            instance = new MYConnection();    //создать новый объект
        }
        return instance;
    }

    public static Connection connection = null;

    public static Connection getConnection() throws Exception{

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            connection = DriverManager.getConnection(url);

        return connection;
    }

    public static void closeConnection() throws SQLException{
            connection.close();
    }

}