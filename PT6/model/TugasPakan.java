package model;

import java.util.List;

public interface TugasPakan {
    void lihatJadwal(List<JadwalPakan> daftarJadwal);
    void konfirmasiPakan(List<JadwalPakan> daftarJadwal, String idTugas);
}
