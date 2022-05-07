package my.killer.junit.utils;

import my.killer.junit.exceptions.ArgumentParserException;

import java.util.HashSet;
import java.util.Set;

public class ArgumentParser {

    private int threadsCount;

    private Set<String> classNames = new HashSet<>();
    private static final String CLASS_NAME_START = "class-name";
    private static final String ARGUMENTS_TEMPLATE =
            "Ex.: java -cp <your-junit-jar>;<tested-classes> <your-main-class> N class-name [class-name]* \n" +
            "   Where:\n" +
            "       -- N - количество потоков, в которых должны запускаться тесты;\n" +
            "       -- [class-name]* - полные имена классов, в которых находятся тесты (произвольное количество)";

    public ArgumentParser(String[] args) throws ArgumentParserException {
        try {
            if (args.length <= 2)
                throw new ArgumentParserException("No arguments given!");

            threadsCount = Integer.parseInt(args[0]);
            if (threadsCount <= 0)
                throw new ArgumentParserException("Zero or negative number of threads [" + threadsCount + "]");

            if (!args[1].equals(CLASS_NAME_START))
                throw new ArgumentParserException("No 'class-name' argument field found!");

            for (int i = 2; i < args.length; i++){
                classNames.add(args[i]);
            }
        }catch (Exception e){
            System.err.println("Failed to parse arguments \n Reason: " + e.getMessage() + "\n" + ARGUMENTS_TEMPLATE);
            throw new ArgumentParserException("Failed to parse arguments \n Reason: " + e.getMessage());
        }

    }

    public int getThreadsCount(){
        return threadsCount;
    }

    public Set<String> getClassNames(){
        return classNames;
    }
}
