package Session12.Ex04;

public class LabResult {
    private int patientId;
    private String resultValue;

    public LabResult(int patientId, String resultValue) {
        this.patientId = patientId;
        this.resultValue = resultValue;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getResultValue() {
        return resultValue;
    }

    public void setResultValue(String resultValue) {
        this.resultValue = resultValue;
    }
}
