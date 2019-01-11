package org.saheb.thread;

public class SequencePrinttwoThreads {
	public static void main(String[] args) {
		Print print = new Print();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				print.printOdd();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				print.printEven();
			}
		});
		t1.start();
		t2.start();
	}
}

class Print{
	boolean flag = true;
	int limit = 20;
	int i=1;
	void printOdd() {
		while(true) {
			synchronized (this) {
				if(!flag) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(i<limit && (i%2) != 0) {
					System.out.println("Thread 1::"+i);
					i++;
					flag = false;
					notify();
				}
				
			}
		}
		
	}
	void printEven() {
		while(true) {
			synchronized (this) {
				if(flag) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(i<=limit && (i%2) == 0) {
					System.out.println("Thread 2::"+i);
					i++;
					flag = false;
					notify();
				}
			}
		}
	}
}
