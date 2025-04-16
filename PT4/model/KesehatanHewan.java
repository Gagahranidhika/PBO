package model;

public class KesehatanHewan {
    private String idKesehatan;
    private String idHewan;
    private String tanggalPeriksa;
    private String status;
    private String catatan;

    public KesehatanHewan(String idKesehatan, String idHewan, String tanggalPeriksa, String status, String catatan) {
        this.idKesehatan = idKesehatan;
        this.idHewan = idHewan;
        this.tanggalPeriksa = tanggalPeriksa;
        this.status = status;
        this.catatan = catatan;
    }

    public String getIdKesehatan() { return idKesehatan; }
    public String getIdHewan() { return idHewan; }
    public String getTanggalPeriksa() { return tanggalPeriksa; }
    public String getStatus() { return status; }
    public String getCatatan() { return catatan; }
    public void setTanggal(String tanggal) { this.tanggalPeriksa = tanggal; }
    public void setStatus(String status) { this.status = status; }
    public void setCatatan(String catatan) { this.catatan = catatan; }


    public void tampilkanInfo() {
        System.out.println("ID Kesehatan: " + idKesehatan + ", ID Hewan: " + idHewan);
        System.out.println("Tanggal: " + tanggalPeriksa + ", Status: " + status);
        System.out.println("Catatan: " + catatan);
    }
}
