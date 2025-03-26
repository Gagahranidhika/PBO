import java.util.ArrayList;
public class Hewan {
    private String idHewan;
    protected String namaHewan;
    String jenisHewan;
    public String idKandang;

    // Public constructor
    public Hewan(String idHewan, String namaHewan, String jenisHewan, String idKandang) {
        this.idHewan = idHewan;
        this.namaHewan = namaHewan;
        this.jenisHewan = jenisHewan;
        this.idKandang = idKandang;
    }
    
    // Public getter methods
    public String getIdHewan() {
        return idHewan;
    }
    
    // Protected getter
    protected String getNamaHewan() {
        return namaHewan;
    }
    
    // Default (package-private) getter
    String getJenisHewan() {
        return jenisHewan;
    }
    
    // Public setter methods dengan validasi
    public void setIdHewan(String idHewan) {
        if(idHewan != null && !idHewan.isEmpty()) {
            this.idHewan = idHewan;
        }
    }
    
    // Protected setter
    protected void setNamaHewan(String namaHewan) {
        if(namaHewan != null && !namaHewan.isEmpty()) {
            this.namaHewan = namaHewan;
        }
    }
    
    // Default setter
    void setJenisHewan(String jenisHewan) {
        this.jenisHewan = jenisHewan;
    }
    
    // Public method untuk menampilkan info hewan
    public void displayInfo() {
        System.out.println("ID Hewan: " + idHewan);
        System.out.println("Nama Hewan: " + namaHewan);
        System.out.println("Jenis Hewan: " + jenisHewan);
        System.out.println("ID Kandang: " + idKandang);
    }
}

// Manager untuk Hewan (diupdate untuk menggunakan encapsulation)
class HewanManager {
    private ArrayList<Hewan> daftarHewan = new ArrayList<>();

    // Public method untuk menambah hewan
    public void addHewan(Hewan hewan) {
        if(hewan != null) {
            daftarHewan.add(hewan);
        }
    }

    // Public method untuk melihat daftar hewan
    public void viewHewan() {
        for (Hewan hewan : daftarHewan) {
            hewan.displayInfo();
            System.out.println("-------------------");
        }
    }

    // Protected method untuk update hewan
    protected void updateHewan(String idHewan, String namaBaru, String jenisBaru, String kandangBaru) {
        for (Hewan hewan : daftarHewan) {
            if (hewan.getIdHewan().equals(idHewan)) {
                hewan.setNamaHewan(namaBaru);
                hewan.setJenisHewan(jenisBaru);
                hewan.idKandang = kandangBaru; //  public field
                return;
            }
        }
    }

    // Public method untuk menghapus hewan
    public void deleteHewan(String idHewan) {
        daftarHewan.removeIf(hewan -> hewan.getIdHewan().equals(idHewan));
    }
}