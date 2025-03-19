package demo.controller;

import demo.repository.MahasiswaDb;
import demo.repository.MentorDb;
import demo.repository.KelompokDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    private MahasiswaDb mahasiswaDb;

    @Autowired
    private MentorDb mentorDb;

    @Autowired
    private KelompokDb kelompokDb;
    

    @GetMapping("/")
    public String home(Model model) {
        long totalMahasiswa = mahasiswaDb.count();
        long totalMentor = mentorDb.count();
        long totalKelompok = kelompokDb.count();

        model.addAttribute("totalMahasiswa", totalMahasiswa);
        model.addAttribute("totalMentor", totalMentor);
        model.addAttribute("totalKelompok", totalKelompok);
        
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/lirik-lagu")
    public String lirikLagu() {
    return "lirik-lagu";
}

    @GetMapping("/helpdesk")
    public String helpdesk() {
        return "helpdesk";
    }

    @GetMapping("/helpdesk/ganjil")
    public String helpdeskGanjil(Model model) {
        model.addAttribute("npmType", "ganjil");
        return "helpdesk-detail";
    }

    @GetMapping("/helpdesk/genap")
    public String helpdeskGenap(Model model) {
        model.addAttribute("npmType", "genap");
        return "helpdesk-detail";
    }
}