package ring.commands.inventory;

import ring.commands.Command;
import ring.commands.CommandArguments;
import ring.commands.CommandResult;
import ring.commands.CommandSender;
import ring.items.Item;
import ring.mobiles.Mobile;

public class Equipment implements Command {

	public void execute(CommandSender sender, CommandArguments params) {
		CommandResult res = new CommandResult();
		res.setFailText("[R][WHITE]You are wearing:\nNothing.");

		String equipment = "[R][WHITE]You are wearing:\n";
		Mobile mob = (Mobile) sender;
		
		//FQCN because of ambiguous reference
		ring.mobiles.backbone.Equipment mobEquipment = mob.getDynamicModel().getEquipment();

		if ((mobEquipment == null) || (mobEquipment.size() == 0)) {
			res.send();
			return;
		}

		for (Item item : mobEquipment) {
			if (item != null) {
				equipment += "<worn on " + item.getPartWornOn().getName()
						+ "> " + item.getName() + "\n";
			}
		}

		res.setText(equipment);
		res.setSuccessful(true);
		res.send();
	}

	public String getCommandName() {
		return "equipment";
	}

	public void rollback() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setCommandName(String name) {
		// TODO Auto-generated method stub
		
	}

}