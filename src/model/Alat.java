package model;

public abstract class Alat {

    // FIX: menambahkan status alat agar class lain bisa mengecek apakah alat sedang dipinjam
    public static class Status {
        public boolean sedangDiluar;
    }

    protected String kodeAlat;
    protected String nama;
    protected int tahunPerolehan;
    protected Status status = new Status();

    public Alat(String kodeAlat, String nama, int tahunPerolehan) {
        this.kodeAlat = kodeAlat;
        this.nama = nama;
        this.tahunPerolehan = tahunPerolehan;
    }

    public String deskripsi() {
        return kodeAlat + " - " + nama + " (" + tahunPerolehan + ")";
    }

    public boolean siapDipinjam() {
        return true;
    }

    public String getNama() {
        return nama;
    }

    // FIX: getter kode alat dibutuhkan oleh `LayananPeminjaman`
    public String getKodeAlat() {
        return kodeAlat;
    }

    // FIX: getter status agar pengecekan `alat.getStatus().sedangDiluar` bisa bekerja
    public Status getStatus() {
        return status;
    }

    public String laporanRingkas() {
        String status = siapDipinjam() ? "SIAP" : "TIDAK SIAP";
        return String.format("%-8s %-22s %s", kodeAlat, nama, status);
    }

    public int getTahunPerolehan() {
        return tahunPerolehan;
    }
}
