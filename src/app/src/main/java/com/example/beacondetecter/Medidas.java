package com.example.beacondetecter;

import java.util.Calendar;
/*!
 * \brief Clase de apoyo
 * \details Clase para almacenar las medidas en un formato correcto
 * \author Pepe Gascó Bule
 * \version 1.0
 * \date 2023
 */
public class Medidas {
    float value;
    String date;

    /**
     * Constructor vacio, añadimos la fecha de creacion.
     */
    public Medidas() {
        this.date = String.valueOf(Calendar.getInstance().getTime());
    }

    /**
     * Sobrecarga del constructor con el valor deseado
     * @param value Valor de la medicion introducida en el EditText
     */
    public Medidas(float value) {
        this.value = value;
        this.date = String.valueOf(Calendar.getInstance().getTime());
    }

    /**
     * Geters and setters
     * */
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
