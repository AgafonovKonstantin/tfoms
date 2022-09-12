package ru.tfomsrm.tfoms.indicators;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import ru.tfomsrm.tfoms.indicators.models.DataModel;
import ru.tfomsrm.tfoms.indicators.models.ResultRepo;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;


public class XLSXCreater {

    private String filename;
    private String uploadPath;

    public XLSXCreater(String filename, String uploadPath) {
        this.filename = filename;
        this.uploadPath = uploadPath;
    }

    public void create() throws Exception {
        // создание самого excel файла в памяти
        HSSFWorkbook workbook = new HSSFWorkbook();

        for (int i = 0; i < ResultRepo.getInstance().getLength(); i++) {
            // создание листа
            HSSFSheet sheet = null;

            if (i + 1 <= 3) {
                sheet = workbook.createSheet("1_" + (i + 1));
            }

            if (i + 1 <= 5 && i + 1 > 3) {
                sheet = workbook.createSheet("2_" + (i + 1 - 3));
            }

            if (i + 1 <= 7 && i + 1 > 5) {
                sheet = workbook.createSheet("3_" + (i + 1 - 5));
            }

            if (i + 1 <= 9 && i + 1 > 7) {
                sheet = workbook.createSheet("4_" + (i + 1 - 7));
            }

            if (i + 1 <= 11 && i + 1 > 9) {
                sheet = workbook.createSheet("5_" + (i + 1 - 9));
            }

            if (i + 1 <= 13 && i + 1 > 11) {
                sheet = workbook.createSheet("7_" + (i + 1 - 11));
            }

            if (i + 1 <= 15 && i + 1 > 13) {
                sheet = workbook.createSheet("8_" + (i + 1 - 13));
            }

            if (i + 1 <= 17 && i + 1 > 15) {
                sheet = workbook.createSheet("9_" + (i + 1 - 15));
            }

            if (i + 1 <= 19 && i + 1 > 17) {
                sheet = workbook.createSheet("10_" + (i + 1 - 17));
            }

            if (i + 1 <= 21 && i + 1 > 19) {
                sheet = workbook.createSheet("11_" + (i + 1 - 19));
            }

            if (i + 1 <= 23 && i + 1 > 21) {
                sheet = workbook.createSheet("12_" + (i + 1 - 21));
            }

            if (i + 1 <= 25 && i + 1 > 23) {
                sheet = workbook.createSheet("13_" + (i + 1 - 23));
            }

            if (i + 1 <= 27 && i + 1 > 25) {
                sheet = workbook.createSheet("14_" + (i + 1 - 25));
            }

            if (i + 1 == 28) {
                sheet = workbook.createSheet("15");
            }

            if (i + 1 == 29) {
                sheet = workbook.createSheet("16");
            }

            if (i + 1 <= 31 && i + 1 > 29) {
                sheet = workbook.createSheet("18_" + (i + 1 - 29));
            }

            if (i + 1 <= 33 && i + 1 > 31) {
                sheet = workbook.createSheet("19_" + (i + 1 - 31));
            }

            if (i + 1 <= 35 && i + 1 > 33) {
                sheet = workbook.createSheet("20_" + (i + 1 - 33));
            }

            if (i + 1 <= 37 && i + 1 > 35) {
                sheet = workbook.createSheet("21_" + (i + 1 - 35));
            }

            if (i + 1 <= 39 && i + 1 > 37) {
                sheet = workbook.createSheet("22_" + (i + 1 - 37));
            }

            if (i + 1 == 40) {
                sheet = workbook.createSheet("23");
            }

            if (i + 1 <= 42 && i + 1 > 40) {
                sheet = workbook.createSheet("26_" + (i + 1 - 40));
            }

            if (i + 1 <= 44 && i + 1 > 42) {
                sheet = workbook.createSheet("27_" + (i + 1 - 42));
            }
            // заполняем список какими-то данными
            List<DataModel> dataList = fillData(i);

            // счетчик для строк
            int rowNum = 0;

            // создаем подписи к столбцам (это будет первая строчка в листе Excel файла)
            Row row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue("МО");
            row.createCell(1).setCellValue("КОЛ-ВО");

            // заполняем лист данными
            for (DataModel dataModel : dataList) {
                createSheetHeader(sheet, ++rowNum, dataModel);
            }
        }

        // записываем созданный в памяти Excel документ в файл
        FileOutputStream out = new FileOutputStream(new File(uploadPath + "/" + filename));
        workbook.write(out);

        new ResultRepo().getInstance().clear();
    }

    private static void createSheetHeader(HSSFSheet sheet, int rowNum, DataModel dataModel) {
        Row row = sheet.createRow(rowNum);

        row.createCell(0).setCellValue(dataModel.getNam_mok());
        row.createCell(1).setCellValue(dataModel.getCount());

    }

    // заполняем список
    private static List<DataModel> fillData(int i) {
        List<DataModel> dataModels = new ArrayList<>();

        Hashtable<String, String> table = ResultRepo.get(i);
        Enumeration<String> e = table.keys();
        while (e.hasMoreElements()) {
            String key = e.nextElement();
            String value = String.valueOf(table.get(key));
            dataModels.add(new DataModel(key, value));
        }

        return dataModels;
    }
}
