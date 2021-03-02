package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.impl.UserServiceImpl;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2021/03/01
 */

@Path("/register")
public class RegisterController implements PageController {

    private UserService userService = new UserServiceImpl();

    @Override
    @POST
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.printf("name: %s, password: %s\n", name, password);
        if (name == null || password == null) {
            return "register.jsp";
        }

        if (userService.register(new User(name, password, "1", "1"))) {
            return "login.jsp";
        }
        return "failed.jsp";
    }
}
