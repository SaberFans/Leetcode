package util.ds.impl;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;

public class LIFOStackImpl<E> {
	private Object[] elements;
	private static int PREDEFINED_SIZE = 10;//Integer.MAX_VALUE/20;
	private int actual_size = 0;
	
	public LIFOStackImpl() {
		elements = new Object[PREDEFINED_SIZE];
	}

	public void push(E element) {
		ensure_capacity();
		elements[actual_size++] = element;
	}

	public E pop() {
		E element = (E) elements[actual_size - 1];
		elements[actual_size - 1] = null;
		actual_size--;
		return element;
	}

	private void ensure_capacity() {
		if (actual_size == elements.length) {
			elements = Arrays.copyOf(elements, elements.length * 2);
		}
		
	}
	@Test
	public void test_mystack_validity() throws Exception {
		LIFOStackImpl stack = new LIFOStackImpl();
		for(int i=0;i<Integer.MAX_VALUE/300;i++)
			stack.push(i);
		for(int i=Integer.MAX_VALUE/300-1;i>=0;i--)
			assertEquals(i, stack.pop());
	}
	@Test
	public void test_stack_validity() throws Exception {
		Stack stack = new Stack();
		for(int i=0;i<Integer.MAX_VALUE/300;i++)
			stack.push(i);
		for(int i=Integer.MAX_VALUE/300-1;i>=0;i--)
			assertEquals(i, stack.pop());
	}
	
}
