package com.cubit.it.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cubit.it.dao.CubicDao;
import com.cubit.it.dao.CubicDaoImpl;
import com.cubit.it.entity.BlockTimeEntity;

@WebServlet("/blockTime")
public class BlockTimeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			CubicDao cubicDao =new CubicDaoImpl();
			//Adding List into request scope against key "blockTimeList"
			List<BlockTimeEntity> blockTimeList=cubicDao.findBlockTimes();
			req.setAttribute("blockTimeList",blockTimeList);
			req.getRequestDispatcher("blockTime.jsp").forward(req, resp);
	}
}
