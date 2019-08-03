package com.javaproject.jcode.collections;

import java.util.LinkedList;

/**
 * <p>LinkedList：双向链表。非同步，增删快，查询慢，线程不安全，效率高；     
 * <p>不要通过随机访问去遍历LinkedList，效率低: get/set/add/remove，
 * <p>而应该采用逐个遍历的方式：
 * 
 * <p>1.迭代器：
 * <pre>{@code} for(Iterator iter=list.iterator();iter.hasNext();) {
 * {@code} iter.next();}</pre>
 * 
 * <p>2.for循环变种：
 * <pre>{@code} for (Integer integ:list) {;}</pre>
 * 
 * <p>继承于AbstractSequentialList的双向链表。它也可以被当作堆栈stack、队列queue或双端队列进行操作
 * <p>调用get(int location)时，首先会比较“location”和“双向链表长度的1/2”；
 *    若前者大，则从链表头开始往后查找，直到location位置；否则，从链表末尾开始先前查找，直到location位置
 */
public class LinkedList_skywang {

	   public static void main(String[] args) {
	        // 测试LinkedList的API
	        testLinkedListAPIs() ;
	 
	        // 将LinkedList当作 LIFO(后进先出) 的堆栈stack
	        useLinkedListAsLIFO();
	 
	        // 将LinkedList当作 FIFO(先进先出) 的队列queue
	        useLinkedListAsFIFO();
	    }
	     
	    /** 
	     * 测试LinkedList中部分API                                 
	     */
	    private static void testLinkedListAPIs() {
	        String val = null;
	        //LinkedList llist;
	        //llist.offer("10");
	        // 新建一个LinkedList
	        LinkedList<String> llist = new LinkedList<String>();
	        //---- 添加操作 ----
	        // 依次添加1,2,3
	        llist.add("1");
	        llist.add("2");
	        llist.add("3");
	 
	        /**
	         * 通过add(int index, E element)向LinkedList插入元素时，
	         * 先在双向链表中找到要插入节点的位置index；找到之后，再插入一个新节点。
	         * 
	         * 双向链表查找index位置的节点时，有一个加速动作：
	         * 若index < 双向链表长度的1/2，则从前向后查找; 否则，从后向前查找
	        */       
	        
	        // 将“4”添加到第一个位置
	        llist.add(1, "4");
	         
	 
	        System.out.println("\nTest \"addFirst(), removeFirst(), getFirst()\"");
	        // (01) 将“10”添加到第一个位置。  失败的话，抛出异常！
	        llist.addFirst("10");
	        System.out.println("llist:"+llist);
	        // (02) 将第一个元素删除。返回被删除的元素        失败的话，抛出异常！
	        System.out.println("llist.removeFirst():"+llist.removeFirst());
	        System.out.println("llist:"+llist);
	        // (03) 获取第一个元素。          失败的话，抛出异常！
	        System.out.println("llist.getFirst():"+llist.getFirst());
	 
	 
	        System.out.println("\nTest \"offerFirst(), pollFirst(), peekFirst()\"");
	        // (01) 将“10”添加到第一个位置。  返回true。
	        llist.offerFirst("10");
	        System.out.println("llist:"+llist);
	        // (02) 将第一个元素删除。        失败的话，返回null。
	        System.out.println("llist.pollFirst():"+llist.pollFirst());
	        System.out.println("llist:"+llist);
	        // (03) 获取第一个元素。          失败的话，返回null。
	        System.out.println("llist.peekFirst():"+llist.peekFirst());
	     
	 
	        System.out.println("\nTest \"addLast(), removeLast(), getLast()\"");
	        // (01) 将“20”添加到最后一个位置。  失败的话，抛出异常！
	        llist.addLast("20");
	        System.out.println("llist:"+llist);
	        // (02) 将最后一个元素删除。        失败的话，抛出异常！
	        System.out.println("llist.removeLast():"+llist.removeLast());
	        System.out.println("llist:"+llist);
	        // (03) 获取最后一个元素。          失败的话，抛出异常！
	        System.out.println("llist.getLast():"+llist.getLast());
	 
	 
	        System.out.println("\nTest \"offerLast(), pollLast(), peekLast()\"");
	        // (01) 将“20”添加到最后一个位置。  返回true。
	        llist.offerLast("20");
	        System.out.println("llist:"+llist);
	        // (02) 将最后一个元素删除。        失败的话，返回null。
	        System.out.println("llist.pollLast():"+llist.pollLast());
	        System.out.println("llist:"+llist);
	        // (03) 获取最后一个元素。          失败的话，返回null。
	        System.out.println("llist.peekLast():"+llist.peekLast());
	 
	          
	 
	        // 将第3个元素设置300。不建议在LinkedList中使用此操作，因为效率低！
	        llist.set(2, "300");
	        // 获取第3个元素。不建议在LinkedList中使用此操作，因为效率低！
	        System.out.println("\nget(3):"+llist.get(2));
	        
	        /**
	         * 通过get(int index)获取LinkedList第index个元素时，
	         * 先是在双向链表中找到要index位置的元素，找到之后再返回。
	         * 
	         * 双向链表查找index位置的节点时，有一个加速动作，
	         * 若index < 双向链表长度的1/2，则从前向后查找; 否则，从后向前查找。
	         * 
	        */
	        
	 
	        // ---- toArray(T[] a) ----
	        // 将LinkedList转行为数组
	        String[] arr = (String[])llist.toArray(new String[0]);
	        for (String str:arr)
	            System.out.println("str:"+str);
	 
	        // 输出大小
	        System.out.println("size:"+llist.size());
	        // 清空LinkedList
	        llist.clear();
	        // 判断LinkedList是否为空
	        System.out.println("isEmpty():"+llist.isEmpty()+"\n");
	 
	    }
	 
