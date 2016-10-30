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

public class CorInformation extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private List<CarInformaitonEntity> list;

	public CorInformation() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
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
		for (CarInformaitonEntity bean : list) {
			// 单个用户的JSON对象
			JSONObject obj = new JSONObject();
			try {
				obj.put("title", bean.getCarTitle());
				obj.put("url", bean.getCarImagerUrl());
				obj.put("time", bean.getCarTime());
				obj.put("comment", bean.getCarComment());
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			array.add(obj);
		}
		
		object.put("car", array);
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
		list = new ArrayList<CarInformaitonEntity>();
		
		CarInformaitonEntity bean1 = new CarInformaitonEntity();
		bean1.setCarTitle("奔驰1");
		bean1.setCarImagerUrl("http://img.my.csdn.net/uploads/201508/05/1438760758_3497.jpg");
		bean1.setCarTime("2015-10-01");
		bean1.setCarComment(10);
		list.add(bean1);
		
		CarInformaitonEntity bean2 = new CarInformaitonEntity();
		bean2.setCarTitle("奔驰2");
		bean2.setCarImagerUrl("http://img.my.csdn.net/uploads/201508/05/1438760758_6667.jpg");
		bean2.setCarTime("2015-10-02");
		bean2.setCarComment(11);
		list.add(bean2);
		
		CarInformaitonEntity bean3 = new CarInformaitonEntity();
		bean3.setCarTitle("奔驰3");
		bean3.setCarImagerUrl("http://img.my.csdn.net/uploads/201508/05/1438760757_3588.jpg");
		bean3.setCarTime("2015-10-03");
		bean3.setCarComment(13);
		list.add(bean3);
		
		CarInformaitonEntity bean4 = new CarInformaitonEntity();
		bean4.setCarTitle("奔驰4");
		bean4.setCarImagerUrl("http://img.my.csdn.net/uploads/201508/05/1438760756_3304.jpg");
		bean4.setCarTime("2015-10-04");
		bean4.setCarComment(14);
		list.add(bean4);
		
		CarInformaitonEntity bean5 = new CarInformaitonEntity();
		bean5.setCarTitle("奔驰5");
		bean5.setCarImagerUrl("http://img.my.csdn.net/uploads/201508/05/1438760755_6715.jpeg");
		bean5.setCarTime("2015-10-05");
		bean5.setCarComment(15);
		list.add(bean5);
		
		CarInformaitonEntity bean6 = new CarInformaitonEntity();
		bean6.setCarTitle("奔驰6");
		bean6.setCarImagerUrl("http://img.my.csdn.net/uploads/201508/05/1438760726_5120.jpg");
		bean6.setCarTime("2015-10-06");
		bean6.setCarComment(16);
		list.add(bean6);
		
		CarInformaitonEntity bean7 = new CarInformaitonEntity();
		bean7.setCarTitle("奔驰7");
		bean7.setCarImagerUrl("http://img.my.csdn.net/uploads/201508/05/1438760726_8364.jpg");
		bean7.setCarTime("2015-10-07");
		bean7.setCarComment(17);
		list.add(bean7);
		
		CarInformaitonEntity bean8 = new CarInformaitonEntity();
		bean8.setCarTitle("奔驰8");
		bean8.setCarImagerUrl("http://img.my.csdn.net/uploads/201508/05/1438760725_4031.jpg");
		bean8.setCarTime("2015-10-08");
		bean8.setCarComment(18);
		list.add(bean8);
		
		CarInformaitonEntity bean9 = new CarInformaitonEntity();
		bean9.setCarTitle("奔驰9");
		bean9.setCarImagerUrl("http://img.my.csdn.net/uploads/201508/05/1438760758_3497.jpg");
		bean9.setCarTime("2015-10-09");
		bean9.setCarComment(19);
		list.add(bean9);
		
		CarInformaitonEntity bean10 = new CarInformaitonEntity();
		bean10.setCarTitle("奔驰10");
		bean10.setCarImagerUrl("http://img.my.csdn.net/uploads/201508/05/1438760724_9463.jpg");
		bean10.setCarTime("2015-10-20");
		bean10.setCarComment(20);
		list.add(bean10);
		
		CarInformaitonEntity bean21 = new CarInformaitonEntity();
		bean21.setCarTitle("奔驰21");
		bean21.setCarImagerUrl("http://img.my.csdn.net/uploads/201508/05/1438760724_2371.jpg");
		bean21.setCarTime("2015-10-21");
		bean21.setCarComment(21);
		list.add(bean21);
		
		CarInformaitonEntity bean22 = new CarInformaitonEntity();
		bean22.setCarTitle("奔驰22");
		bean22.setCarImagerUrl("http://img.my.csdn.net/uploads/201508/05/1438760706_6864.jpg");
		bean22.setCarTime("2015-10-22");
		bean22.setCarComment(22);
		list.add(bean22);
		
		CarInformaitonEntity bean23 = new CarInformaitonEntity();
		bean23.setCarTitle("奔驰23");
		bean23.setCarImagerUrl("http://img.my.csdn.net/uploads/201508/05/1438760707_4653.jpg");
		bean23.setCarTime("2015-10-23");
		bean23.setCarComment(23);
		list.add(bean23);
		
		CarInformaitonEntity bean24 = new CarInformaitonEntity();
		bean24.setCarTitle("奔驰24");
		bean24.setCarImagerUrl("http://img.my.csdn.net/uploads/201508/05/1438760706_9279.jpg");
		bean24.setCarTime("2015-10-24");
		bean24.setCarComment(24);
		list.add(bean24);
		
		CarInformaitonEntity bean25 = new CarInformaitonEntity();
		bean25.setCarTitle("奔驰25");
		bean25.setCarImagerUrl("http://img.my.csdn.net/uploads/201508/05/1438760704_2341.jpg");
		bean25.setCarTime("2015-10-25");
		bean25.setCarComment(25);
		list.add(bean25);
		
		CarInformaitonEntity bean26 = new CarInformaitonEntity();
		bean26.setCarTitle("奔驰26");
		bean26.setCarImagerUrl("http://img.my.csdn.net/uploads/201508/05/1438760704_5707.jpg");
		bean26.setCarTime("2015-10-26");
		bean26.setCarComment(26);
		list.add(bean26);
		
		CarInformaitonEntity bean27 = new CarInformaitonEntity();
		bean27.setCarTitle("奔驰27");
		bean27.setCarImagerUrl("http://img.my.csdn.net/uploads/201508/05/1438760685_5091.jpg");
		bean27.setCarTime("2015-10-27");
		bean27.setCarComment(27);
		list.add(bean27);
		
		CarInformaitonEntity bean28 = new CarInformaitonEntity();
		bean28.setCarTitle("奔驰28");
		bean28.setCarImagerUrl("http://img.my.csdn.net/uploads/201508/05/1438760685_4444.jpg");
		bean28.setCarTime("2015-10-28");
		bean28.setCarComment(28);
		list.add(bean28);
		
		CarInformaitonEntity bean29 = new CarInformaitonEntity();
		bean29.setCarTitle("奔驰29");
		bean29.setCarImagerUrl("http://img.my.csdn.net/uploads/201508/05/1438760684_8827.jpg");
		bean29.setCarTime("2015-10-29");
		bean29.setCarComment(29);
		list.add(bean29);
		
	}

}
