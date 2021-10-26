package com.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.ersreimbDao;
import com.example.dao.reimbstatusDao;
import com.example.dao.reimbtypeDao;
import com.example.dao.userDao;
import com.example.dao.userroleDao;
import com.example.model.ersreimb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONDisp {
	
	public static HibernateUtil hUtil = new HibernateUtil();
	public static reimbtypeDao rtd = new reimbtypeDao(hUtil);
	public static reimbstatusDao rsd = new reimbstatusDao(hUtil);
	public static userroleDao urd = new userroleDao(hUtil);
	public static userDao userd = new userDao(hUtil);
	public static ersreimbDao ersd = new ersreimbDao(hUtil);
///Project1/getuser.json
	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		
		switch (req.getRequestURI()) {
		case "/Project1/gettext.json":
			System.out.println("in a gettext.json");
			ersd.update();
			res.getWriter().write(new ObjectMapper().writeValueAsString(ersd.getAll()));
			System.out.println("in a gettext.json SENT");
			break;
		case "/Project1/getuser.json":
			System.out.println("in a getuser.json");
			System.out.println(req.getSession().getAttribute("currentuser"));
			res.getWriter().write(new ObjectMapper().writeValueAsString(req.getSession().getAttribute("currentuser")));
			break;

		default:
			System.out.println("in json default");
			res.getWriter().write(new ObjectMapper().writeValueAsString("end of switch statment"));
			break;
		}
		
		
	}

}
