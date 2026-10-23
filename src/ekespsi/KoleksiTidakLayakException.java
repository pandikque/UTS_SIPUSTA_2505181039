package ekespsi;

public class KoleksiTidakLayakException extends PustakaException {
    public KoleksiTidakLayakException(String judul) {
        super("Maaf, koleksi \"" + judul + "\" belum bisa dipinjam saat ini.");
    }
}