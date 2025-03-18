import java.util.ArrayList;

// Entitas Pakan
class Pakan {
    String id_pakan;
    String jenis_pakan;
    int stok_pakan;
    String tanggal_kadaluarsa;

    public Pakan(String id_pakan, String jenis_pakan, int stok_pakan, String tanggal_kadaluarsa) {
        this.id_pakan = id_pakan;
        this.jenis_pakan = jenis_pakan;
        this.stok_pakan = stok_pakan;
        this.tanggal_kadaluarsa = tanggal_kadaluarsa;
    }
}

// Manager untuk Pakan
class PakanManager {
    private ArrayList<Pakan> pakans = new ArrayList<>();

    public void addPakan(Pakan pakan) {
        pakans.add(pakan);
    }

    public void viewPakan() {
        for (Pakan pakan : pakans) {
            System.out.println("ID Pakan: " + pakan.id_pakan + ", Jenis Pakan: " + pakan.jenis_pakan + ", Stok: " + pakan.stok_pakan + ", Tanggal Kadaluarsa: " + pakan.tanggal_kadaluarsa);
        }
    }

    public void updatePakan(String id_pakan, String jenis_pakan, int stok_pakan, String tanggal_kadaluarsa) {
        for (Pakan pakan : pakans) {
            if (pakan.id_pakan.equals(id_pakan)) {
                pakan.jenis_pakan = jenis_pakan;
                pakan.stok_pakan = stok_pakan;
                pakan.tanggal_kadaluarsa = tanggal_kadaluarsa;
                return;
            }
        }
    }

    public void deletePakan(String id_pakan) {
        pakans.removeIf(pakan -> pakan.id_pakan.equals(id_pakan));
    }
}