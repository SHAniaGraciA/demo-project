package demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "komentar")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Komentar {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // Username mahasiswa yang mengomentari
    private String username;
    
    // Isi komentar
    @Column(length = 1000)
    private String isiKomentar;
    
    // Waktu komentar dikirim
    private LocalDateTime waktu = LocalDateTime.now();

    // Nilai komentar (1-10)
    private int nilai;
}