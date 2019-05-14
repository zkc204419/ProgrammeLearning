package kai.chang.zhang.Algorithm;

import java.awt.event.MouseWheelEvent;
import java.util.Scanner;
import java.util.Stack;

//求从A点到B点的路径的条数
class Node{
	int x;
	int y;
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
public class AtoBpathes {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int a[][] = new int [N][M];
		int flag[][] = new int [N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M ; j++) {
				a[i][j] = scanner.nextInt();
			}
		}
		int x1 = scanner.nextInt();
		int y1 = scanner.nextInt();
		int x2 = scanner.nextInt();
		int y2 = scanner.nextInt();
		scanner.close();
		Stack<Node>stack = new Stack<>();
		stack.push(new Node(x1, y1));
		int pathNum = 0;
		while(!stack.empty()) {
			Node temp = stack.pop();
			int x = temp.getX();
			int y = temp.getY();
			if(x==x2 && y==y2) {
				pathNum++;
				continue;
			}
			else {
				flag[x][y] = 1;
				if(y-1>=0 && a[x][y-1]>a[x][y] && flag[x][y-1] == 0) {
					stack.push(new Node(x, y-1));
				}
				if(x-1>=0 && a[x-1][y]>a[x][y] && flag[x-1][y] == 0) {
					stack.push(new Node(x-1, y));
				}
				if(y+1<a[0].length &&a[x][y+1]>a[x][y] && flag[x][y+1] == 0) {
					stack.push(new Node(x, y+1));
				}
				if(x+1<a.length && a[x+1][y]>a[x][y] && flag[x+1][y] == 0) {
					stack.push(new Node(x+1, y));
				}
			}
		}
		System.out.println(pathNum%1000000000);	
	}
}
