package ua.testing.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Contains ArrayList and provides access only to adding methods.
 */

public class UndeletableElementsList<E> implements Iterable<E>{
	
	private List<E> innerList;	
	
	public UndeletableElementsList() {
		innerList = new ArrayList<E>();
	}

	public UndeletableElementsList(Collection<? extends E> c) {
		innerList = new ArrayList<E>(c);
	}

	public UndeletableElementsList(int initialCapacity) {
		innerList = new ArrayList<E>(initialCapacity);
	}
	
	public void add(E element) {
		innerList.add(element);
	}
	
	public void add(int index, E element) {
		innerList.add(index, element);
	}
	
	public void addAll(Collection <? extends E> c) {
		innerList.addAll(c);
	}
	
	public void addAll(int index, Collection <? extends E> c) {
		innerList.addAll(index, c);
	}
	
	public boolean contains(Object o) {
		return innerList.contains(o);
	}
	
	public E get(int index) {
		return innerList.get(index);
	}
	
	public Iterator<E> iterator() {
		return innerList.iterator();
	}
	
	public ListIterator<E> listIterator() {
		return innerList.listIterator();
	}
	
	public int size() {
		return innerList.size();
	}
	
}
