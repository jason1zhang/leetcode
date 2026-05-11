class MinStack:
    """
    最小栈：在标准栈的基础上，额外支持常数时间获取栈内最小值。
    使用一个辅助栈 min_stack 来同步记录每个状态下的最小值。
    """
    def __init__(self):
        self.stack = []
        self.min_stack = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        
        if not self.min_stack or val < self.min_stack[-1]:
            self.min_stack.append(val)

    def pop(self) -> None:
        if not self.stack:
            return
        
        if self.stack[-1] == self.min_stack[-1]:
            self.min_stack.pop()

        self.stack.pop()

    def top(self) -> int:
        if self.stack:
            return self.stack[-1]
        
        return -1
    
    def getMin(self) -> int:
        if self.min_stack:
            return self.min_stack[-1]
        
        return -1
    
# =============================================
# 测试代码
# =============================================
if __name__ == "__main__":
    # 模拟示例操作序列
    # 操作顺序：["MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin"]
    # 参数：     [[], [-2], [0], [-3], [], [], [], []]
    # 期望输出： [null, null, null, null, -3, null, 0, -2]

    min_stack = MinStack()
    results = []

    # 初始化：min_stack 已创建 (无输出)
    results.append(None)

    # push(-2)
    min_stack.push(-2)
    results.append(None)

    # push(0)
    min_stack.push(0)
    results.append(None)

    # push(-3)
    min_stack.push(-3)
    results.append(None)

    # getMin() -> 期望 -3
    res = min_stack.getMin()
    results.append(res)

    # pop()
    min_stack.pop()
    results.append(None)

    # top() -> 期望 0
    res = min_stack.top()
    results.append(res)

    # getMin() -> 期望 -2
    res = min_stack.getMin()
    results.append(res)

    # 打印测试结果
    expected = [None, None, None, None, -3, None, 0, -2]
    print("=" * 60)
    print("LeetCode 155. Min Stack 测试运行")
    print("=" * 60)
    print(f"操作序列:  [MinStack, push(-2), push(0), push(-3), getMin, pop, top, getMin]")
    print(f"期望输出:  {expected}")
    print(f"实际输出:  {results}")
    print("=" * 60)

    # 详细比对
    passed = all(r == e for r, e in zip(results, expected))
    status = "✅ PASS" if passed else "❌ FAIL"
    print(f"测试结果:  {status}")

    # 附加测试：边界情况
    print("\n附加测试:")
    ms = MinStack()
    ms.push(5)
    ms.push(2)
    ms.push(2)
    ms.push(7)
    print(f"push(5,2,2,7) -> getMin() = {ms.getMin()} (期望 2)")
    ms.pop()
    print(f"pop() -> top() = {ms.top()} (期望 2), getMin() = {ms.getMin()} (期望 2)")
    ms.pop()
    print(f"pop() -> getMin() = {ms.getMin()} (期望 2)")
    ms.pop()
    print(f"pop() -> getMin() = {ms.getMin()} (期望 5)")
