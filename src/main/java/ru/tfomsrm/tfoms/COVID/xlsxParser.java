package ru.tfomsrm.tfoms.COVID;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import ru.tfomsrm.tfoms.other.MYConnection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

public class xlsxParser {

    private static int rowWidth = 24;

    private static ArrayList<Record> list = new ArrayList<>();

    public static void parse(String filename) throws Exception {
        MYConnection myconnection = MYConnection.getInstance();
        Connection connection = myconnection.getConnection();

        try {
            InputStream is = new FileInputStream(filename);
            Workbook workbook = StreamingReader.builder()
                    .rowCacheSize(100)
                    .bufferSize(4096)
                    .open(is);

            //разбираем первый лист входного файла на объектную модель
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> it = sheet.iterator();

            //проходим по всему листу
            Row row = it.next();
            row = it.next();
            while (it.hasNext()) {
                //long start = System.currentTimeMillis();
                row = it.next();

                String mass[] = new String[rowWidth];

                for (int i = 0; i < rowWidth; i++) {
                    Cell cell = row.getCell(i);
                    mass[i] = cell.getStringCellValue();
                }
                list.add(new Record(mass));
            }
            new DBAdd(list, connection);
        } catch (NullPointerException ex) {
            new DBAdd(list, connection);
        }

        connection.close();
    }
}


