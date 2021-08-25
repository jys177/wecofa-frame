package wecofa.frame.member.customer.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "WCF_CUSTOMER")
public class Customer {

    public Customer() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cus_no")
    private Long cusNo;

    @Column(name = "cus_id")
    private String cusId;

    @Column(name = "cus_name")
    private String cusName;

    @Column(name = "cus_balance")
    private double cusBalance;

    @Column(name = "cus_birthday")
    private Date cusBirthday;

    @Override
    public String toString() {
        return "Customer{" +
                "cusNo='" + cusNo + '\'' +
                ", cusName='" + cusName + '\'' +
                ", cusBalance=" + cusBalance +
                ", cusBirthday=" + cusBirthday +
                '}';
    }

    public Long getCusNo() {
        return cusNo;
    }

    public void setCusNo(Long cusNo) {
        this.cusNo = cusNo;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public double getCusBalance() {
        return cusBalance;
    }

    public void setCusBalance(double cusBalance) {
        this.cusBalance = cusBalance;
    }

    public Date getCusBirthday() {
        return cusBirthday;
    }

    public void setCusBirthday(Date cusBirthday) {
        this.cusBirthday = cusBirthday;
    }
}
