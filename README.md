# Reverse Polish Notation (RPN)

Reverse Polish Notation (RPN), also known as postfix notation, is a mathematical notation where the operator is placed after its operands. For example, instead of writing 2+2 (infix notation), you would write 2 2 +. This method eliminates the need for parentheses and is evaluated strictly from left to right. 

### How it works Numbers and operators: 
You read the expression from left to right.If you see a number: Push it onto a stack.If you see an operator: Take the last two numbers off the stack, perform the operation, and push the result back onto the stack.Final result: Once you have processed the entire expression, the single value remaining on the stack is the final answer. 

#### Example To evaluate 

To evaluate the below expression:
```bash
4 8 + 1 3 + /
```

* 4: Push (4) onto the stack. Stack: ([4])

* 8: Push (8) onto the stack. Stack: ([4,8])

* +: Pop (8) and (4). Calculate (4+8=12). Push (12) onto the stack. Stack: ([12])

* 1: Push (1) onto the stack. Stack: ([12,1])

* 3: Push (3) onto the stack. Stack: ([12,1,3])

* +: Pop (3) and (1). Calculate (1+3=4). Push (4) onto the stack. Stack: ([12,4])
* /: Pop (4) and (12). Calculate (12/4=3). Push (3) onto the stack. Stack: ([3])

## Final Result is 3

For project compilation:
```bash
mvn clean compile
```

For execution:
```bash
mvn exec:java -Dexec.mainClass="com.sample.snippets.App"
```