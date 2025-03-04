package demo.repository;

import demo.model.Kelompok;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KelompokDb extends JpaRepository<Kelompok, Long> {
    Kelompok findByMahasiswaNpm(String npm);
}