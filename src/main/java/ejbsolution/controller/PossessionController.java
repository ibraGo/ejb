package ejbsolution.controller;

import ejbsolution.dao.PossessionDaoBean;
import ejbsolution.enums.Possession_Type;
import ejbsolution.model.Possession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class PossessionController extends HttpServlet {

    @EJB(mappedName="java:module/PossessionDaoBean")
    private PossessionDaoBean possessionDaoBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // init data for test purpose
        possessionDaoBean.persist(new Possession("Said", Possession_Type.Flat, 3, 10.0, 10, "description"));
        possessionDaoBean.persist(new Possession("FL", Possession_Type.Flat, 3, 10.0, 10, "description"));

        req.setAttribute("posts", possessionDaoBean.findAll());

        RequestDispatcher dispatcher = req.getRequestDispatcher(
                "/WEB-INF/jsp/posts.jsp");
        dispatcher.forward(req, resp);
    }
}
