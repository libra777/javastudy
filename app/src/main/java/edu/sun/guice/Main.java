package edu.sun.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.sun.guice.action.LoginController;
import edu.sun.guice.service.LoginService;

/**
 * User: sunqipeng
 * Date: 12-9-8
 */
public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AppModule());
        LoginController loginController = new LoginController();
        injector.injectMembers(loginController);

        System.out.println(loginController.getLoginService());
        System.out.println(loginController.getTestString());
        System.out.println(loginController.getTestString2());
        loginController.getLoginService().addUser("", "");

        for (int i = 0; i < 10000; i++) {
            LoginService loginService = injector.getInstance(LoginService.class);
            System.out.println(loginService);
        }
    }
}
