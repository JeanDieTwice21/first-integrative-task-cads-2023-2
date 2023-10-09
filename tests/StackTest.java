package tests;
import org.junit.Test;
import static org.junit.Assert.*;
import model.Stack;
public class StackTest<T> {

    // pop an empty stack and check that it returns null
    @Test
    public void test_pop_empty_stack_returns_null() {
        Stack<Double> stack = new Stack<>();
        assertNull(stack.pop());
    }

    // push null onto the stack, then pop it and check that it returns null
    @Test
    public void test_push_null_and_pop_returns_null() {
        Stack<String> stack = new Stack<>();
        stack.push(null);
        assertNull(stack.pop());
    }

    // push a value onto the stack, then check that top() returns that value
    @Test
    public void test_push_value_then_top_returns_value() {
        Stack<String> stack = new Stack<>();
        stack.push("test");
        assertEquals("test", stack.top());
    }

    // Push a string onto the stack, then push a null value onto the stack, then call top() and verify that it returns the null value.
    @Test
    public void test_push_string_then_push_null_then_top_returns_null() {
        Stack<String> stack = new Stack<>();
        stack.push("test");
        stack.push(null);
        assertNull(stack.top());
    }

}