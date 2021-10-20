/**
 * @(#) CarController.java
 */

package Game.CommandPattern;

import Game.Message;

import java.util.ArrayList;

public class Controller
{
	private ArrayList<ICommand> list = new ArrayList<ICommand>();

	public  ArrayList<ICommand> getList()
	{
		return list;
	}

	public int run(ICommand cmd)
	{
		list.add(cmd);
		int result = cmd.execute();
		return result;
	}

	public void undo()
	{
		int index = list.size();
		ICommand cmd = list.get(index-1);
		list.remove(index - 1);
		cmd.undo();
	}
}
