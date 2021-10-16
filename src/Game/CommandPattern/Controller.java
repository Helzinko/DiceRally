/**
 * @(#) CarController.java
 */

package Game.CommandPattern;

import java.util.ArrayList;

public class Controller
{
	private ArrayList<ICommand> list = new ArrayList<ICommand>();

	public  ArrayList<ICommand> getList()
	{
		return list;
	}

	public void run(ICommand cmd)
	{
		list.add(cmd);
		cmd.execute();
	}

	public void undo()
	{
		int index = list.size();
		ICommand cmd = list.get(index-1);
		list.remove(index - 1);
		cmd.undo();
	}
}
