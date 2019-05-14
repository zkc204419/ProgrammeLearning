package kai.chang.zhang.Algorithm;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

class Item implements Comparable<Item>{
	private String description;
	private int partNumber;
	
	public Item(String description , int partNumber) {
		this.description = description;
		this.partNumber = partNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}
	
	public String toString() {
		return "[description=" + description +",partNumber=" + partNumber + "]";
	}
	
	public boolean equals(Object otherobject) {
		if(this == otherobject) {
			return true;
		}
		if(otherobject == null) {
			return false;
		}
		if(getClass()!=otherobject.getClass()) {
			return false;
		}
		Item other = (Item)otherobject;
		return Objects.equals(description, other.description) && partNumber == other.partNumber;
	}
	
	public int hashCode() {
		return Objects.hash(description,partNumber);
	}
	
	@Override
	public int compareTo(Item other) {
		int diff = Integer.compare(partNumber, other.partNumber);
		return diff != 0 ? diff : description.compareTo(other.description);
	}
}





public class TreeSetTest {
	public static void main(String args[]) {
		SortedSet<Item>parts = new TreeSet<>();
		parts.add(new Item("Toaster", 12345));
		parts.add(new Item("Widget", 23456));
		parts.add(new Item("Modem", 99123));
		System.out.println(parts);
		
		NavigableSet<Item> sortByDescription = new TreeSet<>(
				Comparator.comparing(Item::getDescription));
		sortByDescription.addAll(parts);
		System.out.println(sortByDescription);
	}
	

}
