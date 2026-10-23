package model;

public class BukuCetak extends koleksi implements Terarsip {
    private int jumlahHalaman;
    private String nomorRak;
    private boolean sedangDiperbaiki;

    public BukuCetak(String kode, String judul, int tahun,int jumlahHalaman, String nomorRak, boolean sedangDiperbaiki) {
        super(kode, judul, tahun);
        this.jumlahHalaman = jumlahHalaman;
        this.nomorRak = nomorRak;
        this.sedangDiperbaiki = sedangDiperbaiki;
    }

    public int getJumlahHalaman()       { return jumlahHalaman; }
    public String getNomorRak()         { return nomorRak; }
    public boolean isSedangDiperbaiki() { return sedangDiperbaiki; }

    @Override
    public boolean layakDipinjam() {
        return !sedangDiperbaiki;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi()
            + " | Buku Cetak | " + jumlahHalaman + " halaman | Rak " + nomorRak
            + " | " + (sedangDiperbaiki ? "sedang diperbaiki" : "siap dipinjam");
    }
    
    @Override
    public String nomorRak(){
        return nomorRak;
    }

    @Override 
    public String lokasiLantai() {
        return "Lantai 1";
    } // sesuaikan
}