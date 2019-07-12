package resource.tree;

public class ThreadTest{
	public static void main(String[] args) {
//		new ThreadTest1().start();
//		new ThreadTest1().start();
//		new ThreadTest1().start();
		Runnable r = new ThreadTest2();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		Thread t3 = new Thread(r);
		t1.start();
		t2.start();
		t3.start();
	}
}
//
//class ThreadTest1 extends Thread{  
//	  private int ticket = 10;  
//	  public void run(){  
//	    while(true){  
//	      if(ticket > 0){  
//	        System.out.println(Thread.currentThread().getName() + " is selling ticket" + ticket--);  
//	      }else{  
//	        break;  
//	      }  
//	    }  
//	  }  
//}

class ThreadTest2 implements Runnable{
	private int ticket = 10;
	public void run() {
		// TODO Auto-generated method stub
		while(true){  
		      if(ticket > 0){  
		        System.out.println(Thread.currentThread().getName() + " is selling ticket" + ticket--);  
		      }else{  
		        break;  
		      }  
		    } 
	}
	
}
