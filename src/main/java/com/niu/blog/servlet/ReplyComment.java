package com.niu.blog.servlet;

import com.niu.blog.entity.Reply;
import com.niu.blog.service.ReplyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/replyComment")
public class ReplyComment extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String commentId = request.getParameter("commentId");
        String replyUserName = (String) request.getSession().getAttribute("UserName");
        request.setAttribute("commentId", commentId);
        request.setAttribute("replyUserName", replyUserName);
        request.getRequestDispatcher("/replyComment.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String replyUserName = request.getParameter("replyUserName");
        String commentId = request.getParameter("commentId");
        String replyContent = request.getParameter("replyContent");

        Reply reply = new Reply();
        reply.setReplyUserName(replyUserName);
        reply.setCommentId(Integer.parseInt(commentId));
        reply.setReplyContent(replyContent);

        ReplyService replyService = new ReplyService();
        replyService.addReply(reply);

        response.sendRedirect("manageReply?commentId=" + commentId);

    }
}
