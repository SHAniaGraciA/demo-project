package demo.repository;

import demo.model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MahasiswaDb extends JpaRepository<Mahasiswa, String> {
    Mahasiswa findByNpm(String npm);
    List<Mahasiswa> findByKelompok(int kelompok);
}