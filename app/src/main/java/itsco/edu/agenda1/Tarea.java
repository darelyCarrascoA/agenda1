package itsco.edu.agenda1;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by darelitha on 05/03/2017.
 */

public class Tarea implements Parcelable{
    private String nombre;
    private String telefono;
    private String email;

    public Tarea(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email; }

    @Override
    public String toString() {
        return this.nombre;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(telefono);
        dest.writeString(email);

    }

    private Tarea(Parcel parcel) {
        this.nombre = parcel.readString();
        this.telefono = parcel.readString();
        this.email = parcel.readString();
    }

    public static final Parcelable.Creator<Tarea> CREATOR = new Parcelable.Creator<Tarea>() {
        @Override
        public Tarea createFromParcel(Parcel parcel) {
            return new Tarea(parcel);
        }

        @Override
        public Tarea[] newArray(int i) {
            return new Tarea[i];
        }
    };

}



