import java.util.ArrayList;

public class Staf {
    // Private field untuk data sensitif
    private String idStaf;
    private String nama;
    
    // Protected field untuk data yang mungkin perlu diakses subclass
    protected String jabatan;
    
    // Default (package-private) field
    String noTelp;
    
    // Public field (biasanya dihindari, tapi digunakan sebagai contoh)
    public String alamat;

    // Public constructor
    public Staf(String idStaf, String nama, String jabatan, String noTelp, String alamat) {
        this.idStaf = idStaf;
        this.nama = nama;
        this.jabatan = jabatan;
        this.noTelp = noTelp;
        this.alamat = alamat;
    }

    // Public getters
    public String getIdStaf() {
        return idStaf;
    }

    public String getNama() {
        return nama;
    }

    // Protected getter
    protected String getJabatan() {
        return jabatan;
    }

    // Default (package-private) getter
    String getNoTelp() {
        return noTelp;
    }

    // Public setters dengan validasi
    public void setNama(String nama) {
        if (nama != null && !nama.isEmpty()) {
            this.nama = nama;
        }
    }

    // Protected setter
    protected void setJabatan(String jabatan) {
        if (jabatan != null && !jabatan.isEmpty()) {
            this.jabatan = jabatan;
        }
    }

    // Default setter
    void setNoTelp(String noTelp) {
        if (noTelp != null && noTelp.matches("\\d+")) {
            this.noTelp = noTelp;
        }
    }

    // Public method untuk menampilkan info staf
    public void displayInfo() {
        System.out.println("ID Staf: " + idStaf);
        System.out.println("Nama: " + nama);
        System.out.println("Jabatan: " + jabatan);
        System.out.println("No. Telp: " + noTelp);
        System.out.println("Alamat: " + alamat);
    }
}

class StafManager {
    private ArrayList<Staf> daftarStaf = new ArrayList<>();

    // Public method untuk menambah staf
    public void addStaf(Staf staf) {
        if (staf == null) {
            System.out.println("Error: Data staf tidak valid");
            return;
        }

        for (Staf s : daftarStaf) {
            if (s.getIdStaf().equals(staf.getIdStaf())) {
                System.out.println("Error: ID Staf " + staf.getIdStaf() + " sudah ada");
                return;
            }
        }

        daftarStaf.add(staf);
        System.out.println("Staf berhasil ditambahkan");
    }

    // Public method untuk melihat daftar staf
    public void viewStafs() {
        if (daftarStaf.isEmpty()) {
            System.out.println("Belum ada staf terdaftar");
            return;
        }

        for (Staf staf : daftarStaf) {
            staf.displayInfo();
            System.out.println("-------------------");
        }
    }

    // Protected method untuk update staf
    protected void updateStaf(String idStaf, String nama, String jabatan, String noTelp, String alamat) {
        for (Staf staf : daftarStaf) {
            if (staf.getIdStaf().equals(idStaf)) {
                staf.setNama(nama);
                staf.setJabatan(jabatan);
                staf.setNoTelp(noTelp);
                staf.alamat = alamat; // alamat adalah public field
                return;
            }
        }
        System.out.println("Staf dengan ID " + idStaf + " tidak ditemukan");
    }

    // Public method untuk menghapus staf
    public void deleteStaf(String idStaf) {
        boolean removed = daftarStaf.removeIf(staf -> staf.getIdStaf().equals(idStaf));
        System.out.println(removed ? "Staf berhasil dihapus" : "Staf tidak ditemukan");
    }

    // Public method untuk mencari staf berdasarkan ID
    public Staf findStafById(String idStaf) {
        for (Staf staf : daftarStaf) {
            if (staf.getIdStaf().equals(idStaf)) {
                return staf;
            }
        }
        return null;
    }
}