package ru.tfomsrm.tfoms.indicators;

import ru.tfomsrm.tfoms.other.MyLogger;
import ru.tfomsrm.tfoms.domain.User;
import ru.tfomsrm.tfoms.indicators.queries.*;
import ru.tfomsrm.tfoms.repos.IndicatorsEntRepo;

public class Indicators extends Thread {

    public Integer year;
    public Integer month;
    public String filename;
    private User user;
    private IndicatorsEntRepo indicatorsEntRepo;
    private Long id;
    private String uploadPath;

    private static MyLogger LOG = MyLogger.getInstance();

    public Indicators(int year, int month, User user, String filename, IndicatorsEntRepo indicatorsEntRepo, Long id, String uploadPath) {
        this.year = year;
        this.month = month;
        this.user = user;
        this.filename = filename;
        this.indicatorsEntRepo = indicatorsEntRepo;
        this.id = id;
        this.uploadPath = uploadPath;
    }

    @Override
    public void run(){
        try {
            //System.out.println(0);
            new First(year, month,uploadPath);
            //System.out.println(1);
            new Second(year, month,uploadPath);
            //System.out.println(2);
            new Third(year, month,uploadPath);
            //System.out.println(3);
            new Fourth(year, month,uploadPath);
            //System.out.println(4);
            new Fifth(year, month,uploadPath);
            //System.out.println(5);
            //System.out.println(6);
            new Seventh(year, month,uploadPath);
            //System.out.println(7);
            new Eighth(year, month,uploadPath);
            //System.out.println(8);
            new Ninth(year, month,uploadPath);
            //System.out.println(9);
            new Tenth(year, month,uploadPath);
            //System.out.println(10);
            new Eleventh(year, month,uploadPath);
            //System.out.println(11);
            new Twelfth(year, month,uploadPath);
            //System.out.println(12);
            new Thirteenth(year, month,uploadPath);
            //System.out.println(13);
            new Fourteenth(year, month,uploadPath);
            //System.out.println(14);
            new Fifteenth(year, month,uploadPath);
            //System.out.println(15);
            new Sixteenth(year, month,uploadPath);
            //System.out.println(16);
            //System.out.println(17);
            new Eighteenth(year, month,uploadPath);
            //System.out.println(18);
            new Ninteenth(year, month,uploadPath);
            //System.out.println(19);
            new Twentieth(year, month,uploadPath);
            //System.out.println(20);
            new Twenty_first(year, month,uploadPath);
            //System.out.println(21);
            new Twenty_secound(year, month,uploadPath);
            //System.out.println(22);
            new Twenty_third(year, month,uploadPath);
            //System.out.println(23);
            //System.out.println(24);
            //System.out.println(25);
            new Twenty_sixth(year, month,uploadPath);
            //System.out.println(26);
            new Twenty_seventh(year, month,uploadPath);
            //System.out.println(27);

            new XLSXCreater(filename, uploadPath).create();
            indicatorsEntRepo.setStatusById(2, id);

            LOG.info("Файл " + uploadPath + "/" + filename + " успешно загружен!");
        }catch (Exception e){
            //e.printStackTrace();
            LOG.info(e.getMessage());
            indicatorsEntRepo.setStatusById(3, id);
        }

    }
}
