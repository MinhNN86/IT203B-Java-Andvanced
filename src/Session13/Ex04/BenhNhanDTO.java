package Session13.Ex04;

import java.util.List;

public class BenhNhanDTO {

    private int maBenhNhan;
    private String tenBenhNhan;
    private List<DichVu> dsDichVu;

    // Constructor rỗng
    public BenhNhanDTO() {
    }

    // Constructor đầy đủ
    public BenhNhanDTO(int maBenhNhan, String tenBenhNhan, List<DichVu> dsDichVu) {
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.dsDichVu = dsDichVu;
    }

    // Getter & Setter
    public int getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(int maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public List<DichVu> getDsDichVu() {
        return dsDichVu;
    }

    public void setDsDichVu(List<DichVu> dsDichVu) {
        this.dsDichVu = dsDichVu;
    }

    @Override
    public String toString() {
        return "BenhNhanDTO{" +
                "maBenhNhan=" + maBenhNhan +
                ", tenBenhNhan='" + tenBenhNhan + '\'' +
                ", dsDichVu=" + dsDichVu +
                '}';
    }
}