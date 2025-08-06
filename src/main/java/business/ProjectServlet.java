package business;

import dao.ProjectDao;
import dao.ProjectDaoimp;
import entity.Project;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "projects", value = "/projects")
public class ProjectServlet extends HttpServlet {
    private final ProjectDao projectDao;

    public ProjectServlet() {
        projectDao = new ProjectDaoimp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("findAll")) {
            findAllProject(request, response);
        } else if (action.equals("initUpdate")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Project project = projectDao.findById(id);
            request.setAttribute("project", project);
            request.getRequestDispatcher("/view/projectUpdate.jsp").forward(request, response);
        } else if (action.equals("Delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Boolean result = projectDao.delete(id);
            if (result) {
                findAllProject(request, response);
            } else {
                request.getRequestDispatcher("/view/error.jsp").forward(request, response);
            }
        }


    }


    public void findAllProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Project> projects = projectDao.findAll();
        request.setAttribute("projects", projects);
        request.getRequestDispatcher("/view/projects.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("add")) {
            Project project = new Project();
            project.setName(request.getParameter("name"));
            project.setDescription(request.getParameter("description"));
            project.setImageUrl(request.getParameter("imageUrl"));
            Boolean result = projectDao.save(project);
            if (result) {
                findAllProject(request, response);
            } else {
                request.getRequestDispatcher("/view/error.jsp").forward(request, response);
            }

        } else if (action.equals("Update")) {
            Project project = new Project();
            project.setId(Integer.parseInt(request.getParameter("id")));
            project.setName(request.getParameter("name"));
            project.setDescription(request.getParameter("description"));
            project.setImageUrl(request.getParameter("imageUrl"));
            Boolean result = projectDao.update(project);
            if (result) {
                findAllProject(request, response);
            } else {
                request.getRequestDispatcher("/view/error.jsp").forward(request, response);
            }
        }
    }
}
