package demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mahasiswa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mahasiswa {
    @Id
    private String npm;
    private String nama;
    private String fakultas;
    private int kelompok;
    private String username;
    private String password;
}