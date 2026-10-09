// Untuk nandai barangnya bersertifikat, misal laptop, proyektor, dll

package model;

import java.time.LocalDate;

public interface Bersertifikat {

    String nomorSertifikat();
    LocalDate masaBerlakuSertifikat();

    default boolean sertifikatAktif() {
        return !LocalDate.now().isAfter(masaBerlakuSertifikat());
    }

    default String ringkasanSertifikat() {
        return "Nomor Sertifikat - " + nomorSertifikat() + " | Masa Berlaku - " + masaBerlakuSertifikat();
    }
}