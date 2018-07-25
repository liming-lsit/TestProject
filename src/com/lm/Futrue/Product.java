package com.lm.Futrue;

/**
 * describe:
 *
 * @author lm
 * @date 2018/7/19
 */
public class Product {

    private String id;
    private String name;

    public Product(String id, String name) {
        System.out.println("Product.Product 开始生产" );
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        this.id = id;
        this.name = name;
        System.out.println("Product.Product 生产完毕" );
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


    public static void main(String[] args) {
        Product product = new Product("1","蛋糕");
        System.out.println("我去上班了，下了班我来取蛋糕。。。。");
        System.out.println("我拿着蛋糕回家."+product);
    }
}
