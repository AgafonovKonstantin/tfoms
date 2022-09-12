package ru.tfomsrm.tfoms.COVID;

import ru.tfomsrm.tfoms.other.MYConnection;
import ru.tfomsrm.tfoms.other.MyLogger;
import ru.tfomsrm.tfoms.domain.FileEnt;
import ru.tfomsrm.tfoms.repos.FileEntRepo;

import java.sql.SQLException;

public class Registr extends Thread {

    private static MyLogger LOG = MyLogger.getInstance();

    private FileEntRepo entRepo;
    private FileEnt ent;
    private String way;

    public Registr(FileEntRepo ent, FileEnt fileEnt, String way) {
        this.entRepo = ent;
        this.ent = fileEnt;
        this.way = way;
    }

    public FileEntRepo getEntRepo() {
        return entRepo;
    }

    public FileEnt getEnt() {
        return ent;
    }

    public String getWay() {
        return way;
    }

    @Override
    public void run() {
        FileEntRepo fileEntRepo = getEntRepo();
        FileEnt ent = getEnt();
        fileEntRepo.setStatusById(1, ent.getId());//файл положен на загрузку

        try {
            xlsxParser.parse(getWay());
            MYConnection.getInstance().closeConnection();

            fileEntRepo.setStatusById(2, ent.getId());//файл успешно загружен
            LOG.info("Файл " + getWay() + " успешно загружен!");
        } catch (Exception e) {
            try {
                MYConnection.getConnection().rollback();
            } catch (SQLException ex) {
                LOG.info("Файл " + getWay() + " не загрузился! " + ex.getMessage());
            } catch (Exception ex) {
                LOG.info("Файл " + getWay() + " не загрузился! " + ex.getMessage());
            }
            fileEntRepo.setStatusById(3, ent.getId());//ошибка
            LOG.info("Файл " + getWay() + " не загрузился! " + e.getMessage());
        }
    }
}
