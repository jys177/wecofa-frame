package wecofa.frame.sql;

import org.junit.Test;
import org.springframework.util.StringUtils;
import wecofa.frame.sql.model.Department;
import wecofa.frame.sql.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class SqlTest {
    /***
     * Q : table join 을 java 로 표현할 수 있을까?
     * A join B
     * table A join table B
     * Array A join join Array B
     * */

    private List<Employee> employeeList = new ArrayList<>();
    private List<Department> departmentList= new ArrayList<>();

    private void setEmployeeList(){
        for(int i=0; i<100;i++){
            Employee emp = new Employee();
            emp.setEmpNm("EMP000"+(i+1));
            emp.setEmpNo("EMP000"+(i+1));
            emp.setAge(30+(i+1)%5);
            emp.setJobCode("JOB00"+(i+1)%5);
            emp.setSalary(100000*(i+1)%5+100000);
            emp.setDeptNo("DEP000"+((i%5)+1));
            emp.putKey("empNo",emp.getEmpNo());
            emp.putKey("deptNo",emp.getDeptNo());
            employeeList.add(emp);
        }
    }
    private void setDepartmentList(){
        for(int i=0; i<5;i++){
            Department dept = new Department();
            dept.setDeptNo("DEP000"+(i+1));
            dept.setDeptNm("DP"+(i+1));
            dept.setAddress("AD-0"+(i+1)+"-00"+(i+1));
            dept.putKey("deptNo",dept.getDeptNo());
            departmentList.add(dept);
        }
    }

    @Test
    public void joinTest(){
        setEmployeeList();
        setDepartmentList();
    }


    public List<Employee> join(List<Employee> tableA,List<Department> tableB){
        for(Employee emp:tableA){
            for(Department dept:tableB){

            }

        }
        return null;
    }



}
