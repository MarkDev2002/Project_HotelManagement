package DOAN;

public class ConNguoi {
    protected String Ten, GT, TTLL;
    protected int Tuoi;

    protected ConNguoi() {
        Ten = null;
        GT = null;
        Tuoi = 0;
        TTLL = null;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getGT() {
        return GT;
    }

    public void setGT(String gT) {
        GT = gT;
    }

    public String getTTLL() {
        return TTLL;
    }

    public void setTTLL(String tTLL) {
        TTLL = tTLL;
    }

    public int getTuoi() {
        return Tuoi;
    }

    public void setTuoi(int tuoi) {
        Tuoi = tuoi;
    }


}
