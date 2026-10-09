package transaksi;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Alat;
import model.Mahasiswa;
import model.Petugas;

public class Peminjaman {

    public static class PeminjamanSudahDitutupException extends Exception {
        public PeminjamanSudahDitutupException(String nomorPeminjaman, LocalDate tanggalKembali) {
            super("Peminjaman " + nomorPeminjaman + " sudah ditutup pada tanggal " + tanggalKembali);
        }
    }

    private static final int BATAS_HARI = 7;
    private static final double TARIF_DENDA_PER_HARI = 2000.0;

    private final String nomorPeminjaman;
    private final LocalDate tanggalPinjam;
    private LocalDate tanggalKembali;
    private final Mahasiswa peminjam;
    private final Petugas penyetuju;
    private final List<DetailPeminjaman> detail = new ArrayList<>();

    public Peminjaman(String nomorPeminjaman, Mahasiswa peminjam, Petugas penyetuju) {
        this.nomorPeminjaman = nomorPeminjaman;
        this.peminjam = peminjam;
        this.penyetuju = penyetuju;
        this.tanggalPinjam = LocalDate.now();
    }

    public Peminjaman(String nomorPeminjaman, Mahasiswa peminjam, Petugas penyetuju, LocalDate tanggalPinjam) {
        this.nomorPeminjaman = nomorPeminjaman;
        this.peminjam = peminjam;
        this.penyetuju = penyetuju;
        this.tanggalPinjam = tanggalPinjam;
    }

    // ===== TAMBAHAN BARU =====
    public void kembalikan() throws PeminjamanSudahDitutupException {
        if (tanggalKembali != null) {
            throw new PeminjamanSudahDitutupException(nomorPeminjaman, tanggalKembali);
        }
        this.tanggalKembali = LocalDate.now();
    }

    public boolean sudahKembali() {
        return tanggalKembali != null;
    }

    // ===== TAMBAHAN BARU — hitung denda =====
    public double hitungDenda() {
        if (tanggalKembali == null) {
            return 0.0;
        }
        return hitungHariTerlambat() * TARIF_DENDA_PER_HARI;
    }

    public long hitungHariTerlambat() {
        if (tanggalKembali == null) {
            return 0L;
        }
        long totalHari = ChronoUnit.DAYS.between(tanggalPinjam, tanggalKembali);
        if (totalHari > BATAS_HARI) {
            return totalHari - BATAS_HARI;
        }
        return 0L;
    }

    public boolean isTerlambat() {
        return hitungHariTerlambat() > 0;
    }

    public void tambahDetail(Alat alat, int jumlah) {
        detail.add(new DetailPeminjaman(alat, jumlah));
    }

    public List<DetailPeminjaman> getDetail() {
        return Collections.unmodifiableList(detail);
    }

    public int totalItem() {
        int total = 0;
        for (DetailPeminjaman d : detail) {
            total += d.getJumlah();
        }
        return total;
    }

    public String getNomorPeminjaman() { return nomorPeminjaman; }
    public LocalDate getTanggalPinjam() { return tanggalPinjam; }
    public LocalDate getTanggalKembali() { return tanggalKembali; }
    public Mahasiswa getPeminjam() { return peminjam; }
    public Petugas getPenyetuju() { return penyetuju; }
    public static int getBatasHari() { return BATAS_HARI; }
    public static double getTarifDendaPerHari() { return TARIF_DENDA_PER_HARI; }
}