package com.lm.Futrue;

/**
 * describe:
 *
 * @author lm
 * @date 2018/7/19
 */
public class ProductFactory {

    public Futrue createProduct(){
        Futrue futrue = new Futrue();
        System.out.println("Product.Product 开始生产" );
        new Thread(new Runnable() {
            @Override
            public void run() {
                futrue.set(new Product("1","蛋糕"));
            }
        }).start();

        return futrue;
    }
}
