package wecofa.frame.sql.model;

import wecofa.frame.sql.TableInterface;

import java.util.Map;

public class Department implements TableInterface {
    private String deptNo;
    private String deptNm;
    private String address;


    @Override
    public Map<String, String> getKeys() {
        return keys;
    }

    @Override
    public void putKey(String key, String value) {
        keys.put(key,value);
    }

    @Override
    public boolean containKeys(String key) {
        return keys.containsKey(key);
    }

    @Override
    public String getValue(String key) {
        return keys.get(key);
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptNm() {
        return deptNm;
    }

    public void setDeptNm(String deptNm) {
        this.deptNm = deptNm;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
