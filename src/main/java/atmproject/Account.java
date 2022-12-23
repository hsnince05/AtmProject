package atmproject;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {


    private int accountNumber;      // hesap numarasi
    private int pinNumber;          // sifre

    private double checkingBalance; // vadesiz hesap bakiyesi
    private double savingBalance;    // vadeli hesa bakiyesi

    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    Scanner input = new Scanner(System.in);


    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckkingBalance(double checkkingBalance) {
        this.checkingBalance = checkkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingNalance(double savingNalance) {
        this.savingBalance = savingNalance;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }



    // para cekme  ==> vadesiz hesap (checking Balance) para Cekme Isleminde nSonra Kalan Miktari hesaplama      amount: miktar
    private double calculateCheckingBalanceAfterWithdraw(double amount){

        checkingBalance = checkingBalance - amount;

        return checkingBalance;

    }


    // para yatirma  ==> vadesiz hesap(checking Balance) para yatirma isleminden sonra bakiyeyi hesapla          amount: miktar
    private double calculateCheckingBalanceAfterDeposit(double amount){

        checkingBalance = checkingBalance + amount;

        return checkingBalance;

    }



    // para cekme  ==> vadeli hesap(saving balance)para Cekme Isleminden Sonra Kalan Miktari hesapla              amount: miktar
    private double calculateSavingBalanceAfterWithdraw(double amount){

        savingBalance = savingBalance - amount;

        return savingBalance;

    }


    // para yatirma  ==> vadeli hesap(saving balance ) para yatirma isleminden sonra bakiyeyi hesapla               amount: miktar
    private double calculateSavingBalanceAfterDeposit(double amount){

        savingBalance = savingBalance + amount;

        return savingBalance;

    }


    //para cekme : checking hesap musteri ile para cekmek icin etkilesime gecelim:
    public void getCheckingWithdraw(){
        displayCurrentAmount(checkingBalance);
        System.out.println("cekmek istediginiz miktari giriniz");
        double amount = input.nextDouble();

        if (amount<=0){
            System.out.println("sifir veya eksi tutarlar gecersizdir!");
            getCheckingWithdraw();// recursive method ==> methodu tekrardan cagirma
        } else if (amount<=checkingBalance){

            calculateCheckingBalanceAfterWithdraw(amount);
            displayCurrentAmount(checkingBalance);

        } else {
            System.out.println("yetersiz bakiye");
        }
    }



    //Para yatirma(checking): musteri ile para yatirmak icin etkilesime gecelim
    public void getCheckingDeposit(){
        displayCurrentAmount(checkingBalance);
        System.out.println("yatirmak istediginiz miktari giriniz");
        double amount = input.nextDouble();

        if (amount<=0){
            System.out.println("sifir veya eksi tutarlar gecersizdir!");
            getCheckingDeposit();
        }else {
            calculateCheckingBalanceAfterDeposit(amount);
            System.out.println();
            displayCurrentAmount(checkingBalance);
        }

    }



    // para cekmek(saving):musteri ile para cekmek icin etkilesime gecelim: saving balance
    public void getSavingWithdraw() {

        displayCurrentAmount(savingBalance);
        System.out.println("cekmek istediginiz miktari giriniz");
        double amount = input.nextDouble();

        if (amount<=0) {
            System.out.println("sifir veya eksi tutarlar gecersizdir!");
            getSavingWithdraw();
        } else if (amount<=savingBalance) {
            calculateSavingBalanceAfterWithdraw(amount);
            System.out.println();
            displayCurrentAmount(savingBalance);
        }else {
            System.out.println("Yetersiz bakiye");
        }
    }


    // para yatirma(saving) : musteri ile para yatirma icin etkilesime gecelim: saving Balance
    public void getSavingDeposit(){
        displayCurrentAmount(savingBalance);
        System.out.println("yatirmak istediginiz miktari giriniz");
        double amount = input.nextDouble();

        if (amount<=0){
            System.out.println("sifir veya eksi tutarlar gecersizdir!");
            getSavingDeposit();
        }else {
            calculateSavingBalanceAfterDeposit(amount);
            System.out.println();
            displayCurrentAmount(savingBalance);
        }

    }














    // son bakiyeyi goster
    public void displayCurrentAmount(double balance){

        System.out.println("hesabinizda bulunan bakiye: " + moneyFormat.format(balance));

    }






}
