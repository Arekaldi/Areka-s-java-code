package Command;

public class CommandCheck {
    final static String[] orders =
            {"quit", "register", "login", "logout",
                    "printInfo", "createCourse", "listCourse", "selectCourse",
                    "cancelCourse", "switch", "inputCourseBatch", "outputCourseBatch",
                    "listStudent", "removeStudent", "listCourseSchedule"};
    final static int[] numOfArgsForOrder =
            {0, 5, 2, 1, 1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    private static String userOrder;
    private static String[] userArgs;
    CommandCheck() {}
    public static void setUserOrder(String userOrder) {
        CommandCheck.userOrder = userOrder;
    }
    public static void setUserArgs(String[] userArgs) {
        CommandCheck.userArgs = userArgs;
    }

    private static int commandIsDefined() {
        for(int i = 0;i < orders.length; ++i) {
            if(orders[i].equals(userOrder)) {
                return i;
            }
        }
        return -1;
    }
    private static boolean commandNumOfArgsIsCorrect(int index) {
        int numOfArgs = userArgs.length;
        if(userOrder.equals("logout") || userOrder.equals("printInfo") || userOrder.equals("listCourse") || userOrder.equals("listCourseSchedule"))
            return numOfArgs == 0 || numOfArgs == 1;
        if(userOrder.equals("removeStudent"))
            return numOfArgs == 1 || numOfArgs == 2;
        return numOfArgs == numOfArgsForOrder[index];
    }
    public static boolean commandCheck() {
        CommandCheck.setUserOrder(CommandSentence.commandOrder);
        CommandCheck.setUserArgs(CommandSentence.commandArgs);
        int index = commandIsDefined();
        if(index == -1) {
            System.out.println("Command '" + userOrder + "' not found");
            return false;
        }
        if(!commandNumOfArgsIsCorrect(index)) {
            System.out.println("Illegal argument count");
            return false;
        }
        return true;
    }
}
