package ekespsi;

public class KoleksiSedangDipinjamException extends PustakaException {
    public KoleksiSedangDipinjamException(String judul) {
        super("Maaf, koleksi \"" + judul + "\" sedang dipinjam oleh pengguna lain.");
    }
}