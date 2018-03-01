package com.example.ravindra.php_mysql_android;

import com.google.gson.annotations.SerializedName;

public class student_details {
    @SerializedName("Name")
    public String Name;
    @SerializedName("Branch")
    public String Branch;
    @SerializedName("Phone")
    public int Phone;
    @SerializedName("Email")
    public String Email;
    @SerializedName("Age")
    public int Age;
}
