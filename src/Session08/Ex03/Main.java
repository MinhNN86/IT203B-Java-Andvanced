package Session08.Ex03;


import Session08.Ex03.command.*;
import Session08.Ex03.device.*;
import Session08.Ex03.remote.*;

public class Main {
    public static void main(String[] args) {

        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        RemoteControl remote = new RemoteControl();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command fanOn = new FanOnCommand(fan);
        Command acTemp = new ACSetTemperatureCommand(ac, 26);

        remote.setCommand(0, lightOn);
        remote.setCommand(1, lightOff);
        remote.setCommand(2, fanOn);
        remote.setCommand(3, acTemp);

        System.out.println("\n--- Nhấn nút 0 ---");
        remote.pressButton(0);

        System.out.println("\n--- Nhấn nút 1 ---");
        remote.pressButton(1);

        System.out.println("\n--- Undo ---");
        remote.pressUndo();

        System.out.println("\n--- Nhấn nút 3 ---");
        remote.pressButton(3);

        System.out.println("\n--- Undo ---");
        remote.pressUndo();
    }
}
