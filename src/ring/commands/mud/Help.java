package ring.commands.mud;

import ring.commands.Command;
import ring.commands.CommandParameters;
import ring.commands.CommandResult;
import ring.commands.CommandSender;

//TODO implement help
public class Help implements Command {

	public void execute(CommandSender sender, CommandParameters params) {
		throw new UnsupportedOperationException();
	}

	public String getCommandName() {
		return "help";
	}

	public void rollback() {
		throw new UnsupportedOperationException();
	}

}
