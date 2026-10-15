package eksepsi;

public class DataTidakValidException extends SipalabException {

    private final String namaKOlom;

    public DataTidakValidException(String namaKolom, String pesan) {
        super(pesan);
        this .namaKOlom = namaKolom;
    }

    public String getNamaKolom() {
        return namaKOlom;
    }

}
