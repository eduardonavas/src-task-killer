package br.com.navas.application.service;

import br.com.navas.framework.adapter.cmd.out.ExecuteCommand;

public class ServiceKillTask {

    public void kill(){
        ConsultProcess consultProcess = new ConsultProcess();
        ExecuteCommand executeCommand = new ExecuteCommand();
        boolean run = true;
        while(run){
            try {
                var retorno = executeCommand.execute("tasklist /FI \"windowtitle eq robobateponto\"");

                var processCode = consultProcess.run(retorno);
                System.out.println("Process Code: " + processCode);
                executeCommand.execute("taskkill /F /PID " + processCode);
            }catch (RuntimeException e){
                run = false;
            }

        }
        System.out.println("Finalizado");

    }
}
