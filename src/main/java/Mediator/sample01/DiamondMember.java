package Mediator.sample01;

public class DiamondMember extends Member
{
	public DiamondMember(String name)
	{
		super(name);
	}
	
	public void sendText(String to,String message)
	{
	    System.out.println("��ʯ��Ա������Ϣ��");
	    chatroom.sendText(name,to,message);  //����
	}
	
	public void sendImage(String to,String image)
	{
		System.out.println("��ʯ��Ա����ͼƬ��");
	    chatroom.sendImage(name,to,image);  //����
	}
}