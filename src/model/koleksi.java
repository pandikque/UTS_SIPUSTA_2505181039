package model;

public abstract class koleksi {
    private String kodeKoleksi;
    private String judul;
    private int tahunTerbit;

    public koleksi(String kodeKoleksi, String judul, int tahunTerbit) {
        this.kodeKoleksi = kodeKoleksi;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    public String getKodeKoleksi() { return kodeKoleksi; }
    public String getJudul()       { return judul; }
    public int getTahunTerbit()    { return tahunTerbit; }

    // method abstract aturan kelayakan pinjam
    public abstract boolean layakDipinjam();

    // method deskripsi yang akan dipakai turunan via super
    public String deskripsi() {
        return kodeKoleksi + " | " + judul + " (" + tahunTerbit + ")";
    }
}