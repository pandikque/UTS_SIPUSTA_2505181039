package eksepsi;

public class AlatSedangDipinjamException extends SipalabException {
    public AlatSedangDipinjamException(String KodeAlat) {
        super("Alat : " + KodeAlat + " sedang dipinjam dan belum bisa dikembalikan");
    }
}
