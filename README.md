ThreadPractise
==============

ArrayBlockingQueue:
Array blocking queue is just an array implementation of a blocking queue. The push method is used to add a value to the queue.
The take method is used to block the thread until an element in the queue becomes available.

DelayedBlockingQueue:
This queue again is like an arrayblockingqueue. Just that it gives one more feature where we can just add a delay to every element
added to the queue.This queue takes only elements of object type that implements the "Delayed" interface.The Delayed interface
has two methods getDelay() and compareTo. Compare to is like a normal comparator where we can give the order in which the elements
need to be arranged. The getDelay should always be the "time at which the value was inserted+delay - currenttime".



