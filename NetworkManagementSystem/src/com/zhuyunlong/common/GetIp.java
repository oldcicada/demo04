package com.zhuyunlong.common;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class GetIp {
	public String getHostIp(){  
	    try{  
	        Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();  
	        while (allNetInterfaces.hasMoreElements()){  
	            NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();  
	            Enumeration<InetAddress> addresses = netInterface.getInetAddresses();  
	            while (addresses.hasMoreElements()){  
	                InetAddress ip = (InetAddress) addresses.nextElement();  
	                if (ip != null   
	                        && ip instanceof Inet4Address  
	                        && !ip.isLoopbackAddress() 
	                        && ip.getHostAddress().indexOf(":")==-1){  
	                    return ip.getHostAddress();  
	                }   
	            }  
	        }  
	    }catch(Exception e){  
	        e.printStackTrace();  
	    }
	    return null;  
	    }
}
