

package model;

public interface Terlacak {

    String nomorSeri();
    String lokasiTerakhir();

    default String ringkasanLacak() {
        return "Nomor Seri - " + nomorSeri() + " terakhri berada di " + lokasiTerakhir();
    }

}
