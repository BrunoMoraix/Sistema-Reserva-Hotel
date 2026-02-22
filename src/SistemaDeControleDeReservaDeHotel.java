import com.object.entity.Reserva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SistemaDeControleDeReservaDeHotel {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Reserva[] reservas = new Reserva[10];
        int indiceAtual = 0;
        int opcao = 0;

        while (opcao != 5) {
        System.out.println("----- Bem-vindo ao Sistema de Reserva de Hotel! -----");
        System.out.println("1 - Fazer Nova Reserva");
        System.out.println("2 - Listar Reservas");
        System.out.println("3 - Buscar Reserva pelo Nome do Hóspede");
        System.out.println("4 - Ordenar Reservas por Dias (Decrescente)");
        System.out.println("5 - Sair");
        System.out.println("Digite a opção que deseja: ");

        opcao = scanner.nextInt();
        scanner.nextLine();

            switch (opcao) {
                case 1:
                    if (indiceAtual < reservas.length) {

                        System.out.println("Digite o nome do hóspede: ");
                        String nomeHospede = scanner.nextLine();
                        System.out.println("Digite a quantidade de dias que ele se hospedará:");
                        int diasHospedados = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Digite o tipo do quarto: (1-Normal / 2-Premium / 3-Luxo");
                        int tipoQuarto = scanner.nextInt();
                        scanner.nextLine();
                        double valorDiaria;
                        switch (tipoQuarto){
                            case 1: valorDiaria = 150.0; break;
                            case 2: valorDiaria = 250.0; break;
                            case 3: valorDiaria = 400.0; break;
                            default:
                                valorDiaria= 150.0;
                                System.out.println("Tipo invalido. Taxa padrão aplicada!");
                                break;
                        }

                        Reserva novaReserva = new Reserva(nomeHospede, diasHospedados, valorDiaria , tipoQuarto);

                        System.out.println("O valor da reserva ficou: "+ novaReserva.calcularValorTotal());

                        String resposta;
                        do {
                            System.out.println("Deseja confirmar a reserva? (s/n)");
                            resposta = scanner.nextLine().toLowerCase();
                        } while (!resposta.equals("s") && !resposta.equals("n"));
                        if (resposta.equals("s")) {
                            reservas[indiceAtual] = novaReserva;
                            indiceAtual++;
                            System.out.println("Reserva feita!");

                        } else if (resposta.equals("n")) {
                            System.out.println("Reserva cancelada!");
                            break;
                        }

                    } else {
                        System.out.println("O hotel está lotado!");
                    }
                    break;

                case 2:
                    System.out.println("----- Lista de reservas -----");
                    if (indiceAtual == 0){
                        System.out.println("Ainda não há reservas registradas!");
                    }else{
                        for (int i = 0; i < indiceAtual; i++) {
                            System.out.println((i+1)+ "- " + reservas[i]);
                        }
                    }
                    System.out.println();
                    break;

                case 3:
                    boolean check = false;
                    System.out.println("Digite o nome do hóspede que deseja buscar a reserva:");
                    String nomeBusca = scanner.nextLine();
                    for (int i = 0; i < indiceAtual; i++) {
                        if (reservas[i].getNomeHospede().equalsIgnoreCase(nomeBusca)){
                            System.out.println(reservas[i]);
                            check = true;
                        }

                    }
                        if (!check){
                            System.out.println("Reserva no nome de: "+ nomeBusca +" não encontrada!");
                        }
                    break;

                case 4:
                    Arrays.sort(reservas,0,indiceAtual, (r1, r2) -> Integer.compare(r2.getDiasHospedagem(), r1.getDiasHospedagem()));
                    for (int i= 0 ; i < indiceAtual; i++ ) {
                        System.out.println(reservas[i]);
                    }
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Opção Invalida");
                    break;

            }
        }
    }
}
