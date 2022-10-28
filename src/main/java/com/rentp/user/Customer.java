package com.rentp.user;

import com.rentp.Database.DatabaseUsers;

public class Customer {
    public String id_Customer;
    public String transport;

    public void opciones_cliente(String opc) {
        // DatabaseCars dbCars = new DatabaseCars();
        // dbCars.addNewCar("Renault", "Things", "Hello");
        // System.out.println(dbCars);
        // dbCars.save();

        // Alquilar
        if (opc.equals("1")) {
            // Mostrar un catalogo de los autos que se pueden alquilar
            alquilar();
        }
        // proporcionar auto
        else if (opc.equals("2")) {
            // el cliente tiene que dar los datos del auto que quiere ofrecer
            // vehiculo v1 = new vehiculo(placa,"color","modelo","marca",soat)
        }
    }

    public void singIn(String e, String p) {
        boolean valid = new DatabaseUsers().auth(e, p);
        if (valid) {
            System.out.println("OK!!");
        }
    }

    public void alquilar() {
        System.out.println("Placa: ujt-231" + "\nColor: rojo" + "\nModelo: spark" + "\nMarca: chevrolet" + "\nSoat : ");
    }
}
