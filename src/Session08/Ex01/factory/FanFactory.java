package Session08.Ex01.factory;

import Session08.Ex01.device.Device;
import Session08.Ex01.device.Fan;

public class FanFactory extends DeviceFactory {

    @Override
    public Device createDevice() {
        System.out.println("FanFactory: Đã tạo quạt mới.");
        return new Fan();
    }
}