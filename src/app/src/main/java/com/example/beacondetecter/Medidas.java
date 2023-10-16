package com.example.beacondetecter;

import java.util.Calendar;

public class Medidas {
    float value;
    String date;

    public Medidas() {
        this.date = String.valueOf(Calendar.getInstance().getTime());
    }

    public Medidas(float value) {
        this.value = value;
        this.date = String.valueOf(Calendar.getInstance().getTime());
    }

    public float getValue() {
        return value;
    }

    public String getDate() {
        return date;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
