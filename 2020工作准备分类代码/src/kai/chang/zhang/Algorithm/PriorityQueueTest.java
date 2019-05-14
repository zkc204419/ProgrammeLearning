package kai.chang.zhang.Algorithm;

import java.time.LocalDate;
import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String args[]) {
		PriorityQueue<LocalDate> pQueue = new PriorityQueue<>();
		pQueue.add(LocalDate.of(1906, 12, 9));
		pQueue.add(LocalDate.of(1815, 12, 10));
		pQueue.add(LocalDate.of(1903, 12, 3));
		pQueue.add(LocalDate.of(1910, 6, 22));
		System.out.println("Iterating over elements ..");
		for(LocalDate date: pQueue) {
			System.out.println(date);
		}
		
		System.out.println("Removing elements...");
		while(!pQueue.isEmpty()) {
			System.out.println(pQueue.remove());
		}
	}
}
