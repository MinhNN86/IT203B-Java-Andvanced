package Session08.Ex01.factory;

import Session08.Ex01.device.Device;
import Session08.Ex01.device.Light;

public class LightFactory extends DeviceFactory {

    @Override
    public Device createDevice() {
        System.out.println("LightFactory: Đã tạo đèn mới.");
        return new Light();
    }
}
