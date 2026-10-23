
import model.*;
import layanan.*;
import ekespsi.*;

public class Main {
    public static void main(String[] args) {

        KatalogPerpustakaan katalog = new KatalogPerpustakaan();

        // Contoh isi katalog: buku, majalah, dan berkas digital.
        katalog.tambah(new BukuCetak("BK-001", "Java How to Program", 2022,
                620, "A-12", false));
        katalog.tambah(new BukuCetak("BK-002", "Basis Data Relasional", 2021,
                410, "B-04", true));
        katalog.tambah(new Majalah("MJ-001", "Info Teknologi Edisi 88", 2026,
                88, "Agustus", true, "C-01"));
        katalog.tambah(new Majalah("MJ-002", "Info Teknologi Edisi 87", 2026,
                87, "Juli", false, "C-02"));
        katalog.tambah(new BerkasDigital("BD-001", "Panduan Pemrograman Java", 2024,
                15, "unduh.polmed.ac.id/bd001"));
        katalog.tambah(new BerkasDigital("BD-002", "Jurnal Rekayasa Perangkat", 2025,
                8, "unduh.polmed.ac.id/bd002"));

        // Tampilkan kondisi kelayakan setiap koleksi sebelum diurutkan.
        katalog.cetakStatus();

        // Urutkan koleksi berdasarkan kelayakan pinjam, lalu judul.
        System.out.println("\n=== SETELAH DIURUT ===");
        katalog.urut(new UrutLayakLaluJudul());
        katalog.cetakStatus();

        // Uji peminjaman berulang; kegagalan satu percobaan tidak menghentikan percobaan lain.
        System.out.println("\n=== UJI PINJAM ===");
        try {
            katalog.pinjam("BK-001");  // Contoh peminjaman yang berhasil.
        } catch (PustakaException e) {
            System.out.println("Gagal: " + e.getMessage());
        }

        try {
            katalog.pinjam("BK-001");  // Contoh menolak koleksi yang sudah dipinjam.
        } catch (PustakaException e) {
            System.out.println("Gagal: " + e.getMessage());
        }

        try {
            katalog.pinjam("BK-002");  // Contoh menolak buku yang sedang diperbaiki.
        } catch (PustakaException e) {
            System.out.println("Gagal: " + e.getMessage());
        }

        // Simpan ringkasan katalog ke file teks.
        EksporKatalog.ekspor(katalog, "katalog.txt");
    }

    
}