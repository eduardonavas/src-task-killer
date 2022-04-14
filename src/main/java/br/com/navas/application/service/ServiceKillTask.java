package br.com.navas.application.service;

import br.com.navas.framework.adapter.cmd.out.ExecuteCommand;
import br.com.navas.framework.helper.Constants;

public class ServiceKillTask {

    public void kill(String processName){
        ConsultProcess consultProcess = new ConsultProcess();
        ExecuteCommand executeCommand = new ExecuteCommand();
        boolean run = true;
        while(run){
            try {
                var retorno = executeCommand.execute(String.format(Constants.COMMAND_TASK_LIST, processName));

                var processCode = consultProcess.run(retorno);
                System.out.println("Process Code: " + processCode);
                executeCommand.execute(String.format(Constants.COMMAND_TASK_KILL, processCode));
            }catch (RuntimeException e){
                run = false;
            }

        }
        System.out.println("Finalizado");

    }
}
