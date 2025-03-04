package demo.controller;

import demo.model.Komentar;
import demo.service.KomentarService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/komentar")
public class KomentarController {

    @Autowired
    private KomentarService komentarService;

    @GetMapping("/halaman")
    public String tampilkanHalamanKomentar(Model model) {
        return "form-komentar";  // pastikan ada file komentar.html pada direktori templates
    }
    // Endpoint untuk menyimpan komentar baru (misal, via POST)
    @PostMapping("/tambah")
    public Komentar tambahKomentar(@RequestBody Komentar komentar) {
        return komentarService.simpanKomentar(komentar);
    }

    // Endpoint untuk mengambil semua komentar (misal, via GET)
    @GetMapping
    public List<Komentar> getSemuaKomentar() {
        return komentarService.ambilSemuaKomentar();
    }
}