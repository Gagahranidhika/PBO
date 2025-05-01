package model;

public class Kandang {
    private String idKandang;
    private String namaKandang;
    private String lokasi;
    private int kapasitas;

    public Kandang(String idKandang, String namaKandang, String lokasi, int kapasitas) {
        this.idKandang = idKandang;
        this.namaKandang = namaKandang;
        this.lokasi = lokasi;
        this.kapasitas = kapasitas;
    }

    public String getIdKandang() { return idKandang; }
    public String getNamaKandang() { return namaKandang; }
    public String getLokasi() { return lokasi; }
    public int getKapasitas() { return kapasitas; }

    public void setNamaKandang(String namaKandang) { this.namaKandang = namaKandang; }
    public void setLokasi(String lokasi) { this.lokasi = lokasi; }
    public void setKapasitas(int kapasitas) { this.kapasitas = kapasitas; }

    public void tampilkanInfo() {
        System.out.println("ID Kandang   : " + idKandang);
        System.out.println("Nama Kandang : " + namaKandang);
        System.out.println("Lokasi       : " + lokasi);
        System.out.println("Kapasitas    : " + kapasitas);
    }
}
