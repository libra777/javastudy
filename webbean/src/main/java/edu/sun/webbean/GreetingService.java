/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
*/
package edu.sun.webbean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
import java.util.List;

@Named
@ApplicationScoped
public class GreetingService {

    private String name;

    @Inject
    private LoginUser loginUser;

    @Inject
    private List<String> values;

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public LoginUser getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(LoginUser loginUser) {
        this.loginUser = loginUser;
    }

    public String getName() {
        if (loginUser == null)
            name = "the login user object is null";
        else {
            name = loginUser.getName() + " the preview is the login's name value " + new Date();
        }

        if (values == null)
            name += " the value list is null";
        else
            name += " the value list size " + values.size();
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String createGreeting(String name) {
        return "Hello " + name + ". We hope you enjoy Apache MyFaces!";
    }

    public void test() {
        this.name = "the name is changed " + new Date();
    }

}
