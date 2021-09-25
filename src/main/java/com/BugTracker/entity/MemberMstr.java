package com.BugTracker.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MEMBER_MSTR")
public class MemberMstr {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private BigInteger userId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="MID_NAME")
	private String midName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="DOB")
	private Date dob;
	
	@Column(name="PRIMARY_EMAIL_ID")
	private String priMailId;
	
	@Column(name="PRIMARY_MOBILE_NUM")
	private BigInteger priMobile;
	
	@Column(name="SECONDARY_EMAIL_ID")
	private String secMailID;
	
	@Column(name="SECONDARY_MOBILE_NUM")
	private BigInteger secMobile;
	
	@Column(name="ROLE_CODE")
	private String roleCd;
	
	@Column(name="DATE_OF_JOINING")
	private Date dateOfJoining;
	
	@Column(name="ADDR_LINE_1")
	private String addrLine1;
	
	@Column(name="ADDR_LINE_2")
	private String addrLine2;
	
	@Column(name="PINCODE")
	private BigInteger pincode;
	
	@Column(name="CREATED_TIMESTAMP")
	private Timestamp createdTmstmp;
	
	@Column(name="LAST_UPDATED_TIMESTAMP")
	private Timestamp lastUpdatedTmpstmp;
	
	@Column(name="CREATED_BY")
	private BigInteger createdBy;
	
	@Column(name="LAST_UPDATED_BY")
	private BigInteger lastUpdateBy;
	
	@Column(name="UNIQUE_ID_TYPE")
	private String uniqueIdType;
	
	@Column(name="UNIQUE_ID")
	private String uniqueId;
	
	public BigInteger getUserId() {
		return userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMidName() {
		return midName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getDob() {
		return dob;
	}

	public String getPriMailId() {
		return priMailId;
	}

	public BigInteger getPriMobile() {
		return priMobile;
	}

	public String getSecMailID() {
		return secMailID;
	}

	public BigInteger getSecMobile() {
		return secMobile;
	}

	public String getRoleCd() {
		return roleCd;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public String getAddrLine1() {
		return addrLine1;
	}

	public String getAddrLine2() {
		return addrLine2;
	}

	public BigInteger getPincode() {
		return pincode;
	}

	public Timestamp getCreatedTmstmp() {
		return createdTmstmp;
	}

	public Timestamp getLastUpdatedTmpstmp() {
		return lastUpdatedTmpstmp;
	}

	public BigInteger getCreatedBy() {
		return createdBy;
	}

	public BigInteger getLastUpdateBy() {
		return lastUpdateBy;
	}

	public String getUniqueIdType() {
		return uniqueIdType;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setPriMailId(String priMailId) {
		this.priMailId = priMailId;
	}

	public void setPriMobile(BigInteger priMobile) {
		this.priMobile = priMobile;
	}

	public void setSecMailID(String secMailID) {
		this.secMailID = secMailID;
	}

	public void setSecMobile(BigInteger secMobile) {
		this.secMobile = secMobile;
	}

	public void setRoleCd(String roleCd) {
		this.roleCd = roleCd;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public void setAddrLine1(String addrLine1) {
		this.addrLine1 = addrLine1;
	}

	public void setAddrLine2(String addrLine2) {
		this.addrLine2 = addrLine2;
	}

	public void setPincode(BigInteger pincode) {
		this.pincode = pincode;
	}

	public void setCreatedTmstmp(Timestamp createdTmstmp) {
		this.createdTmstmp = createdTmstmp;
	}

	public void setLastUpdatedTmpstmp(Timestamp lastUpdatedTmpstmp) {
		this.lastUpdatedTmpstmp = lastUpdatedTmpstmp;
	}

	public void setCreatedBy(BigInteger createdBy) {
		this.createdBy = createdBy;
	}

	public void setLastUpdateBy(BigInteger lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public void setUniqueIdType(String uniqueIdType) {
		this.uniqueIdType = uniqueIdType;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

}















