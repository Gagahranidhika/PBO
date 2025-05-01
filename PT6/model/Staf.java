package model;

import java.util.ArrayList;
import java.util.List;

public class Staf extends Akun implements TugasPakan {
    private String jabatan;
    private static ArrayList<Staf> daftarStaf = new ArrayList<>();

    public Staf(String id, String nama, String password, String noTelp, String jabatan) {
        super(id, nama, password, noTelp);
        this.jabatan = jabatan;
    }

    public String getJabatan() { return jabatan; }
    public void setJabatan(String jabatan) { this.jabatan = jabatan; }

    @Override
    public void tampilkanInfo() {
        System.out.println("=== Staf ===");
        System.out.println("ID: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("No. Telp: " + noTelp);
        System.out.println("Jabatan: " + jabatan);
    }

    // Implementasi metode CRUD untuk Staf
    @Override
    public void tambah(Akun akun) {
        daftarStaf.add((Staf) akun); // Menambahkan staf ke daftar
    }

    public static void tampilkanSemua() {
        for (Staf staf : daftarStaf) {
            staf.tampilkanInfo();
            System.out.println("----------------------");
        }
    }

    @Override
    public void update(String id, String namaBaru, String noTelpBaru) {
        for (Staf staf : daftarStaf) {
            if (staf.getId().equals(id)) {
                staf.setNama(namaBaru);
                staf.setNoTelp(noTelpBaru);
                break;
            }
        }
    }

    public void update(String id, String namaBaru, String noTelpBaru, String jabatanBaru) {
        for (Staf staf : daftarStaf) {
            if (staf.getId().equals(id)) {
                staf.setNama(namaBaru);
                staf.setNoTelp(noTelpBaru);
                staf.setJabatan(jabatanBaru);  // Update jabatan as well
                break;
            }
        }
    }


    @Override
    public void hapus(String id) {
        daftarStaf.removeIf(staf -> staf.getId().equals(id));
    }

    public static ArrayList<Staf> getDaftarStaf() {
        return daftarStaf;
    }

    @Override
public void lihatJadwal(List<JadwalPakan> daftarJadwal) {
    System.out.println("=== Jadwal Pakan untuk " + getNama() + " ===");
    for (JadwalPakan jp : daftarJadwal) {
        if (jp.getIdStaf().equals(this.getId())) {
            jp.tampilkanInfo();
            System.out.println("---------------------");
        }
    }
}

@Override
public void konfirmasiPakan(List<JadwalPakan> daftarJadwal, String idTugas) {
    for (JadwalPakan jp : daftarJadwal) {
        if (jp.getIdJadwal().equals(idTugas) && jp.getIdStaf().equals(this.getId())) {
            jp.setStatus("Selesai");
            System.out.println("Tugas pakan ID " + idTugas + " telah dikonfirmasi selesai.");
            return;
        }
    }
    System.out.println("Tugas tidak ditemukan atau bukan milik Anda.");
}

}
