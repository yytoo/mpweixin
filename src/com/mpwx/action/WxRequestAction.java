package com.mpwx.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.mpwx.util.HttpRequest;
import com.mpwx.bean.PicInforBean;
import com.mpwx.dao.OnLoadWxDAO;

public class WxRequestAction {
	public String getWxRequest() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();  
		HttpServletResponse response= ServletActionContext.getResponse();
		PrintWriter out;
		out = response.getWriter();
		/*String sCityName=request.getParameter("cityname");
		String sKey=request.getParameter("key");
		System.out.println(sCityName+"=================sCityName");
		System.out.println(sKey+"=================sKey");*/
		String sAction=request.getParameter("action");
		System.out.println(sAction+"=================action");
		OnLoadWxDAO onloadDao = new OnLoadWxDAO();
		ArrayList<PicInforBean> picInfor = onloadDao.selectPic();
/*		ArrayList<Object> list = new ArrayList<Object>();
		list.add(picInfor);
		list.add(des);
		System.out.println(list+"=================Alist");*/
		JSONArray jsonArray=JSONArray.fromObject(picInfor);	
	/*	jsonObject.accumulate("haha", "aaaaaaaaaaaa");*/
		System.out.println(jsonArray.toString()+"=================list");
/*		request.setAttribute("return", jsonObject.toString());*/
		out.println(jsonArray.toString());
		out.flush();
		out.close();
		return null;
	} 
	
	public String getExRate() {
		Long lTemp = System.currentTimeMillis();
	System.out.println("start time:" +lTemp );
		String s=HttpRequest.sendPost("http://srh.bankofchina.com/search/whpj/search.jsp", "erectDate=&nothing=&pjname=1316","utf-8");
        //System.out.println(s);
		Long lTemp1 = System.currentTimeMillis();
		System.out.println("temp1:" +(lTemp1-lTemp));
		HttpServletRequest request = ServletActionContext.getRequest();  	
		HttpServletResponse response= ServletActionContext.getResponse();

		PrintWriter out = null;
		try {
			
			out = response.getWriter();
			String sUsdPrice=request.getParameter("usdPrice");
			System.out.println(sUsdPrice+"=================usdPrice");
	        try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        if(s!=null&&s.trim().length()>0){
				Document doc =Jsoup.parse(s);
		        Element tr=doc.select("div.BOC_main").first().select("table").select("tr").get(1).select("td").get(3);
		       out.println(tr.text());
	        }else{
	        	out.println(new JSONObject().put("msg", -1).toString());
	        }
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally{
			out.flush();
			out.close();
		}
		
		Long lEnd = System.currentTimeMillis();
		System.out.println("dsafadfa:::" + (lEnd-lTemp));
		return null;
	}
	
}
	

