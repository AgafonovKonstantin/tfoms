package ru.tfomsrm.tfoms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.tfomsrm.tfoms.domain.IndicatorsEnt;
import ru.tfomsrm.tfoms.domain.User;
import ru.tfomsrm.tfoms.indicators.Indicators;
import ru.tfomsrm.tfoms.repos.IndicatorsEntRepo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.UUID;

@Controller
public class Indicators_Controller {
    @Autowired
    private IndicatorsEntRepo indicatorsEntRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/28_indicators")
    private String COVID(Model model) {
        Iterable<IndicatorsEnt> indicatorsEnts = indicatorsEntRepo.findAll();
        model.addAttribute("indicatorsEnts", indicatorsEnts);
        return "/28_indicators";
    }

    @PostMapping("/28_indicators")
    private String addFile(@AuthenticationPrincipal User user,
                           @RequestParam("YEAR") Integer year,
                           @RequestParam("MONTH") Integer month
    ) {
        String uuidFile = UUID.randomUUID().toString();
        String fullFilename = "28_indicators_" + uuidFile + ".xls";

        IndicatorsEnt indicatorsEnt = new IndicatorsEnt(user);

        indicatorsEnt.setFilename(fullFilename);

        indicatorsEntRepo.save(indicatorsEnt);

        new Indicators(year, month, user, fullFilename, indicatorsEntRepo, indicatorsEnt.getId(), uploadPath).start();

        return "redirect:/28_indicators";
    }

    @GetMapping("/28_indicators/{file_name}")
    public HttpEntity getFile(@PathVariable("file_name") String fileName) throws IOException {

        Path path = Paths.get(uploadPath + "/" + fileName);
        byte[] excelContent = Files.readAllBytes(path);

        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "force-download"));
        header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=28_indicators_" + new Date() + ".xls");

        return new HttpEntity<>(new ByteArrayResource(excelContent), header);
    }
}
