package Session08.Ex03.remote;

import Session08.Ex03.command.*;


public class RemoteControl {

    private Command[] slots = new Command[5];
    private Command lastCommand;

    public void setCommand(int slot, Command command) {
        slots[slot] = command;
        System.out.println("Đã gán command cho nút " + slot);
    }

    public void pressButton(int slot) {
        if (slots[slot] != null) {
            slots[slot].execute();
            lastCommand = slots[slot];
        } else {
            System.out.println("Nút chưa được gán command.");
        }
    }

    public void pressUndo() {
        if (lastCommand != null) {
            lastCommand.undo();
        } else {
            System.out.println("Không có lệnh để undo.");
        }
    }
}
