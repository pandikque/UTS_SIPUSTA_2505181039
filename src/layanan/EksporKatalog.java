package layanan;

import model.koleksi;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EksporKatalog {

    public static void ekspor(KatalogPerpustakaan katalog, String namaFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(namaFile))) {
            bw.write(String.format("%-10s | %-35s | %-6s | %-10s%n",
                    "KODE", "JUDUL", "TAHUN", "LAYAK"));
            bw.write("--------------------------------------------------------------------------\n");

            for (koleksi k : katalog.getDaftar()) {
                bw.write(String.format("%-10s | %-35s | %-6d | %-10s%n",
                        k.getKodeKoleksi(),
                        k.getJudul(),
                        k.getTahunTerbit(),
                        k.layakDipinjam() ? "Ya" : "Tidak"));
            }
            System.out.println("Katalog diekspor ke " + namaFile);
        } catch (IOException e) {
            System.err.println("Gagal mengekspor katalog: " + e.getMessage());
        }
    }
}