package com.orphanage.apps.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrphanageRegistrationModel {

    @SerializedName("registerData")
    @Expose
    public RegisterData registerData;

    public RegisterData getRegisterData() {
        return registerData;
    }

    public void setRegisterData(RegisterData registerData) {
        this.registerData = registerData;
    }

    public static class RegisterData {

        @SerializedName("data")
        @Expose
        public Data data;
        @SerializedName("APIkey")
        @Expose
        public String aPIkey;

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

        public String getAPIkey() {
            return aPIkey;
        }

        public void setAPIkey(String aPIkey) {
            this.aPIkey = aPIkey;
        }
    }

    public static class Data {

        @SerializedName("FullName")
        @Expose
        public String fullName;
        @SerializedName("RegisterNumber")
        @Expose
        public String registerNumber;
        @SerializedName("ManagerName")
        @Expose
        public String managerName;
        @SerializedName("NumberKids")
        @Expose
        public String numberKids;
        @SerializedName("Address")
        @Expose
        public String address;
        @SerializedName("PhoneNumber1")
        @Expose
        public String phoneNumber1;
        @SerializedName("PhoneNumber2")
        @Expose
        public String phoneNumber2;
        @SerializedName("EmailID")
        @Expose
        public String emailID;
        @SerializedName("SocialMedia")
        @Expose
        public String socialMedia;
        @SerializedName("device")
        @Expose
        public String device;
        @SerializedName("type")
        @Expose
        public String type;

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getRegisterNumber() {
            return registerNumber;
        }

        public void setRegisterNumber(String registerNumber) {
            this.registerNumber = registerNumber;
        }

        public String getManagerName() {
            return managerName;
        }

        public void setManagerName(String managerName) {
            this.managerName = managerName;
        }

        public String getNumberKids() {
            return numberKids;
        }

        public void setNumberKids(String numberKids) {
            this.numberKids = numberKids;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhoneNumber1() {
            return phoneNumber1;
        }

        public void setPhoneNumber1(String phoneNumber1) {
            this.phoneNumber1 = phoneNumber1;
        }

        public String getPhoneNumber2() {
            return phoneNumber2;
        }

        public void setPhoneNumber2(String phoneNumber2) {
            this.phoneNumber2 = phoneNumber2;
        }

        public String getEmailID() {
            return emailID;
        }

        public void setEmailID(String emailID) {
            this.emailID = emailID;
        }

        public String getSocialMedia() {
            return socialMedia;
        }

        public void setSocialMedia(String socialMedia) {
            this.socialMedia = socialMedia;
        }

        public String getDevice() {
            return device;
        }

        public void setDevice(String device) {
            this.device = device;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
