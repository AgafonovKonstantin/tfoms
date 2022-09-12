package ru.tfomsrm.tfoms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.tfomsrm.tfoms.domain.NasEnt;
import ru.tfomsrm.tfoms.domain.User;
import ru.tfomsrm.tfoms.naselenie.Parser_01_22;
import ru.tfomsrm.tfoms.repos.NasEntRepo;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class NasController {
    @Autowired
    private NasEntRepo nasEntRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/NAS")
    private String NAS(Model model) {
        Iterable<NasEnt> nasEnts = nasEntRepo.findAll();
        model.addAttribute("nasEnts", nasEnts);
        return "/NAS";
    }

    @PostMapping("/NAS")
    private String addFile(@AuthenticationPrincipal User user,
                           Map<String, Object> model,
                           @RequestParam("file") MultipartFile file
    ) throws IOException {
        NasEnt nasEnt = new NasEnt(user);
        String resultFilename = "";

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/"+ resultFilename));

            nasEnt.setFilename(resultFilename);

            nasEntRepo.save(nasEnt);

            new Parser_01_22(nasEntRepo, nasEnt,uploadPath + "/"+ resultFilename).start();//передаем путь + имя файла
        }


        Iterable<NasEnt> nasEnts = nasEntRepo.findAll();

        model.put("nasEnts", nasEnts);

        return "redirect:/NAS";
    }
}
