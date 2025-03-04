package demo.repository;

import demo.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorDb extends JpaRepository<Mentor, Long> {
    // Find mentor by kelompok
    Mentor findByKelompok(int kelompok);
    
    // Find mentor by nama
    Mentor findByNama(String nama);
}