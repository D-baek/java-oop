package com.bitcamp.services;
import com.bitcamp.domains.MemberBean;

public interface AdminService {

	public String list();
	public MemberBean findByID(String ID);
	public MemberBean[] findByName(String name);
	public String countAll() ;

}
