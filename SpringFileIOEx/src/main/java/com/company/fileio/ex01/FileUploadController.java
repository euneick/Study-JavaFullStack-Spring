package com.company.fileio.ex01;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {

	private static String FILE_REPOSITORY = "C:\\ProjectPlace\\JavaFullStack\\fileRepository";
	
	@RequestMapping(value = "/form")
	public String form() {
		return "uploadForm";
	}
	
	@RequestMapping(value = "/download")
	public void download(@RequestParam("imageFileName") String imageFileName,
			HttpServletResponse response) throws Exception {
		
		OutputStream out = response.getOutputStream();
		
		String downFile = FILE_REPOSITORY + File.separator + imageFileName;
		
		File file = new File(downFile);
		
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; fileName="+imageFileName);
		
		FileInputStream in = new FileInputStream(file);
		byte[] buffer = new byte[1024 * 8];
		
		while (true) {
			int count = in.read(buffer);
			if (count == -1) break;
			out.write(buffer, 0, count);
		}
		
		in.close();
		out.close();
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView upload(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		Enumeration enumeration = request.getParameterNames();
		
		while (enumeration.hasMoreElements()) {
			String name = (String) enumeration.nextElement();
			String value = request.getParameter(name);
			
			map.put(name, value);
		}
		
		List<String> fileList = fileProcess(request);
		map.put("fileList", fileList);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("map", map);
		modelAndView.setViewName("result");
		
		return modelAndView;
	}

	private List<String> fileProcess(MultipartHttpServletRequest request) throws Exception {

		List<String> fileList = new ArrayList<String>();
		
		Iterator<String> fileNames = request.getFileNames();
		
		while(fileNames.hasNext()) {
			String fileName = fileNames.next();
			MultipartFile multipartFile = request.getFile(fileName);
			
			String originFileName = multipartFile.getOriginalFilename();
			fileList.add(originFileName);
			
			File file = new File(FILE_REPOSITORY + File.separator + originFileName);
			
			if(multipartFile.getSize() != 0) {
				if (!file.exists() && file.getParentFile().mkdirs()) {
					file.createNewFile();	
				}
				
				multipartFile.transferTo(new File(FILE_REPOSITORY + File.separator + originFileName));
			}
		}
		
		return fileList;
	}
}
