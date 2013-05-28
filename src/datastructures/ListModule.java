package datastructures;

import java.util.Arrays;

import option.None;
import option.Option;
import option.Some;

public class ListModule {
  public static interface List<T> {

    public abstract Option       head();
    public abstract List<Option> tail();
    public abstract boolean isEmpty();
  }

  public static final class NonEmptyList<T> implements List<T> {

    public Option       head()    { return _head; }
    public List<Option> tail()    { return _tail; }
    public boolean isEmpty() { return false; }

    protected NonEmptyList(Option head, List<Option> tail) {
      this._head = head;
      this._tail = tail;
    }

	private final Option _head;
    private final List<Option> _tail;

    @Override
    public boolean equals(Object other) {
      if (other == null || getClass() != other.getClass())
        return false;
      List<?> that = (List<?>) other;
      return head().equals(that.head()) && tail().equals(that.tail());
    }

    @Override
    public int hashCode() { return 37*(head().hashCode()+tail().hashCode()); }

    @Override
    public String toString() { return "(" + head() + ", " + tail() + ")"; }
  }

 // public static class EmptyListHasNoHead extends RuntimeException {}
 // public static class EmptyListHasNoTail extends RuntimeException {}

  public static final List<? extends Object> EMPTY = new List<Option>() {

    public Option       head()    { return new None(); }
    public List<Option> tail()    { return emptyList(); }
    public boolean      isEmpty() { return true; }

    @Override
    public String toString() { return "()"; }
  };

  /* See the text for an explanation of this code */
  @SuppressWarnings(value = "unchecked")
  public static <T> List<T> emptyList() {
    return (List<T>) EMPTY; // Dangerous!?
  }

  /*
  public static <Option> List<Option> list(Option head, List<Option> tail) {
    return new NonEmptyList(head, tail);
  }
  */
  
  // Update for Chapter 3, exercise 1
  @SuppressWarnings("unchecked")
  public static <T> List<T> createProperList(Object ... args) {
	  if (args.length == 0) {
		  return emptyList();
	  } else if (args.length == 1) {		  
		  return new NonEmptyList(new Some(args[0]), EMPTY);
	  } else {
		  return new NonEmptyList(new Some(args[0]), createProperList(Arrays.copyOfRange(args, 1, args.length)));
	  }
  }
}
