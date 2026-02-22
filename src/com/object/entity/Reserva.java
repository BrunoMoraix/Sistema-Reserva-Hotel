package com.object.entity;

public class Reserva {
    private String nomeHospede;
    private int diasHospedagem;
    private int tipoQuarto;
    private double valorDiaria;

    public Reserva(String nomeHospede,int diasHospedagem, double valorDiaria, int tipoQuarto){
        this.nomeHospede = nomeHospede;
        this.diasHospedagem = diasHospedagem;
        this.valorDiaria = valorDiaria;
        this.tipoQuarto = tipoQuarto;
    }
    public String getNomeHospede(){
        return nomeHospede;
    }
    public void setNomeHospede(String nomeHospede){
        this.nomeHospede = nomeHospede;
    }
    public int getDiasHospedagem(){
        return diasHospedagem;
    }
    public void setDiasHospedagem(int diasHospedagem){
        this.diasHospedagem = diasHospedagem;
    }
    public double calcularValorTotal(){
        return diasHospedagem * valorDiaria;
    }

    @Override
    public String toString(){
        return "Reserva {" + "Nome do Hóspede: "+ nomeHospede + " | "
                + "Dias Hospedados: " + diasHospedagem + " | "
                + "Valor Total: " + calcularValorTotal() + "}";
    }



}
