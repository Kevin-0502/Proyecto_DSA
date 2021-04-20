package com.example.dentistapp;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class ContactsModel implements Serializable, Parcelable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("tel")
    @Expose
    private String tel;
    @SerializedName("img")
    @Expose
    private int img;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public ContactsModel(String name, String tel, int img) {
        this.name = name;
        this.tel = tel;
        this.img = img;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.img);
        dest.writeInt(Integer.parseInt(this.tel));
    }

    public void readFromParcel(Parcel source) {
        this.name = source.readString();
        this.tel = source.readString();
        this.img = source.readInt();

    }

    public ContactsModel() {
    }

    protected ContactsModel(Parcel in) {
        this.name = in.readString();
        this.tel = in.readString();
        this.img = in.readInt();
    }

    public static final Creator<ContactsModel> CREATOR = new Creator<ContactsModel>() {
        @Override
        public ContactsModel createFromParcel(Parcel source) {
            return new ContactsModel(source);
        }

        @Override
        public ContactsModel[] newArray(int size) {
            return new ContactsModel[size];
        }
    };


}