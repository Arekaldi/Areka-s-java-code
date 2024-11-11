package Command;

public class CommandSentence {
    static String inputCommandSentence;
    static String commandOrder;
    static String[] commandArgs;

    CommandSentence() {}

    public static void setInputCommandSentence(String input) {
        inputCommandSentence = input;
        getCommandOrderAndArgs();
    }

    private static void getCommandOrderAndArgs() {
        String[] words = inputCommandSentence.split("[ \\t]");
        commandOrder = words[0];
        String[] args = new String[words.length - 1];
        int argLength = 0;
        for(int i = 1; i < words.length; ++i) {
            if(words[i].equals(" ") || words[i].isEmpty())
                continue;
            else if(words[i].charAt(0) == ' ')
                for(int j = 1; j < words[i].length(); ++j)
                    args[argLength] += words[i].charAt(j);
            else
                args[argLength] = words[i];
            argLength++;
        }
        commandArgs = new String[argLength];
        System.arraycopy(args, 0, commandArgs, 0, argLength);
    }

    public static String getCommandOrder() {
        return commandOrder;
    }
    public static String[] getCommandArgs() {
        return commandArgs;
    }

    public static boolean commandCheck() {
        return CommandCheck.commandCheck();
    }
}
