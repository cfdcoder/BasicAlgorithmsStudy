package library;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Bag<Item> implements Iterable<Item> {
	private Node<Item> first;
	private int N;
	
	//helper linked list class
    private class Node<Item>{
    	private Item item;
    	private Node<Item> next;
    }
    
    ////constructor
    public Bag(){
    	first=null;
    	N=0;
    }
    
    public boolean isEmpty(){
    	return (first==null);
    }
    
    //return num of items in the bag
    public int size(){
    	return N;
    }
    
    //add items to the bag
    public void add(Item item){
    	Node<Item> old=first;//
    	first=new Node<Item>();
    	first.item=item;
    	first.next=old;
    	N++;
    }
    
    public Iterator<Item> iterator(){
    	return new ListIterator<Item> (first);
    }
    
    private class ListIterator<Item> implements Iterator<Item>{
        private Node<Item> current;
        public ListIterator(Node<Item> first){
        	current=first;
        }
        
        public boolean hasNext(){
        	return current!=null;
        }
        
        public void remove(){
        	throw new UnsupportedOperationException();
        }
        
        public Item next(){
        	if(!hasNext()) throw new NoSuchElementException();
        	Item item=current.item;
        	current=current.next;
        	return item;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Bag<String> bag=new Bag<String>();
        while(StdIn.isEmpty()){
        	String item=StdIn.readString();
        	bag.add(item);
        }
		
        StdOut.println("size of the bag "+bag.size());
        for(String s:bag){
        	StdOut.println(s);
        }
		
		
	}

}

/******************************************************************************
 *  Copyright 2002-2015, Robert Sedgewick and Kevin Wayne.
 *
 *  This file is part of algs4.jar, which accompanies the textbook
 *
 *      Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne,
 *      Addison-Wesley Professional, 2011, ISBN 0-321-57351-X.
 *      http://algs4.cs.princeton.edu
 *
 *
 *  algs4.jar is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  algs4.jar is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with algs4.jar.  If not, see http://www.gnu.org/licenses.
 ******************************************************************************/


