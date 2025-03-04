package demo.service;

import demo.model.Mahasiswa;
import demo.model.Mentor;
import demo.repository.MahasiswaDb;
import demo.repository.MentorDb;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class KelompokService {
    private final MahasiswaDb mahasiswaDb;
    private final MentorDb mentorDb;

    public Map<String, Object> getKelompokDetailsByNpm(String npm) {
        Map<String, Object> result = new HashMap<>();
        
        // Find mahasiswa by NPM
        Mahasiswa mahasiswa = mahasiswaDb.findByNpm(npm);
        if (mahasiswa == null) {
            return null;
        }

        // Get kelompok number
        int kelompok = mahasiswa.getKelompok();
        
        // Find mentor for this kelompok
        Mentor mentor = mentorDb.findByKelompok(kelompok);
        
        // Find other mahasiswa in the same kelompok
        List<Mahasiswa> anggotaKelompok = mahasiswaDb.findByKelompok(kelompok);
        // Remove the current mahasiswa from the list
        anggotaKelompok.removeIf(m -> m.getNpm().equals(npm));

        result.put("mahasiswa", mahasiswa);
        result.put("mentor", mentor);
        result.put("anggotaKelompok", anggotaKelompok);
        result.put("nomorKelompok", kelompok);

        return result;
    }
}