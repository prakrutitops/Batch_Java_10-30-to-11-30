package com.connect;

import java.sql.Connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util 
{
	public static Session getconnect()
	{
		Session sess = null;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		sess = sf.openSession();
		return sess;
	}
}
