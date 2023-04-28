package com.newlecture.web.controller.admin.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller("adminNoticeController")
@RequestMapping("/admin/board/notice/")
public class NoticeController { //<bean name="adminNoticeController" class="com.newlecture.web.controller.admin.board.NoticeController"/>
	
		@Autowired
		private ServletContext ctx;
	
		@RequestMapping("list")
		public String list() {
			
			return "admin.board.notice.list";
		}
		@GetMapping("reg")
		public String reg() {
			
			return "admin.board.notice.reg";
		}
		
		@PostMapping("reg")
		public String reg(String title, MultipartFile[] files, String content, String category, String[] foods, String food, HttpServletRequest request) throws IllegalStateException, IOException {
			
			
			for(MultipartFile file : files) {
			long size = file.getSize();
			String fileName = file.getOriginalFilename();
			System.out.printf("fileName:%s, fileSize:%d\n", fileName, size);
			
//			ServletContext ctx = request.getServletContext(); 이녀석을 멤버로 둘수도있다. 위에 처럼.
			String webPath = "/static/upload";
			String realPath = ctx.getRealPath(webPath);
			System.out.printf("realPath : %s\n", realPath);
			File savePath = new File(realPath);
			if(!savePath.exists())
				savePath.mkdirs();			
			realPath += File.separator + fileName;
			File saveFile = new File(realPath);
			file.transferTo(saveFile);
			}
			return "admin.board.notice.reg";
			//return String.format("title:%s<br>, content:%s<br>, category:%s", title, content, category);
		}
		@RequestMapping("edit")
		public String edit() {
			
			return "admin.board.notice.edit";
		}
		@RequestMapping("del")
		public String del() {
			
			return "";
		}
		
}
