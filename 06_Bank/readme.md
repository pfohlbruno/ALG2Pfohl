#Banka

Vytvořte projekt <prijmeni>_Bank, kde vytvoříte a implementujete částečný objektový model z finančního prostředí. 
V balíčku bank.
##1. Vytvořte třídu Account (Účet), která reprezentuje bankovní účet bez možnosti přečerpání.
Třída má umožnit vytvořit prázdný účet a účet s počátečním vkladem.
Umožněte vklad zadané sumy peněz na účet.
Umožněte výběr zadané sumy peněz z účtu.
Poskytněte údaje o výši zůstatku na účtu. 
##2. Vytvořte abstraktní třídu Client (Klient), která reprezentuje klienta banky. Kromě jiných metod má jednu abstraktní metodu, která vrací jméno s oslovením (viz poslední bod)
Klient je charakterizován jménem a sadou účtů.
Umožněte přidání účtu klientovi s počátečním vkladem. 
Poskytněte informaci o celkové sumě peněz, které má klient v bance na účtech.
Poskytněte jméno klienta s oslovením jako abstraktní metodu vracející typ String.
##3. Vytvořte třídy Person (Osoba) a Company (Firma). Odvoďte je od třídy Client.
Obě třídy mají vytvořit objekt na základě zadaného jména.
Třída Person ať poskytuje jméno klienta s oslovením ve formě paní Svecova resp. pan Svec, podle toho, zda jméno končí na "ova". 
Třída Company ať poskytuje jméno klienta ve formě "firma Vitvarova".

##Implementujte hlavní program Main v balíčku app.
Vytvořte pole klientů banky: Pekar jako osoba, Svecova jako osoba a Skoda jako firma. 
Pekarovi vytvořte účet s počátečním vkladem 1000 a druhý účet s počátečním vkladem 500. Svecové vytvořte účet s počátečním vkladem 1200 a Škodě vytvořte účet s počátečním vkladem 120.
Vypište všechny klienty banky pomocí jména s oslovením a u každého vypište celkovou sumu peněz, které má v bance.
