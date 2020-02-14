package com.qhit.servlet.news;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import com.qhit.entity.News;
import com.qhit.servic.NewsService;
import com.qhit.servic.impl.NewsServiceimpl;
import com.qhit.servlet.topic.DelServletTopic;

public class AddServletNews extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		String contextPath = request.getContextPath();// ��·��
		Logger logger=Logger.getLogger(AddServletNews.class.getName());
		NewsService ns = new NewsServiceimpl();
		News n = new News();
		// �����ļ��ϴ�����·��
		String savePath = "D://eclipse//����//Topic//WebContent//upload";
		// ������ʱ�ļ�·��
		String tempPath = this.getServletContext().getRealPath("/WEB-INF/tempFiles");
		File tempFile = new File(tempPath);
		if (!tempFile.exists()) {
			tempFile.mkdir();
		}
		// �����쳣��Ϣ
		String errorMessage = "";
		// ����file items����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// ���û�������С
		factory.setSizeThreshold(1024 * 100);
		// ������ʱ�ļ�·��
		factory.setRepository(tempFile);
		// �����ļ��ϴ�������
		ServletFileUpload upload = new ServletFileUpload(factory);
		// �����ļ��ϴ�����
		ProgressListener progressListener = new ProgressListener() {
			public void update(long pBytesRead, long pContentLength, int pItems) {
				//System.out.println("���ڶ�ȡ�ļ��� " + pItems);
				if (pContentLength == -1) {
					//System.out.println("�Ѷ�ȡ�� " + pBytesRead + " ʣ��0");
				} else {
					//System.out.println("�ļ��ܴ�С��" + pContentLength + " �Ѷ�ȡ��" + pBytesRead);
				}
			}
		};
		upload.setProgressListener(progressListener);
		// ����ϴ��ļ�������������
		upload.setHeaderEncoding("UTF-8");
		// �ж��ύ�����������Ƿ����ϴ���������
		if (!ServletFileUpload.isMultipartContent(request)) {
			// ���մ�ͳ��ʽ��ȡ����
			return;
		}
		// �����ϴ������ļ��Ĵ�С�����ֵ��Ŀǰ������Ϊ1024*1024�ֽڣ�Ҳ����1MB
		upload.setFileSizeMax(1024 * 1024);
		// �����ϴ��ļ����������ֵ�����ֵ=ͬʱ�ϴ��Ķ���ļ��Ĵ�С�����ֵ�ĺͣ�Ŀǰ����Ϊ10MB
		upload.setSizeMax(1024 * 1024 * 10);
		try {
			// ʹ��ServletFileUpload�����������ϴ����ݣ�����������ص���һ��List<FileItem>���ϣ�ÿһ��FileItem��Ӧһ��Form����������
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> iterator = items.iterator();
			while (iterator.hasNext()) {
				FileItem item = iterator.next();
				// �ж�jsp�ύ�������ǲ����ļ�
				if (item.isFormField()) {
						if(item.getFieldName().equals("ntid")){
						    n.setNtid(Integer.parseInt(item.getString("UTF-8")));
						}else if(item.getFieldName().equals("ntitle")){
							n.setNtitle(item.getString("UTF-8"));
						}else if(item.getFieldName().equals("nauthor")){
							n.setNauthor(item.getString("UTF-8"));
						}else if(item.getFieldName().equals("nsummary")){
							n.setNsummary(item.getString("UTF-8"));
						}else if(item.getFieldName().equals("ncontent")){
							n.setNcontent(item.getString("UTF-8"));
						}
					
					errorMessage = "���ύ�ļ���";
					//break;
				} else{
					// �ļ���
					String fileName = item.getName();
					System.out.println(fileName+"�����ļ���");
					if (fileName == null || fileName.trim() == "") {
						System.out.println("�ļ���Ϊ�գ�");
					}
					// ����ͬ������ύ���ļ�����·������
					fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
					// �ļ���չ��
					String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
					// �ж���չ���Ƿ�Ϸ�
					if (!validExtension(fileExtension)) {
						errorMessage = "�ϴ��ļ��Ƿ���";
						logger.warn("�ϴ��Ƿ��ļ�,��׺������jpg, txt, doc, pdf");
						item.delete();
						break;
					}
					// ����ļ�������
					InputStream in = item.getInputStream();
					// �õ������ļ�������
					String saveFileName = createFileName(fileName);
					n.setNpicPath(saveFileName);
					// �õ��ļ�����·��
					String realFilePath = createRealFilePath(savePath, saveFileName);
					// �����ļ������
					FileOutputStream out = new FileOutputStream(realFilePath);
					// ����������
					byte buffer[] = new byte[1024];
					int len = 0;
					while ((len = in.read(buffer)) > 0) {
						// д�ļ�
						out.write(buffer, 0, len);
					}
					// �ر�������
					in.close();
					// �ر������
					out.close();
					// ɾ����ʱ�ļ� TODO
					item.delete();
					// ���ϴ��ļ���Ϣ���浽�������� TODO
			}
			}
		} catch (FileUploadBase.FileSizeLimitExceededException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "�����ļ��������ֵ������");
			logger.warn("�ϴ��ĵ����ļ��������ֵ��");
			request.getRequestDispatcher("/newspages/admin.jsp").forward(request, response);
			return;
		} catch (FileUploadBase.SizeLimitExceededException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "�ϴ��ļ����ܵĴ�С�������Ƶ����ֵ������");
			logger.warn("�ϴ��ļ����ܵĴ�С�������Ƶ����ֵ��");
			request.getRequestDispatcher("/newspages/admin.jsp").forward(request, response);
			return;
		} catch (FileUploadException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "�ļ��ϴ�ʧ�ܣ�����");
			logger.warn("�ļ��ϴ�ʧ�ܣ�");
			request.getRequestDispatcher("/newspages/admin.jsp").forward(request, response);
			return;
		}
		request.setAttribute("errorMessage", errorMessage);
		//request.getRequestDispatcher("/newspages/admin.jsp").forward(request, response);
		int flag = ns.insertNews(n);
		pw.write("<script type=\"text/javascript\">");
		pw.write("alert(\"����������ӳɹ���\");");
		pw.write("location.href=\"" + contextPath + "/newspages/admin.jsp\";");
		pw.write("</script>");
		logger.info("����������ӳɹ���");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private boolean validExtension(String fileExtension) {
		String[] exts = { "jpg", "txt", "doc", "pdf" };
		for (int i = 0; i < exts.length; i++) {
			if (fileExtension.equals(exts[i])) {
				return true;
			}

		}

		return false;
	}

	private String createFileName(String fileName) {
		return UUID.randomUUID().toString() + "_" + fileName;
	}

	/**
	 * ���ݻ���·�����ļ�����������ʵ�ļ�·��������·��\\��\\��\\fileName
	 *
	 * @param basePath
	 * @param fileName
	 * @return
	 */
	private String createRealFilePath(String basePath, String fileName) {
		Calendar today = Calendar.getInstance();
		String year = String.valueOf(today.get(Calendar.YEAR));
		String month = String.valueOf(today.get(Calendar.MONTH) + 1);

		String upPath = basePath + File.separator + year + File.separator + month + File.separator;
		File uploadFolder = new File(upPath);
		if (!uploadFolder.exists()) {
			uploadFolder.mkdirs();
		}

		String realFilePath = upPath + fileName;

		return realFilePath;
	}
}
