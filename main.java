package facebook;

import java.io.*;
import java.util.*;
import java.util.Scanner;
public class main {

	
	public static void main(String[] args) throws IOException
	{
		 	BufferedReader in = new BufferedReader(new FileReader("facebook.txt"));
	        String str;
	        person[] obj=new person[2000];
	        int k=0;
	        while((str = in.readLine()) != null)
	        {
	        	List<String> list = new ArrayList<String>();
	            list.add(str);
	            String[] stringArr = list.toArray(new String[0]);
	            String[] words=stringArr[0].split(",");
	            int l=words.length;
	            int p=0;
	            obj[k]=new person();
	            for(int i=0;i<l;i++)
	            {
	            //	System.out.println(words[i]);
	            }
	            obj[k].UserName=words[p];
	            p=p+1;
	            //System.out.print(obj[k].UserName+" ");
	            obj[k].Password=words[p];
	            p=p+1;
	           // System.out.println(obj[k].Password);
	            obj[k].Display_Name=words[p];
	            p=p+1;
	            //System.out.println(obj[k].Display_Name);
	            obj[k].NumberOfFriend=Integer.parseInt(words[p]);
	            p=p+1;
	            //System.out.println(obj[k].NumberOfFriend);
	            for(int i=0 ; i<obj[k].NumberOfFriend ; i++)
	            {
	            	obj[k].FriendList.add(words[p]);
	            	p=p+1;
	            }
	            obj[k].NoOfPendingRequest=Integer.parseInt(words[p]);
	            p=p+1;
	            //System.out.println(obj[k].NoOfPendingRequest);
	            for(int i=0;i<obj[k].NoOfPendingRequest;i++)
				{
					obj[k].RequestPending.add(words[p]);
					p=p+1;
				}
	            
	            obj[k].Status=words[p];
	            //System.out.println(obj[k].Status);
	            k=k+1;
		    }
	        while(1>0)
	        {
	        	Scanner inp=new Scanner(System.in);
	        	System.out.println("1.Sign Up");
	        	System.out.println("2.Log In");
	        	int ch,lm;
	        	ch=inp.nextInt();
	        	switch(ch)
	        	{
	        		case 1:
	        			{
	        				lm=signup(obj,k);
	        				System.out.println("Registration successful.User "+obj[k].UserName+" is created.");
	        				k=k+1;
	        				write(obj,k);
	        				break;
		        		}
	        		case 2:
	        			{
	        				int m;
	        				m=login(obj,k);
	        				loggedin(obj,m,k);
	        				break;
	        			}
	        	}
	        }
	        
	        
	        
	        
	   }
	public static int signup(person[] obj,int k)
	{
		int f=0;
		Scanner inp=new Scanner(System.in);
		System.out.println("Enter Username:");
		while(f!=1)
		{
			String username=inp.nextLine();
			int flag=0;
			for(int i=0 ; i<k ; i++)
			{
				if(username.equals(obj[i].UserName))
				{
					System.out.println("Person with same username exists,write another username");
					flag=1;
					continue;
				}
			}
			
			if(flag==0)
			{
				obj[k]=new person();
				obj[k].UserName=username;
				System.out.println("Enter Display Name:");
				String dis=inp.nextLine();
				obj[k].Display_Name=dis;
				System.out.println("Enter Password:");
				String pass=inp.nextLine();
				obj[k].Password=pass;
				obj[k].NoOfPendingRequest=0;
				obj[k].NumberOfFriend=0;
				obj[k].Status="New Account!!!";
				return 0;
			}
		}
		return 0;
			
	}
	public  static int login(person[] obj,int k)
	{
		int f=0;
		Scanner inp=new Scanner(System.in);
		System.out.println("Enter Username:");
		while(f!=1)
		{
			String username=inp.nextLine();
			for(int i=0 ; i<k ; i++)
			{
				if(username.equals(obj[i].UserName))
				{
					System.out.println("Enter Password:");
					String pass=inp.nextLine();
					if(pass.equals(obj[i].Password))
					{
						return i;
					}
					else
					{
						System.out.println("Wrong Password!!!");
						i=i-1;
					}
				}
				
			}
			System.out.println("Username Does not exist!!!");
		}
		return 0;
	}
	public static void loggedin(person[] obj,int m,int k) throws IOException
	{
		while(1>0)
		{	
			System.out.println(obj[m].Display_Name+" is logged in now");
			System.out.println(obj[m].Status);
			System.out.println("1.List Friends");
			System.out.println("2.Search");
			System.out.println("3.Update Status");
			System.out.println("4.Pending Requests");
			System.out.println("5.Logout");
			Scanner inp=new Scanner(System.in);
			int choice;
			String p;
        	choice=inp.nextInt();
        	switch(choice)
        	{
        	case 1:
        		{
        			System.out.print("Your Friends are:");
        			for(int i=0 ;i<obj[m].NumberOfFriend ; i++)
        			{
        				String val=obj[m].FriendList.get(i);
        				System.out.print(val+",");
        			}
        			break;
        		}
        	case 2:
        		{
        			System.out.println("Enter Name:");
        			String name=inp.next();
        			int flag=0;
        			for(int i=0 ; i<k ; i++)
        			{
        				if(name.equals(obj[i].UserName))
        				{
        					for(int i1=0 ;i1<obj[m].NumberOfFriend ; i1++)
                			{
                				String val=obj[m].FriendList.get(i1);
                				if(val.equals(name))
                				{
                					System.out.println("You and "+name+"  are friends");
                					System.out.println("Display name: "+obj[i].Display_Name);
                					System.out.println("Status: "+obj[i].Status);
                					System.out.print("Friendlist: ");
                					for(int lmn=0 ; lmn<obj[i].NumberOfFriend ; lmn++)
                					{
                						String jai=obj[i].FriendList.get(lmn);
                						System.out.print(jai +" ");
                						
                					}
                					System.out.println("");
                					flag=1;
                				
                				}
                				
                			}
            					int kite=0;
            					String mutual="";
        						for(int k1=0 ; k1<obj[m].NumberOfFriend ; k1++)
            					{
            						String val=obj[m].FriendList.get(k1);
            						for(int j=0 ; j<obj[i].NumberOfFriend ; j++)
            						{
            							String val2=obj[i].FriendList.get(j);
            							if(val.equals(val2))
            							{
            								kite=1;
            								mutual=mutual+val+" ";
            							}
            							
            						}
            					}
            						if(kite==1)
            						{
            							System.out.println("Mutual Friends:"+mutual);
            						}
            						if(kite==0)
            						{
            							System.out.println("No mutual friends");
            						}
            				if(flag==0)		
            				{
            					int chul=0;
        						for(int lm=0 ; lm<obj[i].NoOfPendingRequest ; lm++)
        						{
        							String req=obj[i].RequestPending.get(lm);
        							if(req.equals(obj[m].UserName))
        							{
        								chul=1;
        							}
        						}
        						if(chul==0)
        						{
        							System.out.println("1.Send Request");
        							System.out.println("b.back");
        							String ch=inp.next();
        							if(ch.equals("b"))
        							{
        								break;
        							}
        							else
        							{
        								obj[i].NoOfPendingRequest+=1;
        								obj[i].RequestPending.add(obj[m].UserName);
        							}
        							write(obj,k);
        						}
        						if(chul==1)
        						{
        							System.out.println("1.Cancel Request");
        							System.out.println("b.back");
        							String ch=inp.next();
        							if(ch.equals("b"))
        							{
        								break;
        							}
        							else
        							{
        								obj[i].NoOfPendingRequest-=1;
        								obj[i].RequestPending.remove(obj[m].UserName);
        							}
        							write(obj,k);
        						}
            				}
        						
            				}
        					
        					
        				}
        			break;
        			}
        			
        		
        	case 3:
        		{
        			Scanner in =new Scanner(System.in);
        			System.out.println("Enter Status:");
        			String p1=in.nextLine();
        			
        			obj[m].Status=p1;
        			System.out.println("Status Updated!!");
        			write(obj,k);
        			break;
        		}
        	case 4:
        		{
        			while(1>0)
        			{
        				int x;
        				for(int i=0 ; i<obj[m].NoOfPendingRequest ; i++)
        				{
        					String val=obj[m].RequestPending.get(i);
        					System.out.println((i+1)+"."+val);
        				}
        				System.out.println("b."+"back");
        				String ch=inp.next();
        				if(ch.equals("b"))
        				{
        					break;
        				}		
        				else
        				{
        					x=Integer.parseInt(ch);
        					x=x-1;
        					String val=obj[m].RequestPending.get(x);
        					System.out.println(val);
        					System.out.println("1.Accept");
        					System.out.println("2.Reject");
        					int choice2;
        					choice2=inp.nextInt();
        					if(choice2==1)
        					{
        						obj[m].FriendList.add(val);
        						obj[m].RequestPending.remove(x);
        						obj[m].NoOfPendingRequest-=1;
        						obj[m].NumberOfFriend+=1;
        						System.out.println(val+" is your friend");
        						for(int kill=0 ; kill<k ; kill++)
        						{
        							if(val.equals(obj[kill].UserName))
        							{
        								obj[kill].NumberOfFriend+=1;
        								obj[kill].FriendList.add(obj[m].UserName);
        								
        							}
        						}
        						
        					}
        					else if(choice2==2)
        					{
        						obj[m].RequestPending.remove(x);
        						obj[m].NoOfPendingRequest-=1;
        						System.out.println("You removed "+val);     
        					}
        					write(obj,k);
        				}
        				
        			}
        			break;
        			}
        	case 5:
        		{
        			System.out.println(obj[m].UserName+"logged out succesfully");
        			return;
        		}
        		}
        	}
        }
        
	
	public static void write(person[] obj,int size) throws IOException
	{
		File f=new File("facebook.txt");
		BufferedWriter bw=new BufferedWriter(new FileWriter(f));
		for(int i=0 ; i<size ; i++)
		{
			bw.write(obj[i].UserName+",");
			bw.write(obj[i].Password+",");
			bw.write(obj[i].Display_Name+",");
			String n=Integer.toString(obj[i].NumberOfFriend);
			bw.write(n+",");
			for(int m=0 ;m<obj[i].NumberOfFriend ; m++)
    		{
    			String val=obj[i].FriendList.get(m);
    			bw.write(val+',');
    		}
			String o=Integer.toString(obj[i].NoOfPendingRequest);
			bw.write(o+",");
			for(int m=0 ;m<obj[i].NoOfPendingRequest ; m++)
    		{
    			String val=obj[i].RequestPending.get(m);
    			bw.write(val+',');
    		}
			bw.write(obj[i].Status);
			//System.out.println("njnjk");
			bw.newLine();
		}
		bw.close();
	}
	

	}


