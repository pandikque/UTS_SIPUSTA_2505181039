package eksepsi;

public class AlatBelumSiapException extends SipalabException {
    // FIX: parameter harus memakai nama yang sesuai dengan variabel yang dipakai di super()
    public AlatBelumSiapException(String kodeAlat, String alasan) {
        super("Alat : " + kodeAlat + " belum siap dipinjam. " + alasan);
    }
}
