package model;

public class Majalah extends koleksi implements Terarsip{
    private int edisi;
    private String bulanTerbit;
    private boolean edisiTerbaru;
    private String nomorRak;   // Majalah punya lokasi fisik

    public Majalah(String kode, String judul, int tahun,
                int edisi, String bulanTerbit, boolean edisiTerbaru,
                String nomorRak) {
        super(kode, judul, tahun);
        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
        this.edisiTerbaru = edisiTerbaru;
        this.nomorRak = nomorRak;
    }

    public int getEdisi()             { return edisi; }
    public String getBulanTerbit()    { return bulanTerbit; }
    public boolean isEdisiTerbaru()   { return edisiTerbaru; }
    public String getNomorRak()       { return nomorRak; }

    @Override
    public boolean layakDipinjam() {
        return !edisiTerbaru;   // layak jika BUKAN edisi terbaru
    }

    @Override
    public String deskripsi() {
        return super.deskripsi()
            + " | Majalah Edisi " + edisi + " (" + bulanTerbit + ")"
            + " | Rak " + nomorRak
            + " | " + (edisiTerbaru ? "edisi terbaru" : "boleh dipinjam");
    }

    @Override
    public String nomorRak(){
        return nomorRak;
    }

    @Override 
    public String lokasiLantai() {
        return "Lantai 2";
    } // sesuaikan
}