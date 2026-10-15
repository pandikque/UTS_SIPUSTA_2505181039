package berkas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import model.Alat;

public class EksporLaporan {

    public void tulisInventaris(String namaBerkas, List<Alat> daftar) throws IOException{
        try(PrintWriter tulis = new PrintWriter(new BufferedWriter(new FileWriter(namaBerkas)))){

            tulis.println("LAPORAN INVENTARIS LABORATORIUM");
            tulis.println("Tanggal Cetak: " + LocalDate.now());
            tulis.println();
            tulis.printf("%-10s %-26s %-14s %-14s\n", "KODE", "NAMA", "JENIS", "STATUS");
            tulis.println("-".repeat(68));

            for(Alat a : daftar){
                String status = a.getStatus().sedangDiluar ? "Dipinjam" : "Tersedia";
                tulis.printf("%-10s %-26s %-14s %-14s\n", a.getKodeAlat(), a.getNama(), a.getJenis(), status);
            }
            tulis.println();
            tulis.println("Jumlah Alat: " + daftar.size());
        }
    }
}
