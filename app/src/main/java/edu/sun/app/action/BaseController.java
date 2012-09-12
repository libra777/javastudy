package edu.sun.app.action;

import javax.faces.context.FacesContext;
import java.util.Map;

/**
 * User: sunqipeng
 * Date: 12-9-12
 */
public class BaseController {
    public Object getParamter(String name) {
        Map<String, Object> map = FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
        for (String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }
        return FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(name);
    }
}
