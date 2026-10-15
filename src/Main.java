import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import Layanan.InventarisLab;
import Layanan.LayananPeminjaman;
import berkas.EksporLaporan;
import berkas.PenyinmpananBerkas;
import eksepsi.SipalabException;
import model.Alat;
import model.AlatUkur;
import model.Komponen;
import model.Laptop;
import model.Proyektor;
import model.Petugas;
import model.Mahasiswa;
import model.Labolatorium;
import transaksi.Peminjaman;
import transaksi.DetailPeminjaman;

public class Main {
        public static void main(String[] args) {
                Komponen mouse = new Komponen("KP-002", "Mouse", 2024, 3, 3);
                Komponen kabelHDMI = new Komponen("KP-001", "Kabel HDMI", 2024, 12, 5);

                InventarisLab inventaris = new InventarisLab();
                inventaris.tambah(kabelHDMI);
                inventaris.tambah(mouse);
                inventaris.tambah(new Laptop("LP-001", "Laptop Dell", 2023, 8, false,
                        "SERT-LP-002", LocalDate.of(2026, 6, 30)));
                inventaris.cetakStatus();
                inventaris.tambah(new AlatUkur("AU-001", "Multimeter", 2023, "volt", LocalDate.of(2024, 5, 15)));
                inventaris.tambah(new Komponen("HP-0101", "Handphone", 2024, 10, 2));

                try {
                        new EksporLaporan().tulisInventaris(
                                "laporan_inventaris.txt",
                                inventaris.semuaAlat());
                        System.out.println("Laporan inventaris dibuat: laporan_inventaris.txt");
                        // Buat salinan inventaris dalam format CSV agar mudah dibuka di spreadsheet.
                        new EksporLaporan().tulisCSV(
                                "inventaris.csv",
                                inventaris.semuaAlat());
                        System.out.println("Laporan CSV dibuat: inventaris.csv");
                } catch (IOException e) {
                        System.err.println("Gagal membuat laporan: " + e.getMessage());
                        e.printStackTrace();
                }

                try {
                        // PenyimpanBerkas menulis daftar alat ke file inventaris.dat.
                        PenyinmpananBerkas.PenyimpanBerkas penyimpan =
                                new PenyinmpananBerkas().new PenyimpanBerkas("inventaris.dat");
                        penyimpan.simpan(inventaris.semuaAlat());
                        System.out.println("Data inventaris disimpan: inventaris.dat");
                        // Muat kembali data untuk memastikan file inventaris.dat dapat dibaca.
                        System.out.println("Jumlah data yang dimuat: " + penyimpan.muat().size());
                } catch (IOException | ClassNotFoundException e) {
                        System.err.println("Gagal menyimpan data inventaris: " + e.getMessage());
                        e.printStackTrace();
                }

                Laptop lap = new Laptop("LP-002", "Laptop Lenovo", 2023, 16, true,
                        "SERT-LP-001", LocalDate.of(2027, 12, 31));
                Proyektor pro = new Proyektor("PR-003", "Proyektor Epson", 2023, 3300, 1200);
                AlatUkur ukur = new AlatUkur(
                        "AU-004", "Multimeter Fluke", 2020, "volt", LocalDate.of(2024, 3, 10));

                System.out.println(lap.deskripsi() + " | siap: " + lap.siapDipinjam());
                System.out.println(lap.ringkasanLacak());
                System.out.println(lap.ringkasanSertifikat());
                System.out.println(pro.deskripsi() + " | siap: " + pro.siapDipinjam());
                System.out.println(pro.ringkasanLacak());
                System.out.println(ukur.deskripsi() + " | siap: " + ukur.siapDipinjam());
                System.out.println(ukur.statusKalibrasi());

                // bagian penguji relasi
                Mahasiswa mhs = new Mahasiswa("2505181039", "Irfandi Prasetia", "Teknologi Rejayasa Perangkat Lunak");
                Petugas ptgs = new Petugas("P-001", "Budi Santoso");

                Labolatorium lab = new Labolatorium("LAB-RPL", "Laboratorium Rekayasa PL");
                lab.tambahAlat(lap);
                lab.tambahAlat(pro);
                System.out.println("Jumlah alat di lab: " + lab.jumlahAlat());

                Peminjaman pinjam = new Peminjaman("PM-001", mhs, ptgs);
                pinjam.tambahDetail(lap, 1);
                pinjam.tambahDetail(pro, 2);
                System.out.println("Total item dipinjam : " + pinjam.totalItem());

                for (DetailPeminjaman d : pinjam.getDetail()){
                        System.out.println(" " + d.baris());
                }

                // Coba peminjaman lewat layanan; laptop ini siap dipinjam.
                cobaPinjam(new LayananPeminjaman(), mhs, ptgs, lap);

                // Uji input tahun, method ini akan meminta masukan dari pengguna.
                ujiTangguh();

                try {
                        // Tulis contoh file teks dengan try-with-resources agar otomatis ditutup.
                        tulisDenganMenutup();
                        System.out.println("File Uji_AMAN.txt berhasil dibuat.");
                } catch (IOException e) {
                        System.err.println("Gagal membuat Uji_AMAN.txt: " + e.getMessage());
                        e.printStackTrace();
                }
        }

        //tambahan
        // FIX: method ini memakai `LayananPeminjaman`, `Alat`, dan `SipalabException`
        // jadi harus di-import di bagian atas file agar Java tahu kelas-kelas itu.
        private static void cobaPinjam(LayananPeminjaman layanan, Mahasiswa mhs, Petugas ptg, Alat alat){
                try{
                        Peminjaman p = layanan.pinjam(mhs, ptg, alat, 1);
                        System.out.println("    BERHASIL " + p.getNomorPeminjaman());
                }catch (SipalabException e) {
                        System.out.println("    GAGAL: " + e.getMessage());
                }
        }
        
        public static void ujiTangguh(){
                Scanner masukan = new Scanner(System.in);
                System.out.print("Masukkan Tahun Perolehan: ");
                try {
                        int tahun = Integer.parseInt(masukan.nextLine());
                        System.out.println("Tahun Tercatat: " + tahun);
                }catch (NumberFormatException e) {
                        System.out.println("Tahun harus berupa angka, contoh 2026");
                }
                masukan.close();
        }

        //public static void tulisTanpaMenutup() throws IOException {
        //        FileWriter fw = new FileWriter("uji_lupa_tutup.txt");
        //        fw.write("Baris ini harusnya tersimpan.");
        //        // Sengaja tidak dipanggil tulis.close()p
        //}
        public static void tulisDenganMenutup() throws IOException {
                try(FileWriter tulis = new FileWriter("Uji_AMAN.txt")){
                        tulis.write("Baris ini pasti Tersimpan");
                }
        }
}
