package com.training.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "visitors")
public class Visitor {

    @Id
    private int visitorId;

    @Column()
    private String visitorName;

    @Column
    private String purpose;

    @Column
    private String mobileNumber;

    public Visitor() {
    }
    public Visitor(int visitorId, String visitorName, String purpose, String mobileNumber) {
        this.visitorId = visitorId;
        this.visitorName = visitorName;
        this.purpose = purpose;
        this.mobileNumber = mobileNumber;
    }

    public int getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(int visitorId) {
        this.visitorId = visitorId;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Visitor visitor = (Visitor) o;
        return visitorId == visitor.visitorId && Objects.equals(visitorName, visitor.visitorName) && Objects.equals(purpose, visitor.purpose) && Objects.equals(mobileNumber, visitor.mobileNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitorId, visitorName, purpose, mobileNumber);
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "visitorId=" + visitorId +
                ", visitorName='" + visitorName + '\'' +
                ", purpose='" + purpose + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
