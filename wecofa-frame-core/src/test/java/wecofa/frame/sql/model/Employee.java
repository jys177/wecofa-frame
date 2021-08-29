package wecofa.frame.sql.model;

import wecofa.frame.sql.TableInterface;

import java.util.Map;

public class Employee implements TableInterface {
    private String empNo;
    private String empNm;
    private String jobCode;
    private int age;
    private int salary;
    private String deptNo;

    @Override
    public Map<String, String> getKeys() {
        return keys;
    }

    @Override
    public String getValue(String key) {
        return keys.get(key);
    }

    @Override
    public void putKey(String key, String value) {
        keys.put(key,value);
    }

    @Override
    public boolean containKeys(String key) {
        return keys.containsKey(key);
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpNm() {
        return empNm;
    }

    public void setEmpNm(String empNm) {
        this.empNm = empNm;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }
}
