package org.saheb.thread;

import java.util.concurrent.locks.Lock;

public class SequencePrinttwoThreadsLock {

}
class PrintOdd{
	Lock lock;
	PrintOdd(Lock lock){
		this.lock = lock;
	}
	void print(){
		
	}
}
class PrintEven{
	
}