package model;

import java.util.ArrayList;
import java.util.List;

public class Labolatorium {

    private final String KodeLab;
    private final String nama;

    private final List<Alat> KoleksiAlat = new ArrayList<>();

    public Labolatorium(String kodeLab, String nama){
        this.KodeLab = kodeLab;
        this.nama = nama;
    }

    public void tambahAlat(Alat alat){
        KoleksiAlat.add(alat);
    }

    public int jumlahAlat(){
        return KoleksiAlat.size();
    }

    public String getKodeLab() {
        return KodeLab;
    }

    public String getNama() {
        return nama;
    }

}
