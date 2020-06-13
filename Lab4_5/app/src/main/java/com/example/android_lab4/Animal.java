package com.example.android_lab4;
import java.io.Serializable;

public class Animal implements Serializable{
    private int _id;
    private String gatunek;
    private String kolor;
    private float wielkosc;
    private String opis;

    public Animal(){}

    public Animal(String gatunek, String kolor, float wielkosc, String opis){
        super();
        this.gatunek = gatunek;
        this.kolor = kolor;
        this.wielkosc = wielkosc;
        this.opis = opis;
    }

    public int get_Id(){return _id;}
    public String getOpis(){return opis;}
    public String getGatunek(){return gatunek;}
    public String getKolor(){return kolor;}
    public float getWielkosc(){return wielkosc;}
    public void set_Id(int _id){this._id=_id;}



}
