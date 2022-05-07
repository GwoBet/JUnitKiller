package my.killer.junit;

import my.killer.junit.utils.ArgumentParser;

public class Main {


    public static void main(String[] args){
        try {
            ArgumentParser argumentParser = new ArgumentParser(args);
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                System.out.println("============ STOP ================");
            }));
            System.out.println("============ START JUnitKiller ================");


        }catch (Exception e){
            System.err.println("Program failed: " + e.getMessage());
            e.printStackTrace();
        }

    }


}
