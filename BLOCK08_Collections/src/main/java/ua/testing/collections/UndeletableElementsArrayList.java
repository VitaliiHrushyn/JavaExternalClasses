package ua.testing.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * All method which removes elements just have been overrided to throws UnsupportedOperationException
 */

public class UndeletableElementsArrayList<E> extends ArrayList<E>{

	private static final long serialVersionUID = 1L;	
	
	public UndeletableElementsArrayList() {
		super();
	}

	public UndeletableElementsArrayList(Collection<? extends E> c) {
		super(c);
	}

	public UndeletableElementsArrayList(int initialCapacity) {
		super(initialCapacity);
	}

	@Override
	public void clear() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public E remove(int arg0) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object arg0) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> arg0) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeIf(Predicate<? super E> arg0) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void replaceAll(UnaryOperator<E> arg0) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> arg0) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
}
