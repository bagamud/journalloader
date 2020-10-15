package ru.kpp.journalloader;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "journal", schema = "rab")
public class Journal {
    int id;
    private String requestDate;
    private String requestTime;
    private Date requestDateTime;
    private String subject;
    private String department;
    private String userName;
    private String GRZ;
    private String VIN;
    private String back;
    private String chassi;
    private String PTC;
    private String CTC;
    private String admNum;
    private String docNum;
    private String familyOrganization;
    private String name;
    private String fatherName;
    private String birthday;
    private String serialPas;
    private String serialVU;
    private String INN;
    private String OGRN;
    private Timestamp loadDate;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    @Basic
    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    @Basic
    @Column(columnDefinition = "TIMESTAMP")
    public Date getRequestDateTime() {
        return requestDateTime;
    }

    public void setRequestDateTime(Date requestDateTime) {
        this.requestDateTime = requestDateTime;
    }

    @Basic
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Basic
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Basic
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    public String getGRZ() {
        return GRZ;
    }

    public void setGRZ(String GRZ) {
        this.GRZ = GRZ;
    }

    @Basic
    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    @Basic
    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    @Basic
    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    @Basic
    public String getPTC() {
        return PTC;
    }

    public void setPTC(String PTC) {
        this.PTC = PTC;
    }

    @Basic
    public String getCTC() {
        return CTC;
    }

    public void setCTC(String CTC) {
        this.CTC = CTC;
    }

    @Basic
    public String getAdmNum() {
        return admNum;
    }

    public void setAdmNum(String admNum) {
        this.admNum = admNum;
    }

    @Basic
    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    @Basic
    public String getFamilyOrganization() {
        return familyOrganization;
    }

    public void setFamilyOrganization(String familyOrganization) {
        this.familyOrganization = familyOrganization;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    @Basic
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Basic
    public String getSerialPas() {
        return serialPas;
    }

    public void setSerialPas(String serialPas) {
        this.serialPas = serialPas;
    }

    @Basic
    public String getSerialVU() {
        return serialVU;
    }

    public void setSerialVU(String serialVU) {
        this.serialVU = serialVU;
    }

    @Basic
    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    @Basic
    public String getOGRN() {
        return OGRN;
    }

    public void setOGRN(String OGRN) {
        this.OGRN = OGRN;
    }

    @Basic
    @Column(columnDefinition = "TIMESTAMP")
    public Timestamp getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(Timestamp loadDate) {
        this.loadDate = loadDate;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Journal) obj).requestDate.equals(this.requestDate) &&
                ((Journal) obj).requestTime.equals(this.requestTime) &&
                ((Journal) obj).requestDateTime.toString().equals(this.requestDateTime.toString()) &&
                ((Journal) obj).subject.equals(this.subject) &&
                ((Journal) obj).department.equals(this.department) &&
                ((Journal) obj).userName.equals(this.userName) &&
                ((Journal) obj).GRZ.equals(this.GRZ) &&
                ((Journal) obj).VIN.equals(this.VIN) &&
                ((Journal) obj).back.equals(this.back) &&
                ((Journal) obj).chassi.equals(this.chassi) &&
                ((Journal) obj).PTC.equals(this.PTC) &&
                ((Journal) obj).CTC.equals(this.CTC) &&
                ((Journal) obj).admNum.equals(this.admNum) &&
                ((Journal) obj).docNum.equals(this.docNum) &&
                ((Journal) obj).familyOrganization.equals(this.familyOrganization) &&
                ((Journal) obj).name.equals(this.name) &&
                ((Journal) obj).fatherName.equals(this.fatherName) &&
                ((Journal) obj).birthday.equals(this.birthday) &&
                ((Journal) obj).serialPas.equals(this.serialPas) &&
                ((Journal) obj).serialVU.equals(this.serialVU) &&
                ((Journal) obj).OGRN.equals(this.OGRN);
    }
}
