package layanan;

import model.koleksi;
import java.util.Comparator;

public class UrutLayakLaluJudul implements Comparator<koleksi> {
    @Override
    public int compare(koleksi a, koleksi b) {

        // layak dipinjam lebih dulu
        int layak = Boolean.compare(!a.layakDipinjam(), !b.layakDipinjam());

        
        if (layak != 0) return layak;
        // lalu berdasarkan judul
        return a.getJudul().compareToIgnoreCase(b.getJudul());
    }
}