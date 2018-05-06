package Mediator.sample01;

import java.util.*;

public class ChatGroup extends AbstractChatroom
{
	private Hashtable members=new Hashtable();
	
	public void register(Member member)
	{
		if(!members.contains(member))
		{
			members.put(member.getName(),member);
			member.setChatroom(this);
		}
	}
	
   public void sendText(String from,String to,String message)
   {
   	  Member member=(Member)members.get(to);
   	  String newMessage=message;
   	  newMessage=message.replaceAll("��","*");
	  member.receiveText(from,newMessage);
   }
   
   public void sendImage(String from,String to,String image)
   {
   	  Member member=(Member)members.get(to);
   	  //ģ��ͼƬ��С�ж�
   	  if(image.length()>5)
   	  {
   	  	  System.out.println("ͼƬ̫�󣬷���ʧ�ܣ�");
   	  }
   	  else
   	  {
   	  	  member.receiveImage(from,image);
   	  }
   }
}