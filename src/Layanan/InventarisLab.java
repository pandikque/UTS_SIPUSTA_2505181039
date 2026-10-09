package Layanan;

import java.util.ArrayList;
import java.util.List;
import model.Alat;

interface Kalibrasiable {
    String statusKalibrasi();
}

public class InventarisLab {

    public final List<Alat> daftarAlat = new ArrayList<>();

    public void tambah(Alat alat) {
        daftarAlat.add(alat);
    }

    public List<Alat> semuaAlat() {
        return daftarAlat;
    }

//    public void cetakStatusBercabang() {
//        for (Alat a : daftarAlat) {
//            if(a instanceof Laptop){
//                Laptop 1 = (Laptop) a;
//                System.out.println(1.getNama() + " " + 1.siapDipinjam());
//            }else if(a instanceof Proyektor){
//                proyektor p = (Proyektor) a;
//                System.out.println(p.getNama() + " " + p.siapDipinjam());
//            }else if(a instanceof AlatUkur){
//                AlatUkur u = (AlatUkur) a;
//                System.out.println(u.getNama() + " " + u.siapDipinjam());
//            }
//        }
//    }

    public void cetakStatus() {
        for (Alat a : daftarAlat) {
            System.out.println(a.laporanRingkas());
        }
    }

    public void cetakJadwalKalibrasi() {
        for (Alat a : daftarAlat) {
            if (a instanceof Kalibrasiable k) {
                System.out.println(a.getNama() + " -> " + k.statusKalibrasi());
            }
        }
    }

    public int hitungSiapDipinjam() {
        int jumlahSiapDipinjam = 0;
        for (Alat a : daftarAlat) {
            if (a.siapDipinjam()) {
                jumlahSiapDipinjam++;
            }
        }
        return jumlahSiapDipinjam;
    }

    public List<Alat> daftarTidakSiap(){
        List<Alat> hasil = new ArrayList<>();
        for (Alat a : daftarAlat) {
            if (!a.siapDipinjam()){
                hasil.add(a);
            }
        }
        return hasil;
    }
}
