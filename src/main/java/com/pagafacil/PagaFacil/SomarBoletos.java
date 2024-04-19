package com.pagafacil.PagaFacil;

import java.util.Scanner;

// metodos de somar o boleto
public class SomarBoletos{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Aqui vai ser perguntado para o cliente o os valores para ser somado
        System.out.print("Quantos boletos você quer somar? ");
        int quantidadeBolheto = scanner.nextInt();

        int[] valores = new int[quantidadeBolheto];

        for (int i = 0; i < quantidadeBolheto; i++) {
            System.out.print("Digite o valor" + (i + 1) + ": ");
            valores[i] = scanner.nextInt();
        }

        int total = somarValores(valores);
        System.out.println("O total da soma do valoror dos boletos é: " + total + "R$");

        scanner.close();
    }

    public static int somarValores(int[] valores) {
        int soma = 0;
        for (int valor : valores) {
            soma += valor;
        }
        return soma;
    }
}
