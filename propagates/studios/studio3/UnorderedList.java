package studio3;

import java.util.LinkedList;
import java.util.List;

public class UnorderedList<T extends Comparable<T>> implements PriorityQueue<T> {

	public List<T> list;
	
	public UnorderedList() {
		list = new LinkedList<T>();
	}
	
	@Override
	public boolean isEmpty() {
		//
		// FIXME
		//
		
		return list.isEmpty();
	}

	@Override
	public void insert(T thing) {
		//
		// FIXME
		//
		list.add(thing);
	}

	@Override
	public T extractMin() {
		//
		// FIXME
		//
		T x=list.get(0); 
		int index;
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).compareTo(x)<0)
			{
				x=list.get(i);
				index = i;
			}
		}
		
		list.remove(x);
		return x;
	}

}
