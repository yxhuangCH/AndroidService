package com.yxhuang.car.information.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class CarInfoHeadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private List<CarInfoHeadViewEntity> list;

	public CarInfoHeadServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		// 准备用户数据
		preparaData();
		
		// JSON数组
		JSONArray array = new JSONArray();
		
		JSONObject object = new JSONObject();
		object.put("result", "1");
		for (CarInfoHeadViewEntity bean : list) {
			// 单个用户的JSON对象
			JSONObject obj = new JSONObject();
			try {
				obj.put("news_title", bean.getNewTitle());
				obj.put("news_image_url", bean.getNewImageUrl());
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			array.add(obj);
		}
		
		object.put("mag", array);
		// 输出
		out.write(object.toString());
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

	// 准备用户数据
		private void preparaData(){
			list = new ArrayList<CarInfoHeadViewEntity>();
			
		    CarInfoHeadViewEntity bean1 = new CarInfoHeadViewEntity();
		    bean1.setNewImageUrl("http://pic4.nipic.com/20091012/3547306_143732095735_2.jpg");
		    bean1.setNewTitle("最新的奔驰跑车降价了");
			list.add(bean1);
			
			CarInfoHeadViewEntity bean2 = new CarInfoHeadViewEntity();
		    bean2.setNewImageUrl("http://pic7.nipic.com/20100609/3143623_160727326957_2.jpg");
		    bean2.setNewTitle("最新的宝马");
			list.add(bean2);
			
			CarInfoHeadViewEntity bean3 = new CarInfoHeadViewEntity();
		    bean3.setNewImageUrl("http://img3.douban.com/view/note/large/public/p29098040.jpg");
		    bean3.setNewTitle("最新的东风日产");
			list.add(bean3);
			
			CarInfoHeadViewEntity bean4 = new CarInfoHeadViewEntity();
		    bean4.setNewImageUrl("http://pic21.nipic.com/20120512/9725044_114533627117_2.jpg");
		    bean4.setNewTitle("最新的广汽本田");
			list.add(bean4);
			
			CarInfoHeadViewEntity bean5 = new CarInfoHeadViewEntity();
		    bean5.setNewImageUrl("http://img4.imgtn.bdimg.com/it/u=1458292040,1470453806&fm=21&gp=0.jpg");
		    bean5.setNewTitle("最新的劳斯莱斯");
			list.add(bean5);
		
		}
}
