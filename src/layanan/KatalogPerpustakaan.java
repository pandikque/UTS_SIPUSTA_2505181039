package layanan;

import ekespsi.KoleksiSedangDipinjamException;
import ekespsi.KoleksiTidakLayakException;
import java.util.HashSet;
import java.util.Set;

import model.koleksi;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KatalogPerpustakaan {
    private List<koleksi> daftar = new ArrayList<>();

    public void tambah(koleksi k) {
        daftar.add(k);
    }

    public List<koleksi> getDaftar() {
        return daftar;
    }

    // Pemrosesan polimorfik TANPA instanceof
    public void cetakStatus() {
        System.out.println("=== STATUS KATALOG ===");
        for (koleksi k : daftar) {
            System.out.println(k.deskripsi());
            System.out.println("   Layak dipinjam? " + k.layakDipinjam());
        }
    }

    public void urut(Comparator<koleksi> comparator) {
    daftar.sort(comparator);
    }

    private Set<String> sedangDipinjam = new HashSet<>();

    public void pinjam(String kodeKoleksi)throws KoleksiSedangDipinjamException, KoleksiTidakLayakException {

        koleksi target = null;
        for (koleksi k : daftar) {
            if (k.getKodeKoleksi().equals(kodeKoleksi)) {
                target = k;
                break;
            }
        }
        if (target == null) {
            throw new KoleksiTidakLayakException(kodeKoleksi); // atau pesan "tidak ditemukan"
        }
        if (sedangDipinjam.contains(kodeKoleksi)) {
            throw new KoleksiSedangDipinjamException(target.getJudul());
        }
        if (!target.layakDipinjam()) {
            throw new KoleksiTidakLayakException(target.getJudul());
        }
        sedangDipinjam.add(kodeKoleksi);
        System.out.println("Berhasil meminjam: " + target.getJudul());
    }
}