package com.yxhuang.uploadimage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class UploadImage extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7412989119906693629L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("------------------->UploadImage   doPost-------------");
		
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("Name");
		String gender = request.getParameter("Gender");
		System.out.println("-------Name: " + name + "     Gender:  " + gender);

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html:charset=UTF-8");
		PrintWriter out = null;
		/**
		 * 将jsp中得到的文件内容上传到服务器
		 */
		// 判断其实是否为上传一个复杂性文件的请求
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			/**
			 * 接受上去的准备工作
			 * 设置一个缓存区
			 * 位置|大少
			 */
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024 * 1024 * 2);
			File  temp = new File("c:\\temp");
			if (!temp.exists()) {
				temp.mkdir();
			}
			factory.setRepository(temp);
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("UTF-8");
			upload.setFileSizeMax(1024 * 1024 * 5);  // Returns the maximum allowed size of a single uploaded file, as opposed to getSizeMax().
			upload.setSizeMax(1024 * 1024 * 6);  //Sets the maximum allowed size of a complete request, as opposed to setFileSizeMax(long).
		
			try {
				out = response.getWriter();  //输出
				
				List<FileItem> items = upload.parseRequest(request);
				if (items != null) {
					for (FileItem item : items ) {
						if (item.isFormField()) {    // 一般数据
							System.out.println("---->简单数据的文件名： "  + item.getName());
						
						} else {   // 复杂数据
							// 将数据写到服务器上
							System.out.println("---->复杂数据的文件名： "  + item.getName());
							item.write(new File("e:\\" + item.getName()));
//							request.getInputStream();
						}
					}
				}
				
				out.print("Upload image success");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print("Upload image failed");
			}
		
		}
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("------------------->UploadImage   doGet-------------");
		this.doPost(request, response);
	}
}
