package leetcode.design;

import java.util.ArrayList;
import java.util.List;
/***
 * 可改用java stack 實作
 * @author brian
 *
 */
public class minStack {
	List<Integer> innerList;
	public  minStack() {
		innerList = new ArrayList<Integer>();
	}
    public void push(int x) {
    	innerList.add(x);
    }
    
    public void pop() {
        int length=innerList.size()-1;
        innerList.remove(length);
    }
    
    public int top() {
    	
    	int length=innerList.size()-1;
		return innerList.get(length);
        
    }
    
    public int getMin() {
    	int a;
    	a = innerList.get(0);
    	for(int i=1;i<innerList.size();i++){
    		if(a>innerList.get(i)){
    			a=innerList.get(i);
    		}
    	}
		return a;
        
    }
    public static void main(String[] args){
    	minStack stack = new minStack();
    	stack.push(-2);
    	stack.push(0);
    	stack.push(-3);
    	stack.getMin();  
    	stack.pop();
    	stack.top();      
    	stack.getMin(); 
	}
    
}
