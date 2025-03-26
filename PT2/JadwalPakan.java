import java.util.ArrayList;

// Entitas JadwalPakan
class JadwalPakan {
    String id_jadwal;
    String id_kandang;
    String id_pakan;
    String id_staf;
    String tanggal_pemberian;
    String waktu_pemberian;

    public JadwalPakan(String id_jadwal, String id_kandang, String id_pakan, String id_staf, String tanggal_pemberian, String waktu_pemberian) {
        this.id_jadwal = id_jadwal;
        this.id_kandang = id_kandang;
        this.id_pakan = id_pakan;
        this.id_staf = id_staf;
        this.tanggal_pemberian = tanggal_pemberian;
        this.waktu_pemberian = waktu_pemberian;
    }
}

// Manager untuk JadwalPakan
class JadwalPakanManager {
    private ArrayList<JadwalPakan> jadwalPakans = new ArrayList<>();

    public void addJadwalPakan(JadwalPakan jadwalPakan) {
        jadwalPakans.add(jadwalPakan);
    }

    public void viewJadwalPakan() {
        for (JadwalPakan jp : jadwalPakans) {
            System.out.println("ID Jadwal: " + jp.id_jadwal + ", ID Kandang: " + jp.id_kandang + ", ID Pakan: " + jp.id_pakan + ", ID Staf: " + jp.id_staf + ", Tanggal Pemberian: " + jp.tanggal_pemberian + ", Waktu Pemberian: " + jp.waktu_pemberian);
        }
    }

    public void updateJadwalPakan(String id_jadwal, String id_kandang, String id_pakan, String id_staf, String tanggal_pemberian, String waktu_pemberian) {
        for (JadwalPakan jp : jadwalPakans) {
            if (jp.id_jadwal.equals(id_jadwal)) {
                jp.id_kandang = id_kandang;
                jp.id_pakan = id_pakan;
                jp.id_staf = id_staf;
                jp.tanggal_pemberian = tanggal_pemberian;
                jp.waktu_pemberian = waktu_pemberian;
                return;
            }
        }
    }

    public void deleteJadwalPakan(String id_jadwal) {
        jadwalPakans.removeIf(jp -> jp.id_jadwal.equals(id_jadwal));
    }
}