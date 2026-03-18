package Session08.Ex01.factory;

import Session08.Ex01.device.AirConditioner;
import Session08.Ex01.device.Device;

public class AirConditionerFactory extends DeviceFactory {

    @Override
    public Device createDevice() {
        System.out.println("AirConditionerFactory: Đã tạo điều hòa mới.");
        return new AirConditioner();
    }
}
