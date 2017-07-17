package leetcode.design;

import java.util.LinkedList;
import java.util.Queue;

public class implementStackusingQueues {
		Queue<Integer> queue;
		Queue<Integer>bufferQueue;
		int topValue;
    public implementStackusingQueues() {
    	queue = new LinkedList<Integer>();
    	bufferQueue= new LinkedList<Integer>();
    } 
    public void push(int x) {
        queue.offer(x);
    }
    public int pop() {
		while(queue.size()!=1){
			bufferQueue.offer(queue.poll());
		}
       while(bufferQueue.size()!=0){
        	queue.offer(bufferQueue.poll());
        }
        return queue.poll(); 
    }
    
    public int top() {
    	while(queue.size()!=1){
			bufferQueue.offer(queue.poll());
		}
    	topValue=queue.poll();
    	while(bufferQueue.size()!=0){
        	queue.offer(bufferQueue.poll());
        }
    	queue.offer(topValue);
        return topValue; 
    }
    public boolean empty() {
    	if(queue.isEmpty()){
    		return true;
    	}
		return false;
        
    }
    public static void main(String[] args){
    	implementStackusingQueues stack = new implementStackusingQueues();
    	stack.push(-2);
    	stack.push(0);
    	stack.push(-3);
    	stack.pop();
    	stack.top();      
    	stack.empty();
    }
}
