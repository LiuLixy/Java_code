题目: 定义栈的数据结构，在该类型中实现一个能够得到的最小元素的min函数

思路: 定义两个栈结构, 一个为 dataStack 的栈存放入栈的数据，另一个为 minStack 的栈，
其栈顶元素存放的是入栈的最小元素，在每次入栈操作时，先将数据入栈到 dataStack 中，
然后判断 minStack 的栈顶元素与 dataStack 的栈顶元素的大小关系，如果 
minStack.peek() > dataStack.peek(), 那么就将 dataStack.peek()入栈到 minStack中，
否则就将 minStack.peek() 入栈到 minStack 中。 这样就保证了 minStack 的栈顶元素是最小的了。


import java.util.Stack;

class minStack {
    Stack<Integer> dataStack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push ( int node) {
        dataStack.push(node);
        if (minStack.isEmpty() || node < minStack.peek()) {
            minStack.push(node);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop () {
        dataStack.pop();
        minStack.pop();
    }

    public int top () {
        return dataStack.peek();
    }

    public int min () {
        return minStack.peek();
    }
}

public class Main {
    public static void main(String[] args) {
        minStack minStack = new minStack();
        minStack.push(3);
        minStack.push(2);
        minStack.push(5);
        minStack.push(4);
        minStack.push(1);
        minStack.push(6);
        System.out.println(minStack.min());
    }
}