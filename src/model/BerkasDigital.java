package model;

public class BerkasDigital extends koleksi {
    private double ukuranMB;
    private String tautanUnduh;

    public BerkasDigital(String kode, String judul, int tahun, double ukuranMB, String tautanUnduh) {
        super(kode, judul, tahun);
        this.ukuranMB = ukuranMB;
        this.tautanUnduh = tautanUnduh;
    }

    public double getUkuranMB()     { return ukuranMB; }
    public String getTautanUnduh()  { return tautanUnduh; }

    @Override
    public boolean layakDipinjam() {
        return true;   // selalu layak
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | Berkas Digital | " + ukuranMB + " MB | " + tautanUnduh;
    }
}