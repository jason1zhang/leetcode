class MyQueue:
    def __init__(self):
        # Two stacks: one for input, one for output (reversed order)
        self.in_stack = []
        self.out_stack = []

    def push(self, x: int) -> None:
        # Push element x to the back of queue
        self.in_stack.append(x)

    def pop(self) -> int:
        # Removes and returns the element from the front of queue
        if not self.out_stack:
            self._in2out()
        return self.out_stack.pop()
    
    def peek(self) -> int:
        if not self.out_stack:
            self._in2out()
        return self.out_stack[-1]
    
    def empty(self) -> bool:
        return not self.in_stack and not self.out_stack
    
    def _in2out(self) -> None:
        while self.in_stack:
            self.out_stack.append(self.in_stack.pop())

# ---------- Test (based on given example) ----------
if __name__ == "__main__":
    # Example:
    # ["MyQueue", "push", "push", "peek", "pop", "empty"]
    # [[], [1], [2], [], [], []]
    my_queue = MyQueue()
    print(my_queue.push(1))   # null
    print(my_queue.push(2))   # null
    print(my_queue.peek())    # 1
    print(my_queue.pop())     # 1
    print(my_queue.empty())   # False

