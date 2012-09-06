package edu.sun.app.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: sunqipeng
 * Date: 12-9-6
 */
@Component(value = "example")
@Scope("session")
public class Example {

    private List<String> names = new ArrayList<String>();
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public String address;

    public void hello() {
        if (StringUtils.hasText(name)) {
            this.names.add(name);
        }

        address = new Date().toString();

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
