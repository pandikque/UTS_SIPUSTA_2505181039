package pembanding;

import java.util.Comparator;
import model.Alat;

public class urutTahun implements Comparator<Alat> {
    
    @Override
    public int compare(Alat a, Alat b) {
        // Lapis pertama: tahun perolehan terbaru dulu
        // (b dibanding a supaya yang lebih besar/tahun baru tampil di depan)
        int bandingTahun = Integer.compare(b.getTahunPerolehan(), a.getTahunPerolehan());
        if (bandingTahun != 0) {
            return bandingTahun;
        }

        // Lapis kedua: bila tahun sama, urutkan berdasarkan nama (A-Z)
        return a.getNama().compareToIgnoreCase(b.getNama());
    }
}

