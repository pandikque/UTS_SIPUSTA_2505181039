package berkas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
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

    public void tulisCSV(String namaBerkas, List<Alat> daftar) throws IOException {
        // Tulis header dan setiap alat sebagai satu baris CSV.
        try (BufferedWriter tulis = Files.newBufferedWriter(
                Path.of(namaBerkas), StandardCharsets.UTF_8)) {
            tulis.write("KODE,NAMA,JENIS,STATUS");
            tulis.newLine();

            for (Alat a : daftar) {
                String status = a.getStatus().sedangDiluar ? "Dipinjam" : "Tersedia";
                // Escape tanda koma dan kutip supaya nilai tetap terbaca sebagai satu kolom.
                tulis.write(escapeCSV(a.getKodeAlat()));
                tulis.write(",");
                tulis.write(escapeCSV(a.getNama()));
                tulis.write(",");
                tulis.write(escapeCSV(a.getJenis()));
                tulis.write(",");
                tulis.write(escapeCSV(status));
                tulis.newLine();
            }
        }
    }

    private String escapeCSV(String nilai) {
        if (nilai.contains(",") || nilai.contains("\"")
                || nilai.contains("\n") || nilai.contains("\r")) {
            return "\"" + nilai.replace("\"", "\"\"") + "\"";
        }
        return nilai;
    }
}
