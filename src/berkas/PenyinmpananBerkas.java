package berkas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model.Alat;

public class PenyinmpananBerkas {

    //private final String namaBerkas;

    public class PenyimpanBerkas {

        private final String namaBerkas;

        public PenyimpanBerkas(String namaBerkas) {
            this.namaBerkas = namaBerkas;
        }

        public void simpan(List<Alat> daftar) throws IOException {
            try (ObjectOutputStream keluar = new ObjectOutputStream(new FileOutputStream(namaBerkas))) {
                keluar.writeObject(new ArrayList<Alat>(daftar));
            }
        }

        @SuppressWarnings("unchecked")
        public List<Alat> muat() throws IOException, ClassNotFoundException {
            try (ObjectInputStream masuk = new ObjectInputStream(new FileInputStream(namaBerkas))) {
                return (List<Alat>) masuk.readObject();
            }
        }
    }

}
