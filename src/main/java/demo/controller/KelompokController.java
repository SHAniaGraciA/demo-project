package demo.controller;

import demo.service.KelompokService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/kelompok")
public class KelompokController {
    @Autowired
    private KelompokService kelompokService;

    @GetMapping("/cari-detail-kelompok")
    public String cariDetailKelompokForm() {
        return "form-cari-detail-kelompok";
    }

    @GetMapping("/detail-kelompok")
    public String cariDetailKelompok(@RequestParam String npm, Model model) {
        var kelompokDetails = kelompokService.getKelompokDetailsByNpm(npm);
        model.addAttribute("details", kelompokDetails);
        return "view-detail-kelompok";
    }
}