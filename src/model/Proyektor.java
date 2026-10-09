package model;

public class Proyektor extends Alat implements Terlacak {

    public static final int BATAS_JAM_LAMPU = 2000;

    private int lumens;
    private int jamPakaiLampu;
    private String nomorSeri;
    private String lokasiTerakhir;

    public Proyektor(String kodeAlat, String nama, int tahunPerolehan, int lumens, int jamPakaiLampu) {
        this(kodeAlat, nama, tahunPerolehan, lumens, jamPakaiLampu, "_", "Lab RPL");
    }

    public Proyektor(String kodeAlat, String nama, int tahunPerolehan, int lumens, int jamPakaiLampu, String nomorSeri, String lokasiTerakhir) {
        super(kodeAlat, nama, tahunPerolehan);
        this.lumens = lumens;
        this.jamPakaiLampu = jamPakaiLampu;
        this.nomorSeri = nomorSeri;
        this.lokasiTerakhir = lokasiTerakhir;
    }

    @Override
    public String deskripsi() {
//        return super.deskripsi() + " Lumens " + lumens + " Jam Pakai Lampu " + jamPakaiLampu;
        return super.deskripsi() + " " + lumens + "lumens";
    }

    @Override
    public boolean siapDipinjam(){
        return jamPakaiLampu < 1000; // Contoh kondisi, bisa disesuaikan
    }

    @Override
    public String nomorSeri() {
        return nomorSeri;
    }

    @Override
    public String lokasiTerakhir() {
        return lokasiTerakhir;
    }
}