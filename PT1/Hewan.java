import java.util.ArrayList;

// Entitas Hewan
class Hewan {
    String id_hewan;
    String nama_hewan;
    String jenis_hewan;
    String id_kandang;

    public Hewan(String id_hewan, String nama_hewan, String jenis_hewan, String id_kandang) {
        this.id_hewan = id_hewan;
        this.nama_hewan = nama_hewan;
        this.jenis_hewan = jenis_hewan;
        this.id_kandang = id_kandang;
    }
}

// Manager untuk Hewan
class HewanManager {
    private ArrayList<Hewan> hewans = new ArrayList<>();

    public void addHewan(Hewan hewan) {
        hewans.add(hewan);
    }

    public void viewHewan() {
        for (Hewan hewan : hewans) {
            System.out.println("ID Hewan: " + hewan.id_hewan + ", Nama Hewan: " + hewan.nama_hewan + ", Jenis Hewan: " + hewan.jenis_hewan + ", ID Kandang: " + hewan.id_kandang);
        }
    }

    public void updateHewan(String id_hewan, String nama_hewan, String jenis_hewan, String id_kandang) {
        for (Hewan hewan : hewans) {
            if (hewan.id_hewan.equals(id_hewan)) {
                hewan.nama_hewan = nama_hewan;
                hewan.jenis_hewan = jenis_hewan;
                hewan.id_kandang = id_kandang;
                return;
            }
        }
    }

    public void deleteHewan(String id_hewan) {
        hewans.removeIf(hewan -> hewan.id_hewan.equals(id_hewan));
    }
}