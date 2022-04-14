package br.com.navas;

import br.com.navas.application.service.ServiceKillTask;
import br.com.navas.framework.helper.Constants;

import java.io.IOException;

public class TaskKillerApplication {

    public static void main(String[] args)  {
        if(args.length == 0){
            throw new RuntimeException(Constants.LOG_PARAMERTO_OBRIGATORIO);
        }

        var processName = args[0];

        System.out.println("ProcessName = " + processName);
        new ServiceKillTask().kill(processName);
    }
}
