package com.yxhuang.Servelt4Android.bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPBinding;

import net.sf.json.JSONArray;


public class ListView4Android extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("*****do Get(...)*****");
		

		// 生成数据
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("张三", "男", "20", "200801"));
		students.add(new Student("李四", "男", "21", "200802"));
		students.add(new Student("小红", "女", "20", "200803"));
		
		// 变成json数据格式
		JSONArray jsonArray = JSONArray.fromObject(students);
		System.out.println(jsonArray);
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = response.getWriter();
		printWriter.print(jsonArray);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
		System.out.println("**************do Post*********");

	}


}
