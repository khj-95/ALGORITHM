package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BOJ_17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String str = bufferedReader.readLine();
		Queue<String> q = new LinkedList<>();
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char now = str.charAt(i);
			if(now == ' ' || now == '<'){
				while(!stack.isEmpty()){
					q.add(stack.pop());
				}
			}
			if(now == ' '){
				q.add(String.valueOf(now));
				continue;
			}
			if(now == '<'){
				while(true){
					q.add(String.valueOf(now));
					if(now == '>'){
						break;
					}
					i++;
					now = str.charAt(i);
				}
				continue;
			}
			stack.add(String.valueOf(now));
		}
		if(!stack.isEmpty()){
			while(!stack.isEmpty()){
				q.add(stack.pop());
			}
		}

		StringBuffer stringBuffer = new StringBuffer();
		while(!q.isEmpty()){
			stringBuffer.append(q.poll());
		}
		System.out.println(stringBuffer);
	}
}
