package com.lm.Futrue;

/**
 * Project Name:TestProject
 * Package Name:com.lm.Futrue
 * Date:2018/7/2522:37
 * Copyright (c) 2018, lm All Rights Reserved.
 */
public class Futrue {

    Product product;
    boolean flag =false;

    public synchronized Product  get(){
        if(!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return product;
    }


    public  synchronized void  set(Product product){
        this.product = product;
        flag = true;
        notifyAll();
    }
}
