package Session13.Ex04;

public class DichVu {

    private int maDichVu;
    private String tenDichVu;

    public DichVu() {
    }

    public DichVu(int maDichVu, String tenDichVu) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
    }

    public int getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(int maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    @Override
    public String toString() {
        return "DichVu{" +
                "maDichVu=" + maDichVu +
                ", tenDichVu='" + tenDichVu + '\'' +
                '}';
    }
}