package Layanan;

import java.time.Year;
import eksepsi.DataTidakValidException;
import model.Alat;

public class ValidatorAlat {

    public void periksa(Alat alat) throws DataTidakValidException {
        if (alat.getKodeAlat() == null || alat.getKodeAlat().isBlank()) {
            throw new DataTidakValidException("kodeAlat", "Kode alat tidak boleh kosong");
        }
        if (alat.getNama() == null || alat.getNama().isBlank()){
            throw new DataTidakValidException("nama", "Nama alat tidak boleh kosong");
        }
        int tahun = alat.getTahunPerolehan();
        if (tahun < 1990 || tahun > Year.now().getValue()){
            throw new DataTidakValidException("tahunPerolehan", "Tahun perolehan harus antara 1990 dan tahun berjalan. " + Year.now().getValue());
        }
    }
}
