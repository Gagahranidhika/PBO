import java.util.ArrayList;

// Entitas KesehatanHewan
class KesehatanHewan {
    String id_kesehatan;
    String id_hewan;
    String tanggal_periksa;
    String status;
    String catatan;

    public KesehatanHewan(String id_kesehatan, String id_hewan, String tanggal_periksa, String status, String catatan) {
        this.id_kesehatan = id_kesehatan;
        this.id_hewan = id_hewan;
        this.tanggal_periksa = tanggal_periksa;
        this.status = status;
        this.catatan = catatan;
    }
}

// Manager untuk KesehatanHewan
class KesehatanHewanManager {
    private ArrayList<KesehatanHewan> kesehatanHewans = new ArrayList<>();

    public void addKesehatanHewan(KesehatanHewan kesehatanHewan) {
        kesehatanHewans.add(kesehatanHewan);
    }

    public void viewKesehatanHewan() {
        for (KesehatanHewan kh : kesehatanHewans) {
            System.out.println("ID Kesehatan: " + kh.id_kesehatan + ", ID Hewan: " + kh.id_hewan + ", Tanggal Periksa: " + kh.tanggal_periksa + ", Status: " + kh.status + ", Catatan: " + kh.catatan);
        }
    }

    public void updateKesehatanHewan(String id_kesehatan, String id_hewan, String tanggal_periksa, String status, String catatan) {
        for (KesehatanHewan kh : kesehatanHewans) {
            if (kh.id_kesehatan.equals(id_kesehatan)) {
                kh.id_hewan = id_hewan;
                kh.tanggal_periksa = tanggal_periksa;
                kh.status = status;
                kh.catatan = catatan;
                return;
            }
        }
    }

    public void deleteKesehatanHewan(String id_kesehatan) {
        kesehatanHewans.removeIf(kh -> kh.id_kesehatan.equals(id_kesehatan));
    }
}