package baseball.model;

import baseball.service.SystemService;
import baseball.service.SystemServiceImpl;
import baseball.service.ManageService;
import baseball.service.ManageServiceImpl;

public class Config {
    public ManageService manageService() {
        return new ManageServiceImpl(systemService());
    }

    public SystemService systemService() {
        return new SystemServiceImpl();
    }
}
