package com.woniu.controllor;
import com.woniu.bean.Page;
import com.woniu.bean.Computer;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Computer
 */
@WebServlet("/Computer.do")
public class Computer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Computer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method=request.getParameter("method");
		if("add".equals(method)){
			add(request,response);
		}else if("edit".equals(method)){
			edit(request,response);
		}else if("show".equals(method)){
			show(request,response);
		}
	}

	private void show(HttpServletRequest request, HttpServletResponse response) {
		// TODO �Զ����ɵķ������
		String pagenum=request.getParameter("pageNum");
		if(pagenum==null){
			pagenum="1";
		}
	    Page pb=new Page();
	    pb.setPageNum(Integer.parseInt(pagenum));
	    pb.getPageRow(3);
	    List<Commputer> coms=servicefactory.(pb);
		Map map=new HashMap();
		map.put("coms",coms);
		map.put("pb",pb);
	    JSONObejct json = JSONObject.fromObject(map);
		response.getWriter().write(json.toString());
		response.getWriter().flush();
 	}

	private void edit(HttpServletRequest request, HttpServletResponse response) {
		// TODO �Զ����ɵķ������
		Integer cid=request.getParameter("cid");
		//����service�Ĳ��ҷ���������������������������
		Commputer c=;
		File fi=new File(c.getCimg());
		fi.delete();
		DiskFileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		List<FileItem> fileitem=upload.parseRequest(request);
		for(FileItem item:fileitem){
			if(item.isFormField()){
				if(item.getFieldName().equals("cname")){
					c.setCname(item.getString("utf-8"));
				}
				if(item.getFieldName().equals("cprice")){
					c.setCprice(Double.parseDouble((item.getString("utf-8"))));
				}
			}else{
				String path=request.getServletContext().getRealPath("/computer");
				String qz=String.valueOf(new Date().getTime());
				String hz=item.getName().substring(item.getName().lastIndexOf("."));
				String filename="/computer/"+qz+hz;
				c.setCimg(filename);
				File file=new File(path);
				filename=filename.substring(filename.lastIndexOf("/"));
				File file2=new File(file,filename);
				item.write(file2);
				
			}
		}
		
		//����service�༭����������������������������������������������������
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		// TODO �Զ����ɵķ������
		DiskFileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		Computer c=new Computer();
		List<FileItem> fileitem=upload.parseRequest(request);
		for(FileItem item:fileitem){
			if(item.isFormField()){
				if(item.getFieldName().equals("cname")){
					c.setCname(item.getString("utf-8"));
				}
				if(item.getFieldName().equals("cprice")){
					c.setCprice(Double.parseDouble((item.getString("utf-8"))));
				}
			}else{
				String path=request.getServletContext().getRealPath("/computer");
				String qz=String.valueOf(new Date().getTime());
				String hz=item.getName().substring(item.getName().lastIndexOf("."));
				String filename="/commpic/"+qz+hz;
				c.setCimg(filename);
				File file=new File(path);
				filename=filename.substring(filename.lastIndexOf("/"));
				File file2=new File(file,filename);
				item.write(file2);
			}
		}
		//����SERVICE��ӷ���!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	}

	catch (FileUploadException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	} catch (IOException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	} catch (Exception e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
