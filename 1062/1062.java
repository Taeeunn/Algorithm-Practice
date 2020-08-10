package DAY01.P1062;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N, K;
	static String[] words;
	static boolean[] visited;
	static int selectedCount=0;
	static int max=0;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src\\DAY01\\P1062\\input.txt"));
		Scanner sc= new Scanner(System.in);
		
		N=Integer.parseInt(sc.next());
		K=Integer.parseInt(sc.next());
		
		if(K<5) {
			System.out.println(0);
			return;
		}
		
		words=new String[N];
		visited=new boolean[26];
		
		
		
		for(int i=0;i<N;i++) {
			words[i]=sc.next().replaceAll("[antic]", "");
		}
	
		visited['a'-'a']=true;
		visited['n'-'a']=true;
		visited['t'-'a']=true;
		visited['i'-'a']=true;
		visited['c'-'a']=true;
		
		selectedCount=5;
		max=wordCount();
		
		for(int i=0;i<26;i++) {
			if(visited[i]==false) {
				dfs(i);
			}
		}
		System.out.println(max);

	}
	
	static void dfs(int index) {
//      1. üũ��                        visited[0-25]=true
		visited[index]=true;
		selectedCount++;
		
//      2. �������ΰ�?       selectCount == K => �ִ밳��
		if(selectedCount == K) {
			max=Math.max(wordCount(), max);
			//max = �ִ� �ܾ� ����.
		}else {
//		    3. �� �� �ִ� ���� ��ȸ     for(0~25)
			for(int i=index+1 ;i<26;i++) {
//			    4. �� �� �ִ°�?      if(visited[ ]==false)
				if(visited[i]==false) {
//				    5. ����  dfs(next)   
					dfs(i);
				}
			}
		}
//	    6. üũ�ƿ�
		visited[index]=false;
		selectedCount--;
			
	}
	
	static int wordCount() {
		int count=0;
		
		for(int i=0;i<N;i++) {
			boolean isPossible=true;
			for(int j=0;j<words[i].length();j++) {
				if(visited[words[i].charAt(j)-'a']==false) {
					isPossible=false;
					break;
				}
			}
			if(isPossible==true) {
				count++;
			}
		}
		return count;
	}

}
