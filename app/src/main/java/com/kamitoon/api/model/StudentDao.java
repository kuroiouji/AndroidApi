package com.kamitoon.api.model;

import com.google.gson.annotations.SerializedName;

public class StudentDao {

    @SerializedName("std_code")
    private String code;

    @SerializedName("std_prefix")
    private String prefix;

    @SerializedName("std_fname")
    private String fname;

    @SerializedName("std_lname")
    private String lname;

    @SerializedName("std_birthdate")
    private String dob;

    @SerializedName("pos_name_th")
    private String pos;

    @SerializedName("tmstd_number")
    private String team;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
