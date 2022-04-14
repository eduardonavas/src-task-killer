package br.com.navas.application.service;

import br.com.navas.framework.adapter.cmd.out.ExecuteCommand;

import java.util.List;

public class ConsultProcess {

    public String run(List<String> linhas){

        String resultado = linhas.stream().filter(l -> l.contains("java.exe")).findFirst().orElseThrow(() -> new RuntimeException("Nenhum processo java encontrado"));
        int idxOfConsole = resultado.indexOf("Console");
        resultado = resultado.substring(idxOfConsole - 10, idxOfConsole);

        return resultado.replaceAll(" ", "");
    }
}
