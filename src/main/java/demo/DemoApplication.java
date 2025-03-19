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
        
    }
}

//iNFO SOAL 3D IMG DI KLIK JADI INFO FAKULTASMYA
//MAP NUSANTARA DI KLIK JADI INFO PAGUYUBAN
//SETIAP INFO terbaru LANGSUNG MUNCUL DI HALAMAN UTAMA WEBSITE
// KEMUNGKINAN POP UP IKLAN MERCH SUPAYA ORANG PADA BELI
// Minggu Ke2 April 2025 bidding
//

//-------------------------------------------------------------------------
//Pembayaran EPI Gateaway
//Ide Divisi FE BE
//