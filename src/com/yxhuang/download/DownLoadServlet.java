package com.yxhuang.download;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import sample.SampleScenario;

public class DownLoadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.print("--------doGet-------");
		InputStream in = null;
		OutputStream out = null;

		try {
			File file = new File("D:\\android.txt");
			in = new BufferedInputStream(new FileInputStream(file));
			
			// 设置响应头信息，设置文件类型
			response.setContentType("application/octet-stream");
			// 设置响应头信息，设置文件长度
			response.setContentLength((int) file.length());
			// 网页中出现下载，android不用
			response.setHeader("Content-Disposition",  "attachment;filename=" + file.getName());
			
			out = new BufferedOutputStream(response.getOutputStream());
			byte[] bytes = new byte[1024 * 10];
			int read = 0;
			while ((read = in.read(bytes)) != -1) {
				out.write(bytes,  0,  read);
			}
			System.out.print("out" + out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.print("--------doPost-------");
		this.doGet(request, response);

	}

	public void init() throws ServletException {
		// Put your code here
	}

}
