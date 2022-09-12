package ru.tfomsrm.tfoms.other;


import org.springframework.stereotype.Component;
import ru.tfomsrm.tfoms.domain.LogEntity;
import ru.tfomsrm.tfoms.repos.LogEntityRepo;

@Component
public class MyLogger {//класс синглетон создает логи

    static LogEntityRepo logEntityRepo;
    private static MyLogger instance;

    public MyLogger(LogEntityRepo logEntityRepo) {
        this.logEntityRepo = logEntityRepo;
    }

    public static MyLogger getInstance() { // #3
        if (instance == null) {        //если объект еще не создан
            instance = new MyLogger(logEntityRepo);    //создать новый объект
        }
        return instance;
    }

    public void info(String message) {
        LogEntity logEntity = new LogEntity();
        logEntity.setMessage(message);

        logEntityRepo.save(logEntity);
    }
}
