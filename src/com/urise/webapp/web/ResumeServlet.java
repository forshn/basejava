package com.urise.webapp.web;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.Storage;
import com.urise.webapp.utils.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class ResumeServlet extends HttpServlet {
    private final Storage storage = Config.get().getStorage();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Writer writer = response.getWriter();
        writer.write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "    <link rel=\"stylesheet\" href=\"css/style.css\">\n" +
                "    <title>Resumes</title>\n" +
                "</head>" +
                "<body>\n" +
                "<table>\n" +
                "  <caption>\n" +
                "Resumes\n" +
                "  </caption>" +
                "<tr>\n" +
                "    <th>Name</th>\n" +
                "    <th>UUID</th>\n" +
                "  </tr>\n");
        for (Resume resume : storage.getAllSorted()) {
            writer.write(
                    "<tr>\n" +
                            "<td>" + resume.getFullName() + "</td>\n" +
                            "<td>" + resume.getUuid() + "</td>\n" +
                            "</tr>\n");
        }
        writer.write("</table>\n" +
                "</body>\n" +
                "</html>");
    }
}
