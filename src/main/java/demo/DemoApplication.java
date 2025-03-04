package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.github.javafaker.Faker;
import demo.model.Mahasiswa;
import demo.model.Mentor;
import demo.model.Kelompok;
import demo.repository.MahasiswaDb;
import demo.repository.MentorDb;
import demo.repository.KelompokDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

// Jika ingin menjalankan logic CommandLineRunner, buat class terpisah atau implementasikan di sini:
@Component
class DataSeeder implements CommandLineRunner {

    @Autowired
    private MahasiswaDb mahasiswaDb;

    @Autowired
    private MentorDb mentorDb;

    @Autowired
    private KelompokDb kelompokDb;

    @Override
    public void run(String... args) {
        // Create Faker instance dengan locale Indonesia
        Faker faker = new Faker(new java.util.Locale("id"));

        // Buat 4 mentor
        for (int i = 1; i <= 4; i++) {
            Mentor mentor = new Mentor();
            mentor.setNama(faker.name().fullName());
            mentor.setKelompok(i);
            mentorDb.save(mentor);
        }

        // Buat 10 mahasiswa (lanjutkan logikanya sesuai kebutuhan)
        String[] fakultas = {"Fasilkom", "FEB", "FK", "FT", "FH"};
        for (int i = 0; i < 10; i++) {
            Mahasiswa mahasiswa = new Mahasiswa();
            // Generate NPM 10 digit
            String npm = String.format("%010d", faker.number().numberBetween(1000000000L, 9999999999L));
            mahasiswa.setNpm(npm);
            mahasiswa.setNama(faker.name().fullName());
            mahasiswa.setFakultas(fakultas[faker.number().numberBetween(0, fakultas.length)]);
            mahasiswa.setKelompok(faker.number().numberBetween(1, 5));
            mahasiswaDb.save(mahasiswa);
        }
    }
}

//iNFO SOAL 3D IMG DI KLIK JADI INFO FAKULTASMYA
//INFO MERCH JADI POP UP YG GABISA DI CLOSE
//MAP NUSANTARA DI KLIK JADI INFO PAGUYUBAN
//SETIAP INFO terbaru LANGSUNG MUNCUL DI HALAMAN UTAMA WEBSITE
// KEMUNGKINAN POP UP IKLAN MERCH SUPAYA ORANG PADA BELI
// INTEGRASIIN VOUCHER GOJEK SAMA SSO
//sURVEI KEPUASAN MAHASISWA
//MENAMPILKAN SURVEI DAN MELAPORKAN KE TIM INTERNAL TENTANG SURVEI TERSEBUT
// DIVISI BARU R&D/LITBANG
// Minggu Ke2 April 2025 bidding
//