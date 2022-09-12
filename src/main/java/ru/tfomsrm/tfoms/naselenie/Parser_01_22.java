package ru.tfomsrm.tfoms.naselenie;

import ru.tfomsrm.tfoms.other.MYConnection;
import ru.tfomsrm.tfoms.other.MyLogger;
import ru.tfomsrm.tfoms.domain.NasEnt;
import ru.tfomsrm.tfoms.repos.NasEntRepo;

import java.sql.SQLException;

public class Parser_01_22 extends Thread{

    private static MyLogger LOG = MyLogger.getInstance();

    NasEntRepo nasEntRepo;
    NasEnt nasEnt;
    String way;

    public Parser_01_22(NasEntRepo nasEntRepo, NasEnt nasEnt, String way){
        this.nasEntRepo = nasEntRepo;
        this.nasEnt = nasEnt;
        this.way = way;

    }

    public NasEntRepo getNasEntRepo() {
        return nasEntRepo;
    }

    public NasEnt getNasEnt() {
        return nasEnt;
    }

    public String getWay() {
        return way;
    }

    @Override
    public void run() {
            NasEntRepo nasEntRepo = getNasEntRepo();
            NasEnt ent = getNasEnt();
            nasEntRepo.setStatusById(1, ent.getId());

        try {
            MYConnection.getInstance();
            xlsxParser.parse(getWay());

            Queryes query = new Queryes(MYConnection.getConnection());
            query.query_1_run();
            query.query_2_run();
            query.query_3_run();

            MYConnection.getInstance().closeConnection();

            nasEntRepo.setStatusById(2, ent.getId());//файл успешно загружен
            LOG.info("Файл " + getWay() + " успешно загружен!");

        } catch (Exception e) {
            try {
                MYConnection.getConnection().rollback();
            } catch (SQLException ex) {
                LOG.info("Файл " + getWay() + " загрузился с ошибкой : " + ex.getMessage());
            } catch (Exception ex) {
                LOG.info("Файл " + getWay() + " загрузился с ошибкой : " + ex.getMessage());
            }
            nasEntRepo.setStatusById(3, ent.getId());//������
            LOG.info("Файл " + getWay() + " загрузился с ошибкой : " + e.getMessage());
        }
    }
}
