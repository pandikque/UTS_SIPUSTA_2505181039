import java.time.LocalDate;

import Layanan.InventarisLab;
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
        }
}
