/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.iesch.desarrollo_interfaces;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author dam2
 */
public class fechas {
    
// Variables a utilizar para el ejercicio
    static int dia;
    static int mes;
    static int año;

    // Método main donde ejecutamos el resto de funciones
    public static void main(String[] args) {
        leer();
        validar();
        mostrarCorta();
        bisiesto();
        diasMes();
        diasTranscurridos();
        diaSemana();
        mostrarLarga();
        fechaTras();
        siguiente();
    }

    // Función encargada de recibir la fecha
    private static void leer() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el año");
        while (!sc.hasNextInt()) {
            System.out.println("Debes introducir un valor entero");
            sc.next();
        }
        año = sc.nextInt();

        System.out.println("Introduce el mes (número)");
        while (!sc.hasNextInt()) {
            System.out.println("Debes introducir un valor entero del 1 al 12");
            sc.next();
        }
        mes = sc.nextInt();

        System.out.println("Introduce el dia");
        while (!sc.hasNextInt()) {
            System.out.println("Debes introducir un valor entero");
            sc.next();
        }
        dia = sc.nextInt();
    }

    // Función encargada de validar la fecha recibida y si no lo es ajustarla
    private static void validar() {
        if (dia < 1) {
            System.out.println("El día introducido no es válido (Es menor que 1), se asignará el día 1");
            dia = 1;
        } else if (dia > 31) {
            System.out.println("El día introducido no es válido (Es mayor que 31), se asignará el día 31");
            dia = 31;
        }

        if (mes < 1) {
            System.out.println("El día introducido no es válido (Es menor que 1), se asignará el mes 1");
            mes = 1;
        } else if (mes > 12) {
            System.out.println("El día introducido no es válido (Es mayor que 12), se asignará el mes 12");
            mes = 12;
        }

        if (año < 1900) {
            System.out.println("El día introducido no es válido (Es menor que 1900), se asignará el año 1900 ");
            año = 1900;
        } else if (año > 2050) {
            System.out.println("El día introducido no es válido (Es mayor que 2050), se asignará el año 2050");
            año = 2050;
        }
    }

    // Función encargada de mostrar la fecha en formato corto
    private static void mostrarCorta() {
        System.out.println(dia + "-" + mes + "-" + año);
    }

    // Función encargada de decir si el años de la fecha seleccionada es bisiesto
    private static void bisiesto() {
        GregorianCalendar calendario = new GregorianCalendar();

        if (calendario.isLeapYear(año)) {
            System.out.println("El año es bisiesto");
        } else {
            System.out.println("El año no es bisiesto");
        }
    }

    // Función encargada de mostrar los dias que tiene el mes introducido en función del año
    private static void diasMes() {
        if (mes == 1) {
            System.out.println(mes + " tiene 31 dias");
        } else if (mes == 2) {
            GregorianCalendar calendario = new GregorianCalendar();

            if (calendario.isLeapYear(año)) {
                System.out.println(mes + " tiene 29 dias");
            } else {
                System.out.println(mes + " tiene 28 dias");
            }
        } else if (mes == 3) {
            System.out.println(mes + " tiene 31 dias");
        } else if (mes == 4) {
            System.out.println(mes + " tiene 30 dias");
        } else if (mes == 5) {
            System.out.println(mes + " tiene 31 dias");
        } else if (mes == 6) {
            System.out.println(mes + " tiene 30 dias");
        } else if (mes == 7) {
            System.out.println(mes + " tiene 31 dias");
        } else if (mes == 8) {
            System.out.println(mes + " tiene 30 dias");
        } else if (mes == 9) {
            System.out.println(mes + " tiene 31 dias");
        } else if (mes == 10) {
            System.out.println(mes + " tiene 30 dias");
        } else if (mes == 11) {
            System.out.println(mes + " tiene 31 dias");
        } else if (mes == 12) {
            System.out.println(mes + " tiene 30 dias");
        }
    }

    // Función encargada de mostrar los días transcurridos desde el 1-1-1900 hasta la fecha introducida
    private static void diasTranscurridos() {
        LocalDate fechaInicial = LocalDate.parse("1900-01-01");
        String aux = "0";
        if (mes < 10 && dia < 10) {
            aux = año + "-0" + mes + "-0" + dia;
        } else if (mes < 10 && !(dia < 10)) {
            aux = año + "-0" + mes + "-" + dia;
        } else if (!(mes < 10) && dia < 10) {
            aux = año + "-" + mes + "-0" + dia;
        } else if (!(mes < 10) && !(dia < 10)) {
            aux = año + "-" + mes + "-" + dia;
        }

        LocalDate fechafinal = LocalDate.parse(aux);

        Duration dias = Duration.between(fechaInicial.atStartOfDay(), fechafinal.atStartOfDay());
        System.out.println("Han transcurrido " + dias.toDays() + " dias");
    }

    // Función encargada de decir el día de la semana que fué o será el día introducido
    private static void diaSemana() {
        String aux = "0";
        if (mes < 10 && dia < 10) {
            aux = año + "-0" + mes + "-0" + dia;
        } else if (mes < 10 && !(dia < 10)) {
            aux = año + "-0" + mes + "-" + dia;
        } else if (!(mes < 10) && dia < 10) {
            aux = año + "-" + mes + "-0" + dia;
        } else if (!(mes < 10) && !(dia < 10)) {
            aux = año + "-" + mes + "-" + dia;
        }

        LocalDate fechafinal = LocalDate.parse(aux);
        System.out.println(fechafinal.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
    }

    // Función encargada de mostrar la fecha en formato largo
    private static void mostrarLarga() {
        String aux = "0";
        if (mes < 10 && dia < 10) {
            aux = año + "-0" + mes + "-0" + dia;
        } else if (mes < 10 && !(dia < 10)) {
            aux = año + "-0" + mes + "-" + dia;
        } else if (!(mes < 10) && dia < 10) {
            aux = año + "-" + mes + "-0" + dia;
        } else if (!(mes < 10) && !(dia < 10)) {
            aux = año + "-" + mes + "-" + dia;
        }

        LocalDate fechafinal = LocalDate.parse(aux);
        System.out.println(fechafinal.getDayOfWeek() + ", " + fechafinal.getDayOfMonth() + " de " + fechafinal.getMonth() + " de " + fechafinal.getYear());
    }

    // Función encargada de mostrar la fecha correspondiente al día introducido comenzando desde el 1-1-1900
    private static void fechaTras() {
        LocalDate fechaInicial = LocalDate.parse("1900-01-01");
        Scanner sc = new Scanner(System.in);
        int dias = 0;
        System.out.println("Fecha inicial: " + fechaInicial);
        System.out.println("¿Cuántos días quieres que pasen desde esa fecha?");
        System.out.println("Introduce un número de dias");
        while (!sc.hasNextInt()) {
            System.out.println("Introduce un número de dias válido");
            sc.next();
        }
        dias = sc.nextInt();

        System.out.println(fechaInicial.plusDays(dias));
    }

    // Función encargada de mostrar el día siguiente al de la fecha introducida
    private static void siguiente() {
        String aux = "0";
        if (mes < 10 && dia < 10) {
            aux = año + "-0" + mes + "-0" + dia;
        } else if (mes < 10 && !(dia < 10)) {
            aux = año + "-0" + mes + "-" + dia;
        } else if (!(mes < 10) && dia < 10) {
            aux = año + "-" + mes + "-0" + dia;
        } else if (!(mes < 10) && !(dia < 10)) {
            aux = año + "-" + mes + "-" + dia;
        }

        LocalDate fechafinal = LocalDate.parse(aux);
        System.out.println("La fecha introducida tras pasar un día será: ");
        System.out.println(fechafinal.plusDays(1));
    }
}
