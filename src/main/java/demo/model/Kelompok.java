package demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "kelompok")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Kelompok {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "npm")
    private Mahasiswa mahasiswa;
    
    @OneToOne
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;
}