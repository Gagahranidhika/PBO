package model;

public class JadwalPakan {
    private String idJadwal;
    private String idKandang;
    private String idStaf;
    private String idPakan;
    private String tanggalPemberian;
    private String waktuPemberian;
    private String status;

    public JadwalPakan(String idJadwal, String idKandang, String idStaf, String idPakan, String tanggalPemberian, String waktuPemberian) {
        this.idJadwal = idJadwal;
        this.idKandang = idKandang;
        this.idStaf = idStaf;
        this.idPakan = idPakan;
        this.tanggalPemberian = tanggalPemberian;
        this.waktuPemberian = waktuPemberian;
        this.status = "Belum Selesai";
    }

    public void setIdKandang(String idKandang) { this.idKandang = idKandang; }
    public void setIdStaf(String idStaf) { this.idStaf = idStaf; }
    public void setIdPakan(String idPakan) { this.idPakan = idPakan; }
    public void setTanggal(String tanggal) { this.tanggalPemberian = tanggal; }
    public void setWaktu(String waktu) { this.waktuPemberian = waktu; }


    public String getIdStaf() {
        return idStaf;
    }

    public String getIdJadwal() {
        return idJadwal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void tampilkanInfo() {
        System.out.println("ID Jadwal: " + idJadwal + ", ID Kandang: " + idKandang);
        System.out.println("ID Staf: " + idStaf + ", ID Pakan: " + idPakan);
        System.out.println("Tanggal: " + tanggalPemberian + ", Waktu: " + waktuPemberian);
        System.out.println("Status: " + status);
    }
}

