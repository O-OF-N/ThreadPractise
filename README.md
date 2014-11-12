ThreadPractise
==============

ExecutorService:
================
This is an interface that extends the Executor interface. It provides a few convenience methods like Submit(runnable) and submit(callable) 
unlike its parent which only offers execute(Runnable).

Executors:
===========

This is just an implementation of ThreadPoolExecutor class. The ThreadPoolExecutor class is a really complex implementation
of ExecutorService class. The problem with this is class is its giant constructor which confuses the user. The advantage
of Executors class is that it provides very convenient static methods.  

BlockingQueue:
===============

 			Throws Exception	Special Value	Blocks		Times Out
Insert			add(o)				offer(o)	put(o)		offer(o, timeout, timeunit)
Remove			remove(o)			poll(o)		take(o)		poll(timeout, timeunit)
Examine			element(o)			peek(o)	 	 


ArrayBlockingQueue:
===================
Array blocking queue is just an array implementation of a blocking queue. The push method is used to add a value to the queue.
The take method is used to block the thread until an element in the queue becomes available.

DelayedBlockingQueue:
=====================
This queue again is like an arrayblockingqueue. Just that it gives one more feature where we can just add a delay to every element
added to the queue.This queue takes only elements of object type that implements the "Delayed" interface.The Delayed interface
has two methods getDelay() and compareTo. Compare to is like a normal comparator where we can give the order in which the elements
need to be arranged. The getDelay should always be the "time at which the value was inserted+delay - currenttime".

LinkedBlockingQueue:
=====================
Just a linked list implementation of blockingqueue.


SynchronousQueue:
=================
Used to have only one element in the queue at any given time. If there is an element in the queue, New insert should wait 
until its taken out of the queue.

PriorityBlockingQueue:
======================
Used to order the elements based on priority. The priority will be defined by the mandatory compareTo method which has to be 
defined.


BlockingDeQueue:
=================
Nothing so great about BlockingDeQueue.Its just a double ended version of a BlockingQueue. Insert or remove from head or tail.
Thats it.

			Throws Exception	Special Value	Blocks			Times Out
Insert		addFirst(o)			offerFirst(o)	putFirst(o)		offerFirst(o, timeout, timeunit)
Remove		removeFirst(o)		pollFirst(o)	takeFirst(o)	pollFirst(timeout, timeunit)
Examine		getFirst(o)			peekFirst(o)
	 	 
 			Throws Exception	Special Value	Blocks			Times Out
Insert		addLast(o)			offerLast(o)	putLast(o)		offerLast(o, timeout, timeunit)
Remove		removeLast(o)		pollLast(o)		takeLast(o)		pollLast(timeout, timeunit)
Examine		getLast(o)			peekLast(o)	 	 

LinkedBlockingDeque:
======================
Linked list implementation of a blockingDeQueue






