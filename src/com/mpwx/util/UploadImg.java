package com.mpwx.util;

import java.io.File;
import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.mpwx.dao.UploadDao;
import com.mpwx.util.BaseActionSupport;

public class UploadImg extends BaseActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private  File upload; 
	private String uploadContentType;
	private String uploadFileName;
	private int iType=0;
	public void fileUpload() throws IOException{
		
		request = ServletActionContext.getRequest();
		String sType=request.getParameter("type");
		String sPicFile = ServletActionContext.getServletContext().getRealPath("PicFile");		
		File targetFile= new File(sPicFile);
		if(!targetFile.mkdir()){
			targetFile.mkdirs();
		}
		
		
		String timestamp=System.currentTimeMillis()+"";
		String fileName=getUploadFileName();
		System.out.println(fileName+"+++++++++++");
		String[] fileNames=fileName.split("\\.");
		System.out.println(fileNames[0]+"+++++++++++"+fileNames[1]);
		
		fileName=fileNames[0]+timestamp+'.'+fileNames[1];
		
		targetFile=new File(targetFile,fileName); // File(String directoryPath, String filename)
		FileUtils.copyFile(upload, targetFile);
		
		if(sType== null ||"".equals(sType)){
			System.out.println("erro imgForm");
		}else{
			iType=Integer.parseInt(sType);
			UploadDao uploadDao = new UploadDao();
			uploadDao.insertPic(fileName, iType);
		}
		
		JSONObject jsonObject= new JSONObject();   //将要传入页面的值写入json中
		jsonObject.put("sPicPath", fileName);

		ServletActionContext.getResponse().getWriter().print(jsonObject);
		
	}

	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

}
