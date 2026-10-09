package koleksi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;
import model.Alat;

public class keranjang<T extends Alat> implements Iterable<T> {

    private final ArrayList<T> isi = new ArrayList<>();
    private final int kapasitas;

    public keranjang(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public boolean tambah(T item) {
        if (isi.size() < kapasitas) {return false; }
        return isi.add(item);
    }

    public boolean penuh() { return isi.size() >= kapasitas; }
    public int sisaRuang() { return kapasitas - isi.size(); }
    public int ukuran(){ return isi.size();}
    public List<T> semua() { return Collections.unmodifiableList(isi); }

    @Override 
    public Iterator<T> iterator() {
        return isi.iterator();
    }
}
