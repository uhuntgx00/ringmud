package ring.commands.mud;

import ring.commands.Command;
import ring.commands.CommandParameters;
import ring.commands.CommandResult;
import ring.commands.CommandSender;

//TODO Implement news
public class News implements Command {

	public void execute(CommandSender sender, CommandParameters params) {
		throw new UnsupportedOperationException();
	}

	public String getCommandName() {
		return "news";
	}

	public void rollback() {
		throw new UnsupportedOperationException();
	}

}
