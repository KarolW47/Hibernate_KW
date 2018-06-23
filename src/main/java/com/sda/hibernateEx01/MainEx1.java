package com.sda.hibernateEx01;

import com.sda.hibernate.service.AdressService;

import java.util.Scanner;

public class MainEx1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz tabele z ktora chcesz pracowac:");
        System.out.println("1 - Adresy");
        System.out.println("2 - Pracownicy");
        System.out.println("3 - Firmy");
        System.out.println("4 - Stanowiska");

        String scannedValue = scanner.nextLine();

        if (scannedValue.equals("1")){
            System.out.println("1 - wyswietl wszystkie");
            System.out.println("2 - zapisz");
            System.out.println("3 - zaktualizuj");
            System.out.println("4 - usun");

            String scannedValue1 = scanner.nextLine();

            if (scannedValue1.equals("1")){
                AdressService adressService = new AdressService();
                System.out.println(adressService.showAll().toString());
            }
        }
    }
}
