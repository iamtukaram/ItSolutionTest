package com.example.itsolutiontest;



public class model {
    private String memberMobileNumber;
    private String contact;
    private String role;
    private String subscriptionFee;
    private String depositAmount;
    private String loanAmount;
    private String gender;
    private String dateOfBirth;
    private String dateOfJoining;
    private String maritalStatus;
    private String dateOfMarriage;
    private String caste;
    private String religion;
    private String category;
    private String aadharNo;

    public model(String memberMobileNumber, String contact, String role, String subscriptionFee,
                 String depositAmount, String loanAmount, String gender, String dateOfBirth,
                 String dateOfJoining, String maritalStatus, String dateOfMarriage, String caste,
                 String religion, String category, String aadharNo) {
        this.memberMobileNumber = memberMobileNumber;
        this.contact = contact;
        this.role = role;
        this.subscriptionFee = subscriptionFee;
        this.depositAmount = depositAmount;
        this.loanAmount = loanAmount;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfJoining = dateOfJoining;
        this.maritalStatus = maritalStatus;
        this.dateOfMarriage = dateOfMarriage;
        this.caste = caste;
        this.religion = religion;
        this.category = category;
        this.aadharNo = this.aadharNo;
    }



    public String getMemberMobileNumber() {
        return memberMobileNumber;
    }

    public String getContact() {
        return contact;
    }

    public String getRole() {
        return role;
    }

    public String getSubscriptionFee() {
        return subscriptionFee;
    }

    public String getDepositAmount() {
        return depositAmount;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getDateOfMarriage() {
        return dateOfMarriage;
    }

    public String getCaste() {
        return caste;
    }

    public String getReligion() {
        return religion;
    }

    public String getCategory() {
        return category;
    }

    public String getAadharNo() {
        return aadharNo;
    }
}