	    /**
	     * 将LinkedList当作 LIFO(后进先出) 的堆栈stack
	     * <p>pop:  删除“栈顶元素”             
	     * <p>peek: 取出“栈顶元素”
	     */
	    private static void useLinkedListAsLIFO() {
	        System.out.println("\nuseLinkedListAsLIFO");
	        // 新建一个LinkedList
	        LinkedList<String> stack = new LinkedList<String>();
	 
	        // 将1,2,3,4添加到堆栈中
	        stack.push("1");
	        stack.push("2");
	        stack.push("3");
	        stack.push("4");
	        // 打印“栈”
	        System.out.println("stack:"+stack);
	 
	        // 删除“栈顶元素”
	        System.out.println("stack.pop():"+stack.pop());
	         
	        // 取出“栈顶元素”
	        System.out.println("stack.peek():"+stack.peek());
	 
	        // 打印“栈”
	        System.out.println("stack:"+stack);
	    }
	 
	    /**
	     * 将LinkedList当作 FIFO(先进先出) 的队列queue
	     * <p>remove:  删除(队列的第一个元素)
	     * <p>element: 读取(队列的第一个元素)
	     */
	    private static void useLinkedListAsFIFO() {
	        System.out.println("\nuseLinkedListAsFIFO");
	        // 新建一个LinkedList
	        LinkedList<String> queue = new LinkedList<String>();
	 
	        // 将10,20,30,40添加到队列。每次都是插入到末尾
	        queue.add("10");
	        queue.add("20");
	        queue.add("30");
	        queue.add("40");
	        // 打印“队列”
	        System.out.println("queue:"+queue);
	 
	        // 删除(队列的第一个元素)
	        System.out.println("queue.remove():"+queue.remove());
	     
	        // 读取(队列的第一个元素)
	        System.out.println("queue.element():"+queue.element());
	 
	        // 打印“队列”
	        System.out.println("queue:"+queue);
	    }
}
