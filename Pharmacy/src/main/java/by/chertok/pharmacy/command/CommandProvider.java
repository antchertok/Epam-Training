package main.java.by.chertok.pharmacy.command;


import main.java.by.chertok.pharmacy.command.impl.EmptyCommand;

/**
 * Class responsible for extradition appropriate implementation of interface
 * {@link ICommand ICommand}
 */
public class CommandProvider {

    private CommandProvider() {
    }
    public static ICommand getCommandByName(String commandName) {
        if (commandName == null || commandName.isEmpty()) {
            return new EmptyCommand();
        }

        String commandType = convertCommand(commandName);

        try {
            return CommandHolder.valueOf(commandType).getCommand();
        } catch (IllegalArgumentException e) {
            return new EmptyCommand();
        }
    }

    /**
     * Auxiliary method for preparing command from request before getting
     * corresponding implementation
     * @param commandName string that contains required command
     * @return command name in appropriate format
     */
    public static String convertCommand(String commandName) {//TODO CHECK IF NULL
        return commandName
                .replace('-', '_')
                .toUpperCase();
    }
}
