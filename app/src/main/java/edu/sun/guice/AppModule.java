package edu.sun.guice;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;
import edu.sun.guice.service.LoginService;
import edu.sun.guice.service.LoginServiceImple;
import edu.sun.guice.service.Trasaction;

/**
 * User: sunqipeng
 * Date: 12-9-9
 */
public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(LoginService.class).to(LoginServiceImple.class);
        bind(String.class).toInstance("this is a test for string inject");
        bind(String.class).annotatedWith(Names.named("testString")).toInstance("this is the teststring");
        bind(String.class).annotatedWith(Names.named("testString2")).toInstance("this is the teststring2");
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(Trasaction.class), new TransactionInterceptor());


    }
}
