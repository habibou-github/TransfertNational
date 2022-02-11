package com.TransfertNational.demo.Controllers;

import com.TransfertNational.demo.Entities.ClientBeneficaireForMultiple;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@RestController
@RequestMapping("/uploadClientBeneficaire")
public class UploadClientsBenificaires {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/upload-csv-file")
    public String uploadCSVFile(@RequestParam("file") MultipartFile file, Model model) {

        // validate file
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a CSV file to upload.");
            model.addAttribute("status", false);
        } else {

            // parse CSV file to create a list of `User` objects
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

                // create csv bean reader
                CsvToBean<Object> csvToBean = new CsvToBeanBuilder<>(reader)
                        .withType(ClientBeneficaireForMultiple.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                // convert `CsvToBean` object to list of users
                List<Object> clients = csvToBean.parse();

                // save users list on model
                model.addAttribute("clients", clients);
                model.addAttribute("status", true);

            } catch (Exception ex) {
                model.addAttribute("message", "An error occurred while processing the CSV file.");
                model.addAttribute("status", false);
            }
        }

        return "file-upload-status";
    }
}
