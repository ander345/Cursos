package org.acme.quickstart.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RealExpensiveService  implements RealExpensive {

    @Override
    public int calculate(){
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return 100;
    }

}
