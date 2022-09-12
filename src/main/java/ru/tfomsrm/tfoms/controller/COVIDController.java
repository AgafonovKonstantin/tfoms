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
import ru.tfomsrm.tfoms.COVID.Registr;
import ru.tfomsrm.tfoms.domain.FileEnt;
import ru.tfomsrm.tfoms.domain.User;
import ru.tfomsrm.tfoms.repos.FileEntRepo;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class COVIDController {
    @Autowired
    private FileEntRepo fileEntRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/COVID")
    private String COVID(Model model) {
        Iterable<FileEnt> fileEnts = fileEntRepo.findAll();
        model.addAttribute("fileEnts", fileEnts);
        return "/COVID";
    }

    @PostMapping("/COVID")
    private String addFile(@AuthenticationPrincipal User user,
                           Map<String, Object> model,
                           @RequestParam("file") MultipartFile file
    ) throws IOException {
        FileEnt fileEnt = new FileEnt(user);
        String resultFilename = "";

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            fileEnt.setFilename(resultFilename);

            fileEntRepo.save(fileEnt);

            new Registr(fileEntRepo, fileEnt,uploadPath + "/" + resultFilename).start();//передаем путь + имя файла
        }

        Iterable<FileEnt> fileEnts = fileEntRepo.findAll();
        model.put("fileEnts", fileEnts);

        return "redirect:/COVID";
    }

}
