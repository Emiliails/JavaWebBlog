package com.niu.blog.servlet;

import com.niu.blog.entity.Reply;
import com.niu.blog.service.ReplyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/manageReply")
public class ManageReply extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String commentId = request.getParameter("commentId");
        ReplyService replyService = new ReplyService();
        List<Reply> replyList = replyService.findByCommentId(commentId);
        request.setAttribute("replyList", replyList);
        request.getRequestDispatcher("/manageReply.jsp").forward(request, response);
    }

}
