package model;

import java.time.LocalDate;

public class Laptop extends Alat implements Terlacak, Bersertifikat {

    private int ramGB;
    private boolean chargerLengkap;
    private String nomorSeri;
    private String lokasiTerakhir;
    private String nomorSertifikat;
    private LocalDate masaBerlakuSertifikat;
    
    public Laptop(String kodeAlat, String nama, int tahunPerolehan,int ramGB, boolean chargerLengkap) {
        this(kodeAlat, nama, tahunPerolehan, ramGB, chargerLengkap, "-", LocalDate.MIN);
    }

    public Laptop(String kodeAlat, String nama, int tahunPerolehan, int ramGB, boolean chargerLengkap, String nomorSertifikat, LocalDate masaBerlakuSertifikat) {
        super(kodeAlat, nama, tahunPerolehan);
        this.ramGB = ramGB;
        this.chargerLengkap = chargerLengkap;
        this.nomorSeri = "LP-002";
        this.lokasiTerakhir = "Lab RPL";
        this.nomorSertifikat = nomorSertifikat;
        this.masaBerlakuSertifikat = masaBerlakuSertifikat;
    }
    

    @Override
    public String nomorSeri() {
        return nomorSeri;
    }

    @Override
    public String lokasiTerakhir() {
        return lokasiTerakhir;
    }

    @Override
    public String nomorSertifikat() {
        return nomorSertifikat;
    }

    @Override
    public LocalDate masaBerlakuSertifikat() {
        return masaBerlakuSertifikat;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " RAM " + ramGB + " GB";
    }

    @Override
    public boolean siapDipinjam(){
        return chargerLengkap;
    }
}