package eksepsi;

public class KuotaPeminjamanHabisException extends SipalabException {
    // FIX: constructor harus menerima nama peminjam, bukan kode alat, lalu pakai variabel yang benar
    public KuotaPeminjamanHabisException(String nama, int kuota) {
        super("Kuota peminjaman " + nama + " sudah habis, batasnya " + kuota + " alat");
    }
}
