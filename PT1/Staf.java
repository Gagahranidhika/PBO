import java.util.ArrayList;

// Entitas Staf
class Staf {
    String id_staf;
    String nama;
    String jabatan;
    String no_telp;
    String alamat;

    public Staf(String id_staf, String nama, String jabatan, String no_telp, String alamat) {
        this.id_staf = id_staf;
        this.nama = nama;
        this.jabatan = jabatan;
        this.no_telp = no_telp;
        this.alamat = alamat;
    }
}

// Manager untuk Staf
class StafManager {
    private ArrayList<Staf> stafs = new ArrayList<>();

    public void addStaf(Staf staf) {
        stafs.add(staf);
    }

    public void viewStafs() {
        for (Staf staf : stafs) {
            System.out.println("ID Staf: " + staf.id_staf + ", Nama: " + staf.nama + ", Jabatan: " + staf.jabatan + ", No. Telp: " + staf.no_telp + ", Alamat: " + staf.alamat);
        }
    }

    public void updateStaf(String id_staf, String nama, String jabatan, String no_telp, String alamat) {
        for (Staf staf : stafs) {
            if (staf.id_staf.equals(id_staf)) {
                staf.nama = nama;
                staf.jabatan = jabatan;
                staf.no_telp = no_telp;
                staf.alamat = alamat;
                return;
            }
        }
    }

    public void deleteStaf(String id_staf) {
        stafs.removeIf(staf -> staf.id_staf.equals(id_staf));
    }
}