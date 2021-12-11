// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashMap {
class Node{  // creat node
    int key, value;
    Node next;  // use this to connect node to one another node
    
    
    public Node(int key, int value) /// linked list constructor
    {
        this.key = key;
        this.value = value;
    }
}
    
    Node[] nodes; //create node container
    int buckets;  // how many nodes in the container
    
    private int getHash(int key)  //hashMap function 
    {
        return Integer.hashCode(key) % buckets;
    }
    
    public Node find(Node node, int key) //from line 22 to 32 I was little confuse 
    {
        Node prev = node; // assign the prev to node 
        Node curr = node.next; // //point the pointer to nect node 
        while(curr!=null && prev.next.key!=key)   // while curr is nor null and the key of prev next is not equal to key 
        {
            prev = curr; // prev onde become  curr node 
            curr = curr.next; //curr become next 
        }
        return prev; // then return the prev node 
    }
    
    
    
    public MyHashMap() {  // hashmapp consturctor
        buckets = 1000; //initialize 1000 buckets
        nodes = new Node[buckets]; // initalize size of buckets to nodes 
        
    }
    
    public void put(int key, int value) {
        
        int index = getHash(key); //call hash fucnction 
        
        if(nodes[index] == null){// check if node contains null values
            
            nodes[index] = new Node(-1, -1); //then intialize the dummy node  - 1, -1 
        }
                 Node prev = find(nodes[index], key);// assign the value of find method top prev
                 if(prev.next == null){ //then check if previous of nect is null 
                     
            prev.next = new Node(key, value); //yes then assign the new node to prev of next 
        }
           else{
               prev.next.value = value;  // else
           }
        
    }
    
    public int get(int key) {   //
        int index = getHash(key); //call hasg function 
        if(nodes[index] == null) //check if nodes is null  return 1
           {
               return -1; 
           }
        Node prev = find(nodes[index], key); //otherwise assign find method key to this 
        if(prev.next == null)//then check prev.next key if null return -1
        {
            return -1;
            
        }
        else{
            return prev.next.value; //else return
        }
    }
    
    public void remove(int key) {
         int index = getHash(key);
        if(nodes[index] == null){
            return;
        }
        Node prev = find(nodes[index], key);  
        if(prev.next == null) //if poiinter prev.next is null 
        {
            return; // then retun 0
        }
        else{
            prev.next= prev.next.next;// notherwise point the pinter to prev.next to next 
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */




// second question
