package com.yxhuang.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ͼƬ����
		System.out.println("**********WebServlet.doGet(...)*****");
		     
		// ������
		InputStream in = null;
//		String id = request.getParameter("id");
		String id = request.getParameter("id");
		
		//输出流
		OutputStream out = null;
		
		try {
			// �ļ�������
			System.out.println("**********id: " + id );
			in = new FileInputStream("D://" + id+ ".jpg");
			
			// ������Ӧͷ��������Ӧ���ݵĳ���
			response.setContentLength((int)in.available());
			
			// �ļ������
			out = response.getOutputStream();
/*			byte[] b = new byte[in.available()];
			
			in.read(b);
			out.write(b);*/
			
	/*		byte[] b = new byte[1024];
			while (in.read(b) != -1) {
				out.write(b);
			}*/
			
			// ��ȡ���
			byte[] b = new byte[1024];
			int read = 0;
			while (  (read = in.read(b)) != -1){
				out.write(b, 0, read);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}  finally{
			if (in != null) {
				in.close();
			}if (out != null) {
				out.close();
			}
			
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("--------doPost-----------");
		this.doGet(request, response);

	}
	public void init() throws ServletException {
		// Put your code here
	}

}
