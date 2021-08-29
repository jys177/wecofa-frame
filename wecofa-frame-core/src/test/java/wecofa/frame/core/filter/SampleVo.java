package wecofa.frame.core.filter;

public class SampleVo {
    private String sampleId;
    private String sampleName;

    public String getSampleId() {
        return sampleId;
    }

    public void setSampleId(String sampleId) {
        this.sampleId = sampleId;
    }

    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    @Override
    public String toString() {
        return "SampleVo{" +
                "sampleId='" + sampleId + '\'' +
                ", sampleName='" + sampleName + '\'' +
                '}';
    }
}
