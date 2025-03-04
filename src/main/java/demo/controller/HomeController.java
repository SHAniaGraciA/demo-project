package demo.controller;

import demo.model.Komentar;
import demo.repository.MahasiswaDb;
import demo.repository.MentorDb;
import demo.repository.KelompokDb;
import demo.service.KomentarService;
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
    
    @Autowired
    private KomentarService komentarService;

    @GetMapping("/")
    public String home(Model model) {
        long totalMahasiswa = mahasiswaDb.count();
        long totalMentor = mentorDb.count();
        long totalKelompok = kelompokDb.count();

        model.addAttribute("totalMahasiswa", totalMahasiswa);
        model.addAttribute("totalMentor", totalMentor);
        model.addAttribute("totalKelompok", totalKelompok);
        
        // Ambil komentar terbaik (max 5 komentar dengan nilai > 7)
        List<Komentar> komentarList = komentarService.ambilSemuaKomentar();
        List<Komentar> komentarTerbaik = komentarList.stream()
                .filter(k -> k.getNilai() > 7)
                .limit(5)
                .collect(Collectors.toList());
        
        model.addAttribute("komentarTerbaik", komentarTerbaik);
        
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/merch")
    public String showMerchPage() {
        return "merch";
    }

    @GetMapping("/lirik-lagu")
    public String lirikLagu() {
    return "lirik-lagu";
}
}