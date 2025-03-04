package demo.service;

import demo.model.Komentar;
import demo.repository.KomentarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KomentarService {

    @Autowired
    private KomentarRepository komentarRepository;

    public Komentar simpanKomentar(Komentar komentar) {
        return komentarRepository.save(komentar);
    }

    public List<Komentar> ambilSemuaKomentar() {
        return komentarRepository.findAll();
    }

    public List<Komentar> ambilKomentarNilaiTinggi() {
        return komentarRepository.findAllByOrderByNilaiDesc();
    }
}