package ru.tfomsrm.tfoms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.tfomsrm.tfoms.other.MyLogger;
import ru.tfomsrm.tfoms.repos.LogEntityRepo;

import javax.xml.ws.RequestWrapper;

@SpringBootApplication
public class TfomsApplication extends SpringBootServletInitializer {

    @Autowired
    static
    LogEntityRepo logEntityRepo;
    private static MyLogger LOG = new MyLogger(logEntityRepo).getInstance();

    public static void main(String[] args) {
        SpringApplication.run(TfomsApplication.class, args);

        LOG.info("=====================================================");
        LOG.info("Запуск программы!");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(TfomsApplication.class);
    }
}
