# Router-Simulator
A model with various properties of a queue in a single router when packets arrive into the queue at a particular rate and depart from the queue at a particular rate. 

The simulation will compute the average waiting times of packets departing a router queue by
simulating the router queue for various packet arrival rates. As the arrival rate gets closer to the service rate, the average waiting times of packets in the queue will increase exponentially and explode. This trend has been modelled by a well known law called the Little’s Law. The average waiting time E(S) or sojourn time of a packet in a queue can be related to the arrival rate λ of packets into the
queue and service rate µ of the queue which denotes the departure rate of packets from the queue via this equation:

E(s) = 1/λ(λ/µ + (1/2 * (λ/µ)^2)/(1-(λ/µ))


Compilation from cmd: javac Queue.java SinglyLinkedList.java LinkedListQueue.java Data.java QueueSimulator.java
Test.java

java Test 1
java Test 2
