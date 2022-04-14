package br.com.navas;

import br.com.navas.application.service.ServiceKillTask;

import java.io.IOException;

public class TaskKillerApplication {

    public static void main(String[] args) throws IOException {
        new ServiceKillTask().kill();
    }
}
