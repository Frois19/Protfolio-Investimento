package com.company;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws ParseException, IOException {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        interfaceUsuario.homePage();
    }
}
