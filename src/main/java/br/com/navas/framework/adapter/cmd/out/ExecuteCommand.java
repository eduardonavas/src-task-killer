package br.com.navas.framework.adapter.cmd.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExecuteCommand {

    public List<String> execute(String command){

        List<String> linhas = new ArrayList<>();

        try {
            Process p = Runtime.getRuntime().exec(command);

            BufferedReader bufer = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String linha;

            while((linha = bufer.readLine()) != null){
                linhas.add(linha);
            }

            bufer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return linhas;
    }
}
