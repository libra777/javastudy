package edu.sun.app.action;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * User: sunqipeng
 * Date: 12-9-6
 */
@Component(value = "example")
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

    public void hello() {
        if (StringUtils.hasText(name)) {
            this.names.add(name);
        }

    }
}
