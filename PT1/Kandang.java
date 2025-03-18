import java.util.ArrayList;

// Entitas Kandang
class Kandang {
    String id_kandang;
    String nama_kandang;
    String lokasi;
    int kapasitas;

    public Kandang(String id_kandang, String nama_kandang, String lokasi, int kapasitas) {
        this.id_kandang = id_kandang;
        this.nama_kandang = nama_kandang;
        this.lokasi = lokasi;
        this.kapasitas = kapasitas;
    }
}

// Manager untuk Kandang
class KandangManager {
    private ArrayList<Kandang> kandangs = new ArrayList<>();

    public void addKandang(Kandang kandang) {
        kandangs.add(kandang);
    }

    public void viewKandang() {
        for (Kandang kandang : kandangs) {
            System.out.println("ID Kandang: " + kandang.id_kandang + ", Nama Kandang: " + kandang.nama_kandang + ", Lokasi: " + kandang.lokasi + ", Kapasitas: " + kandang.kapasitas);
        }
    }

    public void updateKandang(String id_kandang, String nama_kandang, String lokasi, int kapasitas) {
        for (Kandang kandang : kandangs) {
            if (kandang.id_kandang.equals(id_kandang)) {
                kandang.nama_kandang = nama_kandang;
                kandang.lokasi = lokasi;
                kandang.kapasitas = kapasitas;
                return;
            }
        }
    }

    public void deleteKandang(String id_kandang) {
        kandangs.removeIf(kandang -> kandang.id_kandang.equals(id_kandang));
    }
}